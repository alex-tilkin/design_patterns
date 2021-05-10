package unit_19_null_object;

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
		if (c + 1 != log.getRecordCount()){
			throw new Exception();
		}
		
		if (log.getRecordCount() >= log.getRecordLimit()) {
			throw new Exception();
		}
	}
}

public class NullObjectExercise {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}