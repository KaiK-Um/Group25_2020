import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FinalCheck implements ActionListener
{
    public int colorsUsed;
    public int chromaticNumber;
    public void actionPerformed(ActionEvent event)
    {
        boolean finished = true;
        try {
            for (int i = 1; i <= Drawer.g.getAmountVertices(); i++) {
                if (!ColorChecker.Check(i)) finished = false;
            }
            ArrayList<Color> usedColors = new ArrayList<Color>();
            for (int i = 0; i < Drawer.colorList.length; i++) {
                if (!usedColors.contains(Drawer.colorList[i])) {
                    usedColors.add(Drawer.colorList[i]);
                }
            }
            colorsUsed = usedColors.size();
            //System.out.println("amount colors used" + colorsUsed);
        }
        catch(Exception e){
            finished = false;
        }


        Greedy greedy = new Greedy(Drawer.g);
        greedy.upperBound();
       // System.out.println("greeedy:" +cry.getchromaticOfGreedy());

        RLF rlf = new RLF(Drawer.g);
        rlf.solve();
        //System.out.println("RLF:"+red.getChromaticOfRLF());

        LowerBound lowerBound= new LowerBound(Drawer.g);
        lowerBound.solve();
        //System.out.println("Clique:"+kai.getMaxSize());

        BruteForce bruteForce = new BruteForce(Drawer.g);
        bruteForce.solve();
        chromaticNumber = bruteForce.getChromatic();

        System.out.println(chromaticNumber);
        if(chromaticNumber != colorsUsed) finished = false;
        if(finished) {
            if (MainMenu.mode == 1) {
                InGameFrame.frame.remove(InGameFrame.splitPane);

                JPanel rPanel = new JPanel(null);
                rPanel.setBounds(Drawer.FRAME_WIDTH/3,0,Drawer.FRAME_WIDTH,Drawer.FRAME_HEIGHT);
                rPanel.setBackground(Color.lightGray);

                JPanel panel = new JPanel(null);
                panel.setBorder(null);
                panel.setBounds(0,0,800/3,800);


                JLabel succes = new JLabel("Congratulations! :)");
                succes.setFont(new Font("Tahoma", Font.BOLD, 70));
                succes.setForeground(Color.DARK_GRAY);
                succes.setHorizontalAlignment(SwingConstants.CENTER);
                succes.setBounds(33, 42, 720, 276);
                rPanel.add(succes);

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
                usedColors = colors.size();

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


                InGameFrame.frame.add(splitPane);
                InGameFrame.frame.repaint();




            } else if (MainMenu.mode == 2) {
                InGameFrame2.frame.remove(InGameFrame2.splitPane);

                JPanel rPanel = new JPanel(null);
                rPanel.setBounds(Drawer.FRAME_WIDTH/3,0,Drawer.FRAME_WIDTH,Drawer.FRAME_HEIGHT);
                rPanel.setBackground(Color.lightGray);

                JPanel panel = new JPanel(null);
                panel.setBorder(null);
                panel.setBounds(0,0,800/3,800);


                JLabel succes = new JLabel("Congratulations! :)");
                succes.setFont(new Font("Tahoma", Font.BOLD, 70));
                succes.setForeground(Color.DARK_GRAY);
                succes.setHorizontalAlignment(SwingConstants.CENTER);
                succes.setBounds(33, 42, 720, 276);
                rPanel.add(succes);

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
                usedColors = colors.size();

                String amount = Integer.toString(counter) +"/"+ Integer.toString(Drawer.colorList.length);
                JLabel lblNewLabel_1 = new JLabel(amount);
                lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblNewLabel_1.setBounds(98, 379, 80, 60);
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

        }
    }

}
