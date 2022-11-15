package node;
import util.ArrayUtil;

public class Node {
	/*moment_array is the actual state of the puzzle,
	 *all moment_array objects will be different */
	private int[][] array = new int[3][3]; 
	
	/*the "Node" variables are the pointers,
	 * they'll keep the tree connected */
	private Node left = null,
				 middleLeft = null,
				 middleRight = null,
				 right = null,
				 source = null;
	
	private boolean visited = false;
	
	/*this is for a initial state*/
	public Node(int[][] array) {
		this.setArray(array);
	}
	
	public Node() {
	}

	public boolean equals(Node node) {
		return ArrayUtil.equals(node.array, 
				this.getArray());
	}

	public boolean hasSource() {
		if(this.getSource() != null) {
			return true;
		}
		return false;
	}
	public boolean isLeaf() {
		if(this.getLeft() == null) {
			return true;
		}
		return false;
	}

	public String getPositionFreeToString() { //Returns Line, column
		int[] position = ArrayUtil
			.positionArrayNull(this.getArray());

		 return Integer.toString(position[0])
				 +"."+Integer.toString(position[1]);
	}

	public void showArray() {
		ArrayUtil.showArray(this.array);
	}
	
	/* GETTERS AND SETTERS BELLOW */
	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getMiddleLeft() {
		return middleLeft;
	}

	public void setMiddleLeft(Node middleLeft) {
		this.middleLeft = middleLeft;
	}

	public Node getMiddleRight() {
		return middleRight;
	}

	public void setMiddleRight(Node middleRight) {
		this.middleRight = middleRight;
	}

	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public int[][] getArray() {
		return this.array;
	}

	public void setArray(int[][] array) {
		this.array = array;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	

}
