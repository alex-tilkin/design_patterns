package unit_03_factory;

import unit_03_factory.ProcessorsFactory.FactoryType;

interface Cpu {
	void process();
}

interface Mpu {
	void process();
}

class NxpCpu implements Cpu {

	@Override
	public void process() {
		System.out.println("Processing, NXP CPU");
	}
	
}

class NxpMpu implements Mpu {

	@Override
	public void process() {
		System.out.println("Processing, NXP MPU");
	}
	
}


class TiCpu implements Cpu {

	@Override
	public void process() {
		System.out.println("Processing, TI CPU");
	}
	
}

class TiMpu implements Mpu {

	@Override
	public void process() {
		System.out.println("Processing, TI MPU");
	}
	
}

class NxpFactory extends ProcessorsFactory {

	@Override
	Cpu CreateCpu() {
		return new NxpCpu();
	}

	@Override
	Mpu CreateMpu() {
		return new NxpMpu();
	}
	
}

class TiFactory extends ProcessorsFactory {

	@Override
	Cpu CreateCpu() {
		return new TiCpu();
	}

	@Override
	Mpu CreateMpu() {
		return new TiMpu();
	}
}

abstract class ProcessorsFactory {
	private static NxpFactory NXP_FACTORY = new NxpFactory();
	private static TiFactory TI_FACTORY = new TiFactory();
	enum FactoryType {
		NXP,
		TI
	}
	
	public static ProcessorsFactory getFactory(FactoryType factoryType) {
		switch(factoryType) {
		case NXP:
			return NXP_FACTORY;
		case TI:
			return TI_FACTORY;
		}
		return null;
		
	}
	
	abstract Cpu CreateCpu();
	abstract Mpu CreateMpu();
}

public class AbstractFactoryExample {

	public static void main(String[] args) {
		Cpu nxpCpu = ProcessorsFactory.getFactory(FactoryType.NXP).CreateCpu();
		Mpu tiMpu = ProcessorsFactory.getFactory(FactoryType.TI).CreateMpu();
		
		nxpCpu.process();
		tiMpu.process();
	}
}