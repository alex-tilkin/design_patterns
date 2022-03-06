package unit_04_prototype.solution;

class PointSolution {
	public int x, y;

	public PointSolution(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class LineSolution {
	public PointSolution start, end;

	public LineSolution(PointSolution start, PointSolution end) {
		this.start = start;
		this.end = end;
	}

	public LineSolution deepCopy() {
		return new LineSolution(this.start, this.end);
	}
}

public class PrototypeCodingExerciseSolution {

	public static void main(String[] args) {
		PointSolution start = new PointSolution(1, 3);
		PointSolution end = new PointSolution(4, 6);
		LineSolution line1 = new LineSolution(start, end);
		LineSolution line2 = line1.deepCopy();
		System.out.println(String.format("%s: (%d, %d), (%d, %d)", "first line", line1.start.x, line1.start.y, line1.end.x, line1.end.y));
		System.out.println(String.format("%s: (%d, %d), (%d, %d)", "first line", line2.start.x, line2.start.y, line2.end.x, line2.end.y));
		System.out.println("is line1 == line2?");
		System.out.println(line1==line2);

	}

}
