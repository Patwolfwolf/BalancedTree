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
		this.order = order;
		this.comp = comp;
		root = new Node<E>(order, comp);
	}	


	/**
	 * @return whether the tree is empty
	 */
	public boolean isEmpty(){
		return root.isEmpty();
	}


	/**
	 * add the given item to the tree
	 * @param item
	 */
	public void add(E item){
		Node<E> curr = findLeaf(root, item);
		curr.add(item);
		while(curr != null){
			if (curr.hasOverflow()){
				curr.split();
			 	curr = curr.parent;
			}
			else{
				break;
			}
		}
		while (curr.parent != null){
			curr = curr.parent;
		}
		root = curr;
	}



	/**
	 * @param node
	 * @param item
	 * @return the leaf node in the tree started at given node
	 */
	private Node<E> findLeaf(Node<E> node, E item){
		while (!node.isLeaf()){
			int index = 0;
			for (E e : node.data){
				if (comp.compare(e, item) > 0){
					break;
				}
				else{
					index++;
				}
			}
			node = node.children.get(index);
		}
		return node;
	}


	/**
	 * @param item
	 * @return whether the tree contains the given item
	 */
	public boolean contains(E item){
		if (findNode(root, item) != null){
			return true;
		}
		return false;
	}


	/**
	 * @param root
	 * @param item
	 * @return the node with the given item started at the given node
	 */
	private Node<E> findNode(Node<E> root, E item){
		if (root.contains(item)){
			return root;
		}
		else if (root.isLeaf()){
			return null;
		}
		else{
			for (Node<E> n : root.children){
				Node<E> result = findNode(n, item);
				if (result != null){
					return result;
				}
			}
		}
		return null;
	}


	/**
	 * perform inorder traversal of the tree
	 * @param visitor
	 */
	public void inorder(Visitor<E> visitor){
		inorder(visitor, root);
	}


	/**
	 * perform inorder traversal of the tree starting at given node
	 * @param visitor
	 * @param root
	 */
	private void inorder(Visitor<E> visitor, Node<E> root){
		if (!root.isLeaf()){
			inorder(visitor, root.children.get(0));
			for (int i = 0; i < root.data.size(); i++){
				visitor.visit(root.data.get(i));
				inorder(visitor, root.children.get(i+1));
			}
		}
		else{
			for (E e : root.data){
				visitor.visit(e);
			}
		}
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringVisitor<E> sv = new StringVisitor<E>();
		inorder(sv);
		return sv.getValue();
	}


	/**
	 * @return whether the tree is valid
	 */
	public boolean isValid(){
		return isValid(root); 
	}


	/**
	 * @param node
	 * @return whether the tree started at given node is valid
	 */
	private boolean isValid(Node<E> node){
		if (!node.isValid()){
			return false;
		}
		for (Node<E> n : node.children){
			if (!n.isValid()){
				return false;
			}
		}	
		return true;
	}


	public Node<E> getRoot(){
		return root;
	}

}
