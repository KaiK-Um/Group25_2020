import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reRoll implements ActionListener{

/**
*  As soon as the button gets pressed the old window will close and a new one  with a newlz generated grah will appear. The idea behind this feature is that we cannot guarantee good looking graphs and thus we give the user the option to reroll until the user gets a graph he likes.
*  Because every gamemode takes its more or less unique input we have to make a case for everything.
*/
	  public void actionPerformed(ActionEvent event)
	  {
		  if(MainMenu.mode == 1){
		  	if(MainMenu.Choice == 1)
			{
				InGameFrame.frame.dispose();
				NodeButton.Number = 1;
				new InGameFrame(InGameFrame.n,InGameFrame.m);
				for(int i = 0; i < Drawer.colorList.length; i++)
				{
					Drawer.colorList[i] = null;
				}
			} else
			{
				InGameFrame.frame.dispose();
				NodeButton.Number = 1;
				new InGameFrame(MainMenu.filename);
				for(int i = 0; i < Drawer.colorList.length; i++)
				{
					Drawer.colorList[i] = null;
				}
			}
		  }else if(MainMenu.mode == 2){
			  if(MainMenu.Choice == 1)
			  {
			  	  InGameFrame2.clock.setStop(false);
				  InGameFrame2.frame.dispose();
				  NodeButton.Number = 1;
				  new InGameFrame2(InGameFrame2.n,InGameFrame2.m);
				  for(int i = 0; i < Drawer.colorList.length; i++)
				  {
					  Drawer.colorList[i] = null;
				  }
			  } else
			  {
			  	//preventing the timer from going off
				  InGameFrame2.clock.setStop(false);
				  InGameFrame2.frame.dispose();
				  NodeButton.Number = 1;
				  new InGameFrame2(MainMenu.filename);
				  for(int i = 0; i < Drawer.colorList.length; i++)
				  {
					  Drawer.colorList[i] = null;
				  }
			  }

		  }else if(MainMenu.mode == 3){
			  if(MainMenu.Choice == 1)
			  {
				  InGameFrame3.frame.dispose();
				  NodeButton.Number = 1;
				  Gm3Listener.number = 0;
				  new InGameFrame3(InGameFrame3.n,InGameFrame3.m);
				  for(int i = 0; i < Drawer.colorList.length; i++)
				  {
					  Drawer.colorList[i] = null;
				  }
			  } else
			  {
				  InGameFrame3.frame.dispose();
				  NodeButton.Number = 1;
				  Gm3Listener.number = 0;
				  new InGameFrame3(MainMenu.filename);
				  for(int i = 0; i < Drawer.colorList.length; i++)
				  {
					  Drawer.colorList[i] = null;
				  }
			  }

		  }

	  }
	}
