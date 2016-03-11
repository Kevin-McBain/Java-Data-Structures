package setDriver;

import set.HashSet;
import set.Set;
import set.TreeSet;

public class QuizSetDriver {

	public static void main(String args[]) {
		Set<Integer> set1;
		set1 = new TreeSet<Integer>();
		Set<Integer> set2;
		set2 = new TreeSet<Integer>();

		System.out.println("Testing TreeSet");
		test(set1, set2);

		System.out.println("\nTesting HashSet");
		set1 = new HashSet<Integer>();
		set2 = new HashSet<Integer>();
		test(set1, set2);
	}

	private static void test(Set<Integer> set1, Set<Integer> set2) {
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);

		set2.add(6);
		set2.add(7);
		set2.add(8);
		// should be no overlap

		Set<Integer> result = set1.intersection(set2);
		System.out.println("No Intersection Forwards: \n" + result.toString());
		
		result = set2.intersection(set1);
		System.out.println("No Intersection Backwards: \n" + result.toString());

		set2.add(4);
		set2.add(5);

		// overlap should be 4,5

		result = set1.intersection(set2);
		System.out.println("Partial Intersection Forwards: \n" + result.toString());
		result = set2.intersection(set1); 								
		System.out.println("Partial Intersection Backwards: \n" + result.toString());
		
		set2.add(1);
		set2.add(2);
		set2.add(3);
		//overlap should be 1,2,3,4,5
		result = set1.intersection(set2);
		System.out.println("Full Intersection Forwards: \n" + result.toString());
		result = set2.intersection(set1);
		System.out.println("Full Intersection Backwards: \n" + result.toString());

	}
}
