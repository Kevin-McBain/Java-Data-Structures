package queueDriver;

import java.util.Random;

/**
 * Simulate print queues and print jobs assigned to queues
 * 
 * @author (sdb)
 * @version (Feb 2012)
 */
public class PrintQueueTester 
{
	private Printer printer1;
	private Printer printer2;

	Random rand = new Random();
	
	public static void main(String args[]) 
	{
		PrintQueueTester test = new PrintQueueTester();
		test.test();
	}

	public PrintQueueTester() {
		printer1 = new Printer(5, "ROB 312"); // print speed is 5
		printer2 = new Printer(3, "Advanced Lab"); // print speed is 3
	}

	public void test() {
	//	Doc bigDoc = new Doc(33);
	//	Doc littleDoc = new Doc(2);
		printer1.add(new Doc(22));
		printer2.add(new Doc(2));
		printer1.add(new Doc(3));
		printer1.add(new Doc(5));
		printer2.add(new Doc(7));
		printer2.add(new Doc(1));

		for (int i = 0; i < 10; i++) {
			System.out.println("step " + i);
			printer1.print();
			printer2.print();
		}

	}
}