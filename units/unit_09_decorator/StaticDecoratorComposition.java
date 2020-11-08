package unit_09_decorator;

import java.util.function.Supplier;

class StaticColoredShape<T extends Shape> implements Shape {
	private Shape shape;
	private String color;
	
	public StaticColoredShape(Supplier<? extends T> constructor, String color) {
		shape = constructor.get();
		this.color = color;
	}
	
	@Override
	public String info() {
		return shape.info() + "; with color " + color;
	}
}

class StaticTransparentShape<T extends Shape> implements Shape{
	private Shape shape;
	private String transparecy;
	
	public StaticTransparentShape(Supplier<? extends T> constructor, String transparecy) {
		shape = constructor.get();
		this.transparecy = transparecy;
	}

	@Override
	public String info() {
		return shape.info() + "; with transparecy " + transparecy;
	}
}

public class StaticDecoratorComposition {

	public static void main(String[] args) {
		Shape myShape = new StaticColoredShape<>(() -> new StaticTransparentShape<>(() -> new Square(23), "50"), "Blue");
		System.out.println(myShape.info());
	}
}