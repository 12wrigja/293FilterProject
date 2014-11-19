package main.filters;

import java.util.Comparator;

public class MaxFilter<T> extends ExtremesFilter<T>{
	
	private MaxFilter(){
		super(FilterMode.MAX);
	}
	
	private MaxFilter(Comparator<T> comparator){
		super(FilterMode.MAX,comparator);
	}
	
	public static <T> MaxFilter<T> newComparatorInstance(Comparator<T> comparator){
		return new MaxFilter<T>(comparator);
	}
	
	public static <T extends Comparable> MaxFilter<T> newInstance(){
			return new MaxFilter<T>();
	}
}
