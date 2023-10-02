package br.edu.uni7.pod.sorting;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericHeap<T, C extends Comparator<T>> {
	private Integer currentSize;
	private List<T> heapList;
	private final T NONE = null;
	private C comp;
	private static final int TOP = 1;

	public GenericHeap(C comp) {
		this.currentSize = 0;
		init();
		this.comp = comp;
	}

	public T findTop() {
		return heapList.get(TOP);
	}

	public boolean isEmpty() {
		return heapList.size() == 1;
	}

	public void insert(T k) {
		heapList.add(k);
		currentSize++;

		percUp(currentSize);
	}

	public T delTop() {
		T result = heapList.get(TOP);
		heapList.set(1, heapList.get(currentSize));
		currentSize--;
		heapList.remove(currentSize + 1);
		percDown(1);

		return result;
	}

	private void percDown(int i) {
		while (i * 2 <= currentSize) {
			int mc = minChild(i);

			if (comp.compare(heapList.get(i), heapList.get(mc)) > 0) {
				T tmp = heapList.get(i);
				heapList.set(i, heapList.get(mc));
				heapList.set(mc, tmp);
			}

			i = mc;
		}
	}

	private int minChild(int i) {
		if (i * 2 + 1 > currentSize) {
			return i * 2;
		} else if (comp.compare(heapList.get(i * 2), heapList.get(i * 2 + 1)) < 0) {
			return i * 2;
		} else {
			return i * 2 + 1;
		}
	}

	private void percUp(Integer i) {
		while (i / 2 > 0) {
			if (comp.compare(heapList.get(i), heapList.get(i / 2)) < 0) {
				T tmp = heapList.get(i / 2);
				heapList.set(i / 2, heapList.get(i));
				heapList.set(i, tmp);
			}

			i = i / 2;
		}
	}

	public void buildHeap(T[] items) {
		int i = items.length / 2;
		currentSize = items.length;

		init();

		for (T item : items) {
			heapList.add(item);
		}

		while (i > 0) {
			percDown(i);
			i--;
		}
	}

	private void init() {
		this.heapList = new ArrayList<>();
		this.heapList.add(NONE);
	}

	@Override
	public String toString() {
		return heapList.toString();
	}

	public static void main(String[] args) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};

		GenericHeap<Integer, Comparator<Integer>> heap = new GenericHeap<Integer, Comparator<Integer>>(comparator);

		List<Integer> red = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			red.add(200 + i);
		}

		List<Integer> yellow = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			yellow.add(300 + i);
		}

		List<Integer> green = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			green.add(400 + i);
		}

		List<Integer> blue = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			blue.add(500 + i);
		}

		System.out.println(red);
		System.out.println(yellow);
		System.out.println(green);
		System.out.println(blue);

		int ticket = -1;
		for (int i = 0; i < 10; i++) {
			int n = (int) (Math.random() * 4);

			switch (n) {
			case 0:
				if (!red.isEmpty()) {
					ticket = red.remove(0);
					heap.insert(ticket);
				}
				break;
			case 1:
				if (!yellow.isEmpty()) {
					ticket = yellow.remove(0);
					heap.insert(ticket);
				}
				break;
			case 2:
				if (!green.isEmpty()) {
					ticket = green.remove(0);
					heap.insert(ticket);
				}
				break;
			case 3:
				if (!blue.isEmpty()) {
					ticket = blue.remove(0);
					heap.insert(ticket);
				}
				break;
			}

			System.out.println(heap);
		}

		for (int i = 0; i < 10; i++) {
			Integer top = heap.delTop();

			System.out.println("Chamando " + top);
		}
	}
}
