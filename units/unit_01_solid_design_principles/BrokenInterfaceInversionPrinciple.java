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
// ^^ Data Layer

class Relationships {
	private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<Triplet<Person,Relationship,Person>>();
	
	public List<Triplet<Person, Relationship, Person>> getRelations() {
		return relations;
	}
	
	public void AddRelationParentChild(Person parent, Person child) {
		relations.add(new Triplet<Person, Relationship, Person>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<Person, Relationship, Person>(child, Relationship.CHILD, parent));
	}
}
//^^ Infrastructure

class Study {
	public static void printChildrenOf(String name, Relationships relationships) {
		relationships.getRelations().stream().
			filter(relation -> relation.getValue0().getName().equals(name) && relation.getValue1() == Relationship.PARENT).
				forEach(relation -> System.out.println(relation.getValue2().getName() + " is a child of " + relation.getValue0().getName()));
	}
}
//^^ Application

public class BrokenInterfaceInversionPrinciple {

	public static void main(String[] args) {
		Person person1 = new Person("Avi");
		Person person2 = new Person("Tom");
		Person person3 = new Person("Ben");
		Person person4 = new Person("Lakey");
		Person person5 = new Person("Timmy");
		
		Relationships relationships = new Relationships();
		relationships.AddRelationParentChild(person2, person4);
		relationships.AddRelationParentChild(person2, person5);
		relationships.AddRelationParentChild(person1, person3);
		
		Study.printChildrenOf(person1.getName(), relationships);
		Study.printChildrenOf(person2.getName(), relationships);
	}
}