package br.edu.uni7.pod.sorting;

import java.util.Comparator;

public class Heap<T, C extends Comparator<T>> implements Sorter<T, C> {
	@Override
	public void sort(T[] items, C comparator) {
		GenericHeap<T, Comparator<T>> heap = new GenericHeap<T, Comparator<T>>(comparator);

		heap.buildHeap(items);
		int j = 0;
		while (!heap.isEmpty()) {
			items[j] = heap.delTop();
			j++;
		}
	}
}
