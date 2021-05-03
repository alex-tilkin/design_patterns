package unit_18_memento;

import java.util.ArrayList;
import java.util.List;

class Token {
	public int value = 0;

	public Token(int value) {
		this.value = value;
	}
}

class MementoEx {
	public List<Token> tokens = new ArrayList<>();
}

class TokenMachine {
	public List<Token> tokens = new ArrayList<>();

	public MementoEx addToken(int value) {
		return null;
	}

	public MementoEx addToken(Token token) {
		return null;
	}

	public void revert(MementoEx mementoEx) {
		// todo
	}
}

public class MementoExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}