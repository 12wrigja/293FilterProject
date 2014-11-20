package main.filters;

import java.util.List;

import main.filters.exceptions.ResetNotSupportedException;
import main.filters.interfaces.Filter;
import main.filters.interfaces.ResetableFilter;

public class FilterCascade<T> implements Filter<T,T> {

	private final List<Filter<T,T>> filters;
	
	private FilterCascade(List<Filter<T,T>> filters){
		this.filters = filters;
	}
	
	private T output;
	
	@Override
	public void filter(T input) {
		T response = input;
		for(Filter<T,T> filter : filters){
			filter.filter(response);
			response = filter.getOutput();
		}
		output = response;
	}
	
	public static class FilterCascadeBuilder{
		
		private List<? extends Filter<?,?>> filters;
		
	}
	
	public void resetFilterAtIndex(int i, T toReset) throws ResetNotSupportedException{
		if(i<0 || i>=filters.size()){
			throw new IndexOutOfBoundsException("The index "+i+" is out of bounds for this filter cascade.");
		}
		Filter<?,?> filter = filters.get(i);
		if(filter instanceof ResetableFilter){
			((ResetableFilter<T>)filter).reset(toReset);
		}else{
			throw new ResetNotSupportedException("The filter at index "+i+" does not support being reset.");
		}
	}

	@Override
	public T getOutput() {
		return output;
	}
}
