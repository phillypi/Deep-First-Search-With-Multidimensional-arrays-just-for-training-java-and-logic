package ui;
import node.Node;
import util.ArrayUtil;


/*
 * Depth First Search using multidimensional vectors to find the result
 */

public class DepthFirstSeach {
	public static void main(String[] args) { 
		int[][] startArray = { { 1, 4, 2 }, 
							   { 3, 0, 5 }, 
							   { 6, 7, 8 } };

		int[][] objectiveState = { { 0, 1, 2 }, 
								   { 3, 4, 5 }, 
								   { 6, 7, 8 } };
	
		Node initialState = new Node(startArray);
		Node goalState = new Node(objectiveState);

		System.out.println("Start case: ");
		initialState.showArray();
		
		System.out.println("Objective case:");
		goalState.showArray();
		
		System.out.println("Started search now...");
		startSearch(initialState, goalState);
	}

	public static void startSearch(Node source, Node goalState) {
		Node momentNode = source;
		NodeStack<Node> stack = new NodeStack<Node>();
		
		while(!momentNode.isVisited()) {
			
			/* Will expand just if be a LEAF */
			if ((momentNode.isLeaf())&&(!momentNode.isVisited())
					 &&(!NodeStack.contains(momentNode, stack))){
				
				 match(momentNode, goalState, stack);
				 expandAllSonsOfSourceNode(momentNode);	
				 stack.push(momentNode);
		     }

		    if ((momentNode.getLeft() != null)&&(!momentNode.getLeft().isVisited())) {
				momentNode = momentNode.getLeft();
			} 
		    
			else if ((momentNode.getMiddleLeft() != null)&&(!momentNode.getMiddleLeft().isVisited())) {
				momentNode = momentNode.getMiddleLeft();
			}
			
			else if ((momentNode.getMiddleRight() != null)&&(!momentNode.getMiddleRight().isVisited())) {
				momentNode = momentNode.getMiddleRight();
			}
		    
			else if ((momentNode.getRight() != null)&&(!momentNode.getRight().isVisited())) {	
				momentNode = momentNode.getRight();
			}
			else if(momentNode.hasSource()){
				momentNode = trackBack(momentNode);
			}
		}
		
	}

	public static Node trackBack(Node momentNode) {
		momentNode.setVisited(true);
		momentNode = momentNode.getSource();
		return momentNode;
	}
	/* This is just a test if is a goal state */
	public static boolean match(Node momentNode, Node goalState, NodeStack<Node> stack) {
	
		if (ArrayUtil.equals(momentNode.getArray(), goalState.getArray())) { //final match test	
			System.out.println("We found a result with " + stack.size()+ " expanded nodes");
			momentNode.showArray();
			System.exit(0);
		}
		return false;
	}

	/* This will expand new node getting 0 position to realize "moves" */
	public static void expandAllSonsOfSourceNode(Node source) {

		String position = source.getPositionFreeToString();
	
		switch (position) {
		case "0.0":
			expandSourceLeftNode0x0(source);
			expandSourceMiddleLeftNode0x0(source);
			break;

		case "0.1":
			expandSourceLeftNode0x1(source);
			expandSourceMiddleLeftNode0x1(source);
			expandSourceMiddleRightNode0x1(source);
			break;

		case "0.2":
			expandLeftNode0x2(source);
			expandMiddleLeftNode0x2(source);
			break;

		case "1.0":
			expandLeftNode1x0(source);
			expandMiddleLeftNode1x0(source);
			expandMiddleRight1x0(source);
			break;

		case "1.1":
			expandLeftNode1x1(source);
			expandMiddleLeftNode1x1(source);
			expandMiddleRightNode1x1(source);
			expandRightNode1x1(source);
			break;

		case "1.2":
			expandLeftNode1x2(source);
			expandMiddleLeftNode1x2(source);
			expandMiddleRightNode1x2(source);
			break;

		case "2.0":
			expandLeftNode2x0(source);
			expandMiddleLeftNode2x0(source);
			break;

		case "2.1":
			expandLeftNode2x1(source);
			expandMiddleLeftNode2x1(source);
			expandMiddleRightNode2x1(source);
			break;

		case "2.2":
			expandLeftNode2x2(source);
			expandMiddleLeftNode2x2(source);
			break;

		default:
			System.out.println("Case default in startSearch");
			System.exit(0);
			break;
		}
	}

	/* Position 2x2 */
	public static void expandMiddleLeftNode2x2(Node source) {
		Node MiddleLeftNode = new Node();
		source.setLeft(MiddleLeftNode);
		MiddleLeftNode.setSource(source);
		MiddleLeftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellBottonRightToMiddleRight(MiddleLeftNode.getArray());
	}
	
	public static void expandLeftNode2x2(Node source) {
		Node leftNode = new Node();
		source.setLeft(leftNode);
		leftNode.setSource(source);
		leftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellBottonRightToBottonMiddle(leftNode.getArray());
	}
	
	/* Position 2x1 */
	public static void expandMiddleRightNode2x1(Node source) {
		Node middleRightNode = new Node();
		source.setMiddleRight(middleRightNode);
		middleRightNode.setSource(source);
		middleRightNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellBottonMiddleToBottonRight(middleRightNode.getArray());
	}

	public static void expandMiddleLeftNode2x1(Node source) {
		Node middleLeftNode = new Node();
		source.setMiddleLeft(middleLeftNode);
		middleLeftNode.setSource(source);
		middleLeftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellBottonMiddleToBottonLeft(middleLeftNode.getArray());
	}

