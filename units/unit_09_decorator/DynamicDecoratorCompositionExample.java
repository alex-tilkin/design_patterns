package unit_09_decorator;

interface Shape {
	String info();
}

class Circle implements Shape {
	private float radius;

	Circle() {
	}

	public Circle(float radius) {
		this.radius = radius;
	}

	void resize(float factor) {
		radius *= factor;
	}

	@Override
	public String info() {
		return "A circle of radius " + radius;
	}
}

class Square implements Shape {
	private float side;

	public Square() {
	}

	public Square(float side) {
		this.side = side;
	}

	@Override
	public String info() {
		return "A square with side " + side;
	}
}

class ColoredShape implements Shape {
	private Shape shape;
	private String color;

	public ColoredShape(Shape shape, String color) {
		this.shape = shape;
		this.color = color;
	}

	@Override
	public String info() {
		return shape.info() + " has the color " + color;
	}
}

class TransparentShape implements Shape {
	private Shape shape;
	private int transparency;

	public TransparentShape(Shape shape, int transparency) {
		this.shape = shape;
		this.transparency = transparency;
	}

	@Override
	public String info() {
		return shape.info() + " has " + transparency + "% transparency";
	}
}

public class DynamicDecoratorCompositionExample {

	public static void main(String[] args) {
		Circle circle = new Circle(10);
	    System.out.println(circle.info());

	    ColoredShape blueSquare = new ColoredShape(new Square(20), "blue");
	    System.out.println(blueSquare.info());
	    
	    Shape blueTransparentShape = new TransparentShape(blueSquare, 50);
	    
	    System.out.println(blueTransparentShape.info());
	}
}