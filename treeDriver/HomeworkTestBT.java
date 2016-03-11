package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (Mar 2015)
 */
public class HomeworkTestBT
{
    
    public static void main(String args[])
    {
    BinaryTree <String> kids = new EmptyBinarySearchTree <String> ();
    
    if (!kids.isEmpty())
        System.out.println ("Not correct 1");
    
    kids = kids.add ("kimmy");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("sue");

    // With an inorder traversal, names should appear in alphabetic order
      System.out.println (kids);
      
      kids.remove ("kimmy");
      System.out.println (kids);
      kids.add ("kimmy");
      System.out.println (kids);
      kids.remove ("susie");
      System.out.println (kids);
      
      if (! kids.get("sue").equals ("s" + "u" + "e"))
        System.out.println ("Not correct 1");

      // Iterator should also provide an inorder traversal
      Iterator <String> itty = kids.iterator();
      while (itty.hasNext())
        System.out.println (itty.next());
      
    }
}