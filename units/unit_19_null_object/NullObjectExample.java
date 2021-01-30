package unit_19_null_object;

interface Log {
	void info(String msg);

	void warn(String msg);
}

class ConsoleLog implements Log {

	@Override
	public void info(String msg) {
		System.out.println(msg);
	}

	@Override
	public void warn(String msg) {
		System.out.println("WARNING: " + msg);
	}
}

class EntranceCounter {
	private Log log;
	private int count;

	public EntranceCounter(Log log) {
		this.log = log;
	}

	public void enter(int numberOfPeople) {
		count += numberOfPeople;
		log.info("Entered " + numberOfPeople + ", The count is " + count);
	}

	public void leave(int amount) {
		count -= amount;
		System.out.println("Left " + amount + ", the count is " + count);
	}
}

final class NullLog implements Log {

	@Override
	public void info(String msg) {

	}

	@Override
	public void warn(String msg) {

	}
}

public class NullObjectExample {

	public static void main(String[] args) {
	    NullLog log = new NullLog();

	    EntranceCounter entranceCounter = new EntranceCounter(log);
	    entranceCounter.enter(100);
	    entranceCounter.leave(50);
	}
}
