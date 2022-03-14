package unit_09_decorator.exercise;

class Bird {
	public int age;

	public String fly() {
		return age < 10 ? "flying" : "too old";
	}
}

class Lizard {
	public int age;

	public String crawl() {
		return (age > 1) ? "crawling" : "too young";
	}
}

class Dragon {
	private int age;

	public void setAge(int age) {
		// todo
	}

	public String fly() {
		return null;
	}

	public String crawl() {
		return null;
	}
}

public class DecoratorExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
