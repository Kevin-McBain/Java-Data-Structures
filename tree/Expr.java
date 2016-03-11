package tree;

public abstract class Expr {
	Expr left,right;
	public Expr(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}
	
	public Expr()
	{
		
	}
	
	public abstract int eval();
	public abstract Expr simplify();
	public abstract String toString();
	public abstract boolean equals(Expr other);

}
