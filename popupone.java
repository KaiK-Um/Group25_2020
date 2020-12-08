import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class popupone {

	private JFrame frame;
	public static int answer;

	/**
	 * Create the application.
	 */
	public popupone() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {



		
		int answer = 0;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(800, 100, 500, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 273, 486, 50);
		panel_3.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("(Chose whether you want to generate or upload a graph)");
		lblNewLabel.setBounds(0, 0, 486, 50);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.ITALIC, 14));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 486, 50);
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Type Chooser");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 33));
		lblNewLabel_2.setBackground(SystemColor.menu);
		lblNewLabel_2.setBounds(0, 0, 486, 50);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(300, 92, 150, 150);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Upload ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_1.setBounds(0, 0, 150, 50);
		panel_1_1.add(lblNewLabel_1_1);
		
		JButton ButtonUpload = new JButton("Click here");
		
		ButtonUpload.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {

				
			setans2();
			MainMenu.fistpopup();
			frame.dispose();
				
			}
		});
		
		ButtonUpload.setForeground(Color.BLACK);
		ButtonUpload.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 12));
		ButtonUpload.setFocusable(false);
		ButtonUpload.setBorder(new RoundedBorder(15));
		ButtonUpload.setBackground(SystemColor.menu);
		ButtonUpload.setBounds(26, 46, 99, 75);
		panel_1_1.add(ButtonUpload);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(240,240,240));
		panel_1_1_1.setBounds(32, 92, 150, 150);
		frame.getContentPane().add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Generate");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 150, 50);
		panel_1_1_1.add(lblNewLabel_1);
		
		
		
		JButton ButtonGenerate = new JButton("Click here");
		ButtonGenerate.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {				
				setans1();
				MainMenu.fistpopup();
				frame.dispose();
			}
		});
		
		ButtonGenerate.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 12));
		ButtonGenerate.setForeground(Color.BLACK);
		ButtonGenerate.setFocusable(false);
		ButtonGenerate.setBorder(new RoundedBorder(15));
		ButtonGenerate.setBackground(new Color(240,240,240));
		ButtonGenerate.setBounds(22, 47, 99, 75);
		panel_1_1_1.add(ButtonGenerate);
		
		
	}

	public void setans1() {
		answer = 1;
	}
	
	public void setans2() {

		answer = 2;
	}
	
	public static int getans() {
		
		return answer;
	}
}
