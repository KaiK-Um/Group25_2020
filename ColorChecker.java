import java.awt.Color;
import java.util.Arrays;

public class ColorChecker {
		/**
		* Check is a method which checks if the selected node has neighbours with the same color as it
		* @param nb is the selected node, created in the NodeButton class
		* @return returns false if atleast 1 neighbour has the same color as selected node, otherwise returns true
		*/
		public static boolean Check(NodeButton nb) {
			int vertex = nb.getVertexNumber();
			Drawer.g.adjacentNodes(vertex);
			int neighbours [] = Drawer.g.getAdjacentNodes();
			Color color = Drawer.colorList[vertex - 1];
			for (int i = 0; i < neighbours.length; i++) {
				Color neighbourColor = Drawer.colorList[neighbours[i]-1];
				if(color.equals(neighbourColor)) {
					return false;
				}
			}
			return true;
		}
		/**
		* Check is a method which identifies if a selected vertex has neighbours with the same color as it
		* @param vertex is the vertex selected
		* @return returns false if atleast 1 neighbour has the same color as the selected vertex, otherwise it returns true
		*/
		public static boolean Check(int vertex) {
			Drawer.g.adjacentNodes(vertex);
			int neighbours [] = Drawer.g.getAdjacentNodes();
			Color color = Drawer.colorList[vertex - 1];
			for (int i = 0; i < neighbours.length; i++) {
				Color neighbourColor = Drawer.colorList[neighbours[i]-1];
				if(color.equals(neighbourColor)) {
					return false;
				}
			}
			return true;
		}
	/**
	* CheckGM3 is like the other check methods but for gamemode 3 specifically
	* @param vertex is the selected vertex
	* @return returns false if atleast 1 neighbour has the same color as the selected vertex, otherwise returns true
	*/
	public static boolean CheckGM3(int vertex) {
		Drawer.g.adjacentNodes(vertex);
		int neighbours [] = Drawer.g.getAdjacentNodes();
		NodeButton b = InGameFrame3.NodeList.get(vertex-1);
		Color color = b.getColor();
		for (int i = 0; i < neighbours.length; i++) {
			NodeButton c = InGameFrame3.NodeList.get(neighbours[i]-1);
			Color neighbourColor = c.getColor();
			if(color.equals(neighbourColor)) {
				return false;
			}
		}
		return true;
	}
}
