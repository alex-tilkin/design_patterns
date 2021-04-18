package unit_24_visitor;

abstract class ExpressionVisitorEx {
	abstract void visit(ValueEx value);

	abstract void visit(AdditionExpressionEx ae);

	abstract void visit(MultiplicationExpressionEx me);
}

abstract class ExpressionEx {
	abstract void accept(ExpressionVisitorEx ev);
}

class ValueEx extends ExpressionEx {
	public int value;

	public ValueEx(int value) {
		this.value = value;
	}

	@Override
	void accept(ExpressionVisitorEx ev) {
		// todo
	}
}

class AdditionExpressionEx extends ExpressionEx {
	public ExpressionEx lhs, rhs;

	public AdditionExpressionEx(ExpressionEx lhs, ExpressionEx rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	void accept(ExpressionVisitorEx ev) {
		// todo (yeah I know it's boring)
	}
}

class MultiplicationExpressionEx extends ExpressionEx {
	public ExpressionEx lhs, rhs;

	public MultiplicationExpressionEx(ExpressionEx lhs, ExpressionEx rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	void accept(ExpressionVisitorEx ev) {
		// todo
	}
}

class ExpressionPrinterEx extends ExpressionVisitorEx {
	private StringBuilder sb = new StringBuilder();

	// todo: overrides

	@Override
	public String toString() {
		return sb.toString();
	}

	@Override
	void visit(ValueEx value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void visit(AdditionExpressionEx ae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void visit(MultiplicationExpressionEx me) {
		// TODO Auto-generated method stub
		
	}
}

public class VisitorCodingExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}