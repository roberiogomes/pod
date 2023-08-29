package br.edu.uni7.pod.main;

import java.util.Arrays;
import java.util.Comparator;

import br.edu.uni7.pod.misc.Product;
import br.edu.uni7.pod.sorting.Insertion;
import br.edu.uni7.pod.sorting.Merge;
import br.edu.uni7.pod.sorting.Selection;
import br.edu.uni7.pod.sorting.Sorter;

public class SortingMain {
	public static void main(String[] args) {
		final Integer[] numbers = getNumbers();
		final Comparator<Integer> intComparator = getIntComparator();
		final Sorter<Integer, Comparator<Integer>> merge = new Merge<Integer, Comparator<Integer>>();

		System.out.println(Arrays.toString(numbers));
		merge.sort(numbers, intComparator);
		System.out.println(Arrays.toString(numbers));

		final String[] names = getNames();
		final Comparator<String> stringComparator = getStringComparator();
		final Sorter<String, Comparator<String>> insertion = new Insertion<String, Comparator<String>>();

		System.out.println(Arrays.toString(names));
		insertion.sort(names, stringComparator);
		System.out.println(Arrays.toString(names));

		final Product[] products = getProducts();
		final Comparator<Product> prodComparatorByPrice = getProductsComparator();
		final Sorter<Product, Comparator<Product>> selection = new Selection<Product, Comparator<Product>>();

		System.out.println(Arrays.toString(products));
		selection.sort(products, prodComparatorByPrice);
		System.out.println(Arrays.toString(products));
	}

	private static String[] getNames() {
		String[] names = { "Joao", "Carlos", "Andreia", "Lucas" };
		return names;
	}

	private static Integer[] getNumbers() {
		Integer[] numbers = { 23, 12, 4, 2, 1, 23, 12 };
		return numbers;
	}

	private static Product[] getProducts() {
		Product[] products = { new Product(20, "macbook", 5000.0), new Product(12, "cadeira", 500.0),
				new Product(2, "mouse", 50.0), new Product(22, "mouse pad", 5.0) };
		return products;
	}

	private static Comparator<Product> getProductsComparator() {
		Comparator<Product> prodComparatorByPrice = new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				int result = 0;

				if (o1.getPrice() > o2.getPrice()) {
					result = +1;
				} else if (o1.getPrice() < o2.getPrice()) {
					result = -1;
				}

				return result;
			}
		};
		return prodComparatorByPrice;
	}

	private static Comparator<String> getStringComparator() {
		Comparator<String> stringComparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		return stringComparator;
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
