package unit_04_prototype.solution;

class Point {
	public int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Line {
	public Point start, end;

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public Line deepCopy() {
		return new Line(this.start, this.end);
	}
}

public class PrototypeCodingExerciseSolution {

	public static void main(String[] args) {
		Point start = new Point(1, 3);
		Point end = new Point(4, 6);
		Line line1 = new Line(start, end);
		Line line2 = line1.deepCopy();
		System.out.println(String.format("%s: (%d, %d), (%d, %d)", "first line", line1.start.x, line1.start.y, line1.end.x, line1.end.y));
		System.out.println(String.format("%s: (%d, %d), (%d, %d)", "first line", line2.start.x, line2.start.y, line2.end.x, line2.end.y));
		System.out.println("is line1 == line2?");
		System.out.println(line1==line2);

	}

}
