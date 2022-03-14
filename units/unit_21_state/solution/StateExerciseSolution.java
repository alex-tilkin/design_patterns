package unit_21_state.solution;

class CombinationLock {
	private int[] combination;
	public String status = "";

	public CombinationLock(int[] combination) {
		this.combination = combination;
	}

	public void enterDigit(int digit) {
		if (status == "Open" || status == "Closed")
			status = "";
		status += digit;
		System.out.println(status);
		if (status.length() == combination.length) {
			String temp = "";

			for (int dig : combination)
				temp += dig;
			if (temp.equals(status))
				status = "Open";
			else
				status = "Error";
			System.out.println(status);
			status = "Closed";
			System.out.println(status);
		}
	}
}

public class StateExerciseSolution {

	public static void main(String[] args) {
		CombinationLock cl = new CombinationLock(new int[] { 1, 2, 3, 4 });
		cl.enterDigit(1);
		cl.enterDigit(1);
		cl.enterDigit(1);
		cl.enterDigit(1);
		cl.enterDigit(1);
		cl.enterDigit(2);
		cl.enterDigit(3);
		cl.enterDigit(4);
	}

}
