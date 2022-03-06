package unit_03_factory.exercise;

class Person {
	public int id;
	public String name;

	private Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	static class PersonFactory {
		public Person createPerson(String name) {
			// todo
			return null;
		}
	}
}



public class FactoryExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
