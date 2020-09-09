package unit_02_builder;

class Person {
	String name;
	int id;
	String education;
	
	@Override
	public String toString() {
		return String.format("Name: %s\nID: %d\nEducation: %s\n", name, id, education);
	}
}

class PersonBuilder <SELF extends PersonBuilder<SELF>> {
	protected Person person = new Person();
	
	SELF addName(String name) {
		person.name = name;
		
		return self();
	}
	
	SELF addId(int id) {
		person.id = id;
		
		return self();
	}
	
	Person build() {
		return person;
	}
	
	protected SELF self() {
		return (SELF) this;
	}
}

class ScholarBuilder extends PersonBuilder<ScholarBuilder> {

	ScholarBuilder addEducation(String education) {
		person.education = education;
		
		return self();
	}
	
	@Override
	protected ScholarBuilder self() {
		return this;
	}
}

public class PersonTypedInheritedFluentBuilderExample {

	public static void main(String[] args) {
		ScholarBuilder surferBuilder = new ScholarBuilder();
		
		Person person = surferBuilder.addId(123).addName("Kolohe").addEducation("B.Sc. Software Engineering").build();
		
		System.out.println(person.toString());
	}
}
