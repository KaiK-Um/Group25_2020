import java.util.ArrayList;
import java.util.Arrays;

/**
 * This algorithm searches for the maximum clique. Because the maximum clique size is also the lower bound we can use this algorithm as our lower bound algorithm
 * (Source:
 * "Tomita E, Imamatsu K, Kohata Y, Wakatsuki M. A simple and efficient branch and bound algorithm for finding a maximum clique with experimental evaluations.
 * Systems and computers in japan. 1997;28(5):60-67. doi:10.1002/(SICI)1520-684X(199705)28:5<60::AID-SCJ7>3.0.CO;2-M")
 */
public class LowerBound
{
    public LowerBound(Graphs g)
    {
    	adjacencyMatrix = g.getAdjacencyMatrix();

        graph = g;
    }

    /**
     * In the article it says to sort it by degree but it always results in a lower bound of one, so we ignored this
     */
    public void solve()
    {
        //giving the expand method an arraylist with all vertices
        ArrayList<Integer> vertices = new ArrayList<Integer>();
        for(int i = 0; i < graph.getAmountVertices(); i++)
        {
            vertices.add(i);
        }
        //creating an empty arraylist that will contain the members of the clique
        ArrayList<Integer> members = new ArrayList<Integer>();
        expand(vertices, members);
    }

    /**
     * This method supports the solve() method by expanding the clique and adding a new element
     * @param neighbours (was called R in the article) is the set of all neighbours
     * @param members (No in the article) is the set of all members of the clique
     */
    public void expand(ArrayList<Integer> neighbours, ArrayList<Integer> members) {
        while(!neighbours.isEmpty()){
            //we choose a vertex that is in the same clique
            int vertex = neighbours.get(0);
            members.add(vertex);
            ArrayList<Integer> nextNeighbours = new ArrayList<Integer>();
            //we add all the neighbours to the nextNeighbours arraylist
            for(int i = 0; i < neighbours.size();i++){
                if(adjacencyMatrix[vertex][neighbours.get(i)] == 1)
                    nextNeighbours.add(neighbours.get(i));
            }
            //if there are no more neighbours the clique is complete
            if(nextNeighbours.isEmpty()){
                //if the clique is complete we have to compare it to the current max clique
                if(members.size() > maxClique.length){
                    maxClique = new int[members.size()];
                    for(int i = 0;i<maxClique.length;i++)
                    {
                        //we add +1 because our adjecency Matrix starts at 0 while our vertices start at 1
                        maxClique[i] = members.get(i) + 1;
                    }
                    maxSize = maxClique.length;
                }
            }
            //if its not complete we expand again
            else
            {
                expand(nextNeighbours, members);
            }
            // we need to add this to prevent an infinite loop
            members.remove((Integer) vertex);
            neighbours.remove((Integer) vertex);
        }
    }

    public int getMaxSize()
    {
        return maxSize;
    }

    private Graphs graph;
    private int[][] adjacencyMatrix;
    private int[] maxClique = new int[0];
    
    private static int maxSize;
}
