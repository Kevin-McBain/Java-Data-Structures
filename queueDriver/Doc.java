package queueDriver;

/**
 * A Doc has a size, in blocks, to be printed.
 * 
 * @author (sdb) 
 * @version (Feb 2012)
 */
public class Doc
    implements Comparable <Doc>     // for priority queues
{
    private int size;      // size of this Doc, in blocks

    /**
     * Constructor for objects of class Printer
     */
    public Doc(int size)
    {
        this.size = size;
    }
    
    public int size()
    {   return size;  }
    
    public String toString()
    {   return "Doc of size " + size;  }
    
    public int compareTo (Doc doc)
    {   if (size > doc.size)
            return -1;
        if (size < doc.size)
            return 1;
        return 0;
    }
    
}