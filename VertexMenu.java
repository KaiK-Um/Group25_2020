import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class VertexMenu{

	JFrame frame;

	//colors
	public Color [] allcolors = {new Color(0x000000),new Color(0x0000bd),new Color(0x5d0016),new Color(0xF20019)
			,new Color(0x827800),new Color(0x8F00c7),new Color(0x0086FE),new Color(0x008000)
			,new Color(0x00FEFE),new Color(0xFE68FE),new Color(0xFE8420),new Color(0x70FE00)
			,new Color(0xFEFE00),new Color(0xFED38B),new Color(0xA0D681),new Color(0xFFFFFF)};

	//names of the colors
	String [] allcolorsnames = {"Black","DarkBlue","Red","DarkOrange",
			"Brown","Purple","Blue","DarkGreen",
			"Cyan","Pink","Orange","FlashyGreen",
			"Yellow","Beige","LightGreen","White"};


	/**
	 * Create the application.
	 */
	public VertexMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		boolean colorblind;

		//n means Number of row and columns of the gridlayout
		int n = 0;

		if(allcolors.length <= 2) {
			n= 2;
		}

		//This dimension seems to be the best to conserving th square shape of the buttons
		else {
			int sqrt= (int) Math.sqrt(allcolors.length);
			n =sqrt;
		}


		//FRAME
		ImageIcon icon        = new ImageIcon("25.png");
		frame = new JFrame();
		frame.setIconImage(icon.getImage());
		frame.setTitle("Group 25- VertexMenu");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 400, 300);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		//SIDEPANEL
		JPanel panelSide = new JPanel();
		panelSide.setForeground(Color.WHITE);
		panelSide.setBackground(Color.WHITE);
		panelSide.setBounds(0, 0, 100, 300);
		frame.getContentPane().add(panelSide);
		panelSide.setLayout(null);

		//SIDEPANEL (inner for text)
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 10, 80, 50);
		panelSide.add(panel);
		panel.setLayout(null);

		//Label Title
		JLabel LabelVertex = new JLabel("VERTEX");
		LabelVertex.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelVertex.setForeground(Color.WHITE);
		LabelVertex.setHorizontalAlignment(SwingConstants.CENTER);
		LabelVertex.setBounds(10, 5, 60, 20);
		panel.add(LabelVertex);

		JLabel LabelMenu = new JLabel("MENU");
		LabelMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		LabelMenu.setForeground(Color.WHITE);
		LabelMenu.setHorizontalAlignment(SwingConstants.CENTER);
		LabelMenu.setBounds(10, 25, 60, 20);
		panel.add(LabelMenu);

		//Button RETURN
		JButton buttonReturn = new JButton("Return");
		buttonReturn.setFocusable(false);
		buttonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		buttonReturn.setBounds(10, 105, 80, 30);
		buttonReturn.setBackground(Color.DARK_GRAY);
		buttonReturn.setForeground(Color.WHITE);
		panelSide.add(buttonReturn);

		//SEPARATOR
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 155, 80, 2);
		panelSide.add(separator_1);

		//Panel of colors
		JPanel panelColorin = new JPanel();
		panelColorin.setBackground(Color.GRAY);
		panelColorin.setForeground(Color.DARK_GRAY);
		panelColorin.setBounds(120, 10, 245, 245);
		frame.getContentPane().add(panelColorin);
		panelColorin.setLayout(new GridLayout(n,n));


		//Button COLORBLIND this is done only if Colorblind is touched (for the comments,
																	   //skip to the for loop around line 175)
		JButton buttonColorblind = new JButton("Names");
		buttonColorblind.setFocusable(false);
		buttonColorblind.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				panelColorin.removeAll();	//clear the Panel to redraw it for colorblind

				boolean colorblind = true;		//Change to true . if(colorblind) will be executed

				for (int i=0; i<allcolors.length; i++) {

					//create buttons
					CustomButton currentbutton = new CustomButton (i);
					currentbutton.setFocusable(false);
					currentbutton.setPreferredSize(new Dimension(90,90));
					currentbutton.setFont(new Font("TimesRoman", Font.BOLD, 15));
					currentbutton.setBorder(BorderFactory.createLineBorder(Color.black));
					currentbutton.setBackground(allcolors[i]);
					panelColorin.add(currentbutton);


					if(colorblind) {
						currentbutton.setBackground(Color.white);
						currentbutton.setForeground(Color.DARK_GRAY);
						currentbutton.setText(allcolorsnames[i]);
					}


					currentbutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", null, JOptionPane.YES_NO_OPTION);

							//if yes is selected, current color is changed
							if (answer == 0) {
								frame.getContentPane().setBackground(allcolors[currentbutton.currentbuttoncolorindex]);
								Main.currentColor= allcolors[currentbutton.currentbuttoncolorindex];
								frame.dispose();
							}
							if (answer == 1) {
								return;
							}
						}
					});
				}
			}
		});

		//button for colorblind
		buttonColorblind.setBounds(10, 177, 80, 30);
		buttonColorblind.setBackground(Color.DARK_GRAY);
		buttonColorblind.setForeground(Color.WHITE);
		panelSide.add(buttonColorblind);

		//Happens by default

		for (int i=0; i<allcolors.length; i++) {

			colorblind = false;	  							//the default choice
			String currentcolorname =allcolorsnames[i];		//current color name (from the array at the top, for colorblind)
			Color currentcolor =allcolors[i];				//current color (from the array at the top)


			//create buttons that are added to the grid layouts
			CustomButton currentbutton = new CustomButton (i);		//i is unique for every buttons (to easily access them)
			currentbutton.setFocusable(false);
			currentbutton.setPreferredSize(new Dimension(90,90));
			currentbutton.setFont(new Font("TimesRoman", Font.BOLD, 15));
			currentbutton.setBorder(BorderFactory.createLineBorder(Color.black));
			currentbutton.setBackground(currentcolor);
			panelColorin.add(currentbutton);


			if(colorblind) {	//if colorblind, write the color instead of showing the color
				currentbutton.setBackground(Color.DARK_GRAY);
				currentbutton.setForeground(Color.WHITE);
				currentbutton.setText(currentcolorname);
			}


			currentbutton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", null, JOptionPane.YES_NO_OPTION);

					//If the user is sure and selects YES
					if (answer == 0) {
						frame.getContentPane().setBackground(allcolors[currentbutton.currentbuttoncolorindex]);
						Drawer.currentColor= allcolors[currentbutton.currentbuttoncolorindex];		//pass the color to the DrawerClass (for coloring the node)

						//pass the color to the frame in the game and color it with the selected color (for every mode)
						if(MainMenu.mode == 1){
							InGameFrame.panel.setBackground(allcolors[currentbutton.currentbuttoncolorindex]);
						}else if(MainMenu.mode == 2){
							InGameFrame2.panel.setBackground(allcolors[currentbutton.currentbuttoncolorindex]);
						}else if(MainMenu.mode == 3){
							InGameFrame3.panel.setBackground(allcolors[currentbutton.currentbuttoncolorindex]);
						}
						frame.dispose();
					}
					if (answer == 1) {
						return;
					}
				}
			});
		}



	}


}
