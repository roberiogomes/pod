package br.edu.uni7.pod.sorting.util;

import java.util.Arrays;

public class DataGen {
	public Integer[] getRadixData(int size) {
		Integer[] result = new Integer[size];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * 900) + 100;
		}
		
		return result;
	}
	
	public Integer[] getData(int size) {
		Integer[] result = new Integer[size];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		
		return result;
	}
	
	public Integer[] getWorstData(int size) {
		Integer[] result = new Integer[size];
		
		for (int i = 0, j = result.length; i < result.length; i++, j--) {
			result[i] = j;
		}
		
		return result;
	}
	
	public Integer[] getBestData(int size) {
		Integer[] result = new Integer[size];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = i;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		DataGen gen = new DataGen();
		
		System.out.println(Arrays.toString(gen.getWorstData(100)));
	}
}
