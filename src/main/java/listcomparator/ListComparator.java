package listcomparator;

import java.util.List;

public class ListComparator {

	/**
	 * the two lists have exactly the same elements of each other.
	 *  - We don’t care about the order. 
	 *  - We don’t care if a list has duplicate elements as long as the other list has at least one of these elements. 
	 *
	 * Example :
	 * [“A” , “A”, “B”, “C” ] and [ “C”, “A”, “B”] have the same elements.
	 * [“A” , “C” ] and [ “C”, “B”, “A”] doesn’t, because “B” isn’t present in the first list.
	 *
	 * You can help you with the Spec file ListComparatorSpec. 
	 * The two lists can have 10 000 000 elements and the function must respond in less of 2 secs. 
	 * Your function must be optimized.
	 *
	 */
	public static <T> boolean haveSameElements(List<T> list1, List<T> list2) {
		return false;
	}
}
