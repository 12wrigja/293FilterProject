package main.filters;

import java.util.Comparator;

import main.filters.interfaces.Filter;
import main.filters.interfaces.ResetableFilter;

public abstract class ComparableFilter<T> implements Filter<T,T>, ResetableFilter<T>{
	
	protected enum FilterMode{MIN,MAX};
	
	protected final FilterMode mode;
	
	protected final Comparator<T> comparator;
	
	protected T extremeObject = null;
	
	protected ComparableFilter(FilterMode mode){
		this.comparator = null;
		this.mode = mode;
	}
	
	protected ComparableFilter(FilterMode mode, Comparator<T> comparator){
		this.comparator = comparator;
		this.mode = mode;
	}
	
	protected final boolean isMinFilter(){
		return this.mode.equals(FilterMode.MIN);
	}
	
	protected final boolean isMaxFilter(){
		return this.mode.equals(FilterMode.MAX);
	}

	@Override
	public final T getOutput() {
		return extremeObject;
	}
}
