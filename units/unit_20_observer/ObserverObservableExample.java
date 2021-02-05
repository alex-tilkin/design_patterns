package unit_20_observer;

import java.util.ArrayList;
import java.util.List;

class PropertyChangedEventArgs<T> {
	public T source;
	public String propertyName;
	public Object newValue;

	public PropertyChangedEventArgs(T source, String propertyName, Object newValue) {
		this.source = source;
		this.propertyName = propertyName;
		this.newValue = newValue;
	}
}

interface Observer<T> {
	void handle(PropertyChangedEventArgs<T> args);
}

class Observable<T> {
	private List<Observer<T>> observers = new ArrayList<>();

	public void subscribe(Observer<T> observer) {
		observers.add(observer);
	}

	protected void propertyChanged(T source, String propertyName, Object newValue) {
		for (Observer<T> o : observers)
			o.handle(new PropertyChangedEventArgs<T>(source, propertyName, newValue));
	}
}

class Surfer extends Observable<Surfer> {
	private int rank;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		if (this.rank == rank) {
			return;
		}
		
		this.rank = rank;
		propertyChanged(this, "rank", rank);
	}
}

class Wsl implements Observer<Surfer> {
	
	@Override
	public void handle(PropertyChangedEventArgs<Surfer> args) {
		System.out.println("Surfer's " + args.propertyName + " changed to " + args.newValue);
	}
}

class ObserverObservableExample {
	public static void main(String[] args) {
		Wsl wsl = new Wsl();
		Surfer surfer = new Surfer();
		surfer.subscribe(wsl);
		for (int i = 5; i > 0; i--) {
			surfer.setRank(i);
		}
	}
}
