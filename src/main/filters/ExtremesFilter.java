package main.filters;

import java.util.Comparator;

import main.filters.interfaces.ResetableFilter;

/**
 * The ExtremesFilter computes an extreme of all the items passed into it. This
 * can be reset using the reset method.
 * 
 * @author james
 *
 * @param <T>
 *            The type of object that the filter accepts.
 */
public abstract class ExtremesFilter<T> extends ComparableFilter<T> implements
		ResetableFilter<T> {

	/**
	 * Constructs a filter using the super constructor located in the
	 * {@link ComparableFilter}. This constructor accepts a FilterMode only.
	 * 
	 * @param mode
	 *            The mode of the filter. See {@link FilterMode} for more
	 *            information.
	 */
	protected ExtremesFilter(main.filters.ComparableFilter.FilterMode mode) {
		super(mode);
	}

	/**
	 * Constructs a filter using the super constructor located in the
	 * {@link ComparableFilter}. This constructor accepts a FilterMode and a
	 * comparator.
	 * 
	 * @param mode
	 *            The mode of the filter. See {@link FilterMode} for more
	 *            information.
	 * @param comparator
	 *            The comparator to use when comparing objects.
	 */
	protected ExtremesFilter(main.filters.ComparableFilter.FilterMode mode,
			Comparator<T> comparator) {
		super(mode, comparator);
	}

	@Override
	public final void filter(T input) {
		if (null == extremeObject) {
			extremeObject = input;
			return;
		}
		int compareVal = compareToExtreme(input);
		if (shouldReplaceMinimum(compareVal)
				|| shouldReplaceMaximum(compareVal)) {
			extremeObject = input;
		}
	}

	@SuppressWarnings("unchecked")
	private final int compareToExtreme(T other) {
		return (null == comparator)?((Comparable<T>) other).compareTo(extremeObject) : comparator.compare(other, extremeObject);
	}

	@Override
	public final void reset(T nextInput) {
		this.extremeObject = nextInput;
	}

	private boolean shouldReplaceMinimum(int compareVal) {
		return mode == FilterMode.MIN && compareVal < 0;
	}

	private boolean shouldReplaceMaximum(int compareVal) {
		return mode == FilterMode.MAX && compareVal > 0;
	}
}
