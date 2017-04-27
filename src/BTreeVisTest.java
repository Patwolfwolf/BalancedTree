
public class BTreeVisTest
{
	public static void main(String[] args)
	{
		BTree<Integer> btree = new BTree<Integer>(2, new NodeComparator());

			Integer[] values = { 50, 80, 60, 55, 20, 57, 59, 70, 95, 75, 65 };


		for (Integer v: values) { 
			btree.add(v);
			new BTreeVis<Integer>(btree.getRoot(), "added " + v);    // visualize after current value
		}
	}
}
