package main.filters;

import java.util.Comparator;

import main.filters.interfaces.Filter;

public abstract class ComparableFilter<T> implements Filter<T,T> {
	
	protected final Comparator<T> comparator;
	
	protected ComparableFilter(){
		this.comparator = null;
	}
	
	protected ComparableFilter(Comparator<T> comparator){
		this.comparator = comparator;
	}
	
}
