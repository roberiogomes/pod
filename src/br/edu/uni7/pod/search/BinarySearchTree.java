package br.edu.uni7.pod.search;

public class BinarySearchTree<T extends Comparable<T>> {
	private T key;
	private BinarySearchTree<T> leftChild;
	private BinarySearchTree<T> rightChild;

	public BinarySearchTree(T key) {
		this(key, null, null);
	}

	public BinarySearchTree(T key, BinarySearchTree<T> leftChild, BinarySearchTree<T> rightChild) {
		this.key = key;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public BinarySearchTree<T> getLeftChild() {
		return leftChild;
	}

	public BinarySearchTree<T> getRightChild() {
		return rightChild;
	}

	public T getKey() {
		return key;
	}

	public void add(T aKey) {
		add(new BinarySearchTree<T>(aKey));
	}

	public void add(BinarySearchTree<T> aNode) {
		if (aNode.getKey().compareTo(key) < 0) {
			if (this.leftChild == null) {
				this.leftChild = aNode;
			} else {
				this.leftChild.add(aNode);
			}
		} else {
			if (this.rightChild == null) {
				this.rightChild = aNode;
			} else {
				this.rightChild.add(aNode);
			}
		}
	}

	public BinarySearchTree<T> get(T aKey) {
		BinarySearchTree<T> result = null;

		if (this.getKey().compareTo(aKey) > 0) {
			if (this.leftChild != null) {
				result = leftChild.get(aKey);
			}
		} else if (this.getKey().compareTo(aKey) < 0) {
			if (this.rightChild != null) {
				result = rightChild.get(aKey);
			}
		} else {
			result = this;
		}

		return result;
	}

	@Override
	public String toString() {
		return "{ 'key' : " + key + ", 'leftChild' : " + leftChild + ", 'rightChild' : " + rightChild + "}";
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> root = new BinarySearchTree<Integer>(8);

		Integer[] items = { 3, 10, 1, 6, 14, 4, 7, 5 };
		for (Integer n : items) {
			root.add(n);
		}

		System.out.println(root);
		
		BinarySearchTree<Integer> node = root.get(10);
		System.out.println(node);
		
		node = root.get(20);
		System.out.println(node);

	}
}
