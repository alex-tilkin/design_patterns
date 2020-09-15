package unit_03_factory;

class PointExample2 {
	private double x;
	private double y;
	
	private PointExample2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	static class Factory {
		public static PointExample2 MakeCartesianPoint(double x, double y) {
			return new PointExample2(x, y);
		}
		
		public static PointExample2 MakePolarPoint(double rho, double theta) {
			return new PointExample2(rho * Math.cos(theta), rho * Math.sin(theta));
		}	
	}
}

public class FactoryExample {

	public static void main(String[] args) {
		PointExample2 point = PointExample2.Factory.MakeCartesianPoint(2, 3);
	}
}
