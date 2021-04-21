package unit_14_chain_of_responsibility;

class Samurai {
	String name;
	int speed;
	int power;
	
	public Samurai(String name, int speed, int power) {
		this.name = name;
		this.speed = speed;
		this.power = power;
	}
}

class SamuraiModifier {
	protected Samurai samurai;
	protected SamuraiModifier next;
	
	public SamuraiModifier(Samurai samurai) {
		this.samurai = samurai;
	}
		
	public void add(SamuraiModifier samuraiModifier) {
		if(next != null) {
			next.add(samuraiModifier);
		} else {
			next = samuraiModifier;
		}
	}
	
	public void handle() {
		if(next != null) {
			next.handle();
		}
	}
}

class SamuraiSpeedIncreaser extends SamuraiModifier {

	public SamuraiSpeedIncreaser(Samurai samurai) {
		super(samurai);
	}
	
	@Override
	public void handle() {
		System.out.println("Increasing the speed of " + samurai.name);
		samurai.speed++;
		
		super.handle();
	}
}

class SamuraiPowerIncreaser extends SamuraiModifier {

	public SamuraiPowerIncreaser(Samurai samurai) {
		super(samurai);
	}
	
	@Override
	public void handle() {
		System.out.println("Increasing the power of " + samurai.name);
		samurai.power++;
		
		super.handle();
	}
}

public class ChainOfResponsibilityExample {
	
	public static void main(String[] args) {
		Samurai samurai = new Samurai("Jin", 1, 2);
		
		SamuraiModifier samuraiModifier = new SamuraiSpeedIncreaser(samurai);
		samuraiModifier.add(new SamuraiPowerIncreaser(samurai));
		
		samuraiModifier.handle();
	}
}