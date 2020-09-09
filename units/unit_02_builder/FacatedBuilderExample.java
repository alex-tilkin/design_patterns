package unit_02_builder;

class PersonFacade {
	String name;
	int id;
	String address;
	String city;
	String position;
	String firm;
	String education;
	int salary;
	
	@Override
	public String toString() {
		return "PersonFacade [name=" + name + ", id=" + id + ", address=" + address + ", city=" + city + ", position="
				+ position + ", firm=" + firm + ", education=" + education + ", salary=" + salary + "]";
	}
}

class PersonBuilderFacade {
	protected PersonFacade person = new PersonFacade();
	
	public PersonBuilderFacade withName(String name) {
		person.name = name;
		
		return this;
	}
	
	public PersonBuilderFacade withId(int id) {
		person.id = id;
		
		return this;
	}
	
	public PersonJobBuilder works() {
		return new PersonJobBuilder(person);
	}
	
	public PersonAddressBuilder lives() {
		return new PersonAddressBuilder(person);
	}
	
	public PersonFacade build() {
		return person;
	}
}

class PersonAddressBuilder extends PersonBuilderFacade {
	public PersonAddressBuilder(PersonFacade person) {
		this.person = person;
	}
	
	public PersonAddressBuilder withAddress(String address) {
		person.address = address;
		
		return this;
	}
	
	public PersonAddressBuilder withCity(String city) {
		person.city = city;
		
		return this;
	}
}

class PersonJobBuilder extends PersonBuilderFacade {
	public PersonJobBuilder(PersonFacade person) {
		this.person = person;
	}
	
	public PersonJobBuilder withPosition(String position) {
		person.position = position;
		
		return this;
	}
	
	public PersonJobBuilder withFirm(String firm) {
		person.firm = firm;
		
		return this;
	}
	
	public PersonJobBuilder withEducation(String education) {
		person.education = education;
		
		return this;
	}
	
	public PersonJobBuilder withSalray(int salary) {
		person.salary = salary;
		
		return this;
	}
}

public class FacatedBuilderExample {
	
	public static void main(String[] args) {
		PersonBuilderFacade personBuilder = new PersonBuilderFacade();
		
		PersonFacade person = personBuilder.
								withId(123).
								withName("Jhonny").
								works().
									withEducation("B.Sc. Software Engineering").
									withFirm("Google").
									withPosition("SW Engineer").
									withSalray(40000).
								lives().
									withAddress("Dizengoff 123").
									withCity("Tel Aviv").
								build();
			
		System.out.println(person.toString());
	}
}