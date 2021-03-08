package unit_04_prototype;

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
		// todo
		return null;
	}
}

public class PrototypeCodingExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
