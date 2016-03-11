package stackDriver;
import stack.*;

import java.util.Scanner;
/**
 * Write a description of class Lab06 here.
 * 
 * @author (sdb) 
 * @version (Oct 2012)
 */
public class LabStringReverseSolution
{
    public static void main(String args[])
    {   String input = " ";
    	
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Enter several lines of input, or just Enter to terminate");
        while (input.length() > 0)
            {   input = scanner.nextLine();
                System.out.println(reverse(input));
            }
     }
        
    public static String reverse (String s)
    {   StackADT <Character> stack = new Stack <Character> ();
        String result = "";
        
        for (int i=0; i<s.length(); i++)
            { stack.push (s.charAt(i));
              System.out.println (stack);   // test toString()
            }
        while (!stack.isEmpty())
            result += stack.pop();
        return result;
    }


}