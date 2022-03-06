package unit_08_composite.exercise;

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
		// TODO Auto-generated method stub
		return null;
	}
}

class ManyValues extends ArrayList<Integer> implements ValueContainer {
}

class MyList extends ArrayList<ValueContainer> {
	// please leave this constructor as-is
	public MyList(Collection<? extends ValueContainer> c) {
		super(c);
	}

	public int sum() {
		return 0;
	}
}

public class CompositeExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
