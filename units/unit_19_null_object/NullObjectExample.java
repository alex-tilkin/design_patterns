package unit_19_null_object;

interface ILog {
	void info(String msg);
	void warn(String msg);
}

class ConsoleLog implements ILog {

	@Override
	public void info(String msg) {
		System.out.println(msg);
	}

	@Override
	public void warn(String msg) {
		System.out.println("WARNING: " + msg);
	}
}

final class NullLog implements ILog {

	@Override
	public void info(String msg) {

	}

	@Override
	public void warn(String msg) {

	}
}

class EntranceCounter {
	public ILog log;
	private int count;

	public EntranceCounter(ILog log) {
		this.log = log;
	}

	public void enter(int numberOfPeople) {
		count += numberOfPeople;
		
		log.info("Entered " + numberOfPeople + ", The count is " + count);
	}

	public void leave(int amount) {
		count -= amount;
		log.warn("Left " + amount + ", the count is " + count);
	}
}

public class NullObjectExample {

	public static void main(String[] args) {
	    NullLog nullLog = new NullLog();

	    EntranceCounter entranceCounter = new EntranceCounter(nullLog);
	    entranceCounter.enter(100);
	    entranceCounter.leave(50);
	    
	    ConsoleLog consoleLog = new ConsoleLog();
	    entranceCounter.log = consoleLog;
	    entranceCounter.enter(100);
	    entranceCounter.leave(50);
	}
}
