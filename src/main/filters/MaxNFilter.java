package main.filters;

import java.util.Comparator;

/**
 * The MaxN filter computes the maximum of the last n items that it has been
 * passed as input.
 * 
 * @author james
 *
 * @param <T>
 *            The type of object that the filter operates on.
 */
public class MaxNFilter<T> extends ExtremesNFilter<T> {

	private MaxNFilter(int size) {
		super(FilterMode.MAX, size);
	}
	
	private MaxNFilter(int size, Comparator<T> comparator) {
		super(FilterMode.MAX, size, comparator);
	}

	/**
	 * Constructor method for a maximum n filter that does not use a comparator
	 * to compare objects. Requires that the type of the object that the filter
	 * operates on implements Comparable.
	 * 
	 * @param <T>
	 *            The type of object that the filter operates on. Must implement
	 *            comparable.
	 * @param size
	 *            The number of objects to remember and compare against.
	 * @return Returns an instance of the MaxNFilter constructed with those
	 *         parameters
	 */
	public static <T extends Comparable<T>> MaxNFilter<T> newInstance(int size){
		return new MaxNFilter<>(size);
	}
	
	/**
	 * Constructor method for the maximum n filter that requires a comparator to
	 * compare objects. The objects it operates on can be any type so long as
	 * the comparator can compare them.
	 * 
	 * @param <T>
	 *            The object type for the filter. Can be anything.
	 * @param size
	 *            The number of objects to remember and compare against
	 * @param comparator
	 *            The comparator that is used to compare the objects.
	 * @return Returns an instance of the MaxNFilter constructed with those
	 *         parameters
	 */
	public static <T> MaxNFilter<T> newComparatorInstance(int size, Comparator<T> comparator){
		return new MaxNFilter<>(size, comparator);
	}
	
}
