package ui;

import java.util.Stack;
import node.Node;
import util.ArrayUtil;


public class NodeStack<E> extends Stack<E>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* This method needs to use a array and a list<Node> that contains arrays 
	 * and will be return a "false" value when that not find the array on this list */
	public static boolean contains(Node source, NodeStack<Node> node) {
		
		int array [][] = source.getArray();
		
		for(int i = 0; i < node.size(); i++) {
			if(ArrayUtil.equals(node
					.get(i).getArray(), array)) {
				return true;
			}
		}
		return false;
	}
}
