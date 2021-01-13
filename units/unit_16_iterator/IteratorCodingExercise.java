package unit_16_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NodeEx<T> {
	public T value;
	public NodeEx<T> left, right, parent;

	public NodeEx(T value) {
		this.value = value;
	}

	public NodeEx(T value, NodeEx<T> left, NodeEx<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;

		left.parent = right.parent = this;
	}

	public Iterator<Node<T>> preOrder() {
		// todo
		return null;
	}
}

public class IteratorCodingExercise {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}