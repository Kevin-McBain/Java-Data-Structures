package tree;
import list.*;
import queue.*;
public class TreeIterator<E> implements Iterator<E>{

	BinaryTree<E> tree;
	QueueADT<E> queue = new ArrayQueue<E>();
	E lastGotten;
	
	protected TreeIterator(BinaryTree<E> tree)
	{
		this.tree = tree;
		buildQ(tree);
	}
	private void buildQ(BinaryTree<E> tree)
	{
		if(tree.getLeft() instanceof BinarySearchTree)
		{
			buildQ(tree.getLeft());
		}
		queue.add(tree.getValue());
		if(tree.getRight() instanceof BinarySearchTree)
		{
			buildQ(tree.getRight());
		}
	}
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	public E next() {
		lastGotten = queue.remove();
		return lastGotten;
	}

	public void remove() {
		tree = tree.remove(lastGotten);
	}
	
	public E getLastGotten()
	{
		return lastGotten;
	}
	
}