package main.filters;

import main.filters.interfaces.Filter;
import main.filters.interfaces.ResetableFilter;

public class IdentityFilter<T> implements Filter<T,T>, ResetableFilter<T> {
	
	private T currentObj;
	
	@Override
	public void reset(T nextInput) {
		throw new UnsupportedOperationException("Reset not supported.");
	}

	@Override
	public void filter(T input) {
		currentObj = input;
	}

	@Override
	public T getOutput() {
		return currentObj;
	}

}