	public static void expandLeftNode2x1(Node source) {
		Node leftNode = new Node();
		source.setLeft(leftNode);
		leftNode.setSource(source);
		leftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellBottonMiddleToCenter(leftNode.getArray());
	}

	/* Position 2x0 */
	public static void expandMiddleLeftNode2x0(Node source) {
		Node middleLeftNode = new Node();
		source.setMiddleLeft(middleLeftNode);
		middleLeftNode.setSource(source);
		middleLeftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellBottonLeftToBottonMiddle(middleLeftNode.getArray());
	}
	
	public static void expandLeftNode2x0(Node source) { 
		Node leftNode = new Node();
		source.setLeft(leftNode);
		leftNode.setSource(source);
		leftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellBottonLeftToMiddleLeft(leftNode.getArray());
	}

	/* Position 1x2 */

	public static void expandMiddleRightNode1x2(Node source) {
		Node middleRightNode = new Node();
		source.setMiddleRight(middleRightNode);
		middleRightNode.setSource(source);
		middleRightNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellMiddleRightToBottonRight(middleRightNode.getArray());
	}

	public static void expandMiddleLeftNode1x2(Node source) {
		Node middleLeftNode = new Node();
		source.setMiddleLeft(middleLeftNode);
		middleLeftNode.setSource(source);
		middleLeftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellMiddleRightToCenter(middleLeftNode.getArray());
	}

	public static void expandLeftNode1x2(Node source) {
		Node leftNode = new Node();
		source.setLeft(leftNode);
		leftNode.setSource(source);
		leftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellMiddleRightToTopRight(leftNode.getArray());
	}

	/* Position 1x1 */

	public static void expandRightNode1x1(Node source) {//ok
		Node rightNode = new Node();
		source.setRight(rightNode);
		rightNode.setSource(source);
		rightNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellCenterToBottonMiddle(rightNode.getArray());
	}

	public static void expandMiddleRightNode1x1(Node source) {//ok
		Node middleRightNode = new Node();
		source.setMiddleRight(middleRightNode);
		middleRightNode.setSource(source);
		middleRightNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellCenterToMiddleRight(middleRightNode.getArray());
	}

	public static void expandMiddleLeftNode1x1(Node source) {//ok
		Node middleLeftNode = new Node();
		source.setMiddleLeft(middleLeftNode);
		middleLeftNode.setSource(source);
		middleLeftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellCenterToTopMiddle(middleLeftNode.getArray());
	}

	public static void expandLeftNode1x1(Node source) {//ok
		Node leftNode = new Node();
		source.setLeft(leftNode);
		leftNode.setSource(source);
		leftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellCenterToMiddleLeft(leftNode.getArray());
	}

	/* Position 1x0 */
	public static void expandMiddleRight1x0(Node source) {//ok
		Node middleRightNode = new Node();
		source.setMiddleRight(middleRightNode);
		middleRightNode.setSource(source);
		middleRightNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellMiddleLeftToBottonLeft(middleRightNode.getArray());
	}

	public static void expandMiddleLeftNode1x0(Node source) { //ok
		Node middleLeftNode = new Node();
		source.setMiddleLeft(middleLeftNode);
		middleLeftNode.setSource(source);
		middleLeftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellMiddleLeftToTopLeft(middleLeftNode.getArray());
	}

	public static void expandLeftNode1x0(Node source) {//ok
		Node leftNode = new Node();
		source.setLeft(leftNode);
		leftNode.setSource(source);
		leftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellMiddleLeftToCenter(leftNode.getArray());
	}

	/* Position 0x2 */
	public static void expandMiddleLeftNode0x2(Node source) {//ok
		Node middleLeftNode = new Node();
		source.setMiddleLeft(middleLeftNode);
		middleLeftNode.setSource(source);
		middleLeftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellTopRightToMiddleRight(middleLeftNode.getArray());
	}

	public static void expandLeftNode0x2(Node source) {//ok
		Node leftNode = new Node();
		source.setLeft(leftNode);
		leftNode.setSource(source);
		leftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellTopRightToTopMiddle(leftNode.getArray());

	}

	/* Position 0x1 */

	public static void expandSourceMiddleRightNode0x1(Node source) {//ok
		Node middleRightNode = new Node();
		source.setMiddleRight(middleRightNode);
		middleRightNode.setSource(source);
		middleRightNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellTopMiddleToCenter(middleRightNode.getArray());
	}

	public static void expandSourceMiddleLeftNode0x1(Node source) {//ok
		Node middleLeftNode = new Node();
		source.setMiddleLeft(middleLeftNode);
		middleLeftNode.setSource(source);
		middleLeftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellTopMiddleToTopLeft(middleLeftNode.getArray());
	}

	public static void expandSourceLeftNode0x1(Node source) {//ok
		Node leftNode = new Node();
		source.setLeft(leftNode);
		leftNode.setSource(source);
		leftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellTopMiddleToTopRight(leftNode.getArray());
	}

	/* position 0x0 */
	public static void expandSourceMiddleLeftNode0x0(Node source) {//ok
		Node middleLeftNode = new Node();
		source.setMiddleLeft(middleLeftNode);
		middleLeftNode.setSource(source);
		middleLeftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellTopLeftToTopMiddle(middleLeftNode.getArray());
	}

	public static void expandSourceLeftNode0x0(Node source) {//ok
		Node leftNode = new Node();
		source.setLeft(leftNode);
		leftNode.setSource(source);
		leftNode.setArray(ArrayUtil.arrayCopy(source.getArray()));

		ArrayUtil.moveNullCellTopLeftToMiddleLeft(leftNode.getArray());
	}

}
