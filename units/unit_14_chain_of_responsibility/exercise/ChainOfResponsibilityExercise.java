package unit_14_chain_of_responsibility.exercise;

import java.util.ArrayList;
import java.util.List;

abstract class Creature {
	public abstract int getAttack();

	public abstract int getDefense();
}

class Goblin extends Creature {
	public Goblin(Game game) {
		// todo
	}

	@Override
	public int getAttack() {
		// todo

		return -1;
	}

	@Override
	public int getDefense() {
		// todo
		return -1;
	}
}

class GoblinKing extends Goblin {
	public GoblinKing(Game game) {
		// todo
		super(game);
	}
}

enum Statistic {
	ATTACK, DEFENSE
}

class Game {
	public List<Creature> creatures = new ArrayList<>();
}

public class ChainOfResponsibilityExercise {

}
