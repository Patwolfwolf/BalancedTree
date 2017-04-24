import java.util.Comparator;
import java.util.LinkedList;

public class Node<E> {

	public int order;
	public LinkedList<Node> children;
	public LinkedList<Node> data;
	public Node parent;
	private Comparator<E> comp;

	
	/**
	 * create an empty node with given order and comparator
	 * @param order
	 * @param comp
	 */
	public Node(int order, Comparator<E> comp){
		
	}
	
	
	/**
	 * create a node with given left and right children, given comparator and given item
	 * @param order
	 * @param comp
	 * @param left
	 * @param item
	 * @param right
	 */
	public Node(int order, Comparator<E> comp, Node<E> left, E item, Node<E> right){
		
	}
	
	
	/**
	 * create a node with the given parent, given data and given children
	 * @param order
	 * @param comp
	 * @param p
	 * @param data
	 * @param children
	 */
	public Node(int order, Comparator<E> comp, Node<E> p, LinkedList<E> data, LinkedList<Node<E>> children){
		
	}
	
	
	/**
	 * @return whether the node is filled with number larger than order.
	 */
	public boolean hasOverflow(){
		return false;
	}
	
	
	/**
	 * @return whether the node is empty
	 */
	public boolean isEmpty(){
		return false;
	}
	
	
	/**
	 * @return whether the node is leaf, i.e.the node have no child.
	 */
	public boolean isLeaf(){
		return false;
	}
	
	
	/**
	 * @param item
	 * @return the next child to follow in order to locate the given item
	 */
	public Node<E> nextChild(E item){
		return null;
	}
	
	
	/**
	 * insert the given item in tree(should use for leaf nodes only).
	 * @param item
	 */
	public void add(E item){
		
	}
	
	
	/**
	 * split the node by creating a new sibling node with half of 
	 * the items and children of the original node
	 */
	public void split(){
		 
	}
	
	
	/**
	 * @param item
	 * @return whether the node contains the given item
	 */
	public boolean contains(E item){
		return false;
	}
	
	
	/**
	 * @return whether a node has its data sorted in order and the children
	 * have correct link to parents.
	 */
	public boolean isValid(){
		return false;
	}
	
	
}
