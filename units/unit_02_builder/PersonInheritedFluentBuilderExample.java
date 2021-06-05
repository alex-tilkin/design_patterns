package unit_02_builder;

class PersonTyped {
	String name;
	int id;
	String education;
	
	@Override
	public String toString() {
		return String.format("Name: %s\nID: %d\nEducation: %s\n", name, id, education);
	}
}

class PersonBuilderTyped {
	protected PersonTyped person = new PersonTyped();
	
	PersonBuilderTyped addName(String name) {
		person.name = name;
		
		return this;
	}
	
	PersonBuilderTyped addId(int id) {
		person.id = id;
		
		return this;
	}
	
	PersonTyped build() {
		return person;
	}
	
	@SuppressWarnings("unchecked")
	<T extends PersonBuilderTyped>T typed(){
		return (T)this;
	}
}

class ScholarBuilderTyped extends PersonBuilderTyped {

	ScholarBuilderTyped addEducation(String education) {
		person.education = education;
		
		return this;
	}
}

public class PersonInheritedFluentBuilderExample {

	public static void main(String[] args) {
		ScholarBuilderTyped scholarBuilderTyped = new ScholarBuilderTyped();

		PersonTyped person = scholarBuilderTyped.addId(123).addName("Eric").<ScholarBuilderTyped>typed().addEducation("B.Sc. Software Engineering").build();
		
		System.out.println(person.toString());
	}
}
