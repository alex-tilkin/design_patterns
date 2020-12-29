package unit_15_interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface Element {
	int eval();
}

class Integer implements Element{
	private int value;
	
	public Integer(int value) {
		this.value = value;
	}
	
	@Override
	public int eval() {
		return value;
	}	
}

class BinaryOperation implements Element{
	public enum Type{
		ADDITION,
		SUBTRACTION
	}
	
	public Type type;
	public Element left, right;
	
	@Override
	public int eval() {
		switch(type) {
			case ADDITION:
				return left.eval() + right.eval();
			case SUBTRACTION:
				return left.eval() - right.eval();
				default:
					return 0;
		}
	}
	
}

class Token{
	public enum Type{
		INTEGER,
		PLUS,
		MINUS,
		LEFT_PARENTHESIS,
		RIGHT_PARENTHESIS
	}
	
	public Type type;
	public String text;
	
	public Token(Type type, String text) {
		this.type = type;
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "'" + text + "'";
	}
}

public class LexerParserDemo {
	
	static List<Token> lex(String input){
		List<Token> tokens = new ArrayList<Token>();
		
		for (int index = 0; index < input.length(); index++) {
			switch(input.charAt(index)) {
			case '+':
				tokens.add(new Token(Token.Type.PLUS, "+"));
				break;
			case '-':
				tokens.add(new Token(Token.Type.MINUS, "-"));
				break;
			case '(':
				tokens.add(new Token(Token.Type.LEFT_PARENTHESIS, "("));
				break;
			case ')':
				tokens.add(new Token(Token.Type.RIGHT_PARENTHESIS, ")"));
				break;
				default:
					StringBuilder sb = new StringBuilder("" + input.charAt(index));
					for (int j = 0; j < input.length(); j++) {
						if(Character.isDigit(input.charAt(j))) {
							sb.append(input.charAt(j));
						} else {
							tokens.add(new Token(Token.Type.INTEGER, sb.toString()));
							break;
						}
					}
					break;
			}
		}
		
		return tokens;
	}
	
	static Element parse(List<Token> tokens) {
		BinaryOperation result = new BinaryOperation();
		boolean haveLHS = false;
		
		for(int i = 0; i < tokens.size(); ++i) {
			Token token = tokens.get(i);
			switch(token.type) {
				case INTEGER:
					Integer integer = new Integer(java.lang.Integer.parseInt(token.text));
					if(!haveLHS) {
						result.left = integer;
						haveLHS = true;
					} else {
						result.right = integer;
					}
					break;
				case PLUS:
					result.type = BinaryOperation.Type.ADDITION;
					break;
				case MINUS:
					result.type = BinaryOperation.Type.SUBTRACTION;
					break;
				case LEFT_PARENTHESIS:
					int j = 0;
					for (;j < tokens.size(); ++j) {
						if(tokens.get(j).type == Token.Type.RIGHT_PARENTHESIS) {
							break;
						}
					}
					
					List<Token> subExpression = tokens.stream().skip(i + 1).limit(j - i - 1).collect(Collectors.toList());
					Element element = parse(subExpression);
					if(!haveLHS) {
						result.left = element;
						haveLHS = true;
					} else {
						result.right = element;
					}
					
					i = j;
					break;
			}
		}
	
	return result;
	}
	
	public static void main(String[] args) {
		String input = "(13+4)-(12+1)";
		List<Token> tokens = lex(input);
		System.out.println(tokens.toString());
		
		Element parsed = parse(tokens);
		System.out.println(input + " = " + parsed.eval());
	}
}
