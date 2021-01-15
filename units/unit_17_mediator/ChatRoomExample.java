package unit_17_mediator;

import java.util.ArrayList;
import java.util.List;

class Person{
	public String name;
	public ChatRoom chatRoom;
	private List<String> chatLog = new ArrayList<String>();

	public Person(String name) {
		this.name = name;
	}
	
	public void receive(String sender, String message) {
		String s = sender + ": '" + message + "'";
		System.out.println("[" + name + "'s chat session]" + s);
	}
	
	public void say(String message) {
		chatRoom.broadcast(name, message);
	}
	
	public void privateMessage(String who, String message) {
		chatRoom.message(name, who, message);
	}
}

class ChatRoom{
	
	private List<Person> people = new ArrayList<Person>();
	
	public void join(Person person) {
		String joinMsg = person.name + " joins the room";
		broadcast("room", joinMsg);
		person.chatRoom = this;
		people.add(person);
	}
	
	public void broadcast(String source, String message) {
		for (Person person : people) {
			if(person.name.equals(source)) {
				continue;
			}
			
			person.receive(source, message);
		}
	}

	public void message(String source, String destination, String message) {
		people.stream()
		.filter(person -> person.name.equals(destination))
		.findFirst()
		.ifPresent(person -> person.receive(source, message));
	}
}

public class ChatRoomExample {

	public static void main(String[] args) {
		ChatRoom room = new ChatRoom();

	    Person john = new Person("John");
	    Person jane = new Person("Jane");

	    room.join(john); // no message here
	    room.join(jane);

	    john.say("hi room");
	    jane.say("oh, hey john");

	    Person simon = new Person("Simon");
	    room.join(simon);
	    simon.say("hi everyone!");

	    jane.privateMessage("Simon", "glad you could join us!");
	}
}
