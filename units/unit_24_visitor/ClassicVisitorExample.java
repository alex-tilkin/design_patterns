package unit_24_visitor;

interface ExpressionVisitor {
	void visit(DoubleExpressionClassic e);
	void visit(AdditionExpressionClassic e);
}

abstract class ExpressionClassic {
	public abstract void accept(ExpressionVisitor visitor);
}

class DoubleExpressionClassic extends ExpressionClassic {
	public double value;

	public DoubleExpressionClassic(double value) {
		this.value = value;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
}

class AdditionExpressionClassic extends ExpressionClassic {
	public ExpressionClassic left, right;

	public AdditionExpressionClassic(ExpressionClassic left, ExpressionClassic right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
}

// separation of concerns
class ExpressionPrinterClassic implements ExpressionVisitor {
	private StringBuilder sb = new StringBuilder();

	@Override
	public void visit(DoubleExpressionClassic e) {
		sb.append(e.value);
	}

	@Override
	public void visit(AdditionExpressionClassic e) {
		sb.append("(");
		e.left.accept(this);
		sb.append("+");
		e.right.accept(this);
		sb.append(")");
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}

class ExpressionCalculator implements ExpressionVisitor {
	public double result;

	@Override
	public void visit(DoubleExpressionClassic e) {
		result = e.value;
	}

	@Override
	public void visit(AdditionExpressionClassic e) { 
		// this is a test too
		e.left.accept(this);
		double a = result;
		e.right.accept(this);
		double b = result;
		result = a + b; // this is a test
	}
}

class ClassicVisitorDemoExample {
	public static void main(String[] args) {
		// 1+(2+3)
		AdditionExpressionClassic e = new AdditionExpressionClassic(new DoubleExpressionClassic(1),
				new AdditionExpressionClassic(new DoubleExpressionClassic(2), new DoubleExpressionClassic(3)));
		
		ExpressionPrinterClassic ep = new ExpressionPrinterClassic();
		ep.visit(e);
		System.out.println(ep);

		ExpressionCalculator calc = new ExpressionCalculator();
		calc.visit(e);
		System.out.println(ep + " = " + calc.result);
	}
}