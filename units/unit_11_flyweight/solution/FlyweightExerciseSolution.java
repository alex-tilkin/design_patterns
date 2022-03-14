package unit_11_flyweight.solution;

class Sentence {
	String[] text;
	WordToken[] isCapitalized;
	
	public Sentence(String plainText) {
		text = plainText.split(" ");
		isCapitalized = new WordToken[text.length];
		for(int i=0; i<text.length; i++)
			isCapitalized[i] = new WordToken();
	}

	public WordToken getWord(int index) {
		return isCapitalized[index];
	}

	@Override
	public String toString() {
		String toReturn = "";
		
		for(int i=0; i<text.length; i++) 
			toReturn += isCapitalized[i].capitalize == true ? text[i].toUpperCase():text[i]; 
		return toReturn;
	}

	class WordToken {
		public boolean capitalize;
	}
}

public class FlyweightExerciseSolution {

	public static void main(String[] args) {
		Sentence sentence = new Sentence("Hi there");
		sentence.getWord(1).capitalize = true;
		System.out.println(sentence);
	}
}