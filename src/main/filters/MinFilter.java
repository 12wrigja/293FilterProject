package main.filters;

import java.util.Comparator;

public class MinFilter<T> extends ExtremesFilter<T>{
	
	private MinFilter(){
		super(FilterMode.MIN);
	}
	
	private MinFilter(Comparator<T> comparator){
		super(FilterMode.MIN,comparator);
	}
	
	public static <T> MinFilter<T> newComparatorInstance(Comparator<T> comparator){
		return new MinFilter<>(comparator);
	}
	
	public static <T extends Comparable<T>> MinFilter<T> newInstance(){
			return new MinFilter<>();
	}
}
