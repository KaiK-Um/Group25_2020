import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class PauseMenu {

	JFrame frame;
	private JPanel PanelRightSide;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public PauseMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		//FRAME
		ImageIcon icon        = new ImageIcon("25.png");
		frame = new JFrame();
		frame.setIconImage(icon.getImage());
		frame.setTitle("Group 25- MainMenu");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, Drawer.FRAME_WIDTH+ (Drawer.FRAME_WIDTH/3) + 10, Drawer.FRAME_HEIGHT+38);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);


		//RIGHT PANEL
		PanelRightSide = new JPanel();
		PanelRightSide.setBackground(Color.DARK_GRAY);
		PanelRightSide.setBounds(250, 0, Drawer.FRAME_WIDTH, Drawer.FRAME_HEIGHT);
		frame.getContentPane().add(PanelRightSide);
		PanelRightSide.setLayout(null);


		//GAME1
		JLabel G = new JLabel("G");
		G.setHorizontalAlignment(SwingConstants.LEFT);
		G.setForeground(Color.RED);
		G.setFont(new Font("Cambria", Font.BOLD, 100));
		G.setBackground(Color.ORANGE);
		G.setBounds(70, 75, 400, 150);
		PanelRightSide.add(G);
		JLabel A = new JLabel("A");
		A.setHorizontalAlignment(SwingConstants.LEFT);
		A.setForeground(Color.ORANGE);
		A.setFont(new Font("Cambria", Font.BOLD, 100));
		A.setBackground(Color.ORANGE);
		A.setBounds(140, 75, 400, 150);
		PanelRightSide.add(A);
		JLabel M = new JLabel("M");
		M.setHorizontalAlignment(SwingConstants.LEFT);
		M.setForeground(Color.YELLOW);
		M.setFont(new Font("Cambria", Font.BOLD, 100));
		M.setBackground(Color.ORANGE);
		M.setBounds(212, 75, 400, 150);
		PanelRightSide.add(M);
		JLabel E = new JLabel("E");
		E.setHorizontalAlignment(SwingConstants.LEFT);
		E.setForeground(Color.GREEN);
		E.setFont(new Font("Cambria", Font.BOLD, 100));
		E.setBackground(Color.ORANGE);
		E.setBounds(300, 75, 400, 150);
		PanelRightSide.add(E);
		//PAUSED1
		JLabel p = new JLabel("P");
		p.setHorizontalAlignment(SwingConstants.LEFT);
		p.setForeground(Color.RED);
		p.setFont(new Font("Cambria", Font.BOLD, 100));
		p.setBackground(new Color(221, 160, 221));
		p.setBounds(30, 200, 400, 125);
		PanelRightSide.add(p);
		JLabel a = new JLabel("A");
		a.setHorizontalAlignment(SwingConstants.LEFT);
		a.setForeground(Color.ORANGE);
		a.setFont(new Font("Cambria", Font.BOLD, 100));
		a.setBackground(new Color(221, 160, 221));
		a.setBounds(90, 200, 400, 125);
		PanelRightSide.add(a);
		JLabel u = new JLabel("U");
		u.setHorizontalAlignment(SwingConstants.LEFT);
		u.setForeground(Color.YELLOW);
		u.setFont(new Font("Cambria", Font.BOLD, 100));
		u.setBackground(new Color(221, 160, 221));
		u.setBounds(155, 200, 400, 125);
		PanelRightSide.add(u);
		JLabel s = new JLabel("S");
		s.setHorizontalAlignment(SwingConstants.LEFT);
		s.setForeground(Color.GREEN);
		s.setFont(new Font("Cambria", Font.BOLD, 100));
		s.setBackground(new Color(221, 160, 221));
		s.setBounds(225, 200, 400, 125);
		PanelRightSide.add(s);
		JLabel e = new JLabel("E");
		e.setHorizontalAlignment(SwingConstants.LEFT);
		e.setForeground(new Color(0x3D3DFF));
		e.setFont(new Font("Cambria", Font.BOLD, 100));
		e.setBackground(new Color(221, 160, 221));
		e.setBounds(277, 200, 400, 125);
		PanelRightSide.add(e);
		JLabel d = new JLabel("D");
		d.setHorizontalAlignment(SwingConstants.LEFT);
		d.setForeground(new Color(0x9900FF));
		d.setFont(new Font("Cambria", Font.BOLD, 100));
		d.setBackground(new Color(221, 160, 221));
		d.setBounds(335, 200, 400, 125);
		PanelRightSide.add(d);
		//GAME2
		JLabel G1 = new JLabel("G");
		G1.setHorizontalAlignment(SwingConstants.LEFT);
		G1.setForeground(Color.RED);
		G1.setFont(new Font("Cambria", Font.BOLD, 100));
		G1.setBackground(Color.ORANGE);
		G1.setBounds(455, 75, 400, 150);
		PanelRightSide.add(G1);
		JLabel A1 = new JLabel("A");
		A1.setHorizontalAlignment(SwingConstants.LEFT);
		A1.setForeground(Color.ORANGE);
		A1.setFont(new Font("Cambria", Font.BOLD, 100));
		A1.setBackground(Color.ORANGE);
		A1.setBounds(525, 75, 400, 150);
		PanelRightSide.add(A1);
		JLabel M1 = new JLabel("M");
		M1.setHorizontalAlignment(SwingConstants.LEFT);
		M1.setForeground(Color.YELLOW);
		M1.setFont(new Font("Cambria", Font.BOLD, 100));
		M1.setBackground(Color.ORANGE);
		M1.setBounds(597, 75, 400, 150);
		PanelRightSide.add(M1);
		JLabel E1 = new JLabel("E");
		E1.setHorizontalAlignment(SwingConstants.LEFT);
		E1.setForeground(Color.GREEN);
		E1.setFont(new Font("Cambria", Font.BOLD, 100));
		E1.setBackground(Color.ORANGE);
		E1.setBounds(685, 75, 400, 150);
		PanelRightSide.add(E1);
		//PAUSED2
		JLabel p1 = new JLabel("P");
		p1.setHorizontalAlignment(SwingConstants.LEFT);
		p1.setForeground(Color.RED);
		p1.setFont(new Font("Cambria", Font.BOLD, 100));
		p1.setBackground(new Color(221, 160, 221));
		p1.setBounds(415, 200, 400, 125);
		PanelRightSide.add(p1);
		JLabel a1 = new JLabel("A");
		a1.setHorizontalAlignment(SwingConstants.LEFT);
		a1.setForeground(Color.ORANGE);
		a1.setFont(new Font("Cambria", Font.BOLD, 100));
		a1.setBackground(new Color(221, 160, 221));
		a1.setBounds(475, 200, 400, 125);
		PanelRightSide.add(a1);
		JLabel u1 = new JLabel("U");
		u1.setHorizontalAlignment(SwingConstants.LEFT);
		u1.setForeground(Color.YELLOW);
		u1.setFont(new Font("Cambria", Font.BOLD, 100));
		u1.setBackground(new Color(221, 160, 221));
		u1.setBounds(540, 200, 400, 125);
		PanelRightSide.add(u1);
		JLabel s1 = new JLabel("S");
		s1.setHorizontalAlignment(SwingConstants.LEFT);
		s1.setForeground(Color.GREEN);
		s1.setFont(new Font("Cambria", Font.BOLD, 100));
		s1.setBackground(new Color(221, 160, 221));
		s1.setBounds(610, 200, 400, 125);
		PanelRightSide.add(s1);
		JLabel e1 = new JLabel("E");
		e1.setHorizontalAlignment(SwingConstants.LEFT);
		e1.setForeground(new Color(0x3D3DFF));
		e1.setFont(new Font("Cambria", Font.BOLD, 100));
		e1.setBackground(new Color(221, 160, 221));
		e1.setBounds(662, 200, 400, 125);
		PanelRightSide.add(e1);
		JLabel d1 = new JLabel("D");
		d1.setHorizontalAlignment(SwingConstants.LEFT);
		d1.setForeground(new Color(0x9900FF));
		d1.setFont(new Font("Cambria", Font.BOLD, 100));
		d1.setBackground(new Color(221, 160, 221));
		d1.setBounds(720, 200, 400, 125);
		PanelRightSide.add(d1);

		//GAME3
		JLabel G2 = new JLabel("G");
		G2.setHorizontalAlignment(SwingConstants.LEFT);
		G2.setForeground(Color.RED);
		G2.setFont(new Font("Cambria", Font.BOLD, 100));
		G2.setBackground(Color.ORANGE);
		G2.setBounds(70, 450, 400, 150);
		PanelRightSide.add(G2);
		JLabel A2 = new JLabel("A");
		A2.setHorizontalAlignment(SwingConstants.LEFT);
		A2.setForeground(Color.ORANGE);
		A2.setFont(new Font("Cambria", Font.BOLD, 100));
		A2.setBackground(Color.ORANGE);
		A2.setBounds(140, 450, 400, 150);
		PanelRightSide.add(A2);
		JLabel M2 = new JLabel("M");
		M2.setHorizontalAlignment(SwingConstants.LEFT);
		M2.setForeground(Color.YELLOW);
		M2.setFont(new Font("Cambria", Font.BOLD, 100));
		M2.setBackground(Color.ORANGE);
		M2.setBounds(212, 450, 400, 150);
		PanelRightSide.add(M2);
		JLabel E2 = new JLabel("E");
		E2.setHorizontalAlignment(SwingConstants.LEFT);
		E2.setForeground(Color.GREEN);
		E2.setFont(new Font("Cambria", Font.BOLD, 100));
		E2.setBackground(Color.ORANGE);
		E2.setBounds(300, 450, 400, 150);
		PanelRightSide.add(E2);
		//PAUSED3
		JLabel p2 = new JLabel("P");
		p2.setHorizontalAlignment(SwingConstants.LEFT);
		p2.setForeground(Color.RED);
		p2.setFont(new Font("Cambria", Font.BOLD, 100));
		p2.setBackground(new Color(221, 160, 221));
		p2.setBounds(30, 600, 400, 125);
		PanelRightSide.add(p2);
		JLabel a2 = new JLabel("A");
		a2.setHorizontalAlignment(SwingConstants.LEFT);
		a2.setForeground(Color.ORANGE);
		a2.setFont(new Font("Cambria", Font.BOLD, 100));
		a2.setBackground(new Color(221, 160, 221));
		a2.setBounds(90, 600, 400, 125);
		PanelRightSide.add(a2);
		JLabel u2 = new JLabel("U");
		u2.setHorizontalAlignment(SwingConstants.LEFT);
		u2.setForeground(Color.YELLOW);
		u2.setFont(new Font("Cambria", Font.BOLD, 100));
		u2.setBackground(new Color(221, 160, 221));
		u2.setBounds(155, 600, 400, 125);
		PanelRightSide.add(u2);
		JLabel s2 = new JLabel("S");
		s2.setHorizontalAlignment(SwingConstants.LEFT);
		s2.setForeground(Color.GREEN);
		s2.setFont(new Font("Cambria", Font.BOLD, 100));
		s2.setBackground(new Color(221, 160, 221));
		s2.setBounds(225, 600, 400, 125);
		PanelRightSide.add(s2);
		JLabel e2 = new JLabel("E");
		e2.setHorizontalAlignment(SwingConstants.LEFT);
		e2.setForeground(new Color(0x3D3DFF));
		e2.setFont(new Font("Cambria", Font.BOLD, 100));
		e2.setBackground(new Color(221, 160, 221));
		e2.setBounds(277, 600, 400, 125);
		PanelRightSide.add(e2);
		JLabel d2 = new JLabel("D");
		d2.setHorizontalAlignment(SwingConstants.LEFT);
		d2.setForeground(new Color(0x9900FF));
		d2.setFont(new Font("Cambria", Font.BOLD, 100));
		d2.setBackground(new Color(221, 160, 221));
		d2.setBounds(335, 600, 400, 125);
		PanelRightSide.add(d2);
		//GAME4
		JLabel G3 = new JLabel("G");
		G3.setHorizontalAlignment(SwingConstants.LEFT);
		G3.setForeground(Color.RED);
		G3.setFont(new Font("Cambria", Font.BOLD, 100));
		G3.setBackground(Color.ORANGE);
		G3.setBounds(455, 450, 400, 150);
		PanelRightSide.add(G3);
		JLabel A3 = new JLabel("A");
		A3.setHorizontalAlignment(SwingConstants.LEFT);
		A3.setForeground(Color.ORANGE);
		A3.setFont(new Font("Cambria", Font.BOLD, 100));
		A3.setBackground(Color.ORANGE);
		A3.setBounds(525, 450, 400, 150);
		PanelRightSide.add(A3);
		JLabel M3 = new JLabel("M");
		M3.setHorizontalAlignment(SwingConstants.LEFT);
		M3.setForeground(Color.YELLOW);
		M3.setFont(new Font("Cambria", Font.BOLD, 100));
		M3.setBackground(Color.ORANGE);
		M3.setBounds(597, 450, 400, 150);
		PanelRightSide.add(M3);
		JLabel E3 = new JLabel("E");
		E3.setHorizontalAlignment(SwingConstants.LEFT);
		E3.setForeground(Color.GREEN);
		E3.setFont(new Font("Cambria", Font.BOLD, 100));
		E3.setBackground(Color.ORANGE);
		E3.setBounds(685, 450, 400, 150);
		PanelRightSide.add(E3);
		//PAUSED4
		JLabel p3 = new JLabel("P");
		p3.setHorizontalAlignment(SwingConstants.LEFT);
		p3.setForeground(Color.RED);
		p3.setFont(new Font("Cambria", Font.BOLD, 100));
		p3.setBackground(new Color(221, 160, 221));
		p3.setBounds(415, 600, 400, 125);
		PanelRightSide.add(p3);
		JLabel a3 = new JLabel("A");
		a3.setHorizontalAlignment(SwingConstants.LEFT);
		a3.setForeground(Color.ORANGE);
		a3.setFont(new Font("Cambria", Font.BOLD, 100));
		a3.setBackground(new Color(221, 160, 221));
		a3.setBounds(475, 600, 400, 125);
		PanelRightSide.add(a3);
		JLabel u3 = new JLabel("U");
		u3.setHorizontalAlignment(SwingConstants.LEFT);
		u3.setForeground(Color.YELLOW);
		u3.setFont(new Font("Cambria", Font.BOLD, 100));
		u3.setBackground(new Color(221, 160, 221));
		u3.setBounds(540, 600, 400, 125);
		PanelRightSide.add(u3);
		JLabel s3 = new JLabel("S");
		s3.setHorizontalAlignment(SwingConstants.LEFT);
		s3.setForeground(Color.GREEN);
		s3.setFont(new Font("Cambria", Font.BOLD, 100));
		s3.setBackground(new Color(221, 160, 221));
		s3.setBounds(610, 600, 400, 125);
		PanelRightSide.add(s3);
		JLabel e3 = new JLabel("E");
		e3.setHorizontalAlignment(SwingConstants.LEFT);
		e3.setForeground(new Color(0x3D3DFF));
		e3.setFont(new Font("Cambria", Font.BOLD, 100));
		e3.setBackground(new Color(221, 160, 221));
		e3.setBounds(662, 600, 400, 125);
		PanelRightSide.add(e3);
		JLabel d3 = new JLabel("D");
		d3.setHorizontalAlignment(SwingConstants.LEFT);
		d3.setForeground(new Color(0x9900FF));
		d3.setFont(new Font("Cambria", Font.BOLD, 100));
		d3.setBackground(new Color(221, 160, 221));
		d3.setBounds(720, 600, 400, 125);
		PanelRightSide.add(d3);

		//LEFTPANEL
		JPanel panelSide = new JPanel();
		panelSide.setForeground(Color.CYAN);
		panelSide.setBackground(Color.WHITE);
		panelSide.setBounds(0,0,(Drawer.FRAME_WIDTH/3),Drawer.FRAME_HEIGHT);
		frame.getContentPane().add(panelSide);
		panelSide.setLayout(null);



		//SIDEPANEL (inner for text)
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(25, 10, 200, 108);
		panelSide.add(panel);
		panel.setLayout(null);


		//Label Title
		JLabel LabelVertexMenu = new JLabel("PAUSE MENU");
		LabelVertexMenu.setBounds(0, 0, 200, 108);
		panel.add(LabelVertexMenu);
		LabelVertexMenu.setFont(new Font("Tahoma", Font.BOLD, 23));
		LabelVertexMenu.setForeground(Color.WHITE);
		LabelVertexMenu.setHorizontalAlignment(SwingConstants.CENTER);


		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setBounds(25, 650, 200, 108);
		panelSide.add(panel1);
		panel1.setLayout(null);


		//Label GROUP25
		JLabel GROUP25 = new JLabel("GROUP 25");
		GROUP25.setBounds(0, 0, 200, 108);
		panel1.add(GROUP25);
		GROUP25.setFont(new Font("Tahoma", Font.BOLD, 23));
		GROUP25.setForeground(Color.WHITE);
		GROUP25.setHorizontalAlignment(SwingConstants.CENTER);

		//Button RETURN
		JButton buttonReturn = new JButton("Resume");
		buttonReturn.setFocusable(false);
		buttonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		buttonReturn.setBounds(67, 275, 114, 50);
		buttonReturn.setBackground(Color.DARK_GRAY);
		buttonReturn.setForeground(Color.WHITE);
		panelSide.add(buttonReturn);


		//SEPARATOR
		JSeparator separator2 = new JSeparator();
		separator2.setBackground(Color.BLACK);
		separator2.setBounds(50, 375, 150, 2);
		panelSide.add(separator2);

		//Button RETURN
		JButton buttonQuit = new JButton("Quit Game");
		buttonQuit.setFocusable(false);
		buttonQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", null, JOptionPane.YES_NO_OPTION);

				if (answer == 0) {
					frame.remove(panelSide);
					frame.remove(PanelRightSide);

					JLabel GameOver = new JLabel("GAME OVER");
					GameOver.setFont(new Font("Tahoma", Font.BOLD, 100));
					GameOver.setForeground(Color.RED);
					GameOver.setHorizontalAlignment(SwingConstants.CENTER);
					GameOver.setBounds(-10, -50, 720, 480);
					frame.getContentPane().add(GameOver);

					//Change dimensions to make the change in the frame visible
					frame.setBounds(100, 100, 720, 481);frame.setBounds(100, 100, 720, 480);


					int a = JOptionPane.showConfirmDialog(null, "Thanks for playing GraphColoring", null, JOptionPane.DEFAULT_OPTION);
					if (a==0||a==-1) {System.exit(0);}

				}

			}
		});
		buttonQuit.setBounds(67, 427, 114, 50);
		buttonQuit.setBackground(Color.DARK_GRAY);
		buttonQuit.setForeground(Color.WHITE);
		panelSide.add(buttonQuit);


	}
}
