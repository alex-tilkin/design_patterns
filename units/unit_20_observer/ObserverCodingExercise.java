package unit_20_observer;

import java.io.Closeable;
import java.io.IOException;

class Game {
	// todo
}

class Rat implements Closeable {
	private Game game;
	public int attack = 1;

	public Rat(Game game) {
		// todo: rat enters game here
	}

	@Override
	public void close() throws IOException {
		// todo: rat dies ;(
	}
}

public class ObserverCodingExercise {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}