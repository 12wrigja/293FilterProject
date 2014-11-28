package main.filters.interfaces;

/**
 * The filter interface is used to define a specification for which all filters
 * must comply. Makes any filter object accept one type as input and another
 * (possibly different) type as output.
 * 
 * @author james
 *
 * @param <I>
 *            The type of object to accept as input
 * @param <O>
 *            The type of output the filter produces.
 */
public interface Filter<I, O> {

	/**
	 * The filter method provides the next piece of input to the filter. Every
	 * time an input is provided, a new output is computed, which is available
	 * by the {@link #getOutput} method.
	 * 
	 * @param input
	 *            The next object to provide as input to the filter.
	 */
	public void filter(I input);

	/**
	 * The getOutput method returns the current output for the filter at the
	 * time the method is called.
	 * 
	 * @return Returns the current output of the filter.
	 */
	public O getOutput();
}
