package unit_16_iterator.solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NodeEx<T> {
	public T value;
	public NodeEx<T> left, right, parent;
	public int childNumber = 0;
	public int numberOfChildren = 2;

	public NodeEx(T value) {
		this.value = value;
	}

	public NodeEx(T value, NodeEx<T> left, NodeEx<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;

		left.parent = right.parent = this;
	}

	public Iterator<NodeEx<T>> preOrder() {
		preOrderIterator<T> poi = new preOrderIterator<>(this);

		System.out.println(this.value);
		while (this.childNumber < 2) {
			if (poi.hasNext())
				poi.next().preOrder();
		}
		return null;
	}
}

class preOrderIterator<T> implements Iterator<NodeEx<T>> {
	private NodeEx<T> n;

	public preOrderIterator(NodeEx<T> node) {
		this.n = node;
	}

	@Override
	public boolean hasNext() {
		if (n.left == null && n.right == null) {
			n.childNumber = 2;
			return false;
		} else if (n.childNumber == 1 && n.right == null) {
			n.childNumber = 2;
			return false;
		} else
			return true;
	}

	public NodeEx<T> next() {
		if (n.left != null && n.childNumber == 0) {
			n.childNumber = 1;
			return n.left;
		}
		n.childNumber = 1;
		if (n.right != null) {
			n.childNumber = 2;
			return n.right;
		}
		n.childNumber = 2;
		return null;
	}
}

public class IteratorCodingExerciseSolution {
	public static void main(String[] args) {
		NodeEx<Integer> n1 = new NodeEx<>(1);
		NodeEx<Integer> n2 = new NodeEx<>(2);
		NodeEx<Integer> n3 = new NodeEx<>(3);
		NodeEx<Integer> n4 = new NodeEx<>(4);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n1.preOrder();
	}
}