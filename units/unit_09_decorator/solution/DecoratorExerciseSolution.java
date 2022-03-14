package unit_09_decorator.solution;

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
	private Bird b = new Bird();
	private Lizard l = new Lizard();

	public void setAge(int age) {
		this.age = age;
		l.age = age;
		b.age = age;
	}

	public String fly() {
		return b.fly();
	}

	public String crawl() {
		return l.crawl();
	}
}

public class DecoratorExerciseSolution {

	public static void main(String[] args) {
		Dragon d1 = new Dragon();
		d1.setAge(5);
		Dragon d2 = new Dragon();
		d2.setAge(0);
		Dragon d3 = new Dragon();
		d3.setAge(11);
		System.out.println(d1.fly());
		System.out.println(d1.crawl());
		System.out.println(d2.fly());
		System.out.println(d2.crawl());
		System.out.println(d3.fly());
		System.out.println(d3.crawl());
	}

}
