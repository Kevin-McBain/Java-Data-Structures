package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to
 * be printed
 * 
 * @author (sdb)
 */
public class Printer {
	private int speed; // speed of this printer, blocks per step
	private QueueADT<Doc> docs; // Queue of documents waiting to be printed
	private int remaining = -1;
	private String id; // name of this Printer

	/**
	 * Constructor for objects of class Printer
	 */
	public Printer(int speed, String id) {
		this.speed = speed;
		docs = new PriorityQueue<Doc>();
		this.id = id;
	}

	/** Add a document to this printer's queue */
	public void add(Doc doc) {
		docs.add(doc);
		System.out.println(doc + " added to the printer queue.");
	}

	/**
	 * Print several blocks, if necessary, determined by this printer's speed
	 * 
	 */
	public void print() {
		if (!docs.isEmpty()) {
			if (remaining == -1) {
				remaining = docs.peek().size();
			}
			if ((remaining - speed) <= 0) {
				System.out.println("Print task completed on " + id + " for: "
						+ docs.remove().toString());
				remaining = -1;
			} else {
				remaining = remaining - speed;
			}
		}
	}

	/** @return the number of documents in this Printer's queue */
	public int size() {
		return docs.size();
	}

	public String toString() {
		return id + ", speed: " + speed + ", docs in queue: " + size();
	}

}