import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Nodes extends JComponent { // this is my Node class with a contructor to make every node.

		// instance fields
		private static final Color stdEdge = Color.GRAY; // set the color to the edges
		private int x;
		private int y;
		private static int diameter = 20;
		
               // node constructor
	public Nodes (int x, int y) {
		this.x = x;
		this.y = y;
		this.setBounds(x,y,diameter,diameter); // set the bounds of the nodes
			
		
		
	}
        // diameter
	public static int getDiameter() {
		return diameter;
	}
	
	public void setDiameter(int diameter) {
		this.diameter=diameter;
	}
        // coordinates
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
        // edges
	public Color getColor() {
		return stdEdge;
	}

	
	public void paintComponent(Graphics g) {
		Graphics2D v = (Graphics2D) g;
		v.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		v.setColor(Color.BLACK); // set the color to the vetices 
		v.fill(new Ellipse2D.Double(0,0,diameter,diameter));
		v.setColor(Color.gray); // at the beginning they are gray
		v.fill(new Ellipse2D.Double(x+((double)diameter)/12,y+((double)diameter/12),((double)diameter*5)/6,((double)diameter*5)/6));
		
	}
        // they will return the center of the nodes
	public int getCenterX() {
		return (x+(diameter/2));
	}
	
	public int getCenterY() {
		return (y+(diameter/2));
	}
	
        // it returns the position of x and y
	public boolean position(int x2, int y2) {
		int x3 = x2 - getCenterX();
		int y3 = y2 - getCenterY();
		
		return (x3*x3)+(y3*y3)<= (diameter*diameter)/4;
	}
	
	
}
 