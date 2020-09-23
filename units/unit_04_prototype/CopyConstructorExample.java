package unit_04_prototype;

import java.util.Arrays;

class FootballPlayer {
	String name;
	int number;
	
	public FootballPlayer(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	public FootballPlayer(FootballPlayer other) {
		name = other.name;
		number = other.number;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + "]";
	}
}

class FootballTeam {
	String name;
	FootballPlayer[] footballPlayers;
	
	public FootballTeam(String name, FootballPlayer[] footballPlayers) {
		this.name = name;
		this.footballPlayers = new FootballPlayer[footballPlayers.length];
		for (int index = 0; index < footballPlayers.length; index++) {
			this.footballPlayers[index] = new FootballPlayer(footballPlayers[index]);
		}
	}
	
	public FootballTeam(FootballTeam other) {
		name = other.name;
		footballPlayers = new FootballPlayer[other.footballPlayers.length];
		for (int index = 0; index < footballPlayers.length; index++) {
			footballPlayers[index] = new FootballPlayer(other.footballPlayers[index]);
		}
	}

	@Override
	public String toString() {
		return "FootballTeam [name=" + name + ", footballPlayers=" + Arrays.toString(footballPlayers) + "]";
	}
}

public class CopyConstructorExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		FootballPlayer[] footballPlayers = new FootballPlayer[2];
		footballPlayers[0] = new FootballPlayer("Russel Wilson", 3);
		footballPlayers[1] = new FootballPlayer("DK Metcalf", 14);
		
		FootballTeam seahawks = new FootballTeam("Seattle Seahawks", footballPlayers);
		FootballTeam cardinals = new FootballTeam(seahawks);
		
		cardinals.name = "Arizona Cardinals";
		cardinals.footballPlayers[0].number = 62;
		cardinals.footballPlayers[1].number = 99;
		
		System.out.println(seahawks);
		System.out.println(cardinals);
	}
}