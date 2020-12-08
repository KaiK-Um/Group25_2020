

import java.awt.*;
import javax.swing.*;

public class Line extends JComponent
{
    /**
	 * Draws a line
	 */
	public Line(int x1,int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        linePanel = new JPanel(){
         /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
            	Graphics2D v = (Graphics2D) g;
            	v.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.drawLine(x1,y1,x2,y2);
            }
        };
        linePanel.setBounds(0,0,Drawer.FRAME_WIDTH,Drawer.FRAME_HEIGHT);
    }

    public JPanel getPanel()
    {
        return linePanel;
    }

  JPanel linePanel = new JPanel();
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int option;
}