package unit_13_command;

class Command {
	enum Action {
		DEPOSIT, WITHDRAW
	}

	public Action action;
	public int amount;
	public boolean success;

	public Command(Action action, int amount) {
		this.action = action;
		this.amount = amount;
	}
}

class Account {
	public int balance;

	public void process(Command c) {
		// todo
	}
}

public class CommandExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}