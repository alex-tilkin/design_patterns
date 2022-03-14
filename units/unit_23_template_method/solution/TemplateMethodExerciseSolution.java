package unit_23_template_method.solution;

class Creature {
	public int attack, health, originalHealth;

	public Creature(int attack, int health) {
		this.attack = attack;
		this.health = health;
		this.originalHealth = health;
	}
}

abstract class CardGame {
	public Creature[] creatures;

	public CardGame(Creature[] creatures) {
		this.creatures = creatures;
	}

	// returns -1 if no clear winner (both alive or both dead)
	public int combat(int creature1, int creature2) {
		Creature first = creatures[creature1];
		Creature second = creatures[creature2];
		hit(first, second);
		hit(second, first);
		// todo: determine who won and return either creature1 or creature2
		if (first.health == second.health) {
			return -1;
		}
		if (first.health > second.health) {
			return creature1;
		}
		return creature2;
	}

	// attacker hits other creature
	protected abstract void hit(Creature attacker, Creature other);
}

class TemporaryCardDamageGame extends CardGame {

	public TemporaryCardDamageGame(Creature[] creatures) {
		super(creatures);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void hit(Creature attacker, Creature other) {
		initHealth(attacker);
		initHealth(other);
		other.health -= attacker.attack;
		if (other.health < 0) {
			other.health = 0;
		}

	}

	private void initHealth(Creature c) {
		if (c.health <= 0)
			return;
		c.health = c.originalHealth;
	}

}

class PermanentCardDamageGame extends CardGame {

	public PermanentCardDamageGame(Creature[] creatures) {
		super(creatures);

	}

	@Override
	protected void hit(Creature attacker, Creature other) {
		other.health -= attacker.attack;
		if (other.health < 0) {
			other.health = 0;
		}
	}

}

public class TemplateMethodExerciseSolution {

	public static void main(String[] args) {

		Creature zeus = new Creature(1, 2);
		Creature voldemort = new Creature(3, 4);
		Creature creatures[] = { zeus, voldemort };

		TemporaryCardDamageGame game1 = new TemporaryCardDamageGame(creatures);
		PermanentCardDamageGame game2 = new PermanentCardDamageGame(creatures);

		game1.combat(0, 1);

		System.out.println(voldemort.health);
		System.out.println(zeus.health);

	}

}
