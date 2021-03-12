package unit_06_adapter;

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
	public SquareToRectangleAdapter(Square square) {
		// todo
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class AdapterExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}