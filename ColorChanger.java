import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ColorChanger implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
		// for gamemode 1 changes the color of the selected node to the selected color
	  if(MainMenu.mode == 1){
		  NodeButton n = (NodeButton)event.getSource();
		  n.setColor(Drawer.currentColor);
		  InGameFrame.clock.setColor(Drawer.currentColor);
		  int vertex = n.getVertexNumber();
		  Drawer.colorList[vertex-1] = Drawer.currentColor;
		  if(!ColorChecker.Check(n))
		  {
			  n.setBorderColor(Color.red);
		  }
		  else
		  {
			  n.setBorderColor(Color.black);
		  }
		// for gamemode 2 changes the color of the selected node to the selected color
	  }else if(MainMenu.mode == 2){
		  NodeButton n = (NodeButton)event.getSource();
		  n.setColor(Drawer.currentColor);
		  InGameFrame2.clock.setColor(Drawer.currentColor);
		  int vertex = n.getVertexNumber();
		  Drawer.colorList[vertex-1] = Drawer.currentColor;
		  if(!ColorChecker.Check(n))
		  {
			  n.setBorderColor(Color.red);
		  }
		  else
		  {
			  n.setBorderColor(Color.black);
		  }
		// for gamemode 3 changes the color of the selected node to the selected color
	  }else if(MainMenu.mode == 3){

		  NodeButton n = (NodeButton)event.getSource();
		  n.setColor(Drawer.currentColor);
		  InGameFrame3.clock.setColor(Drawer.currentColor);
		  int vertex = n.getVertexNumber();
		  Drawer.colorList[vertex-1] = Drawer.currentColor;
		  if(!ColorChecker.Check(n))
		  {
			  n.setBorderColor(Color.red);
		  }
		  else
		  {
			  n.setBorderColor(Color.black);
		  }
	  }

  }
}