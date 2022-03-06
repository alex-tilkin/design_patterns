package unit_07_bridge.solution;

abstract class ShapeEx {
	protected RendererEx renderer;
	public abstract String toString();
}

class TriangleEx extends ShapeEx {
	public TriangleEx(RendererEx renderer) {
		this.renderer = renderer;
	}
	
	public String toString() {
		return renderer.triangleRenderer();
	}
}

class SquareEx extends ShapeEx {
	public SquareEx(RendererEx renderer) {
		this.renderer = renderer;
	}
	
	public String toString() {
		return renderer.squareRenderer();
	}
}

interface RendererEx{
	String triangleRenderer();
	String squareRenderer();
}

class vectorRendererEx implements RendererEx{
	@Override
	public String squareRenderer() {
		return String.format("Drawing square as lines");
	}
	@Override
	public String triangleRenderer() {
		return String.format("Drawing triangle as lines");
	}
}

class rasterRendererEx implements RendererEx{
	@Override
	public String squareRenderer() {
		return String.format("Drawing square as pixels");
	}
	@Override
	public String triangleRenderer() {
		return String.format("Drawing triangle as pixels");
	}
}

public class BridgeExerciseSolution {
	public static void main(String[] args) {
		rasterRendererEx rr = new rasterRendererEx();
		vectorRendererEx vr = new vectorRendererEx();
		SquareEx s1 = new SquareEx(rr);
		SquareEx s2 = new SquareEx(vr);
		TriangleEx t1 = new TriangleEx(vr);
		TriangleEx t2 = new TriangleEx(rr);
		System.out.println(s1);
		System.out.println(t1);
		System.out.println(s2);
		System.out.println(t2);
	}
}