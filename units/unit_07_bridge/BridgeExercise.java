package unit_07_bridge;

abstract class ShapeEx {
	public abstract String getName();
}

class TriangleEx extends ShapeEx {
	@Override
	public String getName() {
		return "Triangle";
	}
}

class SquareEx extends ShapeEx {
	@Override
	public String getName() {
		return "Square";
	}
}

class VectorSquare extends SquareEx {
	@Override
	public String toString() {
		return String.format("Drawing %s as lines", getName());
	}
}

class RasterSquare extends SquareEx {
	@Override
	public String toString() {
		return String.format("Drawing %s as pixels", getName());
	}
}

public class BridgeExercise {
	public static void main(String[] args) {
		
	}
}
