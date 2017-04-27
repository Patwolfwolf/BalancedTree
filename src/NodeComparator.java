import java.util.Comparator;

public class NodeComparator<E> implements Comparator<E>{

	public int compare(E o1, E o2) {
//		if (o1 == o2) {
//			return 0;
//		}
//		if (o1 == null) {
//			return -1;
//		}
//		if (o2 == null) {
//			return 1;
//		}
//		return (o1.toString()).compareTo(o2.toString());
		int i1 = Integer.valueOf(o1.toString());
		int i2 = Integer.valueOf(o2.toString());
		if (i1 > i2){
			return 1;
		}
		if (i1 < i2){
			return -1;
		}
		return 0;

	}



}
