package main.filters;

import java.util.Comparator;

import main.filters.interfaces.Filter;
import main.filters.interfaces.ResetableFilter;

/**
 * The ComparableFilter abstract class lays out the framework for any filter
 * that wishes to store a Comparator, and do comparisons on data using it. It
 * has two constructors, one that allows for the construction of an
 * implementation without a comparator and one with.
 * 
 * The return of data from a ComparableFitler should be done through the
 * extremeObject property of any inheriting class as the {@link #getOutput()}
 * method is marked as final. All changes to the output done on filtering should
 * be reflected in that object.
 * 
 * @author james
 *
 * @param <T>
 *            The object type that is accepted by this filter as both input and
 *            output.
 */
public abstract class ComparableFilter<T> implements Filter<T, T>,
		ResetableFilter<T> {

	/**
	 * The FilterMode enumeration specifies all the potential directions of
	 * comparisons that any implementation can have.
	 * 
	 * @author james
	 *
	 */
	protected enum FilterMode {
		MIN, MAX
	};

	/**
	 * The variable that stores the mode of the ComparableFilter
	 */
	protected final FilterMode mode;

	/**
	 * The storage variable in the filter that holds the comparator
	 */
	protected final Comparator<T> comparator;

	/**
	 * The storage variable that hold the object that will be returned when the
	 * {@link #getOutput()} method is called.
	 */
	protected T extremeObject = null;

	/**
	 * Constructor for a ComparableFilter that accepts a
	 * {@link main.filters.ComparableFilter.FilterMode}
	 * 
	 * @param mode
	 *            The mode for the filter. Either FilterMode.MIN and
	 *            FilterMode.MAX
	 */
	protected ComparableFilter(FilterMode mode) {
		this.comparator = null;
		this.mode = mode;
	}

	/**
	 * Constructor for a ComparableFitler that accepts a
	 * {@link main.filters.ComparableFilter.FilterMode} and a Comparator of the
	 * right type.
	 * 
	 * @param mode The mode for the filter. Either FilterMode.MIN and
	 *            FilterMode.MAX
	 * @param comparator The comparator for the filter object to store.
	 */
	protected ComparableFilter(FilterMode mode, Comparator<T> comparator) {
		this.comparator = comparator;
		this.mode = mode;
	}

	/**A helper method to compare the stored FilterMode to see if the filter mode is a minimum filter.
	 * @return Returns true if the FilterMode is equal to FilterMode.MIN
	 */
	protected final boolean isMinFilter() {
		return this.mode.equals(FilterMode.MIN);
	}

	/**A helper method to compare the stored FilterMode to see if the filter mode is a maximum filter.
	 * @return Returns true if the FitlerMode is equal to FilterMode.MAX
	 */
	protected final boolean isMaxFilter() {
		return this.mode.equals(FilterMode.MAX);
	}

	@Override
	public final T getOutput() {
		return extremeObject;
	}
}
