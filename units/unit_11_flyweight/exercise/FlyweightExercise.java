package unit_11_flyweight.exercise;

class Sentence {
	public Sentence(String plainText) {
		// todo
	}

	public WordToken getWord(int index) {
		// to do
		return null;
	}

	@Override
	public String toString() {
		// to do
		return null;
	}

	class WordToken {
		public boolean capitalize;
	}
}

public class FlyweightExercise {

	public static void main(String[] args) {
		Sentence sentence = new Sentence("Hi there");
		sentence.getWord(1).capitalize = true;
		System.out.println(sentence);
	}
}