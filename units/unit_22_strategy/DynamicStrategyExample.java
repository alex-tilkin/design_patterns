package unit_22_strategy;

import java.util.Arrays;
import java.util.List;

enum StrategyType{
	MarkDown,
	Html
}

interface IDynamicListStrategy {
	default void start(StringBuilder sb) {
	}

	void addListItem(StringBuilder stringBuilder, String item);

	default void end(StringBuilder sb) {
	}
}

class DynamicMarkdownListStrategy implements IDynamicListStrategy {
	@Override
	public void addListItem(StringBuilder stringBuilder, String item) {
		stringBuilder.append(" * ").append(item).append(System.lineSeparator());
	}
}

class DynamicHtmlListStrategy implements IDynamicListStrategy {
	@Override
	public void start(StringBuilder sb) {
		sb.append("<ul>").append(System.lineSeparator());
	}

	@Override
	public void addListItem(StringBuilder stringBuilder, String item) {
		stringBuilder.append("  <li>").append(item).append("</li>").append(System.lineSeparator());
	}

	@Override
	public void end(StringBuilder sb) {
		sb.append("</ul>").append(System.lineSeparator());
	}
}

class DynamicTextProcessor {
	private StringBuilder sb = new StringBuilder();
	private IDynamicListStrategy listStrategy;

	public DynamicTextProcessor(IDynamicListStrategy listStrategy) {
		this.listStrategy = listStrategy;
	}
	
	public void switchStrategy(StrategyType strategyType) {
		switch(strategyType) {
		case Html:
			listStrategy = new DynamicHtmlListStrategy();
			break;
		case MarkDown:
			listStrategy = new DynamicMarkdownListStrategy();
			break;
		}
	}
	
	public void appendList(List<String> items) {
		listStrategy.start(sb);
		for (String item : items) {
			listStrategy.addListItem(sb, item);
		}
		
		listStrategy.end(sb);
	}

	public void clear() {
		sb.setLength(0);
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}

public class DynamicStrategyExample {

	public static void main(String[] args) {
		DynamicTextProcessor textProcessor = new DynamicTextProcessor(new DynamicHtmlListStrategy());
		textProcessor.appendList(Arrays.asList("liberte", "egalite", "fraternite"));
		System.out.println(textProcessor);
		textProcessor.switchStrategy(StrategyType.MarkDown);
		textProcessor.appendList(Arrays.asList("inheritance", "encapsulation", "polymorphism"));
		System.out.println(textProcessor);
	}
}