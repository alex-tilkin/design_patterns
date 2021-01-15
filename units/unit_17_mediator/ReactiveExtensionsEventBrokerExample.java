package unit_17_mediator;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

class EventBroker extends Observable<Integer>{
	private List<Observer<? super Integer>> observers = new ArrayList<>();
	
	@Override
	protected void subscribeActual(Observer<? super Integer> observer) {
		observers.add(observer);
	}
	
	public void publish(String name, int n) {
		for (Observer<? super Integer> observer : observers) {
			observer.onNext(n);
		}
	}
	
}

class FootballPlayer{
	private int goalsScored = 0;
	private EventBroker eventBroker;
	public String name;
	
	public FootballPlayer(EventBroker eventBroker, String name) {
		this.eventBroker = eventBroker;
		this.name = name;
	}
	
	public void score() {
		eventBroker.publish(name, ++goalsScored);
	}
}


class HeadCoach{
	public HeadCoach(EventBroker eventBroker) {
		eventBroker.subscribe((i) -> {System.out.println("You made " + i + " touchdowns");});
	}
	
}
public class ReactiveExtensionsEventBrokerExample {

	public static void main(String[] args) {
		EventBroker eventBroker = new EventBroker();
		FootballPlayer footballPlayer = new FootballPlayer(eventBroker, "Alvin Kamera");
		HeadCoach headCoach = new HeadCoach(eventBroker);
		
		footballPlayer.score();
		footballPlayer.score();
		footballPlayer.score();
	}
}