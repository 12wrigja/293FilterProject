package main.filters;

import main.filters.interfaces.Filter;

/**The identity filter is a basic filter that simply returns whatever is handed to it.
 * @author james
 *
 * @param <T> The type of object that this filter works on.
 */
public class IdentityFilter<T> implements Filter<T,T>{
	
	private T currentObj;
	
	@Override
	public void filter(T input) {
		currentObj = input;
	}

	@Override
	public T getOutput() {
		return currentObj;
	}

}
