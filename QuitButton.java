import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class QuitButton implements ActionListener {
	/**
	 * This methods closes the ingameframe for every game mode.
	 * When pressed you are redirected to the Main menu.
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainMenu.mode == 1){
			InGameFrame.close();
			MainMenu window = new MainMenu();
			window.frame.setVisible(true);
			NodeButton.Number = 1;
			for(int i = 0; i < Drawer.colorList.length; i++)
			{
				Drawer.colorList[i] = null;
			}
		}else if(MainMenu.mode == 2){
			InGameFrame2.clock.setStop(false);
			InGameFrame2.close();
			MainMenu window = new MainMenu();
			window.frame.setVisible(true);
			NodeButton.Number = 1;
			for(int i = 0; i < Drawer.colorList.length; i++)
			{
				Drawer.colorList[i] = null;
			}
		}else if(MainMenu.mode == 3){
			NodeButton.Number = 1;
			Gm3Listener.number = 0;
			InGameFrame3.close();
			MainMenu window = new MainMenu();
			window.frame.setVisible(true);
			NodeButton.Number = 1;
			for(int i = 0; i < Drawer.colorList.length; i++)
			{
				Drawer.colorList[i] = null;
			}
		}
	}

}
