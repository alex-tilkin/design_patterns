package unit_05_singleton;

import java.util.HashMap;

enum AthelateType{
	Swimmer,
	Runner,
	SoccerPlayer
}

class Athelate{
	public static HashMap<AthelateType, Athelate> instances = new HashMap<>();
	
	public static Athelate getInstance(AthelateType athelateType) {
		if(instances.containsKey(athelateType)) {
			return instances.get(athelateType);
		}
		
		Athelate instance = new Athelate();
		instances.put(athelateType, instance);
	
		return instance;
	}
}

public class MultitonExample {

	public static void main(String[] args) {
		Athelate swimmer = Athelate.getInstance(AthelateType.Swimmer);
		Athelate runner = Athelate.getInstance(AthelateType.Runner);
		Athelate soccerPlayer = Athelate.getInstance(AthelateType.SoccerPlayer);
	}
}