package listDriver;

import list.*;

/**
 * Test the ListIterator ADT.
 * 
 * @author (sdb) 
 * @version (Feb 2015)
 */
public class DriverListIterator
{
    public static void main(String args[])
    {   
    List <String> names;
    System.out.println ("Testing ListIterarors for ArrayLists");
    testItty (new ArrayList<String> ());
    System.out.println ("\nTesting ListIterarors for LinkedLists");
    testItty (new LinkedList<String> ());
}
   private static void testItty (List<String> names)
   {
   names.add ("jim");
   names.add ("mary");
   names.add ("joe");
   names.add ("sue");
   System.out.println (names);
    
   System.out.println ("Test the add method:");
   ListIterator <String> itty = names.listIterator();         
    System.out.println (itty.next());       // "jim"
    System.out.println (itty.next());       // "mary"
    itty.add ("harry");
    System.out.println (names);             // [jim, mary, harry, joe, sue]
    System.out.println (itty.next());       // "joe"
    itty.add ("bill");
    System.out.println (itty.previous());   // bill
    System.out.println (names);             // [jim, mary, harry, joe, bill, sue]
}

    }   