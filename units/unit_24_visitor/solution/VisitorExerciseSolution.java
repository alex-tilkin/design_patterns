package unit_24_visitor.solution;

interface ExpressionVisitorEx {
	void visit(ValueEx value);

	void visit(AdditionExpressionEx ae);

	void visit(MultiplicationExpressionEx me);
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
		ev.visit(this);
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
		ev.visit(this);
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
		ev.visit(this);
	}
}

class ExpressionPrinterEx implements ExpressionVisitorEx {
	private StringBuilder sb = new StringBuilder();

	@Override
	public void visit(ValueEx value) {
		sb.append(value.value);

	}

	@Override
	public void visit(AdditionExpressionEx ae) {
		sb.append("(");
		ae.lhs.accept(this);
		sb.append("+");
		ae.rhs.accept(this);
		sb.append(")");

	}

	@Override
	public void visit(MultiplicationExpressionEx me) {
		me.lhs.accept(this);
		sb.append("*");
		me.rhs.accept(this);
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}

public class VisitorExerciseSolution {

	public static void main(String[] args) {
		AdditionExpressionEx simple = new AdditionExpressionEx(new ValueEx(2),
				new MultiplicationExpressionEx(new ValueEx(3), new ValueEx(5)));
		AdditionExpressionEx simple2 = new AdditionExpressionEx(
				new MultiplicationExpressionEx(new ValueEx(3), new ValueEx(5)), new ValueEx(4));
		MultiplicationExpressionEx simple3 = new MultiplicationExpressionEx(new ValueEx(3), new ValueEx(4));

		ExpressionPrinterEx ep = new ExpressionPrinterEx();
		ExpressionPrinterEx ep2 = new ExpressionPrinterEx();
		ExpressionPrinterEx ep3 = new ExpressionPrinterEx();
		ep.visit(simple);
		System.out.println(ep.toString());
		ep2.visit(simple2);
		System.out.println(ep2.toString());
		ep3.visit(simple3);
		System.out.println(ep3.toString());
		// Assert.assertEquals("(2+3)", ep.toString());
	}
}