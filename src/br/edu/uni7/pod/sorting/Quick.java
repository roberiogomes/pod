package br.edu.uni7.pod.sorting;

import java.util.Comparator;

public class Quick<T, C extends Comparator<T>> implements Sorter<T, C> {
	public void sort(T[] items, C comparator) {
		helper(items, comparator, 0, items.length - 1);
	}

	private void helper(T[] items, C comparator, int fisrt, int last) {
		if (fisrt < last) {
			int splitPoint = partition(items, comparator, fisrt, last);

			helper(items, comparator, fisrt, splitPoint - 1);
			helper(items, comparator, splitPoint + 1, last);
		}
	}

	private int partition(T[] items, C comparator, int first, int last) {
		T pivot = items[first];

		int leftMark = first + 1;
		int rightMark = last;

		boolean done = false;
		while (!done) {
			// items[leftMark] <= pivot
			while (leftMark <= rightMark && 
					comparator.compare(items[leftMark], pivot) <= 0) {
				leftMark = leftMark + 1;
			}
			while (comparator.compare(pivot, items[rightMark]) <= 0 && 
					(rightMark >= leftMark)) {
				rightMark = rightMark - 1;
			}
			if (rightMark < leftMark) {
				done = true;
			} else {
				T temp = items[leftMark];
				items[leftMark] = items[rightMark];
				items[rightMark] = temp;
			}
		}
		
		T aux = items[first];
		items[first] = items[rightMark];
		items[rightMark] = aux;

		return rightMark;
	}
}
