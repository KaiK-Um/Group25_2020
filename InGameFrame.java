import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class InGameFrame{

	private static int buttonSize = (Drawer.FRAME_HEIGHT/2)/8;
	public static JPanel panel;
	static JFrame frame;
	public static JSplitPane splitPane = new JSplitPane();
	public static JPanel graph;
	public static int n;
	public static int m;
	public static Clock clock;
	public static Drawer d;

	/**
	*  This constructer automatically creates the window for the graph and generates a custom graph based on the inputs.
	*  @param n is the amount of vertices that the final generated graph should have!
	*  @param m is the amouunt of edges that the generated graph should have!
	*/
	public InGameFrame(int n, int m) {

		this.n = n;
		this.m = m;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, Drawer.FRAME_WIDTH+ (Drawer.FRAME_WIDTH/3) + 10, Drawer.FRAME_HEIGHT+38);
		frame.getContentPane().setLayout(null);

		d = new Drawer();
		graph = d.generate(n,m);

		panel = new JPanel(null);
		panel.setBorder(null);
		panel.setBounds(0,0,(Drawer.FRAME_WIDTH/3),Drawer.FRAME_HEIGHT);
		panel.setBackground(Drawer.currentColor);
		ActionListener vertexColor = new VertexColors();

		//text panel
		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.DARK_GRAY);
		textPanel.setBounds(5, 5, (Drawer.FRAME_WIDTH/3)-10,100);
		panel.add(textPanel);
		textPanel.setLayout(null);


		//text
		JLabel LabelVertexMenu = new JLabel("THE GAME!");
		LabelVertexMenu.setFont(new Font("Tahoma", Font.BOLD, 23));
		LabelVertexMenu.setForeground(Color.white);
		LabelVertexMenu.setHorizontalAlignment(SwingConstants.CENTER);
		LabelVertexMenu.setBounds(5, 5,  (Drawer.FRAME_WIDTH/3) -20, 90);
		textPanel.add(LabelVertexMenu);



		//Color button
        JButton colors = new JButton("Change the color!");
        colors.setFont(new Font("Tahoma", Font.BOLD, 10));
        colors.setForeground(Color.white);
        colors.setBackground(Color.DARK_GRAY);
        colors.addActionListener(vertexColor);
        colors.setBounds(5,Drawer.FRAME_HEIGHT/4,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        colors.setOpaque(true);
        panel.add(colors);

        //reroll button
        JButton reroll = new JButton("Get a new graph!");
        reroll.setFont(new Font("Tahoma", Font.BOLD, 10));
        reroll.setForeground(Color.white);
        reroll.setBackground(Color.DARK_GRAY);
        ActionListener rollie = new reRoll();
        reroll.addActionListener(rollie);
        reroll.setBounds(5,Drawer.FRAME_HEIGHT/4 + buttonSize + buttonSize/2,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        reroll.setOpaque(true);
        panel.add(reroll);

        //Pause button
        /*
        JButton pause = new JButton("PAUSE ||");
        pause.setFont(new Font("Tahoma", Font.BOLD, 10));
        ActionListener pp = new PauseButton();
        pause.setForeground(Color.white);
        pause.setBackground(Color.DARK_GRAY);
        pause.addActionListener(pp);
        pause.setBounds(5,Drawer.FRAME_HEIGHT/4 + 3*buttonSize,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        pause.setOpaque(true);
        panel.add(pause);
        */

        //Finish button
        JButton fini = new JButton("Check result!");
        fini.setFont(new Font("Tahoma", Font.BOLD, 10));
        fini.setForeground(Color.white);
        fini.setBackground(Color.DARK_GRAY);
        ActionListener finish = new FinalCheck();
        fini.addActionListener(finish);
        fini.setBounds(5,Drawer.FRAME_HEIGHT/4 + 3*buttonSize,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        fini.setOpaque(true);
        panel.add(fini);

        // Quit Button

        JButton qq = new JButton("Quitie boi");
        qq.setFont(new Font("Tahoma", Font.BOLD, 10));
        ActionListener quit = new QuitButton();
        qq.addActionListener(quit);
        qq.setForeground(Color.white);
        qq.setBackground(Color.DARK_GRAY);
        qq.setBounds(5,Drawer.FRAME_HEIGHT/4 + 4*buttonSize + buttonSize/2,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        qq.setOpaque(true);
        panel.add(qq);

        //clock
        clock = new Clock(0,0,true);
        clock.panel.setBounds(35,105,200,90);
        panel.add(clock.panel);
        clock.watch();
        clock.start();

        //Creating the split pane

		splitPane.setBackground(Color.LIGHT_GRAY);
		splitPane.setBounds(0, 0, Drawer.FRAME_WIDTH+ (Drawer.FRAME_WIDTH/3), Drawer.FRAME_HEIGHT);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(Drawer.FRAME_WIDTH/3);
		frame.getContentPane().add(splitPane);
		//Assigning the panels to the split pane
		splitPane.setRightComponent(graph);
		splitPane.setLeftComponent(panel);

		frame.setVisible(true);
	}

	/**
	*  This constructer automatically creates the window for the graph and generates a graph based on the inputfile.
	*  @param inputfile is the path of the file as string
	*/

    public InGameFrame(String inputfile) {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, Drawer.FRAME_WIDTH+ (Drawer.FRAME_WIDTH/3) + 10, Drawer.FRAME_HEIGHT+38);
        frame.getContentPane().setLayout(null);

        d = new Drawer();
        graph = d.generate(inputfile);

        panel = new JPanel(null);
        panel.setBorder(null);
        panel.setBounds(0,0,(Drawer.FRAME_WIDTH/3),Drawer.FRAME_HEIGHT);
        panel.setBackground(Drawer.currentColor);
        ActionListener vertexColor = new VertexColors();

        //text panel
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.DARK_GRAY);
        textPanel.setBounds(5, 5, (Drawer.FRAME_WIDTH/3)-10,100);
        panel.add(textPanel);
        textPanel.setLayout(null);


        //text
        JLabel LabelVertexMenu = new JLabel("THE GAME!");
        LabelVertexMenu.setFont(new Font("Tahoma", Font.BOLD, 23));
        LabelVertexMenu.setForeground(Color.white);
        LabelVertexMenu.setHorizontalAlignment(SwingConstants.CENTER);
        LabelVertexMenu.setBounds(5, 5,  (Drawer.FRAME_WIDTH/3) -20, 90);
        textPanel.add(LabelVertexMenu);



        //Color button
        JButton colors = new JButton("Change the color!");
        colors.setFont(new Font("Tahoma", Font.BOLD, 10));
        colors.setForeground(Color.white);
        colors.setBackground(Color.DARK_GRAY);
        colors.addActionListener(vertexColor);
        colors.setBounds(5,Drawer.FRAME_HEIGHT/4,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        colors.setOpaque(true);
        panel.add(colors);

        //reroll button
        JButton reroll = new JButton("Get a new graph!");
        reroll.setFont(new Font("Tahoma", Font.BOLD, 10));
        reroll.setForeground(Color.white);
        reroll.setBackground(Color.DARK_GRAY);
        ActionListener rollie = new reRoll();
        reroll.addActionListener(rollie);
        reroll.setBounds(5,Drawer.FRAME_HEIGHT/4 + buttonSize + buttonSize/2,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        reroll.setOpaque(true);
        panel.add(reroll);

        //Pause button
        /*
        JButton pause = new JButton("PAUSE ||");
        pause.setFont(new Font("Tahoma", Font.BOLD, 10));
        ActionListener pp = new PauseButton();
        pause.setForeground(Color.white);
        pause.setBackground(Color.DARK_GRAY);
        pause.addActionListener(pp);
        pause.setBounds(5,Drawer.FRAME_HEIGHT/4 + 3*buttonSize,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        pause.setOpaque(true);
        panel.add(pause);

         */

        //Finish button
        JButton fini = new JButton("Check result!");
        fini.setFont(new Font("Tahoma", Font.BOLD, 10));
        fini.setForeground(Color.white);
        fini.setBackground(Color.DARK_GRAY);
        ActionListener finish = new FinalCheck();
        fini.addActionListener(finish);
        fini.setBounds(5,Drawer.FRAME_HEIGHT/4 + 3*buttonSize,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        fini.setOpaque(true);
        panel.add(fini);

        // Quit Button

        JButton qq = new JButton("Quitie boi");
        qq.setFont(new Font("Tahoma", Font.BOLD, 10));
        ActionListener quit = new QuitButton();
        qq.addActionListener(quit);
        qq.setForeground(Color.white);
        qq.setBackground(Color.DARK_GRAY);
        qq.setBounds(5,Drawer.FRAME_HEIGHT/4 + 4*buttonSize + buttonSize/2,(Drawer.FRAME_WIDTH/3)-10,buttonSize);
        qq.setOpaque(true);
        panel.add(qq);

        //clock
        clock = new Clock(0,0,true);
        clock.panel.setBounds(35,105,200,90);
        panel.add(clock.panel);
        clock.watch();
        clock.start();

        //Creating the split pane

        splitPane.setBackground(Color.LIGHT_GRAY);
        splitPane.setBounds(0, 0, Drawer.FRAME_WIDTH+ (Drawer.FRAME_WIDTH/3), Drawer.FRAME_HEIGHT);
        splitPane.setDividerSize(1);
        splitPane.setDividerLocation(Drawer.FRAME_WIDTH/3);
        frame.getContentPane().add(splitPane);
        //Assigning the panels to the split pane
        splitPane.setRightComponent(graph);
        splitPane.setLeftComponent(panel);

        frame.setVisible(true);
    }

	public static void close() {
		frame.dispose();
	}


}
