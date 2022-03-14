package unit_15_interpreter.solution;

import java.util.HashMap;
import java.util.Map;

class ExpressionProcessor {
	public Map<Character, Integer> variables = new HashMap<>();

	public int calculate(String expression) {
		for (int i = 0; i < expression.length(); i++)
			if (expression.charAt(i) == '+')
				return calculate(expression.substring(0, i))
						+ calculate(expression.substring(i + 1, expression.length()));
			else if (expression.charAt(i) == '-')
				return calculate(expression.substring(0, i))
						- calculate(expression.substring(i + 1, expression.length()));
		return Integer.parseInt(expression);
	}
}

public class InterpreterSolution {

	public static void main(String[] args) {
		ExpressionProcessor ep = new ExpressionProcessor();
		System.out.println(String.valueOf(ep.calculate("8+3+6")));
	}
}