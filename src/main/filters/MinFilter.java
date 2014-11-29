package main.filters;

import java.util.Comparator;

/**
 * The MinFilter is a filter that computes the minimum of the elements that have
 * been given to it since it was last reset.
 * 
 * @author james
 *
 * @param <T> The type of object that the filter operates on.
 */
public class MinFilter<T> extends ExtremesFilter<T> {

	private MinFilter() {
		super(FilterMode.MIN);
	}

	private MinFilter(Comparator<T> comparator) {
		super(FilterMode.MIN, comparator);
	}

	/**
	 * Constructor method for a minimum filter that uses a comparator to compare
	 * objects to find their minimum.
	 * 
	 * @param <T>
	 *            The object type for the filter
	 * @param comparator
	 *            The comparator for the filter.
	 * @return Returns an instance of the minimum filter created using that
	 *         specification
	 */
	public static <T> MinFilter<T> newComparatorInstance(
			Comparator<T> comparator) {
		return new MinFilter<>(comparator);
	}

	/**
	 * Constructor method for the minimum filter that does not require a
	 * comparator to compare objects. Instead requires that the object type
	 * implements the Comparable interface.
	 * 
	 * @param <T> The object type for the filter. Must implement Comparable.
	 * @return Returns an instance of a minimum filter created.
	 */
	public static <T extends Comparable<T>> MinFilter<T> newInstance() {
		return new MinFilter<>();
	}
}
