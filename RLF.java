import java.util.*;
import java.lang.*;

public class RLF {
    private final boolean DEBUG = false;
    private ArrayList<Integer> U = new ArrayList<Integer>();
    private int amountVertices;
    private int amountEdges;
    private int[][] edges;
    private int[][] saveDegree;
    private int[][] degree;
    private int[] uncoloredNeighbors;
    private int[] neighbours;
    private static int chromaticOfRLF = 0;

    public RLF(int n, int m, int[][] givenEdges) {
        amountEdges = m;
        amountVertices = n;
        edges = givenEdges;
        for(int i = 1; i <= n; i++)
        {
            U.add(i);
        }
        //an array that contains the degree of every vertex and is sorted by size (biggest degree first)
        int[][] deg = new int[2][n];
        for(int i = 0; i < n; i++)
        {
            int j = i+1;
            neighbours(j);
            deg[1][i] = neighbours.length;
        }
        for(int i = 0; i < n; i++)
        {
            deg[0][i] = i + 1;
        }
        degree = deg;
        //the array saving every degree
        int[][] saveDeg = new int[2][n];
        for(int i = 0; i < n; i++)
        {
            int j = i+1;
            neighbours(j);
            saveDeg[1][i] = neighbours.length;
        }
        for(int i = 0; i < n; i++)
        {
            saveDeg[0][i] = i + 1;
        }
        saveDegree  = saveDeg;
        sort(degree);
        if(DEBUG) System.out.println(Arrays.deepToString(degree));
        //System.out.println();
    }
    public RLF(Graphs g) {
        amountEdges = g.getAmountEdge();
        amountVertices = g.getAmountVertices();
        edges = g.getEdges();
        for(int i = 1; i <= amountVertices; i++)
        {
            U.add(i);
        }
        //an array that contains the degree of every vertex and is sorted by size (biggest degree first)
        int[][] deg = new int[2][amountVertices];
        for(int i = 0; i < amountVertices; i++)
        {
            int j = i+1;
            neighbours(j);
            deg[1][i] = neighbours.length;
        }
        for(int i = 0; i < amountVertices; i++)
        {
            deg[0][i] = i + 1;
        }
        degree = deg;
        //the array saving every degree
        int[][] saveDeg = new int[2][amountVertices];
        for(int i = 0; i < amountVertices; i++)
        {
            int j = i+1;
            neighbours(j);
            saveDeg[1][i] = neighbours.length;
        }
        for(int i = 0; i < amountVertices; i++)
        {
            saveDeg[0][i] = i + 1;
        }
        saveDegree  = saveDeg;
        sort(degree);
        if(DEBUG) System.out.println(Arrays.deepToString(degree));
    }

    public void solve(){
        //a set that saves the remaining objects
        ArrayList<Integer> W = new ArrayList<Integer>();
        //a set that saves the degree
        ArrayList<Integer> Deg = new ArrayList<Integer>();
        // if U is empty that means that we gave every element a value.
        //if there is no value that is getting passed that means that every color has been given
        if(!U.isEmpty())
        {
            while(!U.isEmpty())
            {
                int maxDeg = degree[0][0];
                if(DEBUG) System.out.println(maxDeg);
                if(!U.isEmpty())
                {
                    uncoloredNeighbors(maxDeg);
                    if(DEBUG) System.out.println("neighbours: " + Arrays.toString(uncoloredNeighbors));
                    for(int i = 0; i < uncoloredNeighbors.length; i++)
                    {
                        W.add(uncoloredNeighbors[i]);
                        Deg.add(saveDegree[1][uncoloredNeighbors[i]-1]);
                        int remove = uncoloredNeighbors[i];
                        U.remove((Integer) remove);
                        //if(DEBUG) System.out.println("U: " + U);
                        //because we dont want to color our neighbours the same color we have to remove them too
                        //if(DEBUG) System.out.println("Degree: " + Arrays.deepToString(degree));
                        int[][] helper2 = new int[2][degree[0].length-1];
                        for(int l = 0; l < helper2.length; l++)
                        {
                            int k = 0;
                            for(int j = 0; j < degree[0].length; j++)
                            {
                                if(degree[0][j] != uncoloredNeighbors[i])
                                {
                                    helper2[l][k] = degree[l][j];
                                    k++;
                                }
                            }
                        }
                        if(DEBUG) System.out.println("Helper2: " + Arrays.deepToString(helper2));
                        degree = helper2;
                    }
                    //remove the element out of U
                    U.remove((Integer) maxDeg);
                    if(DEBUG) System.out.println("U: " + U);
                    // we have to remove the first element because we are always using the first element
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
            sort(degree);
            Collections.sort(W);
            U = W;
            chromaticOfRLF++;
            if(DEBUG){
                //System.out.println("degree" + Arrays.deepToString(degree));
                //System.out.println("Deg: " + Deg);
                //System.out.println("U: " + U);
                //System.out.println("Savedegree" + Arrays.deepToString(saveDegree));
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            solve();
        }

    }

	/*
	The method that takes the set of neighbours and returns the ones that are still in the U set.
	*/

    public void uncoloredNeighbors(int vertex){
        neighbours(vertex);
        int[] every = neighbours;
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
        uncoloredNeighbors = uncolored;
    }
    /**
     This method takes the edges as input and returns an array with all neighbours!
     @param i is the number we want to find the neighbours for
     */
    public void neighbours(int i)
    {
        //counting the amount of neighbours
        int counter = 1;
        //creating a temporary array
        int[] edge = new int[amountEdges];
        for(int j = 0; j < amountEdges;j++)
        {
            if(edges[0][j] == i)
            {
                edge[counter -1] = edges[1][j];
                counter++;
            }else if(edges[1][j] == i)
            {
                edge[counter -1] = edges[0][j];
                counter++;
            }

        }
        neighbours = new int[counter-1];
        for(int j = 0; j < counter-1; j++)
        {
            neighbours[j] = edge[j];
        }
    }
    /**
     We had some problems sorting the degree array, so we googled it and found this:  https://stackoverflow.com/questions/36183108/sort-2d-array-by-specific-row .
     This method sorts the bottom fom biggest to lowest while also sorting the top row accordingly.
     @param array is the array we want to sort
     */
    public void sort(int[][] array){
        for(int i = 0; i < array[0].length -1; i++) {
            for(int j = i + 1; j < array[0].length; j++) {
                if(array[1][i] < array[1][j]) {
                    swap(array,0,i,j);
                    swap(array,1,i,j);
                }
            }
        }
    }

    /*
        It swaps 2 values. It supports the sort method.
    */
    private void swap(int[][] array, int row,int x, int y) {
        int temp = array[row][x];
        array[row][x] = array[row][y];
        array[row][y] = temp;
    }

    public int getChromaticOfRLF()
    {
        return chromaticOfRLF;
    }

}
