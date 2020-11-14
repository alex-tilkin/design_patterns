package unit_11_flyweight;

class NotOptimizedGazillion {
	private static int num = 0;
	private int row, col;

	public NotOptimizedGazillion(int maxPerRow) {
		row = num / maxPerRow;
		col = num % maxPerRow;
		num++;
	}

	void report() {
		System.out.print(" " + row + col);
	}
}

public class NonFlyweightExampleExample {
	public static final int ROWS = 6, COLS = 10;

	public static void main(String[] args) {
		NotOptimizedGazillion[][] matrix = new NotOptimizedGazillion[ROWS][COLS];
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				matrix[i][j] = new NotOptimizedGazillion(COLS);
			}
		}
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				matrix[i][j].report();
			}
			System.out.println();
		}
	}
}