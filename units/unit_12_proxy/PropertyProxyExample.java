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

class MyInteger{
	public Property<Integer> value;
	
	public MyInteger(Integer value) {
		this.value = new Property<Integer>(value);
	}
	
	public int getValue(){
		return value.get();
	}
	
	public void setValue(Integer value){
		this.value.set(value);
	}
}

class MyFloat{
	public Property<Float> value;
	
	public MyFloat(Float value) {
		this.value = new Property<Float>(value);
	}
	
	public Float getValue(){
		return value.get();
	}
	
	public void setValue(Float value){
		this.value.set(value);
	}
}

public class PropertyProxyExample {

	public static void main(String[] args) {
		new Property<Integer>(10);
		new MyInteger(10);
		new MyFloat(10f);
		
		(new MyInteger(10)).setValue(20);
	}
}