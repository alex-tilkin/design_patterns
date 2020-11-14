package unit_11_flyweight;

import java.util.ArrayList;
import java.util.List;

class CapitalizedText {
	private String text;
	private boolean[] isCapitalized;

	public CapitalizedText(String text) {
		this.text = text;
		isCapitalized = new boolean[text.length()];
	}

	public void capitalize(int start, int end) {
		for (int index = start; index <= end; ++index) {
			isCapitalized[index] = true;	
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int index = 0; index < text.length(); ++index) {
			char character = text.charAt(index);
			stringBuilder.append(isCapitalized[index] ? Character.toUpperCase(character) : character);
		}
		
		return stringBuilder.toString();
	}
}

class FlyweightCapitalizedText {
	private String text;
	private List<TextRange> formatting = new ArrayList<>();

	public FlyweightCapitalizedText(String text) {
		this.text = text;
	}

	public TextRange getRange(int start, int end) {
		TextRange range = new TextRange(start, end);
		formatting.add(range);
		
		return range;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (int index = 0; index < text.length(); ++index) {
			char character = text.charAt(index);
			for (TextRange range : formatting)
				if (range.isCovers(index) && range.capitalize) {
					character = Character.toUpperCase(character);
				}
			
			stringBuilder.append(character);
		}
		
		return stringBuilder.toString();
	}

	public class TextRange {
		public int start;
		public int end;
		public boolean capitalize;
		public boolean bold; 
		public boolean italic;

		public TextRange(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public boolean isCovers(int position) {
			return position >= start && position <= end;
		}
	}
}

class FlyweightTextFormattingExample {
	public static void main(String[] args) {
		CapitalizedText capitalizedText = new CapitalizedText("So long and thank you for the fishes");
		capitalizedText.capitalize(10, 15);
		System.out.println(capitalizedText);

		FlyweightCapitalizedText flyweightCapitalizedText = new FlyweightCapitalizedText("Theatricality & deception. Powerful agents to the uninitiated; "
				+ "but we are initiated aren't we, Bruce. And then, you betrayed us, didn't you, Bruce?");
		
		flyweightCapitalizedText.getRange(13, 18).capitalize = true;
		System.out.println(flyweightCapitalizedText);
	}
}
