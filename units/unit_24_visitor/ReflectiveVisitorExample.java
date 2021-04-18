package unit_24_visitor;

// separation of concerns
class ExpressionPrinter {
	public static void print(Expression e, StringBuilder sb) {
		if (e.getClass() == DoubleExpression.class) {
			sb.append(((DoubleExpression) e).value);
		} else if (e.getClass() == AdditionExpression.class) {
			AdditionExpression ae = (AdditionExpression) e;
			sb.append("(");
			print(ae.left, sb);
			sb.append("+");
			print(ae.right, sb);
			sb.append(")");
		}
	}
}

class ReflectiveVisitorDemo {
	public static void main(String[] args) {
		// 1+(2+3)
		AdditionExpression e = new AdditionExpression(new DoubleExpression(1),
				new AdditionExpression(new DoubleExpression(2), new DoubleExpression(3)));
		StringBuilder sb = new StringBuilder();
		ExpressionPrinter.print(e, sb);
		System.out.println(sb);
	}
}