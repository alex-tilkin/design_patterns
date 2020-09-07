package unit_02_builder;

public class StringBuilderExample {

	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		String[] surboards = new String[] {"Channel Islands", "Pyzel", "Harley", "Rip Curl"};
		stringBuilder.append("Surboards TLV\n");
		stringBuilder.append("=============\n");
		stringBuilder.append("Available in stock\n");
		for (String surfboard : surboards) {
			stringBuilder.append("* " + surfboard + "\n");
		}
		
		System.out.println(stringBuilder);
	}
}