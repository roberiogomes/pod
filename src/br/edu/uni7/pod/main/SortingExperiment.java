package br.edu.uni7.pod.main;

import java.util.Comparator;

import br.edu.uni7.pod.sorting.Insertion;
import br.edu.uni7.pod.sorting.Merge;
import br.edu.uni7.pod.sorting.Selection;
import br.edu.uni7.pod.sorting.Sorter;
import br.edu.uni7.pod.sorting.util.DataGen;

public class SortingExperiment {
	public static void main(String[] args) {
		final DataGen gen = new DataGen();

		final Comparator<Integer> intComparator = getIntComparator();

		final Sorter<Integer, Comparator<Integer>> selection = new Selection<Integer, Comparator<Integer>>();
		final Sorter<Integer, Comparator<Integer>> insertion = new Insertion<Integer, Comparator<Integer>>();
		final Sorter<Integer, Comparator<Integer>> merge = new Merge<Integer, Comparator<Integer>>();

		System.out.println("N,Selection,Insertion,Merge");

		int iterations = 50;
		for (int i = 0; i < iterations; i++) {
			final int n = (int) Math.pow(2, i);

			final Integer[] data = gen.getWorstData(n);

			long deltaSelection = runAndCollectTime(intComparator, selection, data);
			long deltaInsertion = runAndCollectTime(intComparator, insertion, data);
			long deltaMerge = runAndCollectTime(intComparator, merge, data);

			System.out.println(n + "," + deltaSelection + "," + deltaInsertion + "," + deltaMerge);
		}

	}

	private static long runAndCollectTime(final Comparator<Integer> comparator,
			final Sorter<Integer, Comparator<Integer>> sorter, final Integer[] data) {
		long begin = System.nanoTime();
		sorter.sort(data, comparator);
		long end = System.nanoTime();

		return end - begin;
	}

	private static Comparator<Integer> getIntComparator() {
		Comparator<Integer> intComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		return intComparator;
	}
}
