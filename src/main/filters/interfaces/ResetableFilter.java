package main.filters.interfaces;

/**
 * The ResetableFilter interface is to be inherited by those filters that
 * support a reset operation.
 * 
 * @author james
 *
 * @param <I>
 */
public interface ResetableFilter<I> {
	/**
	 * The reset method is to be called, and the value supplied is used to
	 * compute the value of the output after the reset as if it was provided to
	 * the input method of the filter.
	 * 
	 * @param nextInput
	 */
	public void reset(I nextInput);
}
