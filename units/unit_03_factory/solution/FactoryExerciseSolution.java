package unit_03_factory.solution;

class Person {
	public int id;
	public String name;

	private Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	static class PersonFactory {
		private static int counter = 0;
		
		public static Person createPerson(String name) {
			counter++;
			return new Person(counter, name);
		}
	}
}



public class FactoryExerciseSolution {

	public static void main(String[] args) {
		Person newPerson1 = Person.PersonFactory.createPerson("idan");
		Person newPerson2 = Person.PersonFactory.createPerson("dor");
		System.out.println(newPerson1.id + newPerson1.name);
		System.out.println(newPerson2.id + newPerson2.name);
	}

}
