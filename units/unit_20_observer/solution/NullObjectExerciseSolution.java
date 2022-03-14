package unit_20_observer.solution;

interface LogExercise {
	// max # of elements in the log
	int getRecordLimit();

	// number of elements already in the log
	int getRecordCount();

	// expected to increment record count
	void logInfo(String message);
}

class Account {
	private LogExercise log;

	public Account(LogExercise log) {
		this.log = log;
	}

	public void someOperation() throws Exception {
		int c = log.getRecordCount();
		log.logInfo("Performing an operation");
		if (c + 1 != log.getRecordCount())
			throw new Exception();
		if (log.getRecordCount() >= log.getRecordLimit())
			throw new Exception();
	}
}

final class NullLogExercise implements LogExercise {
	private int counter = 0;

	@Override
	public int getRecordLimit() {
		return this.getRecordCount() + 1;
	}

	@Override
	public int getRecordCount() {
		return counter;
	}

	@Override
	public void logInfo(String message) {
		counter++;
	}

}

public class NullObjectExerciseSolution {

	public static void main(String[] args) {
		LogExercise le = new NullLogExercise();
		Account a = new Account(le);
		try {
			a.someOperation();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
