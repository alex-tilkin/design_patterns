package unit_03_factory;

enum CoordinateSystem {
	CARTESIAN,
	POLAR
}

class Point {
	private double x;
	private double y;
	
	private Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// If we want to support both cartesian and polar systems :(
	// we can't create two constructors with the same signature in Java
	/*public Point(double rho, double theta) {
		x = rho * Math.cos(theta);
		x = rho * Math.sin(theta);
	}*/
	
	// This is a bad practice because it cumbersome for the user :(
	/**
	 * 
	 * @param a is x if we use cartesian system and rho if we use polar system
	 * @param b
	 * @param cs
	 */
	public Point(double a, double b, CoordinateSystem cs) {
		switch(cs) {
		case CARTESIAN:
			y = b;
			x = a;
			break;
		case POLAR:
			x = a * Math.cos(b);
			x = a * Math.sin(b);
			break;
		}
	}
	
	public static Point MakeCartesianPoint(double x, double y) {
		return new Point(x, y);
	}
	
	public static Point MakePolarPoint(double rho, double theta) {
		return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
	}
}

public class FactoryMethodExample {

	public static void main(String[] args) {
		Point polarPoint = Point.MakeCartesianPoint(5, 2);
	}
}
