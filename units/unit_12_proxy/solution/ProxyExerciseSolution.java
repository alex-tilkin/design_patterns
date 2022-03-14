package unit_12_proxy.solution;

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
		this.person = person;
	}
	
	public String drink() {
		if(person.getAge() < 18)
			return "too young";
		return person.drink();
	}

	public String drive() {
		if(person.getAge() < 16)
			return "too young";
		return person.drive();
	}

	public String drinkAndDrive() {
		return "do not do that!!!! :/";
	}
	
}

public class ProxyExerciseSolution {

	public static void main(String[] args) {
		ResponsiblePerson rp = new ResponsiblePerson(new PersonExercise(17));
		System.out.println(rp.drink());
		System.out.println(rp.drive());
		System.out.println(rp.drinkAndDrive());
	}
}