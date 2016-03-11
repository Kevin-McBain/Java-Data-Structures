package set;
import tree.*;

/**
 * 
 * Kevin McBain
 */
public class TreeSetIterator<E extends Comparable> extends TreeIterator<E>
{
    TreeSet<E> set;
    
    TreeSetIterator(TreeSet<E> set)
    {
        super(set.tree);
        this.set = set;
    }
    
    //no need to override hasNext(), Next()
    
    public void remove()
    {
        set.tree = set.tree.remove(getLastGotten());
        set.size--;
        
    }
}