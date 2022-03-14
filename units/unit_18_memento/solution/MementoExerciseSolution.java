package unit_18_memento.solution;

import java.util.ArrayList;
import java.util.List;

class Token {
	public int value = 0;

	public Token(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}

class MementoEx {
	public List<Token> tokens = new ArrayList<>();

	public void saveState(List<Token> tokens) {
		for (int i = 0; i < tokens.size(); i++)
			this.tokens.add(new Token(tokens.get(i).value));
	}
}

class TokenMachine {
	public List<Token> tokens = new ArrayList<>();

	public MementoEx addToken(int value) {
		tokens.add(new Token(value));
		MementoEx temp = new MementoEx();
		temp.saveState(tokens);
		return temp;
	}

	public MementoEx addToken(Token token) {
		tokens.add(token);
		MementoEx temp = new MementoEx();
		temp.saveState(tokens);
		return temp;
	}

	public void revert(MementoEx m) {
		tokens.clear();
		for (int i = 0; i < m.tokens.size(); i++)
			tokens.add(new Token(m.tokens.get(i).value));
	}

	@Override
	public String toString() {
		return tokens.toString();
	}
}

public class MementoExerciseSolution {

	public static void main(String[] args) {
		TokenMachine tm = new TokenMachine();
		Token t1 = new Token(4);
		MementoEx m1 = tm.addToken(3);
		System.out.println(tm.toString());
		MementoEx m2 = tm.addToken(t1);
		System.out.println(tm.toString());
		tm.revert(m1);
		System.out.println(tm.toString());
	}
}