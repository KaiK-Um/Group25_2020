import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class GraphicalGeneration {

	public static boolean DEBUG = false;
	
	/** This a method which read the input from the MainMenu popupone into the graaphengine.
	it takes N and M. Which are the Nodes and Edges respectively.
	It fills 2 arrays namely nodes and neighbours.
	in the first part x and y are calculated using the node diameter and the frame_width.
	Furthermore it is checked if the nodes overlap. ( possible = true then continue)
	Finally we check for double edges. If they are present the second edge is recalculated.
	The method returns nodes and neighbours to graphs
	@param m = edges
	@param n = vertices

	*/
	public static  Graphs graphEngine(int n, int m ) {
		Random l = new Random();
		Nodes[] nodes = new Nodes [n];
		
		int [][] neighbours = new int [2][m];
		
		int counter = 0;
		for (int i=0; i<n; i++) {
			int x = l.nextInt(Drawer.FRAME_WIDTH-(2*Nodes.getDiameter()));
			int y = l.nextInt(Drawer.FRAME_HEIGHT-(2*Nodes.getDiameter()));
			//centercoords:
			int cX = (x+(Drawer.NODES_DIAMETER/2));
			int cY = (y+(Drawer.NODES_DIAMETER/2));
			boolean possible = true;
			for(int j = 0; j < counter; j++) {
				if(counter != 0) {
					Rectangle r = new Rectangle(cX - Drawer.NODES_DIAMETER,cY - Drawer.NODES_DIAMETER,2*Drawer.NODES_DIAMETER,2*Drawer.NODES_DIAMETER);
					if (possible && !nodes[j].getBounds().intersects(r)) {
						nodes[i] = new Nodes(x,y);
					}
					else {
						i--;
					}
				}
			}
			if(counter == 0) {
				nodes[i] = new Nodes(x,y);
				counter++;
			}
			}

		//Here bc of the -1 thing again
		counter = 0;
		for (int i=0; i<m;i++) {
			int edge1 = (int)(Math.random()*n);
			edge1++;
			int edge2 = (int)(Math.random()*n);
			edge2++;
			boolean possible = true;
			if(edge1 == edge2) possible = false;
			else if(counter!=0){
				for(int j = 0; j < counter;j++){
					if(neighbours[0][j] == edge1 && neighbours[1][j] == edge2){
						possible = false;
					}
					else if(neighbours[1][j] == edge1 && neighbours[0][j] == edge2){
						possible = false;
					}
				}
			}
			if(!possible) i--;
			else{
				neighbours[0][i] = edge1;
				neighbours[1][i] = edge2;
				counter++;
			}
		}

		// System.out.println("Neighbours: " + Arrays.deepToString(neighbours));
		for (int i=0; i < (m-(n+1)); i++ ) {
			
			int f = l.nextInt(n);
			int g = l.nextInt(n);
			
			if (f == g) {
				g = l.nextInt(n);
			} else continue;
		}
		return new Graphs(nodes,neighbours); 
		
	}

	/**
	 * THis methods gets the edges and nodes from aan chosen file. Then it makes 2 arrays namely nodes and neighbours.
	 * Also here we calculate x and y using the fram_width and nodes diameter.
	 * @param input is taken from the upload tab in the mainmenu.
	 * @return nodes[] and neighbours[] to Graphs
	 */
	
	 public static Graphs readerFromFile(String input) {

		 boolean seen[] = null;

		 //! n is the number of vertices in the graph
		 int n = -1;

		 //! m is the number of edges in the graph
		 int m = -1;

		 //! e will contain the edges of the graph
		 ColEdge e[] = null;

		 try {

			 FileReader fr = new FileReader(input);
			 // System.out.println("hi");
			 BufferedReader br = new BufferedReader(fr);

			 String record = new String();

			 //! THe first few lines of the file are allowed to be comments, staring with a // symbol.
			 //! These comments are only allowed at the top of the file.

			 //! -----------------------------------------
			 while ((record = br.readLine()) != null) {
				 if (record.startsWith("//")) continue;
				 break; // Saw a line that did not start with a comment -- time to start reading the data in!
			 }

			 if (record.startsWith("VERTICES = ")) {
				 n = Integer.parseInt(record.substring(11));
				 if (DEBUG) System.out.println(" Number of vertices = " + n);
			 }

			 seen = new boolean[n + 1];

			 record = br.readLine();

			 if (record.startsWith("EDGES = ")) {
				 m = Integer.parseInt(record.substring(8));
				 if (DEBUG) System.out.println(" Expected number of edges = " + m);
			 }

			 e = new ColEdge[m];

			 for (int d = 0; d < m; d++) {
				 if (DEBUG) System.out.println(" Reading edge " + (d + 1));
				 record = br.readLine();
				 String data[] = record.split(" ");
				 if (data.length != 2) {
					 System.out.println("Error! Malformed edge line: " + record);
					 System.exit(0);
				 }
				 e[d] = new ColEdge();

				 e[d].u = Integer.parseInt(data[0]);
				 e[d].v = Integer.parseInt(data[1]);

				 seen[e[d].u] = true;
				 seen[e[d].v] = true;

				 if (DEBUG) System.out.println(" Edge: " + e[d].u + " " + e[d].v);

			 }

			 String surplus = br.readLine();
			 if (surplus != null) {
				 if (surplus.length() >= 2) if (DEBUG)
					 System.out.println(" Warning: there appeared to be data in your file after the last edge: '" + surplus + "'");
			 }

		 } catch (IOException ex) {
			 // catch possible io errors from readLine()
			 System.out.println("Error! Problem reading file " + input);
			 System.exit(0);
		 }

		 for (int x = 1; x <= n; x++) {
			 if (seen[x] == false) {
				 if (DEBUG)
					 System.out.println(" Warning: vertex " + x + " didn't appear in any edge : it will be considered a disconnected vertex on its own.");
			 }
		 }
		 int edges[][] = new int[2][m];
		 for(int i = 0; i < edges[0].length;i++)
		 {
		 	edges[0][i] = e[i].u;
		 	edges[1][i] = e[i].v;

		 }

		 Random l = new Random();
		 Nodes[] nodes = new Nodes [n];
		 int counter = 0;
		 for (int i=0; i<n; i++) {
			 int x = l.nextInt(Drawer.FRAME_WIDTH-(2*Nodes.getDiameter()));
			 int y = l.nextInt(Drawer.FRAME_HEIGHT-(2*Nodes.getDiameter()));
			 //centercoords:
			 int cX = (x+(Drawer.NODES_DIAMETER/2));
			 int cY = (y+(Drawer.NODES_DIAMETER/2));
			 boolean possible = true;
			 for(int j = 0; j < counter; j++) {
				 if(counter != 0) {
					 Rectangle r = new Rectangle(cX - Drawer.NODES_DIAMETER,cY - Drawer.NODES_DIAMETER,2*Drawer.NODES_DIAMETER,2*Drawer.NODES_DIAMETER);
					 if (possible && !nodes[j].getBounds().intersects(r)) {
						 nodes[i] = new Nodes(x,y);
					 }
					 else {
						 i--;
					 }
				 }
			 }
			 if(counter == 0) {
				 nodes[i] = new Nodes(x,y);
				 counter++;
			 }
		 }


		 Graphs g = new Graphs(n,m,edges,nodes);
		 return g;
	 }
}

class ColEdge {
	int u;
	int v;
}
