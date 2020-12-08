import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VertexColors implements ActionListener
{
  public void actionPerformed(ActionEvent event)
  {
	  EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VertexMenu window = new VertexMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
  }
}