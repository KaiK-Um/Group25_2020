import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DecimalFormat;
import javax.swing.*;

public class Clock {

	private boolean mode; //used to change the clock mode
	private Timer timer;
	private TimerTask task;
	private boolean countdown_over;
	private int seconds;
	private int minutes;

	private Color color;
	private static DecimalFormat df;
	private JLabel label;
	private String min, sec;
	public JPanel panel;

	private int initMin;
	private int initSec;
	private boolean stop = true; //used to stop the clock

	private static TimerTask task2;
	private int fixedtimerate; //in minutes


	/**
	 * This is a clock object that can either function as a timer or as a countdown
	 * @param seconds are the amount of seconds that the timer should start at
	 * @param minutes are the amount of minutes that the timer should start at
	 * @param mode is either the countdown (false) or the timer (true)
	 */
	public Clock(int seconds, int minutes, boolean mode) {   //need to pass seconds, minutes, timelimit and clock mode

	timer = new Timer();
	label = new JLabel(" ", JLabel.CENTER);
	df = new DecimalFormat("00");
	initMin = minutes;
	initSec = seconds;
	this.seconds = seconds;
	this.minutes = minutes;
	this.fixedtimerate = 1000;
	this.mode = mode;
	countdown_over = false;



	label.setText(df.format(minutes)+":"+df.format(seconds)); //setting the text of teh clock
	label.setFont(new Font("SansSerif",Font.BOLD,60));

	label.setOpaque(true);
	label.setBackground(color);
	panel = new JPanel();
	panel.setBackground(color);
	panel.add(label);

	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public void start() {
	
	if (mode == true) {                         //mode switch, no need to select the mode manually
	timer.scheduleAtFixedRate(task, 0, 1000);
	watch();
	}														//just pass true for timer and flase for countdown
	if (mode == false) {
	timer.scheduleAtFixedRate(task2, 0, 1000);
	countdown();
	}
    }

   	public void stop() {

		InGameFrame2.frame.remove(InGameFrame2.splitPane);

		JPanel rPanel = new JPanel(null);
		rPanel.setBounds(Drawer.FRAME_WIDTH/3,0,Drawer.FRAME_WIDTH,Drawer.FRAME_HEIGHT);
		rPanel.setBackground(Color.lightGray);

		JPanel panel = new JPanel(null);
		panel.setBorder(null);
		panel.setBounds(0,0,800/3,800);


		JLabel GameOver = new JLabel("GAME OVER");
		GameOver.setFont(new Font("Tahoma", Font.BOLD, 100));
		GameOver.setForeground(Color.DARK_GRAY);
		GameOver.setHorizontalAlignment(SwingConstants.CENTER);
		GameOver.setBounds(33, 42, 720, 276);
		rPanel.add(GameOver);

		//text panel
		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.DARK_GRAY);
		textPanel.setBounds(5, 5, (800/3)-10,100);
		panel.add(textPanel);
		textPanel.setLayout(null);


		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, Drawer.FRAME_WIDTH+ (Drawer.FRAME_WIDTH/3), Drawer.FRAME_HEIGHT);
		splitPane.setBackground(Color.LIGHT_GRAY);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(800/3);
		splitPane.setLeftComponent(panel);
		splitPane.setRightComponent(rPanel);

		//text
		JLabel LabelVertexMenu = new JLabel("THE GAME!");
		LabelVertexMenu.setFont(new Font("Tahoma", Font.BOLD, 23));
		LabelVertexMenu.setForeground(Color.white);
		LabelVertexMenu.setHorizontalAlignment(SwingConstants.CENTER);
		LabelVertexMenu.setBounds(5, 5,  (800/3) -20, 90);
		textPanel.add(LabelVertexMenu);

		JLabel lblNewLabel = new JLabel("Colored Vertices:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(54, 339, 166, 46);
		rPanel.add(lblNewLabel);

		int usedColors = 0;
		int counter = Drawer.colorList.length;
		for(int i = 0; i < Drawer.colorList.length;i++)
		{
			if(Drawer.colorList[i] == null) counter--;
		}
		ArrayList<Color> colors = new ArrayList<Color>();
		for (int i = 0; i < Drawer.colorList.length; i++) {
			if (!colors.contains(Drawer.colorList[i])) {
				colors.add(Drawer.colorList[i]);
			}
		}
		usedColors = colors.size()-1;

		String amount = Integer.toString(counter) +"/"+ Integer.toString(Drawer.colorList.length);
		JLabel lblNewLabel_1 = new JLabel(amount);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(98, 379, 44, 58);
		rPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Colors used:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(605, 348, 117, 28);
		rPanel.add(lblNewLabel_2);

		String colorsUsed = Integer.toString(usedColors);
		JLabel lblNewLabel_3 = new JLabel(colorsUsed);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(646, 392, 44, 33);
		rPanel.add(lblNewLabel_3);

		JLabel lblThanksForPlaying = new JLabel("Thanks for playing!");
		lblThanksForPlaying.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksForPlaying.setForeground(Color.DARK_GRAY);
		lblThanksForPlaying.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblThanksForPlaying.setBounds(33, 493, 720, 276);
		rPanel.add(lblThanksForPlaying);

		JLabel lblNewLabel_4 = new JLabel("25");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 99));
		lblNewLabel_4.setBounds(328, 300, 159, 182);
		rPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Group");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(353, 325, 82, 28);
		rPanel.add(lblNewLabel_5);

		JButton qq = new JButton("Quit");
		qq.setFont(new Font("Tahoma", Font.BOLD, 10));
		ActionListener quit = new QuitButton();
		qq.addActionListener(quit);
		qq.setForeground(Color.white);
		qq.setBackground(Color.DARK_GRAY);
		qq.setBounds(5,Drawer.FRAME_HEIGHT/4 + 4*InGameFrame2.buttonSize + InGameFrame2.buttonSize/2,(Drawer.FRAME_WIDTH/3)-10,InGameFrame2.buttonSize);
		qq.setOpaque(true);
		panel.add(qq);


		InGameFrame2.frame.add(splitPane);
		InGameFrame2.frame.repaint();
   	}

	public boolean countdown() {   //returns true if the countdown is over

		task2 = new TimerTask()  {

			public void run() {


			if (seconds == 0) {  //updating the count of minutes if seconds == 60
				seconds = 60;
				minutes--;
			}

			seconds--;

			if(minutes == 0 && seconds == 0) {  //exit if we run out of time
					
					countdown_over = true;
					if(checkStop()) stop();
				}



			label.setText(df.format(minutes) + ":" + df.format(seconds));	//setting the text in the label

			}
			
		};

		return countdown_over;

	}

	public void watch(){

		task = new TimerTask()  {

			public void run() {
		
			seconds++;
			if (seconds == 60) {  //updating the count of minutes if seconds == 60
				seconds = 0;
				minutes++;
			}

			label.setText(df.format(minutes) + ":" + df.format(seconds));	//setting the text in the label

			}
			
		};

	}
	public void Pause(){ //stops the clock
		this.cancel();
	}

	public void resume(){

	}
	public boolean cancel() {


	return false;

	}

	public void setStop(boolean b){ //setting a variable for stopping the clock
		stop = b;
	}

	/**
	 * a simple check if the timer should do something when it stops or not
	 * @return It returns true if it should execute something and false if not
	 */
	public boolean checkStop(){ 	
		if(stop) return true;
		else return false;
	}
}