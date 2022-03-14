package unit_13_command.solution;


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
		if(c.action == Command.Action.WITHDRAW) {
			if(c.amount > this.balance) {
				c.success = false;
				return;
			}
			else
				this.balance -= c.amount;
		}
		else
			this.balance += c.amount;
		c.success = true;
	}
}

public class CommandExerciseSolution {

	public static void main(String[] args) {
		Command comm = new Command(Command.Action.DEPOSIT, 20);
		Account a = new Account();
		a.process(comm);
		System.out.println(String.format("success command status: %b\n current balance: %d", comm.success, a.balance));
		Command comm1 = new Command(Command.Action.WITHDRAW, 30);
		a.process(comm1);
		System.out.println(String.format("success command status: %b\n current balance: %d", comm1.success, a.balance));
	}

}