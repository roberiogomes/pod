package br.edu.uni7.pod.search;

public class BinaryTree<T> {
	public interface Command<T>{
		public void execute(T element);
	}
	
	private T key;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	public BinaryTree(T rootObj) {
		this(rootObj, null, null);
	}

	public BinaryTree(T key, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
		this.key = key;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public void insertLeft(T newNode) {
		if (this.leftChild == null) {
			this.leftChild = new BinaryTree<T>(newNode);
		} else {
			BinaryTree<T> t = new BinaryTree<T>(newNode);
			t.leftChild = this.leftChild;
			this.leftChild = t;
		}
	}

	public void insertRight(T newNode) {
		if (this.rightChild == null) {
			this.rightChild = new BinaryTree<T>(newNode);
		} else {
			BinaryTree<T> t = new BinaryTree<T>(newNode);
			t.rightChild = this.rightChild;
			this.rightChild = t;
		}
	}

	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	public BinaryTree<T> getRightChild() {
		return rightChild;
	}

	@Override
	public String toString() {
		return "{ 'key' : " + key + ", 'leftChild' : " + leftChild + ", 'rightChild' : " + rightChild + "}";
	}

	public void setRootValue(T newValue) {
		this.key = newValue;
	}

	public T getRootValue() {
		return key;
	}
	
	public void preOrder(Command<T> command) {
		if (command != null) {
			command.execute(key);
			
			if (leftChild != null) {
				leftChild.preOrder(command);	
			}
			if (rightChild != null) {
				rightChild.preOrder(command);	
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree<String> r = new BinaryTree<String>("a");

		r.insertLeft("b");
		r.insertRight("c");

		BinaryTree<String> w = r.getLeftChild();
		w.setRootValue("ABCD");

		r.insertLeft("x");

		BinaryTree<String> m = r.getLeftChild();
		m.insertLeft("k");

		BinaryTree<String> n = r.getRightChild();
		n.setRootValue("Andreia");

		System.out.println(r);

		r.preOrder(new Command<String>() {
			@Override
			public void execute(String element) {
				System.out.println(element);
			}
		});
	}
}
