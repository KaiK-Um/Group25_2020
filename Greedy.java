

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Greedy {
    private final boolean DEBUG = false;
    private int[][] edges;
    private int[][] list;
    private int[][] degree;
    private int[] neighbours;
    private static int chromaticOfGreedy;
    private int amountVertices;
    private int amountEdges;

    public Greedy(int[][] e, int n, int m)
    {
        amountVertices = n;
        amountEdges = m;
        edges = e;
        chromaticOfGreedy = 1;
        //List includes every element and their color, if they have one
        list = new int[2][amountVertices];
        for(int i = 0; i < amountVertices; i++)
        {
            list[0][i] = i + 1;
        }
        //creating an array with all the degrees in it
        degree = new int[2][amountVertices];
        for(int i = 0; i < amountVertices; i++)
        {
            int j = i+1;
            neighbours(j);
            degree[1][i] = neighbours.length;
        }
        for(int i = 0; i < amountVertices; i++)
        {
            degree[0][i] = i + 1;
        }
        sort(degree);
    }

    public Greedy(Graphs g)
    {
        amountVertices =Drawer.g.getAmountVertices();
        amountEdges = Drawer.g.getAmountEdge();
        edges = Drawer.g.getEdges();
        chromaticOfGreedy = 1;
        //List includes every element and their color, if they have one
        list = new int[2][amountVertices];
        for(int i = 0; i < amountVertices; i++)
        {
            list[0][i] = i + 1;
        }
        //creating an array with all the degrees in it
        degree = new int[2][amountVertices];
        for(int i = 0; i < amountVertices; i++)
        {
            int j = i+1;
            neighbours(j);
            degree[1][i] = neighbours.length;
        }
        for(int i = 0; i < amountVertices; i++)
        {
            degree[0][i] = i + 1;
        }
        sort(degree);
    }

    /**
     This method runs through the greedy algorithm once and returns an approximate chromaticOfGreedy number.
     */
    public void upperBound()
    {
        //there has to be at least one color!
        for(int i = 1; i <= list[0].length;i++)
        {
            neighbours(i);
            // checks if their neighbours color is the one they are trying to get. If yes, they take the next color.
            int currentColor = 1;
            for(int j = 0; j < neighbours.length; j++)
            {
                if(list[1][neighbours[j]-1] == currentColor)
                {
                    j = 0;
                    currentColor++;
                    //Whenever we are adding a color we have to adjust the minimum colors required
                    if(chromaticOfGreedy < currentColor) chromaticOfGreedy = currentColor;
                }
                list[1][i-1] = currentColor;
            }
        }
        if(DEBUG) System.out.println(chromaticOfGreedy);
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

    public int getchromaticOfGreedy()
    {
        return chromaticOfGreedy;
    }

    
}
