import java.util.Comparator;

/**
	 * @author Ruiwen
	 * counts the number of items in the tree in the range
	 * @param <E>
	 */
	public class CountRangeVisitor<E> implements Visitor<E>
	{
		private String str; 
		E rangeS, rangeE;
		Comparator<E> comp;
		
		
		public CountRangeVisitor(E a, E b, Comparator<E> comp){
	        str = "";
	        rangeS = a;
	        rangeE = b;
	        this.comp = comp;
		}

		@Override
		public void visit(E item) {
			if (comp.compare(rangeS, item) <= 0 && comp.compare(rangeE, item) >= 0){
				str += item + " ";
			}
		}

		public Object getValue() {
	        return "[" + str.trim() + "]";
		}
	}
