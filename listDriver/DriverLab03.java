package listDriver;
import list.*;

/**
 * Lab 3
 * Test methods added to the List interface
 * 
 * @author (sdb) 
 * @version (Feb 2015)
 */
public class DriverLab03
{
/**
 *  This main method tests the List classes
 *  for lab 3, Data Structures and Algorithms
 */
    public static void main (String args[])
    {   List<String> friends = new LinkedList <String> ();

        System.out.println ("Testing problem 1");
    friends.add ("joe");
    friends.add ("mary");
    friends.add ("jim");
    friends.add ("joe");                            // Lists may contain duplicate elements
    friends.add (2, "sally");                       // Insert at position 2
    System.out.println (friends.get(3));            // Should be jim
    friends.remove (0);
    System.out.println (friends);                   // [mary, sally, jim joe]
    
    
    ////////////// Uncomment the following when ready for problem 2
     System.out.println ("\n\nTesting problem 2");   
     
     WordList wordList = new WordList();
     List <String> words = wordList.getWordList();
     System.out.println (words.indexOf ("jack"));        // Should be 51595
     if (!words.contains ("zoo"))
         System.err.println ("Error in contains");
     if (words.contains ("foobar"))
         System.err.println ("Error in contains");
      
     wordList = new WordList();
     List <String> moreWords = wordList.getWordList();
     if (!words.equals (moreWords))
         System.err.println ("Error in equals");
     if (!moreWords.equals (words))
         System.err.println ("Error in equals");
     moreWords.add (0, "foobar");
     if (words.equals (moreWords))
         System.err.println ("Error in equals");
     if (moreWords.equals (words))
         System.err.println ("Error in equals");
     moreWords.remove(0);
     moreWords.add ("foobar");
     if (words.equals (moreWords))
         System.err.println ("Error in equals");
     if (moreWords.equals (words))
         System.err.println ("Error in equals");
     words.add ("foo" + "bar");
     if (!words.equals (moreWords))
         System.err.println ("Error in equals");
     if (!moreWords.equals (words))
         System.err.println ("Error in equals");
     System.out.println ("Testing complete");
      }
}