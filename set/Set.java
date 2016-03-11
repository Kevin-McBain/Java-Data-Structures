package set;
import list.Iterator;

/**
 * 
 * Kevin McBain
 */
public interface Set<E>
{
    /**
     * @ return true is the value is added
     */
    boolean add(E value);
    
    /**
     * Return true if the given value is in list
     */
    boolean contains(Object obj);
    
    /**
     * the set will by empty
     */
    void clear();
    
    /**
     * remove the given object 
     *      @return true if removed
     */
    boolean remove(Object obj);
    
    /**
     * @return an iterator for this set
     */
    Iterator<E> iterator();
    
    /** @return the number of elements in this Set */
    int size();

    /** @return true only if there are no elements in this Set  */
    boolean isEmpty();

    /** @return All the elements in this set as a String in the following format:
           [a,b,c]
    */
    String toString();
    
    /** @return true only if this Set is equal to the parameter, other */ 
    boolean equals (Object other);

    boolean subsetOf(Set<E> other);
    
    /** @return A set which is the intersection of this Set with the given set */
    Set <E>  intersection (Set <E> set);
    
    /** @return the difference between this Set and other.  This method will change neither this Set nor the other Set. */
    Set<E>  difference (Set <E> other);

	
}
