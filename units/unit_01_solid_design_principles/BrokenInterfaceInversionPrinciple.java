package unit_01_solid_design_principles;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Triplet;

enum Relationship {
	PARENT,
	CHILD,
	SIBLING
}

class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

class Relationships {
	public List<Triplet<Person, Relationship, Person>> relations = new ArrayList<Triplet<Person,Relationship,Person>>();
	
	public List<Triplet<Person, Relationship, Person>> getRelations() {
		return relations;
	}
	
	public void AddRelationPArentChild(Person parent, Person child) {
		relations.add(new Triplet<Person, Relationship, Person>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<Person, Relationship, Person>(child, Relationship.CHILD, parent));
	}
}

class Study {
	public static void printChildrenOf(String name, Relationships relationships) {
		relationships.relations.stream().
			filter(relation -> relation.getValue0().getName().equals(name) && relation.getValue1() == Relationship.PARENT).
				forEach(relation -> System.out.println(relation.getValue2().getName() + " is a child of " + relation.getValue0().getName()));
	}
}

public class BrokenInterfaceInversionPrinciple {

	public static void main(String[] args) {
		Person person1 = new Person("Avi");
		Person person2 = new Person("Tom");
		Person person3 = new Person("Ben");
		Person person4 = new Person("Lakey");
		Person person5 = new Person("Timmy");
		
		Relationships relationships = new Relationships();
		relationships.AddRelationPArentChild(person2, person4);
		relationships.AddRelationPArentChild(person2, person5);
		relationships.AddRelationPArentChild(person1, person3);
		
		Study.printChildrenOf(person1.getName(), relationships);
		Study.printChildrenOf(person2.getName(), relationships);
	}
}