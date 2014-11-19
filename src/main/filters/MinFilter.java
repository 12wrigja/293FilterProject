package main.filters;

import java.util.Comparator;

import main.filters.interfaces.ResetableFilter;

public class MinFilter<T> extends ExtremesFilter<T>{
	
	private MinFilter(){
		super(FilterMode.MIN);
	}
	
	private MinFilter(Comparator<T> comparator){
		super(FilterMode.MIN,comparator);
	}
	
	public static <T> MinFilter<T> newComparatorInstance(Comparator<T> comparator){
		return new MinFilter<T>(comparator);
	}
	
	public static <T extends Comparable> MinFilter<T> newInstance(){
			return new MinFilter<T>();
	}
}
