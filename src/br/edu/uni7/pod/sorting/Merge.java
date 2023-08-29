package br.edu.uni7.pod.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Merge<T, C extends Comparator<T>> implements Sorter<T, Comparator<T>> {
	@Override
	public void sort(T[] items, Comparator<T> comparator) {
		if (items.length > 1) {
			
			int mid = items.length / 2;
			
			T[] left = Arrays.copyOfRange(items, 0, mid);
			T[] right = Arrays.copyOfRange(items, mid, items.length);
			
			sort(left, comparator);
			sort(right, comparator);
			
			int i = 0;
			int j = 0;
			int k = 0;
			
			while (i < left.length && j < right.length) {
				// left[i] <= right[j]
				if (comparator.compare(left[i], right[j]) <= 0) {
					items[k] = left[i];
					i = i + 1;
				} else {
					items[k] = right[j];
					j = j + 1;
				}
				k++;
			}
			
			while (i < left.length) {
				items[k] = left[i];
				i = i + 1;
				k = k + 1;
			}
			
			while (j < right.length) {
				items[k] = right[j];
				j = j + 1;
				k = k + 1;
			}
		}
	}
}
