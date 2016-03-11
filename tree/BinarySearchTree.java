package tree;

import list.*;
/**
 * 
 * Kevin McBain
 */
public class BinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {

	E value;
	BinaryTree<E> left, right;

	BinarySearchTree(E value) {
		this.value = value;
		left = new EmptyBinarySearchTree<E>();
		right = new EmptyBinarySearchTree<E>();
	}

	public BinaryTree<E> getLeft() {
		return left;
	}

	public BinaryTree<E> getRight() {
		return right;
	}

	public E getValue() {
		return this.value;
	}

	public BinaryTree<E> add(E value) {
		int cmp = value.compareTo(this.value);
		if (cmp < 0) {
			left = left.add(value);
		}
		if (cmp > 0) {
			right = right.add(value);
		}
		return this;
	}

	public boolean containsKey(E value) {
		int cmp = value.compareTo(this.value);
		if (cmp == 0) {
			return true;
		}
		if (cmp < 0) {
			return left.containsKey(value);
		}
		return right.containsKey(value);

	}

	public E get(E value) {
		if (this.containsKey(value)) {
			return value;
		}
		return null;
	}

	public BinaryTree<E> remove(Object obj) {
		try {
			E value = (E) obj;
			int cmp = value.compareTo(this.value);
			if (cmp == 0) {
				List<BinaryTree<E>> kids = children();
				if (kids.size() == 0) {
					return new EmptyBinarySearchTree();
				}
				if (kids.size() == 1) {
					return kids.get(0);
				}
				BinaryTree<E> successor = ((BinarySearchTree) right).smallest();
				BinaryTree<E> result = remove(successor.getValue());
				result.setValue(successor.getValue());
				return result;

			}
			if (cmp < 0) {
				left = left.remove(value);
			}
			if (cmp > 0) {
				right = right.remove(value);
			}
		} catch (ClassCastException cce) {
		}
		return this;
	}

	private List<BinaryTree<E>> children() {
		List<BinaryTree<E>> kids = new ArrayList<BinaryTree<E>>();
		if (left instanceof BinarySearchTree)
			kids.add(left);

		if (right instanceof BinarySearchTree)
			kids.add(right);
		return kids;
	}

	private BinaryTree<E> smallest() {
		if (left instanceof EmptyBinarySearchTree)
			return this;
		return ((BinarySearchTree<E>) left).smallest();
	}

	public Iterator<E> iterator() {
		return new TreeIterator<E>(this);
	}

	public void setValue(E value) {
		this.value = value;
	}

	public void setLeft(BinaryTree<E> left) {
		this.left = left;
	}

	public void setRight(BinaryTree<E> right) {
		this.right = right;
	}

	public String toString() {
		Iterator<E> itty = this.iterator();
		if (itty.hasNext() == false) {
			return "[]";
		}
		String str = "[" + itty.next().toString();
		while (itty.hasNext()) {
			str = str + ", " + itty.next().toString();
		}
		str = str + "]";
		return str;
	}

	public boolean isEmpty() {
		if (this.left instanceof EmptyBinarySearchTree
				&& this.right instanceof EmptyBinarySearchTree) {
			return true;
		}
		return false;
	}

	/** @return the largest value in the family of this BinaryTree 
     *  Pre:   This BinaryTree is not empty
	 */
	public E getLargest() {
		if(!(this.getRight() instanceof BinarySearchTree))	
		{
			return this.value;		//We are at the largest value
		}
		return this.getRight().getLargest();		//We are not at the largest value, go right and try again
	}

	
	public int size() {
		return 1 + getLeft().size() + getRight().size();
	}

}
