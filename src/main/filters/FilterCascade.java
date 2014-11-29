package main.filters;

import java.util.List;

import main.filters.exceptions.ResetNotSupportedException;
import main.filters.interfaces.Filter;
import main.filters.interfaces.ResetableFilter;

/**
 * A FilterCascade takes a single input and passes it through a user-defined
 * series of filters, returning the output at the other end.
 * 
 * @author james
 *
 * @param <T>
 *            the type of object that the cascade can work on.
 */
public class FilterCascade<T> implements Filter<T, T> {

	private final List<Filter<T, T>> filters;

	private FilterCascade(List<Filter<T, T>> filters) {
		this.filters = filters;
	}

	private T output;

	@Override
	public void filter(T input) {
		T response = input;
		for (Filter<T, T> filter : filters) {
			filter.filter(response);
			response = filter.getOutput();
		}
		output = response;
	}

	/**
	 * The ResetFilterAtIndex method will attempt to reset the method located at
	 * index i in the list of filters. Will throw an exception if that filter
	 * cannot be accepted.
	 * 
	 * @param i
	 *            The index of the filter to try and reset.
	 * @param toReset
	 *            The value to use in the call to the reset function. See
	 *            {@link ResetableFilter#reset(Object) ResetableFilter.reset}
	 *            for more information.
	 * @throws ResetNotSupportedException
	 *             Thrown in the event that the filter at that index does not
	 *             support the reset function.
	 */
	@SuppressWarnings("unchecked")
	public void resetFilterAtIndex(int i, T toReset)
			throws ResetNotSupportedException {
		if (i < 0 || i >= filters.size()) {
			throw new IndexOutOfBoundsException("The index " + i
					+ " is out of bounds for this filter cascade.");
		}
		Filter<?, ?> filter = filters.get(i);
		if (filter instanceof ResetableFilter) {
			((ResetableFilter<T>) filter).reset(toReset);
		} else {
			throw new ResetNotSupportedException("The filter at index " + i
					+ " does not support being reset.");
		}
	}

	@Override
	public T getOutput() {
		return output;
	}
}
