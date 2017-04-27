import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BTreeTest {

	private BTree<Integer> empty3;
	private BTree<Integer> single1;
	private BTree<Integer> multi1;
	private BTree<Integer> empty2;
	private BTree<Integer> single2;
	private BTree<Integer> multi2;

	private NodeComparator comp;
	private StringVisitor<Integer> visit;
	
	@Before
	public void setUp(){
		comp = new NodeComparator();
		visit = new StringVisitor<Integer>();
		
		empty3 = new BTree(3, comp);
		assertTrue(empty3.isValid());	
		assertEquals( empty3.toString(), "[]");

		single1 = new BTree(3, comp);
		single1.add(5);
		assertEquals( single1.toString(), "[5]");
		assertTrue(single1.isValid());

		multi1 = new BTree(3, comp);
		multi1.add(7);
		multi1.add(8);
		multi1.add(9);
		assertEquals( multi1.toString(), "[7 8 9]" );
		assertTrue(multi1.isValid());
		
		empty2 = new BTree(2, comp);
		assertEquals( empty2.toString(), "[]");
		assertTrue(empty2.isValid());

		single2 = new BTree(2, comp);
		single2.add(5);
		assertEquals( single2.toString(), "[5]");
		assertTrue(single2.isValid());

		multi2 = new BTree(2, comp);
		multi2.add(50);
		multi2.add(80);
		multi2.add(60);
		multi2.add(55);
		multi2.add(20);
		multi2.add(57);
		multi2.add(59);
		multi2.add(70);
		multi2.add(95);
		multi2.add(75);
		multi2.add(65);
		assertEquals( multi2.toString(), "[20 50 55 57 59 60 65 70 75 80 95]" );
		assertTrue(multi2.isValid());

	}
	
	@Test
	public void test_isEmpty()
	{
		assertTrue( empty3.isEmpty() );

		assertFalse( single1.isEmpty() );

		assertFalse( multi1.isEmpty() );
	}

	@Test
	public void test_contains()
	{
		assertFalse( empty3.contains( 0 ) );

		assertTrue( single1.contains( 5 ) );
		assertFalse( single1.contains( 9 ) );

		assertTrue( multi1.contains( 7 ) );
		assertTrue( multi1.contains( 8 ) );
		assertTrue( multi1.contains( 9 ) );
		assertFalse( multi1.contains( 1 ) );	

		assertTrue( multi2.contains( 50 ) );	
		assertTrue( multi2.contains( 95 ) );	
		assertFalse( multi2.contains( 99 ) );	
		assertFalse( multi2.contains( -1 ) );	
		assertTrue( multi2.contains( 70 ) );	
		assertTrue( multi2.contains( 60 ) );	

	}

	@Test
	public void test_inorder()
	{
		visit = new StringVisitor<Integer>();
		multi1.inorder(visit);
		assertEquals( visit.getValue(), "[7 8 9]");
		visit = new StringVisitor<Integer>();
		single1.inorder(visit);;
		assertEquals( visit.getValue(), "[5]" );
		visit = new StringVisitor<Integer>();
		empty3.inorder(visit);
		assertEquals( visit.getValue(), "[]" );
	}

	
	@Test
	public void test_isValid()
	{
		assertTrue(empty3.isValid());	
		assertEquals( empty3.toString(), "[]");
		
		assertTrue(single1.isValid());
		assertEquals( single1.toString(), "[5]");

		assertTrue(multi1.isValid());	
		assertEquals( multi1.toString(), "[7 8 9]" );
	}
	

}
