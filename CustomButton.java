import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class CustomButton extends JButton{

	/**
	 * This methos is just a button to get the color index of the current node
	 */
	public int currentbuttoncolorindex;
	
	public CustomButton(int colorindex ){
		
		currentbuttoncolorindex = colorindex;
	}

}
