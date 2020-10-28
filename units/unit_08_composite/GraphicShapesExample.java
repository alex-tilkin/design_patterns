package unit_08_composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GraphicObject {
	protected String name = "Group";
	protected String color;
	private List<GraphicObject> graphicObjects;
	
	public GraphicObject(String name, String color) {
		this.name = name;
		this.color = color;
		graphicObjects = new ArrayList<GraphicObject>();
	}
	
	public void addChild(GraphicObject graphicObject) {
		graphicObjects.add(graphicObject);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		print(sb, 0);

		return sb.toString();
	}

	private void print(StringBuilder stringBuilder, int depth) {
		stringBuilder.append(String.join("", Collections.nCopies(depth, "*"))).append(depth > 0 ? " " : "")
				.append((color == null || color.isEmpty()) ? "" : color + " ").append(name)
				.append(System.lineSeparator());

		for (GraphicObject child : graphicObjects) {
			child.print(stringBuilder, depth + 1);
		}
	}
}

class Square extends GraphicObject {
	public Square(String color) {
		super("Square", color);
	}
}

class Circle extends GraphicObject {
	public Circle(String color) {
		super("Circle", color);
	}
}

public class GraphicShapesExample {

	public static void main(String[] args) {
		GraphicObject drawing = new GraphicObject("Shapes", "Red");
		drawing.addChild(new Square("Red"));
		drawing.addChild(new Circle("Green"));

		GraphicObject group = new GraphicObject("Blue Shapes", "Blue");
		group.addChild(new Circle("Blue"));
		group.addChild(new Square("Blue"));
		drawing.addChild(group);

		System.out.println(drawing);

	}

}
