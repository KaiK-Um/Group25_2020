import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

public class NodeButton extends JButton {
    // intance fields
    private Color color;
    private Color borderColor = Color.black;
    private int diameter;
    private int centerX;
    private int centerY;
    public static int Number;
    private int vertex;
    public static ArrayList<Integer> X = new ArrayList<Integer>();
    public static ArrayList<Integer> Y= new ArrayList<Integer>();
    static {
    	Number = 1;
    }
    // constructor NodeButton
    public NodeButton(int x, int y,int diameter, Color color) {
    	//we set the bounds bigger by one because it will look better
    	 this.setBounds(x,y,diameter+1,diameter+1); // set the position and the size of the node
         this.diameter = diameter;
         this.color = color;
         setBackground(color); // fill in the background
         setContentAreaFilled(false); // the content area is not filled
         X.add(x);
         Y.add(y);
         centerX = x + (diameter/2); // coordinates
         centerY = y + (diameter/2);
         Border emptyBorder = BorderFactory.createEmptyBorder(); // creates an empty border
         setBorder(emptyBorder); // draw edges 
         vertex = Number;
         Number++;
    }

    protected void paintComponent(Graphics g)
    {
    	Graphics2D v = (Graphics2D) g;
    	v.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // collaps multiple virtual steps into a single operation
        g.setColor(color);
        g.fillOval(0, 0, diameter,diameter); 
        g.setColor(borderColor);
        g.drawOval(0, 0, diameter,diameter); // the oval is filled using the graphics context's current color.
        super.paintComponent(g); // extends the super class Component
    }

    // accessors for the color
    public void setColor(Color color) 
    {
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }
    // mutuator for the BorderColor
    public void setBorderColor(Color color)
    {
        this.borderColor = color;
    }
    
    // accessors for the coordinates X and Y 
    public int getCenterX()
    {
        return centerX;
    }
    public int getCenterY()
    {
        return centerY;
    }
    // accessor for the number of vetices 
    public int getVertexNumber() {
    	return vertex;
    }

}