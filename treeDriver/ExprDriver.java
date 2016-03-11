package treeDriver;
import tree.*;

/**Test the Expression tree classes.
 * 
 * 
 * 
 * 
 * @author (sdb) 
 * @version (Mar 2015)
 */
public class ExprDriver 
{
  public static void main(String args[])
  {   Expr e1 = new Sum (new Constant(3), new Constant(5));       //  3 + 5      
      Expr e2 = new Sum (new Constant(5), new Constant(3));       //  3 + 5 
      e1 = new Quotient (e1, e2);
      System.out.println ("The quotient is " + e1);                 // (3+5) / (5+3)
      System.out.println ("It simplifies to " + e1.simplify());       // 1
      
      e1 = new Difference (new Constant(3), new Constant(5));       //  3 - 5
      e2 = new Difference (new Constant(5), new Constant (3));      //  5 - 3
      if (e1.equals (e2))
        System.err.println ("Not correct: equals in Difference ");
      
   
      Expr zero = new Constant (0);
      Expr one = new Constant (1);
      e1 = new Sum (new Constant (3), zero);        // 3 + 0
      System.out.println (e1 + " simplifies to " + e1.simplify());           // 3
      
      e1 = new Product (new Constant (4), zero);    // 4 * 0
      System.out.println (e1 + " simplifies to " + e1.simplify());            // 0
      
      e1 = new Product (e2, one);                   //  (5-3) * 1
      System.out.println (e1 + " simplifies to " + e1.simplify());            //  (5 - 3)
      
      //////////  Uncomment the following when ready for problem 3
//         e1 = new Sum (new Variable('x'), new Variable('y'));       //  x + y
//         e2 = new Sum (new Variable('y'), new Variable('x'));       //  y+x
//         e2 = new Difference (e1, e2);                                   // (x+y) - (y+x)
//         System.out.println (e2 + "Simplifies to " + e2.simplify());                             // 0
//         System.out.println();
//         
//         Expr e = new Quotient (new Variable('x'), new Variable('x'));       // x / x
//         e = new Product ( new Variable('y'), e);                    //   y * (x/x)
//         e = new Difference (e, new Variable('y'));                   //   y * (x/x) - y
//         e = new Sum (e, new Constant(1));                             //   (y * (x/x) - y) + 1
// 
//         System.out.println (e + "Simplifies to " + e.simplify());        //    0
//             e1 = new Difference (new Variable ('a'), new Variable ('b'));
//             e2 = new Difference (new Variable ('b'), new Variable ('a'));
//             if (e1.equals (e2))
//                 System.out.println ("Not correct");
//             e1 = new Quotient (new Variable ('a'), new Variable ('b'));
//             e2 = new Quotient (new Variable ('b'), new Variable ('a'));
//             if (e1.equals (e2))
//                 System.out.println ("Not correct");
//        
//               
//           Expr a = new Variable ('a');
//           Expr b = new Variable ('b');
// 
// try {     System.out.println (new Sum(a,b).eval()); }
// catch (IllegalArgumentException iae)
//     {     System.err.println ("Variable has no value. " + iae); }
//      
// 	     e1 = new Sum (new Assign(a, new Constant(5)),
//                             new Assign (b, new Constant (7)));          // e1 = (a=5) + (b=7)
//           System.out.println ("e1 is " + e1);
//           System.out.println ("The value of e1 is " + e1.eval());
//           
//           
//           System.out.println ("a is " + a.eval());
//           System.out.println ("b is " + b.eval());
  
  }
  
}