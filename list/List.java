package list;
 
/**
 * A List is a collection, order is maintained, duplicated are permitted
 *
 *@author Kevin McBain
 *
 */
public interface List<E>
{
    /** Add value to the end of the list */
    public void add(E value);
 
    /** Add value to given position */
    public void add(int index, E value);
 
    /** Return the value at the given position */
    public E get(int index);
 
    /** Change the value at the given index */
    public E set(int index, E value);
 
    /** Remove the value at the given index and return it */
    public E remove(int index);
     
    /** @return the postion of the first occurrence of the value in this List, or -1 if not found */
    public int indexOf(Object value);
     
    /** @return true only if value is contained in this List */
    boolean contains (Object value);
     
    /** @return the elements of this List as a String, with elements separated by commas, enclosed in square brackets:
     *  [a,b,c]
     */
    public String toString( );
     
    /** @return true only if this List is equal to the parameter, other */
    boolean  equals(Object other);
 
    /** Clear all elements from the list */
    public void clear();
 
    public int size();
    
    /**@return an Iterator for this List */
    Iterator<E> iterator();
 
    public boolean isEmpty();
    
    /** Remove the first occurrence of obj from this List if possible.
     *  @return true only if obj was removed.
     */
    boolean remove (Object obj);
    
    /**
     * @return a ListIterator for this list
     */
    ListIterator<E> listIterator();
    
    /**
     * @return a ListIterator starting with position index
     */
    ListIterator<E> listIterator(int index);
    
    /** @return true only if this List has at least one duplicate value */
    boolean hasDuplicates();
} //end list