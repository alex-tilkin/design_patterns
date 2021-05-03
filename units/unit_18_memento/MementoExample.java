package unit_18_memento;


class Memento{
	private int balance;
	
	public Memento(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
}

class BankAccount{
	private int balance;
	
	public BankAccount(int balance) {
		this.balance = balance;
	}
	
	public Memento deposit(int amount) {
		this.balance += amount;
		
		return new Memento(this.balance - amount);
	}
	
	public void restore(Memento memento) {
		balance = memento.getBalance();
	}
	
	@Override
	public String toString() {
		return String.format("The balance is %d", balance);
	}
}

public class MementoExample {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount(400);
		
		Memento memento1 = bankAccount.deposit(10);
		Memento memento2 = bankAccount.deposit(30);
		System.out.println(bankAccount);
		
		bankAccount.restore(memento2);
		System.out.println(bankAccount);
		
		bankAccount.restore(memento1);
		System.out.println(bankAccount);
	}
}