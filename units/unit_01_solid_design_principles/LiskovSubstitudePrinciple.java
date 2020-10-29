package unit_01_solid_design_principles;


class Rectangle{
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getArea() {
		return width * height;
	}
	
	@Override
	public String toString() {
		return "Width: " + width + "; height " + height;
	}
}

class Square extends Rectangle{
	public Square() {
	}
	
	public Square(int side) {
		super(side, side);
	}
	
	public void setWidth(int width) {
		super.setHeight(width);
		super.setWidth(width);
	}
	
	public void setHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
	}
}

/*interface Quad {
	
}

abstract class PropotionalQuad implements Quad {
	
}

abstract class NonpropotionalQuad implements Quad {
	
}

class Rectangle extends NonpropotionalQuad {
	
}

class Square extends PropotionalQuad {
	
}*/

public class LiskovSubstitudePrinciple {
	  static void test(Rectangle rectangle)
	  {
	    int width = rectangle.getWidth();
	    rectangle.setHeight(10);
	    System.out.println("The Expected area size is " + (width * 10) + ", actual are size is " + rectangle.getArea());
	  }

	  public static void main(String[] args) {
	    Rectangle rectangle = new Rectangle(2, 3);
	    test(rectangle);

	    Rectangle square = new Square();
	    square.setHeight(5);
	    //square.setWidth(10);
	    test(square);
	  }
}