package br.edu.uni7.pod.sorting;

import java.util.Comparator;

public interface Sorter<T, C extends Comparator<T>> {
	public void sort(T[] items, C comparator); 
}
