package set;
import tree.*;
import list.Iterator;

/**
 * 
 * Kevin McBain
 * 
 * Implement Set with a Binary Tree
 * Values will be in ascending order
 */
public class TreeSet<E extends Comparable> implements Set<E>
{
    BinaryTree<E> tree = new EmptyBinarySearchTree();
    int size = 0;
    
    public boolean add(E value)
    {
        if(tree.containsKey(value))
           {return false;}
        else{
        if(tree instanceof EmptyBinarySearchTree)
        	{
        	tree = tree.add(value);
        	}
        else{
        	tree.add(value);
        }
        this.size++;
        return true;
        }
    }
    
    public boolean contains(Object obj)
    {
        E value;
        
        try{ value = (E) obj;
             return tree.containsKey(value);
            }
        catch(ClassCastException cce)
        {
            return false;
        }
    }
    
    public void clear()
    {
        tree = new EmptyBinarySearchTree();
        size = 0;
    }
        
    public boolean remove(Object obj)
    {
        if(!contains(obj))
            return false;
        
        tree = tree.remove(obj);
        size--;
        return true;
        
    }
    
    public Iterator<E> iterator()
    {
        return new TreeSetIterator<E>(this);
        
    }
    
    public int size()
    {
        return this.size;
    }

	public boolean isEmpty() {
		return this.size() == 0;
	}
    
	public String toString()
	{
		return tree.toString();
	}
	
	public boolean equals(Object other)
	{
		if(!(other instanceof Set))
			{
				return false; //not a set, not equal
			}
		Set set = (Set) other; //other is a set, cast as such
		if(set.size() == 0 && this.size() == 0)
		{
			return true;
		}
		if(set.size() != this.size())
		{
			return false; //not the same number of elements, not equal
		}
		
		Iterator itty = this.iterator();
		while(itty.hasNext())
		{
			if(!set.contains(itty.next()))
			{
				return false;
			}
		}
		return true;
		
	}
    
	public boolean subsetOf(Set<E> other)
	{
		Iterator itty = this.iterator();
		while(itty.hasNext())
		{
			if(!other.contains(itty.next()))
			{
				return false;
			}
		}
		return true;
	}

	public Set<E> intersection(Set<E> set) {
		Iterator<E> itty = set.iterator();
		Set<E> temp = new TreeSet<E>();
		while(itty.hasNext())
		{
			temp.add(itty.next());				//populates a new temporary set as a copy of the given set to avoid
		}										//adding values that we do not mean to
		Set<E> result = new TreeSet<E>();
		itty = this.iterator();
		while(itty.hasNext())
		{
			E nxt = itty.next();
			if(temp.add(nxt))
			{
				//do nothing
			}
			else{
				result.add(nxt);
			}
		}
		return result;
	}

	public Set<E> difference(Set<E> other) {
		Set<E> result = new TreeSet<E>();
		Iterator<E> itty = this.iterator();
		E element;
		while (itty.hasNext())
		{
			element = itty.next();
			if(!(other.contains(element)))
			{
				result.add(element);
			}
		}
		return result;
	}
   
}
