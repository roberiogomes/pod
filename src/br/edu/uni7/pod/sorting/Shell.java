package br.edu.uni7.pod.sorting;
import java.util.Arrays;
import java.util.Comparator;

public class Shell<T, C extends Comparator<T>> implements Sorter<T, C> {
	public void sort(T[] items, C comparator) {
		int h = items.length / 2;

		while (h > 0) {
			for (int startposition = 0; startposition < h; startposition++) {
				sort(items, comparator, startposition, h);
			}
			
//			System.out.println("Using h equals to " + h + " we have :" + Arrays.toString(items));

			h = h / 2;
		}
	}

	private void sort(T[] items, C comparator, int start, int gap) {
		for (int i = start + gap; i < items.length; i += gap) {
			T currentvalue = items[i];
			int position = i;

			while (position >= gap && comparator.compare(items[position - gap], currentvalue) > 0) {
				items[position] = items[position - gap];
				position = position - gap;
			}

			items[position] = currentvalue;
		}
	}

	public static void main(String[] args) {
		Comparator<Integer> integerComp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		
		Shell<Integer, Comparator<Integer>> shell = new Shell<Integer, Comparator<Integer>>();
		
		Integer[] items = { 54, 26, 93, 17, 77, 31, 44, 55, 20 };
		System.out.println(Arrays.toString(items));
		
		shell.sort(items, integerComp);
		
		System.out.println(Arrays.toString(items));
		
	}
}
