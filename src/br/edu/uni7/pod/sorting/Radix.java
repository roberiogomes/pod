package br.edu.uni7.pod.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.uni7.pod.sorting.util.DataGen;

public class Radix {
	public static final Integer DEFAULT_BASE = 10;

	public Integer[] sort(Integer[] items) {
		Integer[] values = items;

		final List<Integer>[] buckets = createBuckets(DEFAULT_BASE);

		final int numberOfOrders = getNumberOfOrders(items[0]);
		for (int j = 0; j < numberOfOrders; j++) {
			for (Integer number : values) {
				int tmp = (int) (number / Math.pow(DEFAULT_BASE, j));
				int digit = tmp % DEFAULT_BASE;
				buckets[digit].add(number);
			}

			values = new Integer[items.length];

			int i = 0;
			for (List<Integer> bucket : buckets) {
				for (Integer n : bucket) {
					values[i++] = n;
				}
			}

			clearBuckets(buckets);
		}

		return values;
	}

	public List<Integer> sort(List<Integer> items) {
		List<Integer> values = items;

		final List<Integer>[] buckets = createBuckets(DEFAULT_BASE);

		final int numberOfOrders = getNumberOfOrders(items.get(0));
		for (int j = 0; j < numberOfOrders; j++) {
			for (Integer number : values) {
				int tmp = (int) (number / Math.pow(DEFAULT_BASE, j));
				int digit = tmp % DEFAULT_BASE;

				buckets[digit].add(number);
			}

			values = new ArrayList<>();

			for (List<Integer> bucket : buckets) {
				values.addAll(bucket);
			}

			clearBuckets(buckets);
		}

		return values;
	}

	private int getNumberOfOrders(Integer item) {
		return (int) (Math.log10(item)) + 1;
	}

	private void clearBuckets(List<Integer>[] buckets) {
		for (List<Integer> bucket : buckets) {
			bucket.clear();
		}
	}

	private List<Integer>[] createBuckets(int base) {
		final List<Integer>[] result = new ArrayList[base];

		for (int i = 0; i < result.length; i++) {
			result[i] = new ArrayList<>();
		}
		return result;
	}

	public static void main(String[] args) {
		Radix radix = new Radix();
		Integer[] items = { 512, 123, 144, 214, 432, 128 };
		System.out.println(Arrays.toString(items));
		System.out.println(Arrays.toString(radix.sort(items)));

		List<Integer> values = new ArrayList<>(Arrays.asList(items));
		System.out.println(values);
		System.out.println(radix.sort(values));
		
		DataGen data = new DataGen();
		items = data.getRadixData(50000);
//		System.out.println(Arrays.toString(items));
		System.out.println(Arrays.toString(radix.sort(items)));
	}
}
