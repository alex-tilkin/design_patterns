package unit_13_command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Well{
	private int currentVolume = 0;
	
	public void addWater(int liters) {
		currentVolume += liters;
		System.out.println("We added " + liters + "; now the the current volume in the well is " + currentVolume);
	}
	
	public boolean drainWater(int liters) {
		currentVolume -= liters;
		System.out.println("We reduced " + liters + "; now the the current volume in the well is " + currentVolume);
		
		return true;
	}
}

interface ICommand{
	void apply();
	void undo();
}

class WellComand implements ICommand{
	public enum CommandType{
		ADD,
		DRAIN
	};
	
	private CommandType commandType;
	private int liters;
	private Well well;
	private boolean succeed = false;
	
	public WellComand(Well well, CommandType commandType, int liters) {
		this.well = well;
		this.commandType = commandType;
		this.liters = liters;
	}
	
	@Override
	public void apply() {
		switch(commandType) {
			case ADD:
				succeed = true;
				well.addWater(liters);
				break;
			case DRAIN:
				succeed = well.drainWater(liters);
				break;
		}
	}

	@Override
	public void undo() {
		if(!succeed) {
			return;
		}
		
		switch(commandType) {
		case ADD:
			well.drainWater(liters);
			break;
		case DRAIN:
			well.addWater(liters);
			break;
		}
	}
}

public class CommandExample {

	public static void main(String[] args) {
		Well well = new Well();
		List<ICommand> wellCommands = new ArrayList<ICommand>(){};

		wellCommands.add(new WellComand(well, WellComand.CommandType.ADD, 10));
		wellCommands.add(new WellComand(well, WellComand.CommandType.DRAIN, 5));
		
		wellCommands.forEach(wellCommand -> wellCommand.apply());
		
		Collections.reverse(wellCommands);
		
		wellCommands.forEach(wellCommand -> wellCommand.undo());
	}
}
