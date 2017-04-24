import java.util.Comparator;

public class BTree<E> {
	
	private Node<E> root;
	private Comparator<E> comp;
	private int order;
	
	
	/**
	 * creates an empty tree with the given order and given comparator
	 * @param order
	 * @param comp
	 */
	public BTree(int order, Comparator<E> comp){
		
	}	
	
	
	/**
	 * @return whether the tree is empty
	 */
	public boolean isEmpty(){
		return false;
	}
	
	
	/**
	 * add the given item to the tree
	 * @param item
	 */
	public void add(E item){
		
	}
	
	
	/**
	 * @param node
	 * @param item
	 * @return the leaf node in the tree started at given node
	 */
	private Node<E> findLeaf(Node<E> node, E item){
		return null;
	}
	
	
	/**
	 * @param item
	 * @return whether the tree contains the given item
	 */
	public boolean contains(E item){
		return false;
	}
	
	
	/**
	 * @param root
	 * @param item
	 * @return the node with the given item started at the given node
	 */
	private Node<E> findNode(Node<E> root, E item){
		return null;
	}
	
	
	/**
	 * perform inorder traversal of the tree
	 * @param visitor
	 */
	public void inorder(Visitor<E> visitor){
		
	}
	
	
	/**
	 * perform inorder traversal of the tree starting at given node
	 * @param visitor
	 * @param root
	 */
	private void inorder(Visitor<E> visitor, Node<E> root){
		
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return null;
	}
	
	
	/**
	 * @return whether the tree is valid
	 */
	public boolean isValid(){
		return false; 
	}
	
	
	/**
	 * @param node
	 * @return whether the tree started at given node is valid
	 */
	private boolean isValid(Node<E> node){
		return false;
	}
	
}
