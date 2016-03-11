package mapDriver;
import map.*;
import set.*;
import list.Iterator;


/**
 * Test the HashMap
 * 
 * @author (sdb) 
 * @version (Apr 2015)
 */
public class LabMapDriver
{
    public static void main(String args[])
    {   Map <Student, Integer> grades = new HashMap <Student, Integer> ();
        
        test (grades);
        grades = new TreeMap <Student, Integer> ();
        test (grades);
    }

        
     private static void init (Map <Student, Integer> grades)
     {  Student mary = new Student ("mary", "111-22-3333", 3.5);
        grades.put (new Student ("jim", "252-33-0222", 2.5), 75);
        grades.put (mary, 85);
        grades.put (new Student ("joe", "252-00-0212", 3.6), 90);
        grades.put (mary, 95);
         
     }
        
     private static void test (Map<Student, Integer> grades)
     {
         
        assert grades.isEmpty() : "isEmpty incorrect ";
        init (grades);
                
        assert ! grades.isEmpty() : "isEmpty incorrect";
        Student student = new Student (null, "111-22-3333", 0.0); 
        assert grades.containsKey (student) : "containsKey incorrect";
        
        assert grades.size() == 3 : "Size is incorrect" ;
        System.out.println ("Grade for 111-22-3333 is " + grades.get (student));  // should be 95
        
        assert grades.remove (new Student ("", "252-33-0222", 0.0)) == 75 :  "remove is incorrect";
        assert grades.remove (new Student ("", "252-33-0222", 0.0)) == null:  "remove is incorrect";
        
        System.out.println (grades + "\n");  
        
        // Print A students
        // Uncomment the following when ready for problem 2:
         System.out.println ("The 'A' students are: ");
         Set <Student> roster = grades.keySet();
         Iterator <Student> itty = roster.iterator();
         while (itty.hasNext())
             {   Student st = itty.next();
                 if (grades.get(st) >= 90)
                     System.out.println (st);
             }
       
        System.out.println();
}
  
}