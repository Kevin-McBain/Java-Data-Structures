package hashDriver;
import hash.*;

/**
 * Test the HashTable class, using Book as the generic type.
 * 
 * @author (sdb) 
 * @version (March 2015)
 */ 
public class LabHashBooks
{
   public static void main(String args[])
   {    HashTable <Book> library = new HashTable <Book> ();
       
        library.put (new Book ("Java", "Barnes", 300));
        library.put (new Book ("Compilers", "Bergmann", 306));
        library.put (new Book ("Networks", "Stallings", 500));
        library.put (new Book ("Java", "Barnes", 305));
        
       
        if (library.isEmpty())
            System.err.println ("Not correct1");
        if (! library.containsKey (new Book ("Java", "Barnes", 0)))
            System.err.println ("Not correct2");
            
        System.out.println (library.size()); 
        
        System.out.println (library.get (new Book ("Compilers", "Bergmann", 0)));
        
        if (!library.remove (new Book ("Java", "Barnes", 0)))
             System.err.println ("Not correct3");
        if (!library.remove (new Book ("Java", "Barnes", 0)))
             System.err.println ("Not correct4");
        if (library.remove (new Book ("Java", "Barnes", 0)))
             System.err.println ("Not correct5");
             
        library.clear();
        if (!library.isEmpty())
            System.err.println ("Not correct6");
            
        library.put (new Book ("Java", "Barnes", 305));
        }
        
}