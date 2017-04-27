import java.util.Comparator;
import java.util.LinkedList;

public class Node<E> {

	public int order;
	public LinkedList<Node<E>> children;
	public LinkedList<E> data;
	public Node<E> parent;
	private Comparator<E> comp;


	/**
	 * create an empty node with given order and comparator
	 * @param order
	 * @param comp
	 */
	public Node(int order, Comparator<E> comp){
		this.order = order;
		this.comp = comp;
		children = new LinkedList<Node<E>>();
		data = new LinkedList<E>();
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
		this(order, comp);
		this.data.addFirst(item);
		this.children.addFirst(right);
		this.children.addFirst(left);
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
		this(order, comp);
		this.parent = p;
		this.data = data;
		this.children = children;
	}


	/**
	 * @return whether the node is filled with number larger than order.
	 */
	public boolean hasOverflow(){
		return this.data.size() > order;
	}


	/**
	 * @return whether the node is empty
	 */
	public boolean isEmpty(){
		return this.data.isEmpty();
	}


	/**
	 * @return whether the node is leaf, i.e.the node have no child.
	 */
	public boolean isLeaf(){
		return this.children.isEmpty();
	}


	/**
	 * @param item
	 * @return the next child to follow in order to locate the given item
	 */
	public Node<E> nextChild(E item){
		int index = children.indexOf(item);
		if (index < children.size()){
			return children.get(index + 1); 
		}
		return null;
	}


	/**
	 * insert the given item in tree(should use for leaf nodes only).
	 * @param item
	 */
	public void add(E item){
		if (data.isEmpty()){
			data.add(item);
		}
		else {
			for (int i = 0; i < data.size(); i++){
				E e = data.get(i);
				if (comp.compare(e, item) > 0){
					data.add(i, item);
					break;
				}
				else if (i + 1 == data.size()){
					data.addLast(item);
					break;
				}
			}
		}
	}



	/**
	 * split the node by creating a new sibling node with half of 
	 * the items and children of the original node
	 */
	public void split(){
		int mid = data.size()/2;
		E item = data.get(mid);
		Node<E> extend = null;
		if (!isLeaf()){
			extend = new Node<E>( order, comp, parent, 
					new LinkedList<E>( data.subList(mid + 1, data.size())),
					new LinkedList<Node<E>>( children.subList(mid + 1, children.size())) );
			for (Node<E> c : extend.children){
				c.parent = extend;
			}
			children = new LinkedList<Node<E>>(children.subList(0, mid + 1));
		}
		else{
			extend = new Node<E>( order, comp, parent, 
					new LinkedList<E>( data.subList(mid + 1, data.size())), new LinkedList<Node<E>>());
		}
		if (parent != null){
			parent.add(item);
			int parentIndex = parent.data.indexOf(item);
			parent.children.add(parentIndex + 1, extend);
		}
		else{
			Node<E> head = new Node<E>(order, comp, this, item, extend);
			parent = head;
			extend.parent = parent;
		}
		data = new LinkedList<E>(data.subList(0, mid));
	}


	/**
	 * @param item
	 * @return whether the node contains the given item
	 */
	public boolean contains(E item){
		return data.contains(item);
	}


	/**
	 * @return whether a node has its data sorted in order and the children
	 * have correct link to parents.
	 */
	public boolean isValid(){
		for (int i = 0; i < data.size(); i++){
			if (!isLeaf()){
				if (comp.compare(children.get(i).data.getLast(), data.get(i)) > 0){
					return false;
				}
				else if (comp.compare(children.get(i + 1).data.getFirst(), data.get(i)) < 0){
					return false;
				}
			}
			else if (i + 1 < data.size()){
				if (comp.compare(data.get(i), data.get(i + 1)) > 0){
					return false;
				}
			}
		}
		for (Node<E> n : children){
			if (n.parent != this){
				return false;
			}
		}
		return true;
	}


	public int getOrder(){
		return order;
	}


	public LinkedList<E> getData(){
		return data;
	}


	public LinkedList<Node<E>> getChildren(){
		return children;
	}




}
