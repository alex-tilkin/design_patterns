package unit_05_singleton;

class LazySingletone {
	private static LazySingletone instance;
	
	private LazySingletone() {
		
	}
	
	public static LazySingletone getInstance() {
		if(instance == null) {
			return instance = new LazySingletone();
		}
		
		return instance;
	}
}

class TreadSafeLazySingletone {
	private static TreadSafeLazySingletone instance;
	
	private TreadSafeLazySingletone() {
		
	}
	
	public static synchronized TreadSafeLazySingletone getInstance() {
		if(instance == null) {
			return instance = new TreadSafeLazySingletone();
		}
		
		return instance;
	}
}

class DoubleCheckedTreadSafeLazySingletone {
	private static DoubleCheckedTreadSafeLazySingletone instance;
	
	private DoubleCheckedTreadSafeLazySingletone() {
		
	}
	
	public static DoubleCheckedTreadSafeLazySingletone getInstance() {
		if(instance == null) {
			synchronized(DoubleCheckedTreadSafeLazySingletone.class){
				if(instance == null) {
					return instance = new DoubleCheckedTreadSafeLazySingletone();
				}
			}
		}
		
		return instance;
	}
}

public class ThreadSafeLazySingletonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
