package main.filters;

import java.util.Comparator;

import main.filters.interfaces.ResetableFilter;

public abstract class ExtremesFilter<T> extends ComparableFilter<T> implements ResetableFilter<T>{
	
	protected enum FilterMode{MIN,MAX};
	
	private final FilterMode mode;
	
	private T extremeObject = null;
	
	protected ExtremesFilter(FilterMode mode){
		this.mode = mode;
	}
	
	protected ExtremesFilter(FilterMode mode, Comparator<T> comparator){
		super(comparator);
		this.mode = mode;
	}
	protected final boolean isMinFilter(){
		return this.mode.equals(FilterMode.MIN);
	}
	
	protected final boolean isMaxFilter(){
		return this.mode.equals(FilterMode.MAX);
	}
	
	@Override
	public final void filter(T input) {
		if(null == extremeObject){
			extremeObject = input;
			return;
		}
		int compareVal = compareToExtreme(input);
		switch(mode){
		case MIN:
			if(compareVal < 0){
				extremeObject = input;
			}
			break;
		case MAX:
			if(compareVal > 0){
				extremeObject = input;
			}
			break;
		}
		return;
	}
	
	private final int compareToExtreme(T other){
		if(null == comparator){
			return ((Comparable<T>)other).compareTo(extremeObject);
		}else{
			return comparator.compare(other, extremeObject);
		}
	}
	
	@Override
	public final void reset(T nextInput) {
		this.extremeObject = nextInput;
	}
	
	@Override
	public final T getOutput() {
		return extremeObject;
	}
}
