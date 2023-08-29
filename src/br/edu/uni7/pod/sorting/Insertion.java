package br.edu.uni7.pod.sorting;

import java.util.Comparator;

public class Insertion<T, C extends Comparator<T>> implements Sorter<T, C> {
	public void sort(T[] items, C comparator) {
		for (int i = 1; i < items.length; i++) {
			int j = i;

			T aux = null;
			while (j > 0 && comparator.compare(items[j], items[j - 1]) < 0) {
				aux = items[j - 1];
				items[j - 1] = items[j];
				items[j] = aux;

				j = j - 1;
			}
		}
	}
}
