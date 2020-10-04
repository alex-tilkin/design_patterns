package unit_05_singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class BasicSingleton implements Serializable {
	public static final BasicSingleton INSTANCE = new BasicSingleton();
	private int number;
	
	private BasicSingleton() {
		
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
//	/**
//	 * By implementing this method we maintain the Singleton convention
//	 * It is implemented in the ObjectInputStream class
//	 * @return
//	 */
//	protected Object readResolve() {
//		return INSTANCE;
//	}
	
}

public class BasicSingletonExample {
	
	static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
		try (	FileOutputStream fileOut = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) { 
			out.writeObject(singleton);
			}
		}
	
	static BasicSingleton readFromFile(String filename) throws Exception {
		try (	FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn) ) {
			return (BasicSingleton)in.readObject();
			}
		}
	
	public static void main(String[] args) throws Exception {
		BasicSingleton basicSingleton = BasicSingleton.INSTANCE;

		System.out.println(basicSingleton.getNumber());
		
	    String filename = "singleton.bin";
	    saveToFile(basicSingleton, filename);

	    basicSingleton.setNumber(1985);

	    BasicSingleton basicSingletonB = readFromFile(filename);
	    
	    System.out.println(basicSingleton == basicSingletonB);

	    System.out.println(basicSingleton.getNumber());
	    System.out.println(basicSingletonB.getNumber());
	    
	    // uncomment the readResolve method and run it again.
	    // Compare the outputs.
	}
}