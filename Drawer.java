

	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;

	public class Drawer {
		
	    public final static int FRAME_WIDTH = 800;
	    public final static int FRAME_HEIGHT = 800;
	    public final static int NODES_DIAMETER = 30;
	    public static Color currentColor = Color.cyan;
	    public static Color colorList[];
	     static Graphs g;


		/**
		 * This method generates aa file using the input from the upload of the main menu.
		 * It calls upon the GraphicalGeneration.readFromFile to read the file and n/m.
		 * When the file has n and m. First the nodes are drawn using the NodeButton.
		 * Then an actionlistener is placed i=nside the node.
		 * When all the nodes are drawn, the lines are drawn using the Line class.
		 * @param inputFile
		 * @return a ponel with a graph drawn.,
		 */
		public JPanel generate(String inputFile) {
	        JPanel panel = new JPanel(null);
	        panel.setBackground(Color.LIGHT_GRAY);
			g = GraphicalGeneration.readerFromFile(inputFile);
			Nodes[] n = g.nodes;
			int[][] edges = g.neighbours;
			// System.out.println(g.neighbours.length);
			//drawing the nodes
			// System.out.println("EDGES: " + Arrays.deepToString(edges));
			for(int i = 0; i < n.length;i++)
			{
				int x = n[i].getX();
				int y = n[i].getY();
				NodeButton nb = new NodeButton(x,y,NODES_DIAMETER, Color.gray);
				ActionListener cc = new ColorChanger();
				nb.addActionListener(cc);

				panel.add(nb);
			}


			//drawing the lines
			for(int i = 0; i < edges[0].length;i++)
			{
				int x1 = n[edges[0][i]-1].getCenterX();
				int y1 = n[edges[0][i]-1].getCenterY();
				int x2 = n[edges[1][i]-1].getCenterX();
				int y2 = n[edges[1][i]-1].getCenterY();
				Line l = new Line(x1,y1,x2,y2);
				panel.add(l.getPanel());
			}

			colorList = new Color[n.length];
			return panel;
		}


		/**
		 * This methods generates a graph using the n and m.
		 * It calls upon the GraphicalGeneration.graphengine to generate a random n and m
		 *  When the file has n and m. First the nodes are drawn using the NodeButton.
		 *  Then an actionlistener is placed i=nside the node.
		 *  When all the nodes are drawn, the lines are drawn using the Line class.
		 * @param amountVertices
		 * @param amountEdges
		 * @return a panel with the graph.
		 */
		public JPanel generate(int amountVertices,int amountEdges) {
			JPanel panel = new JPanel(null);
	        panel.setBackground(Color.LIGHT_GRAY);
			 g = GraphicalGeneration.graphEngine(amountVertices, amountEdges);
			Nodes[] n = g.nodes;
			int[][] edges = g.neighbours;
			System.out.println(g.neighbours.length);
			//drawing the nodes
			//System.out.println("EDGES: " + Arrays.deepToString(edges));
			for(int i = 0; i < n.length;i++)
			{
				int x = n[i].getX();
				int y = n[i].getY();
				NodeButton nb = new NodeButton(x,y,NODES_DIAMETER, Color.gray);
				ActionListener cc = new ColorChanger();
				nb.addActionListener(cc);
			
				panel.add(nb);
			}
			

			//drawing the lines
			for(int i = 0; i < edges[0].length;i++)
			{
				int x1 = n[edges[0][i]-1].getCenterX();
				int y1 = n[edges[0][i]-1].getCenterY();
				int x2 = n[edges[1][i]-1].getCenterX();
				int y2 = n[edges[1][i]-1].getCenterY();
				Line l = new Line(x1,y1,x2,y2);
				panel.add(l.getPanel());
			}

			colorList = new Color[n.length];
			return panel;
		}

		/**
		 * This is drawer for gamemode 3.
		 * This methods generates a graph using the int m it got from the readerfromfile.
		 *  Only the lines are drawn here. The nodes are later added in the GM3Listener.
		 *  This is so the nodes can appear one by one.
		 * @param inputFile
		 * @return a panel with the lines
		 */

		public JPanel generateGM3(String inputFile) {
			JPanel panel = new JPanel(null);
			panel.setBackground(Color.LIGHT_GRAY);
			g = GraphicalGeneration.readerFromFile(inputFile);
			Nodes[] n = g.nodes;
			int[][] edges = g.neighbours;
			System.out.println(g.neighbours.length);
			//drawing the lines
			for(int i = 0; i < edges[0].length;i++)
			{
				int x1 = n[edges[0][i]-1].getCenterX();
				int y1 = n[edges[0][i]-1].getCenterY();
				int x2 = n[edges[1][i]-1].getCenterX();
				int y2 = n[edges[1][i]-1].getCenterY();
				Line l = new Line(x1,y1,x2,y2);
				panel.add(l.getPanel());
			}

			colorList = new Color[n.length];
			return panel;
		}

		/**
		 * This is drawer for gamemode 3.
		 * This methods generates a graph using m.
		 *  Only the lines are drawn here. The nodes are later added in the GM3Listener.
		 *  This is so the nodes can appear one by one.
		 * @param amountVertices
		 * @param amountEdges
		 * @return a panel with the lines
		 */
		public JPanel generateGM3(int amountVertices,int amountEdges) {
			JPanel panel = new JPanel(null);
			panel.setBackground(Color.LIGHT_GRAY);
			g = GraphicalGeneration.graphEngine(amountVertices, amountEdges);
			Nodes[] n = g.nodes;
			int[][] edges = g.neighbours;
			//System.out.println(g.neighbours.length);
			//drawing the nodes
			//System.out.println("EDGES: " + Arrays.deepToString(edges));

			//drawing the lines
			for(int i = 0; i < edges[0].length;i++)
			{
				int x1 = n[edges[0][i]-1].getCenterX();
				int y1 = n[edges[0][i]-1].getCenterY();
				int x2 = n[edges[1][i]-1].getCenterX();
				int y2 = n[edges[1][i]-1].getCenterY();
				Line l = new Line(x1,y1,x2,y2);
				panel.add(l.getPanel());
			}

			colorList = new Color[n.length];
			return panel;
		}
		
	}
	


