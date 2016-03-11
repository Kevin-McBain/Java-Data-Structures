package listDriver;

import list.*;

/**
 * Test the List ADT.
 * 
 * @author (sdb)
 * @version (Jan 2012)
 */
public class HomeworkLinkedList1Driver {
	public static void main(String args[]) {
		List<String> names;
		System.out.println("Testing LinkedLists");
		names = new LinkedList<String>();
		names.add("a");
		names.add("b");
	    names.add("d");
		names.add("c");
		names.add("e");
		System.out.println(names.hasDuplicates());
	}

}