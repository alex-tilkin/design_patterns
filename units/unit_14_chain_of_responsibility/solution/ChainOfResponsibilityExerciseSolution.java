package unit_14_chain_of_responsibility.solution;

import java.util.ArrayList;
import java.util.List;

abstract class Creature {

	public abstract int getAttack();

	public abstract int getDefense();
}

class GoblinModifier {
	protected Goblin goblin;
	protected GoblinModifier next;

	public GoblinModifier(Goblin goblin) {
		this.goblin = goblin;
	}

	public void add(GoblinModifier goblinModifier) {
		if (next != null) {
			next.add(goblinModifier);
		} else {
			next = goblinModifier;
		}
	}

	public void handle() {
		if (next != null) {
			next.handle();
		}
	}
}

class GoblinAttackIncreaser extends GoblinModifier {

	public GoblinAttackIncreaser(Goblin goblin) {
		super(goblin);
	}

	@Override
	public void handle() {

		goblin.attack++;

		super.handle();
	}
}

class DefenseIncreaser extends GoblinModifier {

	public DefenseIncreaser(Goblin goblin) {
		super(goblin);
	}

	@Override
	public void handle() {

		goblin.Defense++;

		super.handle();
	}
}

class Goblin extends Creature {
	int attack = 1, Defense = 1;

	public Goblin(Game game) {

	}

	@Override
	public int getAttack() {

		return attack;
	}

	@Override
	public int getDefense() {

		return Defense;
	}
}

class GoblinKing extends Goblin {

	public GoblinKing(Game game) {
		// todo
		super(game);
	}

	@Override
	public int getAttack() {
		return 3;
	}

	public int kingGetDefense() {
		return super.getDefense() + 2;
	}

}

enum Statistic {
	ATTACK, DEFENSE
}

class Game {
	public List<Creature> creatures = new ArrayList<>();
}

public class ChainOfResponsibilityExerciseSolution {
	Game game = new Game();
	Goblin goblin = new Goblin(game);

}