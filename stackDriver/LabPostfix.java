package stackDriver;
import stack.*;

import java.util.Scanner;
/**
 * Evaluate postfix expressions
 * Assume that numbers and operators are separated by one space.
 * Assume that the expressions are well-formed.
 * @author (sdb and Kevin McBain) 
 * @version (Sep 2014)
 */
public class LabPostfix
{
	public static void main(String args[])
	{
		postfixEval();
	}
	
    // read postfix expressions from the keyboard, and evaluate
    public static void postfixEval()
    {   Stack <Integer> stack = new Stack <Integer> ();
        
        // read expression from the keyboard
        Scanner scanner = new Scanner (System.in);
        
        String input;       // store an entire expression
        String [] opInts;   // Each string is an operator or an int
            
        System.out.println ("Enter postfix expressions, or Enter to terminate");
        input = scanner.nextLine();
        while (input.length() > 0)
            {   opInts = input.split (" ");      // An array of Strings, delimiter is space
                char first;
                int temp;
                int temp2;
                // fill in the body of this loop:
                for (String s : opInts)
                    {   // Is the string s a number or operator?
                		first = s.charAt(0);
                		if(Character.isDigit(first))
                		{
                			int num = (first - '0');
                			stack.push(num);
                		}
                		else
                		{
                			temp = stack.pop();
            				temp2 = stack.pop();
                			switch (first){

                			case '+':
                				stack.push(temp2 + temp);
                				break;
                		
                			case '-':
                				stack.push(temp2 - temp);
                				break;
                		
                			case '*':
                				stack.push(temp2 * temp);
                				break;
                		
                			case '/':
                				stack.push(temp2 / temp);
                				break;
                		
                			case '%':
                				stack.push(temp2 % temp);
                				break;
                			}
                		}
                       
                    }       // reached end of an expression
                    if (!stack.isEmpty())
                        System.out.println (stack.peek());
                    stack.clear();
                    
                    input = scanner.nextLine();
                }
            }
                
}