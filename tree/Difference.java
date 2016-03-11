package tree;

public class Difference extends Expr {

	public Difference(Expr left , Expr right) {
		super(left,right);
	}

	public int eval() {
		return left.eval() - right.eval();
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		if(right instanceof Constant && right.eval() == 0)
		{
			return left;
		}
		if(left instanceof Constant && right instanceof Constant)
		{
				return new Constant(eval());
		}
		return this;
	}

	public String toString() {
		return "(" + left + " - " + right + ")";
	}

	public boolean equals(Expr other) {
		if(!(other instanceof Difference))
		{
			return false;
		}
		return left.equals(other.left) && right.equals(other.right);
	}

}
