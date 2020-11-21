package unit_12_proxy;

class PersonExercise {
	private int age;

	public PersonExercise(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String drink() {
		return "drinking";
	}

	public String drive() {
		return "driving";
	}

	public String drinkAndDrive() {
		return "driving while drunk";
	}
}

class ResponsiblePerson {
	private PersonExercise person;

	public ResponsiblePerson(PersonExercise person) {
		// todo
	}
}

public class ProxyCodingExercise {

	public static void main(String[] args) {

	}
}