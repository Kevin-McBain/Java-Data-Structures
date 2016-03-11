package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the QuickSort algorithm.
 * 
 * @author (sdb)  
 * @version (Oct 2014)
 */
public class DriverQuicksort
{   static final int MAX = 10;
    
    public static void main(String args[])
    {
        Random rand = new Random();         // random number generator
        List <Integer> numbers = new ArrayList <Integer> ();
        Sorter<Integer>  sorter;
        sorter = new QuickSort <Integer> ();
        
        //Test a specific case of QuickSort     
        numbers.add (5);   
        numbers.add (3);
        numbers.add (1);  
        numbers.add (2);  
        numbers.add (6);  
        numbers.add (4);  
        System.out.println ("Before sorting:");
        System.out.println (numbers);
        sorter.sort (numbers );
        System.out.println ("\nAfter sorting:");
        System.out.println (numbers);
        
        // Test QuickSort with random input
        sorter = new QuickSort <Integer>();
        numbers.clear();                                               
        for (int i=0; i<MAX; i++)
            numbers.add (rand.nextInt(50));   // random int in [0..49]
        System.out.println ("Before sorting:");
        System.out.println (numbers);
        sorter.sort (numbers);
        System.out.println ("\nAfter sorting:");
        System.out.println (numbers);
        
        
         // Test QuickSort with ascending input
        sorter = new QuickSort <Integer>();
        numbers.clear();
        for (int i=0; i<MAX; i++)
            numbers.add (i * 10);           // initially in ascending order
        System.out.println ("Before sorting:");
        System.out.println (numbers);
        sorter.sort ( numbers);
        System.out.println ("\nAfter sorting:");
        System.out.println (numbers);
    }
}