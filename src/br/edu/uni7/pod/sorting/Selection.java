package br.edu.uni7.pod.sorting;

import java.util.Comparator;

public class Selection<T, C extends Comparator<T>> implements Sorter<T, C> {
	public void sort(T[] items, C comparator) {
		for (int i = items.length - 1; i >= 0; i--) {
			int index = selectMax(items, i + 1, comparator);
			
			if (comparator.compare(items[i], items[index]) < 0) {
				T aux = items[index];
				items[index] = items[i];
				items[i] = aux;				
			}			
		}
	}

	private int selectMax(T[] items, int size, C comparator) {
		int index = 0;
		T max = items[0];
		
		for (int i = 0; i < size; i++) {
			if (comparator.compare(items[i], max) > 0) {
				max = items[i];
				index = i;
			}
		}
		
		return index;
	}
}
