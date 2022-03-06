package unit_06_adapter.solution;

class Square {
	public int side;

	public Square(int side) {
		this.side = side;
	}
}

interface Rectangle {
	int getWidth();
	
	
	int getHeight();

	default int getArea() {
		return getWidth() * getHeight();
	}
}

class SquareToRectangleAdapter implements Rectangle {
	Square adaptee;
	
	public SquareToRectangleAdapter(Square square) {
		adaptee = square;
	}

	@Override
	public int getWidth() {
		return adaptee.side;
	}

	@Override
	public int getHeight() {
		return adaptee.side;
	}
}

public class AdapterExerciseSolution {

	public static void main(String[] args) {
		Square s = new Square(4);
		SquareToRectangleAdapter squareToRectangle = new SquareToRectangleAdapter(s);
		System.out.println(squareToRectangle.getArea());
	}
}