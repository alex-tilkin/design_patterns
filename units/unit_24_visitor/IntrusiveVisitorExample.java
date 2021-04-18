package unit_24_visitor;

abstract class Expression {
	// we implement the visitor by adding a new method
	public abstract void print(StringBuilder sb);
}

class DoubleExpression extends Expression {
	double value;

	public DoubleExpression(double value) {
		this.value = value;
	}
	
	@Override
	public void print(StringBuilder sb) {
		sb.append(value);
	}
}

class AdditionExpression extends Expression {
	Expression left, right;

	public AdditionExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	// This approach brakes the open-closed principle
	@Override
	public void print(StringBuilder sb) {
		sb.append("(");
		left.print(sb);
		sb.append("+");
		right.print(sb);
		sb.append(")");
	}
}

class IntrusiveVisitorExample {
	public static void main(String[] args) {
		// 1+(2+3)
		AdditionExpression e = new AdditionExpression(new DoubleExpression(1),
				new AdditionExpression(new DoubleExpression(2), new DoubleExpression(3)));
		StringBuilder sb = new StringBuilder();
		e.print(sb);
		System.out.println(sb);
	}
}