package main.filters;

import java.util.Comparator;

import main.filters.interfaces.ResetableFilter;

public abstract class ExtremesFilter<T> extends ComparableFilter<T> implements ResetableFilter<T>{
	
	protected ExtremesFilter(main.filters.ComparableFilter.FilterMode mode) {
		super(mode);
	}
	
	protected ExtremesFilter(main.filters.ComparableFilter.FilterMode mode,
			Comparator<T> comparator) {
		super(mode, comparator);
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
	
}
