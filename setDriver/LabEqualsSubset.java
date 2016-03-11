package setDriver;
import set.*;
import list.*;


/**
 * Test the implementations of the Set interface.
 * 
 * @author (sdb) 
 * @version (Apr 2015)
 */
public class LabEqualsSubset
{
    public static void main(String args[])
    {   problem2 ();
        System.out.println();
        // Uncomment the following when ready for problem 3.
        problem3 ();
    }
    
    private static void problem2()
    {
        Set <String> friends, pals;
        friends = new TreeSet <String> ();
        pals = new HashSet <String> ();
        System.out.println ("Testing equals (Object)");
        
        if (! friends.equals (pals))
            System.err.println ("Error in equals");
        if (! pals.equals (friends))
            System.err.println ("Error in equals");
            
        friends.add ("joe");
        friends.add ("jim");
        if (friends.equals (pals))
            System.err.println ("Error in equals");
        if (pals.equals (friends))
            System.err.println ("Error in equals");
            
        friends.add ("joe");
        friends.add ("su" + "sie");
        pals.add ("jim");
        pals.add ("susie");
        pals.add ("jim");
        if (friends.equals (pals))
            System.err.println ("Error in equals");
        if (pals.equals (friends))
            System.err.println ("Error in equals");
        pals.add ("joe");
        
         if (! friends.equals (pals))
            System.err.println ("Error in equals");
        if (! pals.equals (friends))
            System.err.println ("Error in equals");

        System.out.println ("friends are: " + friends);
        System.out.println ("pals are: " + pals);
        
    }
    
    private static void problem3()
    {    Set <String> friends, pals;
        friends = new TreeSet <String> ();
        pals = new HashSet <String> ();
        System.out.println ("Testing subsetOf (Set)");
        friends.add ("joe");
        friends.add ("jim");
        if (friends.subsetOf (pals))
            System.err.println ("Error in subset");
        if (! pals.subsetOf (friends))
            System.err.println ("Error in subset");
            
        friends.add ("joe");
        friends.add ("su" + "sie");
        pals.add ("jim");
        pals.add ("susie");
        if (friends.subsetOf (pals))
            System.err.println ("Error in subset");
        if (! pals.subsetOf (friends))
            System.err.println ("Error in subset");
        pals.add ("jim");
        pals.add ("joe");
        
        if (! friends.subsetOf (pals))
            System.err.println ("Error in subset");
        if (! pals.subsetOf (friends))
            System.err.println ("Error in subset");
            
        pals.add ("jimmy");
        if (! friends.subsetOf (pals))
            System.err.println ("Error in subset");
        if (pals.subsetOf (friends))
            System.err.println ("Error in subset");

        System.out.println ("friends are: " + friends);
        System.out.println ("pals are: " + pals);
    }
    }

