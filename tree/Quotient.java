package tree;

public class Quotient extends Expr {

	public Quotient(Expr left, Expr right) {
		super(left,right);
		}

	public int eval() {
		return left.eval() / right.eval();
	}

	public Expr simplify() {
		left = left.simplify();
		right = right.simplify();
		
		if(right instanceof Constant)
		{
			if(right.eval() == 1)
			{
				return left;
			}
		}
		
		if(left instanceof Constant && right instanceof Constant)
		{
			return new Constant(eval());
		}
		if(left.eval() == right.eval())
		{
			return new Constant(1);
		}
		return this;
	
	}

	@Override
	public String toString() {
		return "(" + left + " / " + right + ")";
	}

	@Override
	public boolean equals(Expr other) {
		// TODO Auto-generated method stub
		return false;
	}

}
