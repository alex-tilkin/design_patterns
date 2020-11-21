package unit_12_proxy;

interface IDrivable{
	void drive();
}

class Car implements IDrivable{
	protected Driver driver;
	
	public Car(Driver driver) {
		this.driver = driver;
	}
	
	@Override
	public void drive() {
		System.out.println("The car is driving");
	}
}

class Driver{
	int age;
	
	public Driver(int age) {
		this.age = age;
	}
}

class CarProxy extends Car{
	public CarProxy(Driver driver) {
		super(driver);
	}
	
	@Override
	public void drive() {
		if(driver.age >= 18) {
			super.drive();	
		} else {
			System.out.println("The driver is not eligable for driving");
		}
	}
}

public class ProtectionProxyExample {

	public static void main(String[] args) {
		(new CarProxy(new Driver(16))).drive();
		(new CarProxy(new Driver(18))).drive();
	}

}