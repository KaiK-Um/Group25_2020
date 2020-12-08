import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gm3Listener implements ActionListener {
    public int colorsUsed;
    public int chromaticNumber;
    public static int number;

    static {
        number = 0;
    }

    /**
     * When the start button gets pressed it draws a random node that is colorable. It then chains from node to next node while also removing
     * the ability to color the nodes from before. When every node is drawn it will check if the result is correct and draw a Succes / Game Over screen.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (number == 0) {

            int i = InGameFrame3.List[number];
            int x = InGameFrame3.nodes[i - 1].getX();
            int y = InGameFrame3.nodes[i - 1].getY();
            JPanel panel = new JPanel(null);
            panel.setBounds(x, y, Drawer.NODES_DIAMETER + 1, Drawer.NODES_DIAMETER + 1);
            panel.setBackground(Color.LIGHT_GRAY);
            //System.out.println(i);
            NodeButton nb = new NodeButton(0, 0, Drawer.NODES_DIAMETER, Color.gray);
            ActionListener cc = new ColorChanger();
            ActionListener gm = new Gm3Listener();
            nb.addActionListener(cc);
            nb.addActionListener(gm);
            panel.add(nb);
            InGameFrame3.graph.add(panel);
            InGameFrame3.NodeList.add(nb);
            nb.repaint();
            number++;
        } else {
            //removing the al
            NodeButton n = InGameFrame3.NodeList.get(number - 1);
            for (ActionListener al : n.getActionListeners()) {
                n.removeActionListener(al);
            }
            n.repaint();
            if (InGameFrame3.List.length > number) {
                int i = InGameFrame3.List[number];
                int x = InGameFrame3.nodes[i - 1].getX();
                int y = InGameFrame3.nodes[i - 1].getY();
                JPanel panel = new JPanel(null);
                panel.setBounds(x, y, Drawer.NODES_DIAMETER + 1, Drawer.NODES_DIAMETER + 1);
                panel.setBackground(Color.LIGHT_GRAY);
                NodeButton nb = new NodeButton(0, 0, Drawer.NODES_DIAMETER, Color.gray);
                ActionListener cc = new ColorChanger();
                nb.addActionListener(cc);
                nb.addActionListener(this);
                panel.add(nb);
                InGameFrame3.graph.add(panel);
                InGameFrame3.NodeList.add(nb);
                nb.repaint();
                number++;
            } else {
                InGameFrame3.frame.repaint();
                boolean finished = true;
                for (int i = 1; i <= Drawer.g.getAmountVertices(); i++) {
                    if (!ColorChecker.CheckGM3(i)) finished = false;
                }
                ArrayList<Color> usedColors = new ArrayList<Color>();
                for (int i = 0; i < InGameFrame3.NodeList.size(); i++) {
                    NodeButton b = InGameFrame3.NodeList.get(i);
                    if (!usedColors.contains(b.getColor()) && !b.getColor().equals(Color.gray)) {
                        usedColors.add(b.getColor());
                    }else if(b.getColor().equals(Color.gray) && !usedColors.contains(Drawer.currentColor)){
                        usedColors.add(Drawer.currentColor);
                    }
                }
                colorsUsed = usedColors.size();
               //  System.out.println("amount colors used" + colorsUsed);

                Greedy greedy = new Greedy(Drawer.g);
                greedy.upperBound();
                //System.out.println("greeedy:" +cry.getchromaticOfGreedy());

                RLF rlf = new RLF(Drawer.g);
                rlf.solve();
                //System.out.println("RLF:"+red.getChromaticOfRLF());

                LowerBound lowerBound = new LowerBound(Drawer.g);
                lowerBound.solve();
                //System.out.println("Clique:"+kai.getMaxSize());

                /*
                if (greedy.getchromaticOfGreedy() == lowerBound.getMaxSize() || lowerBound.getMaxSize() == rlf.getChromaticOfRLF())
                    chromaticNumber = lowerBound.getMaxSize();
                else {
                    BruteForce bruteForce = new BruteForce(Drawer.g);
                    bruteForce.solve();
                    chromaticNumber = bruteForce.getChromatic();
                }
                 */
                BruteForce bruteForce = new BruteForce(Drawer.g);
                bruteForce.solve();
                chromaticNumber = bruteForce.getChromatic();

                System.out.println("cn: " + chromaticNumber);
                if (chromaticNumber != colorsUsed) finished = false;
                InGameFrame3.frame.remove(InGameFrame3.splitPane);
                if (finished) {
                    InGameFrame3.frame.remove(InGameFrame3.splitPane);

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

                    int counter = Drawer.colorList.length;
                    for(int i = 0; i < Drawer.colorList.length;i++)
                    {
                        if(Drawer.colorList[i] == null) counter--;
                    }


                    String amount = Integer.toString(counter+1) +"/"+ Integer.toString(Drawer.colorList.length);
                    JLabel lblNewLabel_1 = new JLabel(amount);
                    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
                    lblNewLabel_1.setBounds(98, 379, 44, 58);
                    rPanel.add(lblNewLabel_1);

                    JLabel lblNewLabel_2 = new JLabel("Colors used:");
                    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
                    lblNewLabel_2.setBounds(605, 348, 117, 28);
                    rPanel.add(lblNewLabel_2);
                    colorsUsed =0;
                    colorsUsed = usedColors.size();
                    String colors = Integer.toString(colorsUsed);
                    JLabel lblNewLabel_3 = new JLabel(String.valueOf(colorsUsed));
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


                    InGameFrame3.frame.add(splitPane);
                    InGameFrame3.frame.repaint();

                } else {

                    InGameFrame3.frame.remove(InGameFrame3.splitPane);

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

                    int used = 0;
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
                    used = colors.size()-1;

                    String amount = Integer.toString(counter+1) +"/"+ Integer.toString(Drawer.colorList.length);
                    JLabel lblNewLabel_1 = new JLabel(amount);
                    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
                    lblNewLabel_1.setBounds(98, 379, 44, 58);
                    rPanel.add(lblNewLabel_1);

                    JLabel lblNewLabel_2 = new JLabel("Colors used:");
                    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
                    lblNewLabel_2.setBounds(605, 348, 117, 28);
                    rPanel.add(lblNewLabel_2);

                    String colorsUsed = Integer.toString(used);
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


                    InGameFrame3.frame.add(splitPane);
                    InGameFrame3.frame.repaint();
                }
                InGameFrame3.frame.repaint();
            }
        }
    }
}
