package stack;
import list.*;
public class Stack<E> implements StackADT<E> {

	List<E> values;
	
	public Stack()
	{
		this(true);
	}
	
	public Stack(boolean arrayBased)
	{
		if(arrayBased)
		{
			values = new ArrayList<E>();
		}
		else{
			values = new LinkedList<E>();
		}
	}
	public E push(E value) {
		values.add(value);
		return value;
	}

	public E pop() {
		return values.remove(values.size() - 1);
	}

	public E peek() {
		return values.get(values.size() - 1);
	}
	
	public void clear()
	{
		
		while(!this.isEmpty())
		{
			this.pop();
		}
	}
	
	public boolean isEmpty()
	{
		return values.size() == 0;
	}
	
	public String toString()
	{
		return values.toString();
	}
	
	public String reverse (String s)
	{
    StackADT <Character> stack = new Stack <Character> ();
    String result = "";
    
    for (int i=0; i<s.length(); i++)
        { stack.push (s.charAt(i));
          System.out.println (stack);
        }
    while (!stack.isEmpty())
        result += stack.pop();
    return result;
	}

}
