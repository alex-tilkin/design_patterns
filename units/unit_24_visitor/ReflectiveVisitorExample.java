package unit_24_visitor;

// separation of concerns
class ExpressionPrinter {
	public static void print(Expression expression, StringBuilder sb) {
		if (expression.getClass() == DoubleExpression.class) {
			sb.append(((DoubleExpression) expression).value);
		} else if (expression.getClass() == AdditionExpression.class) {
			AdditionExpression ae = (AdditionExpression) expression;
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