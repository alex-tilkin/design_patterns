package unit_05_singleton;


class StaticBlockSingleton {
	public static StaticBlockSingleton instance;
	
	// This is a Static Block; it is executed when the class is loaded to the memory; meaning only once
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			System.out.println("Failed creating " + StaticBlockSingleton.class.getSimpleName() + "; " + e);
		}
	}
	
	private StaticBlockSingleton() {
		System.out.println(1/0);
	}
}

public class StaticBlockSingletonExample {
	
	public static void main(String[] args) {
		StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.instance;
	}
}