package unit_01_solid_design_principles;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Triplet;


interface IRelationshipsBrowser {
	List<Person> findChildrenOfParentByName(Person person);
}
//^^ Abstract Layer

class RelationshipsBrowser implements IRelationshipsBrowser {
	public List<Triplet<Person, Relationship, Person>> relations = new ArrayList<Triplet<Person,Relationship,Person>>();
	
	public List<Triplet<Person, Relationship, Person>> getRelations() {
		return relations;
	}
	
	public void AddRelationParentChild(Person parent, Person child) {
		relations.add(new Triplet<Person, Relationship, Person>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<Person, Relationship, Person>(child, Relationship.CHILD, parent));
	}
	//^^ exposed for usage in the infrastructure layer but closed for the application layer
	
	@Override
	public List<Person> findChildrenOfParentByName(Person person) {
		List<Person> children = new ArrayList<Person>();
		
		relations.stream().
		filter(relation -> relation.getValue0().getName().equals(person.getName()) && relation.getValue1() == Relationship.PARENT).
		forEach(relation -> children.add(relation.getValue2()));
		
		return children;
	}
}
//^^ Infrastructure

class AgnosticStudy {
	public static void printChildrenOf(Person person, IRelationshipsBrowser relationshipsBrowser) {
		List<Person> children = relationshipsBrowser.findChildrenOfParentByName(person);
		
		children.forEach(child -> System.out.println(String.format("%s is a child of %s", child.getName(), person.getName())));
	}
}
//^^ Application

public class InterfaceInversionPrinciple {

	public static void main(String[] args) {
		Person person1 = new Person("Avi");
		Person person2 = new Person("Tom");
		Person person3 = new Person("Ben");
		Person person4 = new Person("Lakey");
		Person person5 = new Person("Timmy");
		
		RelationshipsBrowser relationshipsBrowser = new RelationshipsBrowser();
		relationshipsBrowser.AddRelationParentChild(person2, person4);
		relationshipsBrowser.AddRelationParentChild(person2, person5);
		relationshipsBrowser.AddRelationParentChild(person1, person3);
		
		AgnosticStudy.printChildrenOf(person1, relationshipsBrowser);
		AgnosticStudy.printChildrenOf(person2, relationshipsBrowser);
	}
}