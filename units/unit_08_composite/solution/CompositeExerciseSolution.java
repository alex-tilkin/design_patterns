package unit_08_composite.solution;

import java.util.*;

interface ValueContainer extends Iterable<Integer> {
}

class SingleValue implements ValueContainer {
	public int value;

	// please leave this constructor as-is
	public SingleValue(int value) {
		this.value = value;
	}

	@Override
	public Iterator<Integer> iterator() {
		ArrayList<Integer> oneElementList = new ArrayList<>();

		oneElementList.add(this.value);
		return oneElementList.iterator();
	}
}

class ManyValues extends ArrayList<Integer> implements ValueContainer {
	public ArrayList<Integer> values;

	public ManyValues() {
		this.values = new ArrayList<>();
	}
}

class MyList extends ArrayList<ValueContainer> {
	// please leave this constructor as-is
	public MyList(Collection<? extends ValueContainer> c) {
		super(c);
	}

	public int sum() {
		int sum = 0;

		for (ValueContainer con : this) {
			for (Integer i : con) {
				sum += i;
			}
		}
		return sum;
	}
}

public class CompositeExerciseSolution {

	public static void main(String[] args) {
		SingleValue sv = new SingleValue(1);
		ManyValues mv = new ManyValues();
		mv.add(2);
		mv.add(3);
		MyList ml = new MyList(new ArrayList<>());
		ml.add(mv);
		ml.add(sv);
		System.out.println(ml.sum());
	}
}