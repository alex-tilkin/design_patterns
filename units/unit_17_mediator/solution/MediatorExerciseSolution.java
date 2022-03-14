package unit_17_mediator.solution;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Observer;

class EventBroker extends Observable<Integer> {
	private List<Observer<? super Integer>> observers = new ArrayList<>();

	@Override
	protected void subscribeActual(Observer<? super Integer> observer) {
		observers.add(observer);
	}

	public void publish(int n) {
		for (Observer<? super Integer> observer : observers) {
			observer.onNext(n);
		}
	}

}

class Participant {
	int value;
	private EventBroker eventBroker;

	public Participant(EventBroker eventBroker) {
		value = 0;
		this.eventBroker = eventBroker;
		eventBroker.subscribe((i) -> {
			this.value += i;
		});
	}

	public void say(int n) {
		eventBroker.publish(n);
		this.value -= n;
	}
}

public class MediatorExerciseSolution {
	public static void main(String[] args) {
		EventBroker e = new EventBroker();
		Participant p1 = new Participant(e);
		Participant p2 = new Participant(e);
		Participant p3 = new Participant(e);

		p1.say(4);
		System.out.println("p1: " + p1.value + " p2: " + p2.value + " p3: " + p3.value);
		p2.say(3);
		System.out.println("p1: " + p1.value + " p2: " + p2.value + " p3: " + p3.value);
		p3.say(2);
		System.out.println("p1: " + p1.value + " p2: " + p2.value + " p3: " + p3.value);
	}
}