package unit_04_prototype;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

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
		
		Cup newCup = SerializationUtils.roundtrip(cup);
		
		newCup.color = "blue";
		newCup.size = "small";
		
		System.out.println(cup);
		System.out.println(newCup);
	}
}