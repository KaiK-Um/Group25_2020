import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
    public final static int FRAME_WIDTH = 700;
    public final static int FRAME_HEIGHT = 700;
    public final static int NODES_DIAMETER = 30;
    public static Color currentColor = Color.cyan;
    public static Color colorList[];
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
