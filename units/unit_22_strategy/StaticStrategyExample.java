package unit_22_strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

interface IListStrategy {
	default void start(StringBuilder sb) {
	}

	void addListItem(StringBuilder stringBuilder, String item);

	default void end(StringBuilder sb) {
	}
}

class MarkdownListStrategy implements IListStrategy {
	@Override
	public void addListItem(StringBuilder stringBuilder, String item) {
		stringBuilder.append(" * ").append(item).append(System.lineSeparator());
	}
}

class HtmlListStrategy implements IListStrategy {
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

class TextProcessor<ListStrategy extends IListStrategy> {
	private StringBuilder sb = new StringBuilder();
	private IListStrategy listStrategy;

	public TextProcessor(Supplier<? extends IListStrategy> ctor) {
		listStrategy = ctor.get();
	}

	public void appendList(List<String> items) {
		listStrategy.start(sb);
		for (String item : items) {
			((unit_22_strategy.IListStrategy) listStrategy).addListItem(sb, item);
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

public class StaticStrategyExample {

	public static void main(String[] args) {
		TextProcessor<MarkdownListStrategy> markdownProcessor = new TextProcessor<>(MarkdownListStrategy::new);
		markdownProcessor.appendList(Arrays.asList("liberte", "egalite", "fraternite"));
		System.out.println(markdownProcessor);

		TextProcessor<HtmlListStrategy> htmlProcessor = new TextProcessor<>(HtmlListStrategy::new);
		htmlProcessor.appendList(Arrays.asList("inheritance", "encapsulation", "polymorphism"));
		System.out.println(htmlProcessor);
	}
}