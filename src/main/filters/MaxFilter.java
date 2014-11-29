package main.filters;

import java.util.Comparator;

/**
 * The MaxFilter is a filter that computes the maximum of the elements that have
 * been given to it since it was last reset.
 * 
 * @author james
 *
 * @param <T> The type of object that the filter operates on 
 */
public class MaxFilter<T> extends ExtremesFilter<T>{
	
	private MaxFilter(){
		super(FilterMode.MAX);
	}
	
	private MaxFilter(Comparator<T> comparator){
		super(FilterMode.MAX,comparator);
	}
	
	/**
	 * Constructor method for a maximum filter that uses a comparator to compare
	 * objects to find their maximum.
	 * 
	 * @param <T>
	 *            The object type for the filter
	 * @param comparator
	 *            The comparator for the filter.
	 * @return Returns an instance of the maximum filter created using that
	 *         specification
	 */
	public static <T> MaxFilter<T> newComparatorInstance(Comparator<T> comparator){
		return new MaxFilter<T>(comparator);
	}
	
	/**
	 * Constructor method for the maximum filter that does not require a
	 * comparator to compare objects. Instead requires that the object type
	 * implements the Comparable interface.
	 * 
	 * @param <T> The object type for the filter. Must implement Comparable.
	 * @return Returns an instance of a maximum filter created.
	 */
	public static <T extends Comparable<T>> MaxFilter<T> newInstance(){
			return new MaxFilter<T>();
	}
}
