package tree;

public class Product extends Expr
{
	public Product(Expr left, Expr right)
	{
		super(left, right);
	}
	
	public int eval()
	{
		return left.eval() * right.eval();
	}
	
	public boolean equals(Expr other)
	{
		if(!(other instanceof Product))
		{
			return false;
		}
		return (left.equals(other.left) && right.equals(other.right)) || (left.equals(other.right) && right.equals(other.left));
	}
	
	public Expr simplify()
	{
		left = left.simplify();
		right = right.simplify();
		
		if(right instanceof Constant)
		{
			if(right.eval() == 0)
			{
				return new Constant(0);
			}
			if(right.eval() == 1)
			{
				return left;
			}
		}
		
		if(left instanceof Constant)
		{
			if(left.eval() == 0)
			{
				return new Constant(0);
			}
			if(left.eval() == 1)
			{
				return right;
			}
		}
		
		if(left instanceof Constant && right instanceof Constant)
		{
			return new Constant(eval());
		}
		return this;
	}
	
	public String toString()
	{
		return "(" + left + " * " + right + ")";
	}
}
