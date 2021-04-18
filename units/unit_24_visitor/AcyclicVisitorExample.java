package unit_24_visitor;

interface Visitor {
}

interface ExpressionAcyclicVisitor extends Visitor {
	void visit(AcyclicExpression obj);
}

interface DoubleExpressionVisitor extends Visitor {
	void visit(AcyclicDoubleExpression obj);
}

interface AdditionExpressionVisitor extends Visitor {
	void visit(AcyclicAdditionExpression obj);
}

abstract class AcyclicExpression {
// optional
	public void accept(Visitor visitor) {
		if (visitor instanceof ExpressionAcyclicVisitor) {
			((ExpressionAcyclicVisitor) visitor).visit(this);
		}
	}
}

class AcyclicDoubleExpression extends AcyclicExpression {
	public double value;

	public AcyclicDoubleExpression(double value) {
		this.value = value;
	}

	@Override
	public void accept(Visitor visitor) {
		if (visitor instanceof ExpressionAcyclicVisitor) {
			((ExpressionAcyclicVisitor) visitor).visit(this);
		}
	}
}

class AcyclicAdditionExpression extends AcyclicExpression {
	public AcyclicExpression left, right;

	public AcyclicAdditionExpression(AcyclicExpression left, AcyclicExpression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void accept(Visitor visitor) {
		if (visitor instanceof AdditionExpressionVisitor) {
			((AdditionExpressionVisitor) visitor).visit(this);
		}
	}
}

class AcyclicExpressionPrinter implements DoubleExpressionVisitor, AdditionExpressionVisitor {
	private StringBuilder sb = new StringBuilder();

	@Override
	public void visit(AcyclicDoubleExpression obj) {
		sb.append(obj.value);
	}

	@Override
	public void visit(AcyclicAdditionExpression obj) {
		sb.append('(');
		obj.left.accept(this);
		sb.append('+');
		obj.right.accept(this);
		sb.append(')');
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}

class AcyclicVisitorExample {
	public static void main(String[] args) {
		AcyclicAdditionExpression e = new AcyclicAdditionExpression(new AcyclicDoubleExpression(1),
				new AcyclicAdditionExpression(new AcyclicDoubleExpression(2), new AcyclicDoubleExpression(3)));
		AcyclicExpressionPrinter ep = new AcyclicExpressionPrinter();
		ep.visit(e);
		System.out.println(ep.toString());
	}
}