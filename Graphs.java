import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphs{
	
    public int [][] neighbours;
    public Nodes[] nodes;
    private int[] adjacentNodes;
    
    private int[][] edges;

    private static boolean DEBUG = false;
    private int amountVertices;
    private int amountEdges;

	/**
	 * This methods contructs a new graphs to be used by the drawer class.
	 * @param n is the amount of vertices
	 * @param m is the amount of edges
	 * @param e is the array containing all the edges
	 * @param nodes is the array containing all the node objects
	 */

	public Graphs(int n,int m, int[][] e,Nodes[] nodes)
    {
        edges = e;
        neighbours = e;
        this.nodes = nodes;
        amountVertices = n;
        amountEdges = m;
    }

	/**
	 * This methods contructs a new graphs to be used by the drawer class.
	 * @param neighbours
	 * @param nodes
	 */
   public Graphs (Nodes[] nodes, int[][] neighbours) {
	edges=neighbours;
	this.nodes = nodes;
	this.neighbours = neighbours;
	amountVertices = nodes.length;
    amountEdges = neighbours[0].length;
}


	/**
	 * This methods makes the adjacency matrix which is used to determine whether something is colored.
	 * @return the adjacency matrix
	 */

	public int [][] getAdjacencyMatrix(){
		int[][] adjacencyMatrix = new int[amountVertices][amountVertices];
		for(int i = 0;i < amountEdges; i++)
		{
			//we fill the matrix when there are edges:
			adjacencyMatrix[edges[0][i]-1][edges[1][i]-1] = 1;
			//As we have connections in both directions we have to fill in a x b as well as b x a
			adjacencyMatrix[edges[1][i]-1][edges[0][i]-1] = 1;
		}
		return adjacencyMatrix;

	}


	public int getAmountVertices() {
		// TODO Auto-generated method stub
		return amountVertices;
	}


	public int[][] getEdges() {
		// TODO Auto-generated method stub
		return edges;
	}


	public int getAmountEdge() {
		// TODO Auto-generated method stub
		return amountEdges;
	}
	
	public int[] getAdjacentNodes() {
		return adjacentNodes;
	}

	/**
	 * This methods checks whether there are adjacent nodes present next to the clicked node.
	 * @param i
	 */
	public void adjacentNodes(int i)
    {
        //counting the amount of neighbours
        int counter = 0;
        //creating a temporary array
        int[] edge = new int[amountEdges];
        //System.out.println("edges = " + Arrays.deepToString(edges));
        for(int j = 0; j < amountEdges;j++)
        {
            if(edges[0][j] == i)
            {
				counter++;
				edge[counter -1] = edges[1][j];
            }else if(edges[1][j] == i)
            {
				counter++;
				edge[counter -1] = edges[0][j];
            }
        }
        adjacentNodes = new int[counter];
        for(int j = 0; j < counter; j++)
        {
            adjacentNodes[j] = edge[j];
        }
        //System.out.println("AdjacentNodes " + Arrays.toString(adjacentNodes));
    }

	

	
}
