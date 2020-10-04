package unit_05_singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.junit.jupiter.api.Test;

interface IWsl {
	int getNumberOfHeatWins(String surfer);
}

class SingletonWsl implements IWsl {
	public static SingletonWsl instance;
	private Dictionary<String, Integer> surfers = new Hashtable<String, Integer>();
	
	static {
		try {
			instance = new SingletonWsl();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	private SingletonWsl() throws IOException {
		File file = new File(System.getProperty("user.dir") + "/units/unit_05_singleton");
		Path path = Paths.get(file.getPath(), "wsl_surfers.txt");
		List<String> lines = Files.readAllLines(path);		
		lines.stream().forEach(line -> surfers.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1])));
		System.out.println("dsdas");
	}

	@Override
	public int getNumberOfHeatWins(String surfer) {
		return surfers.get(surfer);
	}
}

class DummySingletonWsl implements IWsl {
	private Dictionary<String, Integer> surfers = new Hashtable<String, Integer>();
	
	public DummySingletonWsl() {
		surfers.put("yossi", 1);
		surfers.put("assi", 2);
		surfers.put("alon", 3);
	}
	
	@Override
	public int getNumberOfHeatWins(String surfer) {
		return surfers.get(surfer);
	}
}

class SingletonSurferHeatWinsFinder {
	private IWsl wsl;
	
	public SingletonSurferHeatWinsFinder(IWsl wsl) {
		this.wsl = wsl;
	}
	
	public int getTotalNumberOfHeatWins(List<String> names) {
		int result = 0;
		
		for (String name : names) {
			result += wsl.getNumberOfHeatWins(name);	
		}
		
		return result;
	}
}

class SingletonSurferHeatWinsFinderTests {
		
	@Test
	public void SingletonSurferHeatWinsFinder_TotalPopulationEquals6_True() {
		IWsl wsl = new DummySingletonWsl();
		SingletonSurferHeatWinsFinder singletonSurferHeatWinsFinder = new SingletonSurferHeatWinsFinder(wsl);
		ArrayList<String> data = new ArrayList<String>();
		data.add("assi");
		data.add("yossi");
		data.add("alon");
		int value = singletonSurferHeatWinsFinder.getTotalNumberOfHeatWins(data);
		
		assertEquals(6, value);
	}
}

public class UnitTestingWithSingletonExample {
	public static void main(String[] args) {
		
	}
}
