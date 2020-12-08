import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BruteForce{
	/**
	* This is the constructor for the BruteForce
	* @param g is the current graph selected which we want to run through the Brute Force
	*/
    public BruteForce(Graphs g)
    {
        graph = g;
    }
	/*
	* The solve method is where the BruteForce algorithm is used to solve for the chromatic number of a graph
	*/
    public void solve(){
		//getting the vertices of the graph and adding them to an array list
        int vertices1 = graph.getAmountVertices();
        ArrayList<Integer> vertices = new ArrayList<Integer>();
        for (int i = 1; i <= vertices1; i++){
            vertices.add(i);
        }
        // initialising everything we will need for the BruteForce, for example: a color, count etc.
        int count = 0;
        int edges = graph.getAmountEdge();
        int[][] connections = graph.getEdges();
        int color = 0;
        int chromatic = -1;
        ArrayList<Integer> neighbours = new ArrayList<Integer>();
		// Repeating the BruteForce algorithm for the amount of vertices we have
        for (int o = 0; o < vertices1; o++){
            // shifting the vertices in the vertices array by 1 so that everytime the BruteForce is repeated a different order of the vertices is used
            for (int p = 0; p < count; p++){
                int vertex1 = vertices.get(0);
                vertices.remove(0);
                vertices.add(vertex1);
            }
			// the vertices.isEmpty() ensures that the BruteForce algorithm runs as long as there are still uncolored vertices
            while (vertices.isEmpty() == false){
				// changing to the next color
                color = color + 1;
				// repeat for amount of vertices left in the vertices array (uncolored vertices)
                for (int j = 0; j < vertices.size(); j++){
                    // checking for every connection between to vertices to find the neighbours of selected vertex
                    for (int k = 0; k < connections[0].length; k++){
                        // if the connection has the selected vertex in the first column (other vertex in connection is the neighbour)
                        if (connections[0][k] == vertices.get(j)){
							// if the neighbour hasn't already been identified and it is still in the vertices array
                            if (neighbours.contains(connections[1][k]) == false && vertices.contains(connections[1][k])){
                                neighbours.add(connections[1][k]); // add neighbouring vertex to neighbours array

                            }
                            else{
                            }
							// going through the vertices array
                            for (int m = 0; m < vertices.size(); m++){
                                if (vertices.get(m) == connections[1][k]){
                                    vertices.remove(vertices.get(m)); // removing the neighbours from the vertices array so they can't be colored the same color

                                }
                                else{
                                }
                            }
                        }
						// repeating the above large if statement but for connections where the selected vertex is in the second column
                        else if (connections[1][k] == vertices.get(j)){
                            if (neighbours.contains(connections[0][k]) == false && vertices.contains(connections[0][k])){
                                neighbours.add(connections[0][k]);

                            }
                            else{
                            }
                            for (int n = 0; n < vertices.size(); n++){
                                if (vertices.get(n) == connections[0][k]){
                                    vertices.remove(vertices.get(n));

                                }
                                else{
                                }
                            }
                        }
                        else{
                        }
                    }
                }
				// clear vertices array
                vertices.clear();
				/* 
				* Sort neihgbours array
				* Fill vertices array with those neighbours, then clear the neighbours array
				* This allows us to repeat the above process but with only the uncolored vertices
				*/
                Collections.sort(neighbours);
                for (int l = 0; l < neighbours.size(); l++){
                    vertices.add(neighbours.get(l));
                }
                neighbours.clear();

            }
			// if this order of vertices produced a lower chromatic number than the previous lowest, replace chromatic number by current amount of colors
            if (color < chromatic || chromatic == -1){
                chromatic = color;
            }
            else{
            }
            ArrayList<Integer> vertices2 = new ArrayList<Integer>();
			// refill the empty vertices array with all the vertices to restart the whole process
            for (int i = 1; i <= vertices1; i++){
                vertices.add(i);
            }
            count = count + 1;
			// reset color
            color = 0;
        }
        chromaticNumberOfBrute =  chromatic;

    }
	/**
	* This method returns the chromatic number produced by the Brute force algorithm 
	* @return chromaticNumberOfBrute is the chromatic number that the Brute force algorithm found
	*/
    public int getChromatic()
    {
        return chromaticNumberOfBrute;
    }
	// initialising
    private Graphs graph;
    private int chromaticNumberOfBrute;
}


