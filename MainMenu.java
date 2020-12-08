import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.*;

public class MainMenu {

	public static JFrame frame;
	private JPanel PanelRightSide;
	private JPanel PanelLeftSide;
	public static int mode;
	static int n;
	static int m;
	public static int Choice;
	public static String filename;

	public MainMenu() {

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
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		;
		CreateLeftandRightPanel();
		CreateMainMenuRight();

	}

		//CREATE THE LEFTSIDE (general) PANEL
			private void CreateLeftandRightPanel() {






					//RIGHT PANEL
					PanelRightSide = new JPanel();
					PanelRightSide.setBackground(Color.DARK_GRAY);
					PanelRightSide.setBounds(250, 0, 466, 457);
					frame.getContentPane().add(PanelRightSide);
					PanelRightSide.setLayout(null);

					//---------------Anything from here is LEFTPANEL----------------------


					//LEFTPANEL
					PanelLeftSide = new JPanel();
					PanelLeftSide.setForeground(Color.CYAN);
					PanelLeftSide.setBackground(Color.WHITE);
					PanelLeftSide.setBounds(0, 0, 250, 457);
					frame.getContentPane().add(PanelLeftSide);
					PanelLeftSide.setLayout(null);


					//LEFTPANEL (inner for text)
					JPanel panel = new JPanel();
					panel.setBackground(Color.DARK_GRAY);
					panel.setBounds(25, 10, 200, 108);
					PanelLeftSide.add(panel);
					panel.setLayout(null);


					//Label Title
					JLabel LabelMainMenu = new JLabel("MAIN MENU");
					LabelMainMenu.setBackground(Color.DARK_GRAY);
					LabelMainMenu.setFont(new Font("Tahoma", Font.BOLD, 23));
					LabelMainMenu.setForeground(Color.WHITE);
					LabelMainMenu.setHorizontalAlignment(SwingConstants.CENTER);
					LabelMainMenu.setBounds(0, 10, 200, 108);
					panel.add(LabelMainMenu);


					//Button ABOUT
					JButton buttonAbout = new JButton("About");
					buttonAbout.setFont(new Font("Tahoma", Font.PLAIN, 14));
					buttonAbout.setFocusable(false);
					buttonAbout.setForeground(Color.WHITE);
					buttonAbout.setBackground(Color.DARK_GRAY);
					buttonAbout.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null,
									"GRAPH COLORING is a game made by 6 DKE Students",
									null, JOptionPane.INFORMATION_MESSAGE);
						}});

					buttonAbout.setBounds(67, 150, 114, 50);
					PanelLeftSide.add(buttonAbout);


					//SEPARATOR
					JSeparator separator1 = new JSeparator();
					separator1.setBackground(Color.BLACK);
					separator1.setBounds(50, 225, 150, 2);
					PanelLeftSide.add(separator1);



					//Button GameModes
					JButton ButtonGameModes = new JButton("Game Modes");
					ButtonGameModes.setFont(new Font("Tahoma", Font.PLAIN, 14));
					ButtonGameModes.setFocusable(false);
					ButtonGameModes.setForeground(Color.WHITE);
					ButtonGameModes.setBackground(Color.DARK_GRAY);
					ButtonGameModes.setBorder(new RoundedBorder(15));
					ButtonGameModes.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							PanelRightSide.removeAll();
							CreateGameModesRight();

						}});

					ButtonGameModes.setBounds(67, 250, 114, 50);
					PanelLeftSide.add(ButtonGameModes);


					//SEPARATOR
					JSeparator separator3 = new JSeparator();
					separator3.setBackground(Color.BLACK);
					separator3.setBounds(50, 325, 150, 2);
					PanelLeftSide.add(separator3);


					//Button Close
					JButton ButtonClose = new JButton("Quit");
					ButtonClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
					ButtonClose.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							System.exit(0);
						}
					});

					ButtonClose.setFocusable(false);
					ButtonClose.setForeground(Color.WHITE);
					ButtonClose.setBackground(Color.DARK_GRAY);
					ButtonClose.setBounds(67, 350, 114, 50);
					PanelLeftSide.add(ButtonClose);

				}

		//CREATE THE RIGHTSIDE PANEL

			//MenuPanel
			private void CreateMainMenuRight() {


				//WELCOME
				JPanel PanelWelcome = new JPanel();
				PanelWelcome.setBackground(Color.DARK_GRAY);
				PanelWelcome.setBounds(150, 89, 200, 50);
				PanelRightSide.add(PanelWelcome);
				PanelWelcome.setLayout(null);

				JLabel TextWelcome = new JLabel("Group 25's: ");
				TextWelcome.setBackground(Color.WHITE);
				TextWelcome.setForeground(Color.WHITE);
				TextWelcome.setBounds(10, 10, 211, 32);
				TextWelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
				PanelWelcome.add(TextWelcome);

				//GRAPH COLORING LABEL(S)
				JLabel G = new JLabel("G");
				G.setHorizontalAlignment(SwingConstants.LEFT);
				G.setForeground(Color.RED);
				G.setBackground(Color.WHITE);
				G.setFont(new Font("Cambria", Font.BOLD, 75));
				G.setBounds(110, 108, 409, 141);
				PanelRightSide.add(G);

				JLabel R = new JLabel("R");
				R.setHorizontalAlignment(SwingConstants.LEFT);
				R.setForeground(Color.ORANGE);
				R.setBackground(Color.WHITE);
				R.setFont(new Font("Cambria", Font.BOLD, 75));
				R.setBounds(160, 108, 409, 141);
				PanelRightSide.add(R);

				JLabel A = new JLabel("A");
				A.setHorizontalAlignment(SwingConstants.LEFT);
				A.setForeground(Color.YELLOW);
				A.setBackground(Color.WHITE);
				A.setFont(new Font("Cambria", Font.BOLD, 75));
				A.setBounds(215, 108, 409, 141);
				PanelRightSide.add(A);

				JLabel P = new JLabel("P");
				P.setHorizontalAlignment(SwingConstants.LEFT);
				P.setForeground(Color.GREEN);
				P.setBackground(Color.WHITE);
				P.setFont(new Font("Cambria", Font.BOLD, 75));
				P.setBounds(265, 108, 409, 141);
				PanelRightSide.add(P);

				JLabel H = new JLabel("H");
				H.setHorizontalAlignment(SwingConstants.LEFT);
				H.setForeground(new Color(0x3D3DFF));
				H.setBackground(Color.WHITE);
				H.setFont(new Font("Cambria", Font.BOLD, 75));
				H.setBounds(310, 108, 409, 141);
				PanelRightSide.add(H);

				JLabel C = new JLabel("C");
				C.setHorizontalAlignment(SwingConstants.LEFT);
				C.setForeground(Color.RED);
				C.setFont(new Font("Cambria", Font.BOLD, 75));
				C.setBackground(Color.WHITE);
				C.setBounds(55, 186, 409, 141);
				PanelRightSide.add(C);

				JLabel O = new JLabel("O");
				O.setHorizontalAlignment(SwingConstants.LEFT);
				O.setForeground(Color.ORANGE);
				O.setFont(new Font("Cambria", Font.BOLD, 75));
				O.setBackground(Color.WHITE);
				O.setBounds(100, 186, 409, 141);
				PanelRightSide.add(O);

				JLabel L = new JLabel("L");
				L.setHorizontalAlignment(SwingConstants.LEFT);
				L.setForeground(Color.YELLOW);
				L.setFont(new Font("Cambria", Font.BOLD, 75));
				L.setBackground(Color.WHITE);
				L.setBounds(150, 186, 409, 141);
				PanelRightSide.add(L);

				JLabel O2 = new JLabel("O");
				O2.setHorizontalAlignment(SwingConstants.LEFT);
				O2.setForeground(Color.GREEN);
				O2.setFont(new Font("Cambria", Font.BOLD, 75));
				O2.setBackground(Color.WHITE);
				O2.setBounds(190, 186, 409, 141);
				PanelRightSide.add(O2);

				JLabel R2 = new JLabel("R");
				R2.setHorizontalAlignment(SwingConstants.LEFT);
				R2.setForeground(new Color(0x3D3DFF));
				R2.setFont(new Font("Cambria", Font.BOLD, 75));
				R2.setBackground(Color.WHITE);
				R2.setBounds(240, 186, 409, 141);
				PanelRightSide.add(R2);

				JLabel I = new JLabel("I");
				I.setHorizontalAlignment(SwingConstants.LEFT);
				I.setForeground(new Color(0x9900FF));
				I.setFont(new Font("Cambria", Font.BOLD, 75));
				I.setBackground(Color.WHITE);
				I.setBounds(295, 186, 409, 141);
				PanelRightSide.add(I);

				JLabel N = new JLabel("N");
				N.setHorizontalAlignment(SwingConstants.LEFT);
				N.setForeground(new Color(0xFF00FF));
				N.setFont(new Font("Cambria", Font.BOLD, 75));
				N.setBackground(Color.WHITE);
				N.setBounds(325, 186, 409, 141);
				PanelRightSide.add(N);

				JLabel G2 = new JLabel("G");
				G2.setHorizontalAlignment(SwingConstants.LEFT);
				G2.setForeground(Color.RED);
				G2.setFont(new Font("Cambria", Font.BOLD, 75));
				G2.setBackground(Color.WHITE);
				G2.setBounds(375, 186, 409, 141);
				PanelRightSide.add(G2);

				//To see the change
				frame.setBounds(100, 100, 720, 481); 		frame.setBounds(100, 100, 720, 480);

			}

			//GameModesPanel
			private void CreateGameModesRight() {





			//TOP TEXT

				JPanel panel_1_2 = new JPanel();
				panel_1_2.setBounds(50, 34, 350, 100);
				PanelRightSide.add(panel_1_2);
				panel_1_2.setLayout(null);

				JLabel lblGameModes = new JLabel("GAME MODES");
				lblGameModes.setBounds(0, 0, 350, 100);
				lblGameModes.setHorizontalAlignment(SwingConstants.CENTER);
				lblGameModes.setForeground(Color.DARK_GRAY);
				lblGameModes.setFont(new Font("Arial Black", Font.BOLD, 40));
				lblGameModes.setBackground(new Color(64, 64, 64));
				panel_1_2.add(lblGameModes);

			//GAMEMODE1

				JPanel GameMode1 = new JPanel();
				GameMode1.setBounds(25, 225, 375, 35);
				PanelRightSide.add(GameMode1);
				GameMode1.setLayout(null);

				JButton ButtonNormalMode = new JButton("Play");
				ButtonNormalMode.addActionListener(new ActionListener() {


						public void actionPerformed(ActionEvent e) {
							setMode1();     //make the mode equal to 1
							popupone pop = new popupone();

						}
					});

				ButtonNormalMode.setFont(new Font("Tahoma", Font.PLAIN, 10));
				ButtonNormalMode.setForeground(Color.WHITE);
				ButtonNormalMode.setFocusable(false);
				ButtonNormalMode.setBackground(Color.DARK_GRAY);
				ButtonNormalMode.setBounds(275, 2, 65, 31);
				GameMode1.add(ButtonNormalMode);

				JLabel NormalMode = new JLabel("Normal mode");
				NormalMode.setHorizontalAlignment(SwingConstants.CENTER);
				NormalMode.setForeground(Color.DARK_GRAY);
				NormalMode.setFont(new Font("Verdana", Font.PLAIN, 26));
				NormalMode.setBackground(new Color(64, 64, 64));
				NormalMode.setBounds(0, 0, 300, 35);
				GameMode1.add(NormalMode);



				//GAMEMODE2

				JPanel GameMode2 = new JPanel();
				GameMode2.setBounds(25, 300, 375, 35);
				PanelRightSide.add(GameMode2);
				GameMode2.setLayout(null);


				JLabel TimeMode = new JLabel("Timemode");
				TimeMode.setBounds(0, 0, 300, 35);
				GameMode2.add(TimeMode);
				TimeMode.setHorizontalAlignment(SwingConstants.CENTER);
				TimeMode.setForeground(Color.DARK_GRAY);
				TimeMode.setFont(new Font("Verdana", Font.PLAIN, 26));
				TimeMode.setBackground(Color.DARK_GRAY);


				JButton ButtonTimeMode = new JButton("Play");
				GameMode2.add(ButtonTimeMode);
				ButtonTimeMode.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							setMode2();                   //make the mode equal to 2
							popupone pop = new popupone();

						}
					});

				ButtonTimeMode.setFont(new Font("Tahoma", Font.PLAIN, 10));
				ButtonTimeMode.setForeground(Color.WHITE);
				ButtonTimeMode.setFocusable(false);
				ButtonTimeMode.setBackground(Color.DARK_GRAY);
				ButtonTimeMode.setBounds(275, 2, 65, 31);
				GameMode2.add(ButtonTimeMode);



			//GAMEMODE3


				JPanel GameMode3 = new JPanel();
				GameMode3.setBounds(25, 371, 375, 35);
				PanelRightSide.add(GameMode3);
				GameMode3.setLayout(null);

				JLabel RandomMode = new JLabel("Random Mode");
				RandomMode.setBounds(0, 0, 300, 35);
				GameMode3.add(RandomMode);
				RandomMode.setHorizontalAlignment(SwingConstants.CENTER);
				RandomMode.setForeground(Color.DARK_GRAY);
				RandomMode.setFont(new Font("Verdana", Font.PLAIN, 26));
				RandomMode.setBackground(Color.DARK_GRAY);


				JButton ButtonRondomMode = new JButton("Play");
				ButtonRondomMode.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							setMode3(); 			//make the mode equal to 3
							popupone pop = new popupone();

						}
					});

				ButtonRondomMode.setFont(new Font("Tahoma", Font.PLAIN, 10));
				ButtonRondomMode.setForeground(Color.WHITE);
				ButtonRondomMode.setFocusable(false);
				ButtonRondomMode.setBackground(Color.DARK_GRAY);
				ButtonRondomMode.setBounds(275, 2, 65, 31);
				GameMode3.add(ButtonRondomMode);


			//To see the change
					frame.setBounds(100, 100, 720, 481); frame.setBounds(100, 100, 720, 480);
			}

		//CREATE Pop-ups

			//Generate-Upload popup
			public static void fistpopup() {





					Choice = (popupone.getans());   //1 is generate and 2 is upload


					//GENERATE (see setModes methods)
					if (Choice == 1) {
						System.out.println("Generate Graph");
						askinginputs();


						//launch GameMode1 with n nodes and m edges
						if (mode == 1) {
							new InGameFrame(n,m);
							frame.dispose();
						}
						//launch GameMode2 with n nodes and m edges
						if (mode == 2) {
							new InGameFrame2(n,m);
							frame.dispose();


						}
						//launch GameMode3 with n nodes and m edges
						if(mode == 3) {
							new InGameFrame3(n,m);
							frame.dispose();
						}


					}


					//UPLOAD: select different files for different modes (see selectfile method)
					if (Choice == 2) {
						System.out.println("Upload Graph");

						if (mode == 1) {
							filename = selectfile();
							new InGameFrame(filename);
							frame.dispose();

						}
						if (mode == 2) {
							filename = selectfile();
							new InGameFrame2(filename);
							frame.dispose();


						}

						if(mode == 3) {
							filename = selectfile();
							new InGameFrame3(filename);
							frame.dispose();
						}

					}
			}

			//SelectFile
			public static String selectfile() {


				//Choose file	(getting its path in the computer)
					JFileChooser fileChooser = new JFileChooser();
					int response = fileChooser.showOpenDialog(null); //respose is 0(closed popup)  or 1(opened file)

					if(response == JFileChooser.APPROVE_OPTION) {
						File pickfile = new File(fileChooser.getSelectedFile().getAbsolutePath());        // Choose file
						String filepath = pickfile.toString();                                            //path to file represented as a String
						System.out.println("filepath...." + filepath);
						System.out.println();
						return filepath;

					}
					return null;
			}


			//Asking input
			public static void askinginputs() {


					//Draw the pop up as a panel

				    JTextField nField = new JTextField(5);
				    JTextField mField = new JTextField(5);

				    JPanel myPanel = new JPanel();
				    myPanel.add(new JLabel("Nodes:"));
				    myPanel.add(nField);
				    myPanel.add(Box.createHorizontalStrut(30));
				    myPanel.add(new JLabel("Vertices:"));
				    myPanel.add(mField);

				    //Generate the pop up
				    int result = JOptionPane.showConfirmDialog(null, myPanel,
				        "number of nodes and vertices?", JOptionPane.OK_CANCEL_OPTION);

				    //if OK is pressed, we take the inputs
				    if (result == JOptionPane.OK_OPTION) {
				    	//this is a dangerous code since the user could enter an invalid input (a String for example)
				    	try {
				    					Integer nodes = Integer.valueOf(nField.getText());
									    Integer edges = Integer.valueOf(mField.getText());

									    if (DarioCheck(nodes,edges)) {    //DarioCheck is a test that returns true or false depending on
								    									  //if the combination of nodes and edges makes a possible graph
									    								  //(test is passed if it does)
									    	System.out.println("Test passed");
									    	setvalues(nodes, edges);	  //set VALID (test passed) nodes and edges
									    }

									    else
								    	{
									     System.out.println("Test NOT passed");
									     askingVALIDinputs();			//Ask again till valid entries are typed
								    	}
				    	}

				    	//if an error occur (most likely a wrong input), we consider that the test has failed
				    	catch(Exception ex) {
				    		System.out.println("Shit....an exception, let's say Test NOT passed :) ");
				    		askingVALIDinputs();
				    	}


				    }

			}

			//Asking input if things go bad
			public static void askingVALIDinputs() {  //Same as asking input but different texts to show that it is not attempt one


			    JTextField nField = new JTextField(5);
			    JTextField mField = new JTextField(5);

			    JPanel myPanel = new JPanel();
			    myPanel.add(new JLabel("(Valid) Nodes:"));
			    myPanel.add(nField);
			    myPanel.add(Box.createHorizontalStrut(30)); // a spacer
			    myPanel.add(new JLabel("(Valid) Vertices:"));
			    myPanel.add(mField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
			        "PLEASE ENTER VALID VALUES !!!", JOptionPane.OK_CANCEL_OPTION);

			    if (result == JOptionPane.OK_OPTION) {
			    	try {

			    			Integer nodes = Integer.valueOf(nField.getText());
				    		Integer edges = Integer.valueOf(mField.getText());

						    if (DarioCheck(nodes,edges)) {
						    	System.out.println("Test passed");
						    	setvalues(nodes, edges);

						    }
						    else
					    	 {
						     System.out.println("Test NOT passed");
						     askingVALIDinputs();
					    	 }
			       }
				   catch(Exception ex) {
			    		System.out.println("Shit....an exception, let's say Test NOT passed :) ");
			    		askingVALIDinputs();
			       }
			   }
		    }


			//Check if the test is passed
			public static boolean DarioCheck(int nodes , int edges) {


				if (nodes < edges && (nodes*(nodes-1))/2 >= edges) {   //if condition fulfilled, it is a possible combination

					return true;
				}
				else return false;
			}



			//GETTERS AND SETTERS...

			public static int  getN () {

				return n;
			}

			public static int getM() {

				return m;
			}

			public static void setvalues(int nodes, int edges) {		//Set the number of edges n and edges m



				n = nodes;
				m = edges;

			}

			public void setMode1() {


				mode = 1;
			}

			public void setMode2() {
				mode =2;
			}

			public void setMode3() {
				mode =3;
			}


}
