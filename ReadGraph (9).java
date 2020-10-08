import java.io.*;
import java.util.*;
import java.lang.*;

		class ColEdge
			{
			int u;
			int v;
			}

public class ReadGraph
		{

		public final static boolean DEBUG = true;

		public final static String COMMENT = "//";

		public static void main( String args[] )
			{
			if( args.length < 1 )
				{
				System.out.println("Error! No filename specified.");
				System.exit(0);
				}


			String inputfile = args[0];

			boolean seen[] = null;

			//! n is the number of vertices in the graph
			int n = -1;

			//! m is the number of edges in the graph
			int m = -1;

			//! e will contain the edges of the graph
			ColEdge e[] = null;

			try 	{
			    	FileReader fr = new FileReader(inputfile);
			        BufferedReader br = new BufferedReader(fr);

			        String record = new String();

					//! THe first few lines of the file are allowed to be comments, staring with a // symbol.
					//! These comments are only allowed at the top of the file.

					//! -----------------------------------------
			        while ((record = br.readLine()) != null)
						{
						if( record.startsWith("//") ) continue;
						break; // Saw a line that did not start with a comment -- time to start reading the data in!
						}

					if( record.startsWith("VERTICES = ") )
						{
						n = Integer.parseInt( record.substring(11) );
						if(DEBUG) System.out.println(COMMENT + " Number of vertices = "+n);
						}

					seen = new boolean[n+1];

					record = br.readLine();

					if( record.startsWith("EDGES = ") )
						{
						m = Integer.parseInt( record.substring(8) );
						if(DEBUG) System.out.println(COMMENT + " Expected number of edges = "+m);
						}

					e = new ColEdge[m];

					for( int d=0; d<m; d++)
						{
						if(DEBUG) System.out.println(COMMENT + " Reading edge "+(d+1));
						record = br.readLine();
						String data[] = record.split(" ");
						if( data.length != 2 )
								{
								System.out.println("Error! Malformed edge line: "+record);
								System.exit(0);
								}
						e[d] = new ColEdge();

						e[d].u = Integer.parseInt(data[0]);
						e[d].v = Integer.parseInt(data[1]);

						seen[ e[d].u ] = true;
						seen[ e[d].v ] = true;

						if(DEBUG) System.out.println(COMMENT + " Edge: "+ e[d].u +" "+e[d].v);

						}

					String surplus = br.readLine();
					if( surplus != null )
						{
						if( surplus.length() >= 2 ) if(DEBUG) System.out.println(COMMENT + " Warning: there appeared to be data in your file after the last edge: '"+surplus+"'");
						}

					}
			catch (IOException ex)
				{
		        // catch possible io errors from readLine()
			    System.out.println("Error! Problem reading file "+inputfile);
				System.exit(0);
				}

			for( int x=1; x<=n; x++ )
				{
				if( seen[x] == false )
					{
					if(DEBUG) System.out.println(COMMENT + " Warning: vertex "+x+" didn't appear in any edge : it will be considered a disconnected vertex on its own.");
					}
				}

			//! At this point e[0] will be the first edge, with e[0].u referring to one endpoint and e[0].v to the other
			//! e[1] will be the second edge...
			//! (and so on)
			//! e[m-1] will be the last edge
			//!
			//! there will be n vertices in the graph, numbered 1 to n

			//! INSERT YOUR CODE HERE!
			//Approximate of the chromatic number using a greedy algorithm
			//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
			int[][] edges = new int[2][m];
			for(int i = 0; i < m; i++){
				edges[0][i] = e[i].u;
				edges[1][i] = e[i].v;
			}
			greedy(edges, n, m);
			//the exact algorithm using the "Recursive Largest First" Algorithm
			//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
			ArrayList<Integer> U = new ArrayList<Integer>();
			for(int i = 1; i <= n; i++)
			{
				U.add(i);
			}
			//an array that contains the degree of every vertice and is sorted by size (biggest degree first)
			int[][] degree = new int[2][n];
			for(int i = 0; i < n; i++)
			{
				int j = i+1;
				int[] neighbours = neighbours(edges,m,j);
				degree[1][i] = neighbours.length;
			}
			for(int i = 0; i < n; i++)
			{
				degree[0][i] = i + 1;
			}
			int[][] copyDegree = new int[2][n];
			for(int i = 0; i < n; i++)
			{
				copyDegree[0][i] = degree[0][i];
				copyDegree[1][i] = degree[1][i];
			}
			degree = copyDegree;
			//the array saving every degree
			int[][] saveDegree = new int[2][n];
			for(int i = 0; i < n; i++)
			{
				int j = i+1;
				int[] neighbours = neighbours(edges,m,j);
				saveDegree[1][i] = neighbours.length;
			}
			for(int i = 0; i < n; i++)
			{
				saveDegree[0][i] = i + 1;
			}
			sort(degree);
			if(DEBUG) System.out.println(Arrays.deepToString(degree));
			System.out.println();
		 	System.out.println("This is the exact chromatic number: " + rlf(degree,U,m,edges,saveDegree));
		}

		/*
		The Recursive Large First Algorithm, which takes the vertex with the biggest degree and colors it. After that it takes out every neighbours and saves it.
		It repeats that after the initial set is empty. It then repeats the steps with the neighbour set as starting set.
		*/
		public static int rlf(int[][] degree, ArrayList<Integer> U, int m, int[][] edges,int[][] saveDegree){
			int color = 1;
			//copy of degree we can change without having the problem of pass by values
			//int[][] changeDeg  = java.util.Arrays.copyOf(degree, degree.length);
			//a set that saves the remaining objects
			ArrayList<Integer> W = new ArrayList<Integer>();
			//a set that saves the degree
			ArrayList<Integer> Deg = new ArrayList<Integer>();
			// if U is empty that means that we gave every element a value.
			//if there is no value that is getting passed that means that every color has been given
			if(U.isEmpty()) return 0;
			else
			{
				while(!U.isEmpty())
				{
					int maxDeg = degree[0][0];
					if(DEBUG) System.out.println(maxDeg);
					if(!U.isEmpty())
					{
						int[] neighbours = uncoloredNeighbors(U, edges, m, maxDeg);
						if(DEBUG) System.out.println("neighbours: " + Arrays.toString(neighbours));
						for(int i = 0; i < neighbours.length; i++)
						{
							W.add(neighbours[i]);
							Deg.add(saveDegree[1][neighbours[i]-1]);
							int ind = Collections.binarySearch(U, neighbours[i]);
							U.remove(ind);
							System.out.println("U: " + U);
							//because we dont want to color our neighbours the same color we have to remove them too
							if(DEBUG) System.out.println("Degree: " + Arrays.deepToString(degree));
							int[][] helper2 = new int[2][degree[0].length-1];
							for(int l = 0; l < helper2.length; l++)
							{
								int k = 0;
								for(int j = 0; j < degree[0].length; j++)
								{
									if(degree[0][j] != neighbours[i])
									{
										helper2[l][k] = degree[l][j];
										k++;
									}
								}
							}
							if(DEBUG) System.out.println("Helper2: " + Arrays.deepToString(helper2));
							degree = helper2;
					}
					int index = Collections.binarySearch(U, maxDeg);
					//remove the element out of U
					U.remove(index);
					System.out.println("U: " + U);
					// we have to remove the first elemet because we are always using the first element
					int[][] helper = new int[2][degree[0].length-1];
					for(int k = 0; k < degree.length; k++)
					{
						for(int j = 1; j < degree[0].length; j++)
						{
							helper[k][j-1] = degree[k][j];
						}
					}
					if(DEBUG) System.out.println("helper: " + Arrays.deepToString(helper));
					degree = helper;
				}
			}

			int[][] helper3 = new int[2][W.size()];
			for(int i = 0; i < W.size(); i++)
			{
				helper3[0][i] = W.get(i);
				helper3[1][i] = Deg.get(i);
			}
			degree = helper3;
			System.out.println("degree" + Arrays.deepToString(degree));
			sort(degree);
			System.out.println("Deg: " + Deg);
			System.out.println("U: " + U);
			System.out.println("W: " + W);
			System.out.println("Savedegree" + Arrays.deepToString(saveDegree));
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
			return color += rlf(degree, W, m, edges, saveDegree);
		}

	}

	/*
	The method that takes the set of neighbours and returns the ones that are still in the U set.
	*/

		public static int[] uncoloredNeighbors(ArrayList<Integer> U, int[][] e, int edges, int vertice){
			int[] every = neighbours(e,edges,vertice);
			int[] helper = new int[every.length];
			int counter = 0;
			for(int i = 0; i < U.size();i++)
			{
				for(int j = 0; j < every.length;j++)
				{
					if(every[j] == U.get(i))
					{
						helper[counter] = every[j];
						counter++;
					}
				}
			}
			int[] uncolored = new int[counter];
			for(int i = 0; i < counter; i++)
			{
				uncolored[i] = helper[i];
			}
			return uncolored;
		}

/*
	 We had some problems sorting the degree array, so we googled it and found this:  https://stackoverflow.com/questions/36183108/sort-2d-array-by-specific-row .
	 This method sorts the bottom fom biggest to lowest while also sorting the top row accordingly.
*/
		public static int[][] sort(int[][] values){
			for(int i = 0; i < values[0].length -1; i++) {
					for(int j = i + 1; j < values[0].length; j++) {
							if(values[1][i] < values[1][j]) {
									swap(values,0,i,j);
									swap(values,1,i,j);
							}
					}
			}
			if(DEBUG) System.out.println(Arrays.deepToString(values));
			return values;
		}

/*
	It swaps 2 values. It supports the sort method.
*/
		private static void swap(int[][] values,int row,int x, int y) {
			int temp = values[row][x];
			values[row][x] = values[row][y];
			values[row][y] = temp;
		}


		/*
		This algorithm goes through every element and checks for their neighbours color to decide their own color. Basically brute force...
		*/
		public static void greedy(int[][] e, int n, int m){
			//List includes every element and their color, if they have one
			int[][] list = new int[2][n];
			for(int i = 0; i < n; i++)
			{
				list[0][i] = i + 1;
			}
			//there has to be at least one color!
			int chromatic = 1;
			for(int i = 1; i <= list[0].length;i++)
			{
				int[] neighbours = neighbours(e,m,i);
				// checks if their neighbours color is the one they are trying to get. If yes, they take the next color.
				int currentColor = 1;
				for(int j = 0; j < neighbours.length; j++)
				{
					if(list[1][neighbours[j]-1] == currentColor)
					{
						j = 0;
						currentColor++;
						//Whenever we are adding a color we have to adjust the minimum colors required
						if(chromatic < currentColor) chromatic = currentColor;
					}
					list[1][i-1] = currentColor;
				}
			}
			System.out.println("The approximate chromatic number: " + chromatic);
		}

		/*
		This method takes the edges as input and returns an array with all neighbours!
		@param e is the array containing every edges
		@param m is the amount of EDGES
		@param i is the number we want to find the neighbours for
		*/
		public static int[] neighbours(int[][] e, int m, int i){
			//neighbours!!!! and also clunky as fuck
			//counting the amount of neighbours
			int counter = 1;
			//creating a temporary array
			int[] edges = new int[m];
			for(int j = 0; j < m;j++)
			{
				if(e[0][j] == i)
				{
					edges[counter -1] = e[1][j];
					counter++;
				}else if(e[1][j] == i)
				{
					edges[counter -1] = e[0][j];
					counter++;
				}
			}
			//here it is counter -1 because we always add +1 to counter when we find a neighbour. That means that after we added the last neighbor we still added +1!
			int[] neighbours = new int[counter-1];
			for(int j = 0; j < counter-1; j++)
			{
				neighbours[j] = edges[j];
			}
			return neighbours;
		}



}
