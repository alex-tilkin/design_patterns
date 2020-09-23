package unit_04_prototype;

import java.io.Serializable;

class Cup implements Serializable{
	String size;
	String color;
	
	public Cup(String size, String color) {
		this.size = size;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cup [size=" + size + ", color=" + color + "]";
	}
}

public class SerializationExample {
	
	public static void main(String[] args) {
		Cup cup = new Cup("white", "large");
	}
}