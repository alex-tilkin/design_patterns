package unit_08_composite;

class TreeObject{
	int value;
	
	@Override
	public String toString() {
		return "" + value + "\n";
	}
}

class Node extends TreeObject {
	TreeObject left = new TreeObject();
	TreeObject right = new TreeObject();
	
	@Override
	public String toString() {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(value + "\n");
		if(left != null) {
			stringbuilder.append(left.toString());
		}
		
		if(right != null) {
			stringbuilder.append(right.toString());
		}
		
		return stringbuilder.toString();
	}
}

class Leaf extends TreeObject {
	
}

public class CompositeTreeExample {

	public static void main(String[] args) {
		Node root = new Node();
		Leaf left = new Leaf();
		left.value = 7;
		Leaf right = new Leaf();
		right.value = 3;
		
		Node leftNode = new Node();
		leftNode.value = 7;
		leftNode.left = left;
		leftNode.right = right;
		
		Node rightNode = new Node();
		rightNode.value = 8;
		left = new Leaf();
		left.value = 1;
		rightNode.left = left;
		rightNode.right = null;
		
		root.left = leftNode;
		root.right = rightNode;
		
		System.out.println(root);
	}

}
