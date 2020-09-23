package unit_04_prototype;

class Surfboard implements Cloneable {
	String brand;
	int size;
	
	public Surfboard(String brand, int size) {
		this.brand = brand;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Surfboard [brand=" + brand + ", size=" + size + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Surfboard(brand, size);
	}
}

class Surfer implements Cloneable {
	String name;
	Surfboard surfboard;
	
	public Surfer(String name, Surfboard surfboard) {
		this.name = name;
		this.surfboard = surfboard;
	}

	@Override
	public String toString() {
		return "Surfer [name=" + name + ", surfboard=" + surfboard + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Surfer(name, (Surfboard)surfboard.clone());
	}
}

public class ClonableExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		Surfer andino = new Surfer("Kolohe Andino", new Surfboard("Hurley", 5));
		
		Surfer kelly = (Surfer)andino.clone();
		
		kelly.name = "Kelly Slater";
		kelly.surfboard.size = 6;
		
		System.out.println(andino);
		System.out.println(kelly);
	}

}
