package main.filters;

import java.util.Comparator;

public class MinNFilter<T> extends ExtremesNFilter<T> {

	private MinNFilter(int size) {
		super(FilterMode.MIN, size);
	}
	
	private MinNFilter(int size, Comparator<T> comparator) {
		super(FilterMode.MIN, size, comparator);
	}

	public static <T extends Comparable<T>> MinNFilter<T> newInstance(int size){
		return new MinNFilter<>(size);
	}
	
	public static <T> MinNFilter<T> newComparatorInstance(int size, Comparator<T> comparator){
		return new MinNFilter<>(size, comparator);
	}
	
}
