package main.filters;

import java.util.Comparator;

public class MaxNFilter<T> extends ExtremesNFilter<T> {

	private MaxNFilter(int size) {
		super(FilterMode.MAX, size);
	}
	
	private MaxNFilter(int size, Comparator<T> comparator) {
		super(FilterMode.MAX, size, comparator);
	}

	public static <T extends Comparable<T>> MaxNFilter<T> newInstance(int size){
		return new MaxNFilter<>(size);
	}
	
	public static <T> MaxNFilter<T> newComparatorInstance(int size, Comparator<T> comparator){
		return new MaxNFilter<>(size, comparator);
	}
	
}
