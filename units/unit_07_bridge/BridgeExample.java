package unit_07_bridge;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

// Shape: Circle, Square
// Rendere: Vector, Raster
// Classes: VectorCircleRenderer, RasterCircleRenderer, VectorSquareRenderer, RasterSquareRenderer 

interface Renderer {
	void renderCirlde(float radius);
	void renderSquare(float length);
}

class VectorRenderer implements Renderer {

	@Override
	public void renderCirlde(float radius) {
		System.out.println("Drawing a circle of radius " + radius);
	}

	@Override
	public void renderSquare(float dimension) {
		System.out.println("Drawing a square of dimension " + dimension);
	}
}

class RasterRenderer implements Renderer {

	@Override
	public void renderCirlde(float radius) {
		System.out.println("Drawing pixels for a circle of radius " + radius);
		
	}

	@Override
	public void renderSquare(float dimension) {
		System.out.println("Drawing pixels for a square of dimension " + dimension);
		
	}
}

abstract class Shape {
	protected Renderer renderer;
	
	public Shape(Renderer renderer) {
		this.renderer = renderer;
	}
	
	public abstract void draw();
	public abstract void resize(float factor);
}

class Circle extends Shape{
	
	public float radius;
	
	@Inject
	public Circle(Renderer renderer) {
		super(renderer);
	}
	
	public Circle(Renderer renderer, float radius) {
		super(renderer);
		this.radius = radius;
	}

	@Override
	public void draw() {
		renderer.renderCirlde(radius);
	}

	@Override
	public void resize(float factor) {
		radius *= factor;
	}
	
}

class Square extends Shape {
	
	public float dimension;
	
	public Square(Renderer renderer, float dimension) {
		super(renderer);
		this.dimension = dimension;
	}

	@Override
	public void draw() {
		renderer.renderSquare(dimension);
	}

	@Override
	public void resize(float factor) {
		dimension *= factor;
	}
	
}

class ShapeModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Renderer.class).to(VectorRenderer.class);
	}
}

public class BridgeExample {

	public static void main(String[] args) {
		RasterRenderer rasterRenderer = new RasterRenderer();
		VectorRenderer vectorRenderer = new VectorRenderer();
		Circle circle = new Circle(vectorRenderer, 5);
		circle.draw();
		circle.resize(2);
		circle.draw();
		
		Square square = new Square(rasterRenderer, 8);
		square.draw();
		square.resize(2);
		square.draw();
		
		//Google Guice
		Injector injector = Guice.createInjector(new ShapeModule());
		Circle instance = injector.getInstance(Circle.class);
		instance.radius = 8;
		instance.resize(2);
		instance.draw();
	}

}
