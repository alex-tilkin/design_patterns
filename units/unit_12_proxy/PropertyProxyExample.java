package unit_12_proxy;

class Property<T> {
	private T t;
	
	public Property(T t) {
		set(t);
	}
	
	public T get() {
		return t;
	}
	
	public void set(T t) {
		System.out.println(String.format("Replacing value from %s to %s", this.t, t));
		
		this.t = t;
	}
}

class Entity{
	public Property<Integer> value;
	
	public Entity(Integer value) {
		this.value = new Property<Integer>(value);
	}
	
	public int getValue(){
		return value.get();
	}
	
	public void setValue(Integer value){
		this.value.set(value);
	}
}

public class PropertyProxyExample {

	public static void main(String[] args) {
		(new Entity(10)).setValue(20);
	}
}