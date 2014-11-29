package main.filters;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import main.utils.Buffer;

/**
 * The ExtremesFilter computes an extreme of the last n items passed into it.
 * This can be reset using the reset method.
 * 
 * @author james
 *
 * @param <T>
 */
public class ExtremesNFilter<T> extends ComparableFilter<T> {

	/**
	 * The buffer that keeps track of the last N objects.
	 */
	protected final Buffer<T> valuesBuffer;

	/**
	 * The PriorityQueue that keeps track of the object that is either the
	 * largest or smallest object.
	 */
	protected final Queue<T> comparisonHeap;

	/**Constructor for the filter that does not accept a filter
	 * @param mode The mode (either MIN or MAX) for the filter.
	 * @param size The size for the buffer.
	 */
	protected ExtremesNFilter(main.filters.ExtremesFilter.FilterMode mode,
			int size) {
		this(mode, size, null);
	}

	/**Constructor for the filter that accepts a comparator.
	 * @param mode The mode (either MIN or MAX) for the filter.
	 * @param size The size for the buffer.
	 * @param comparator The comparator to use in the comparison.
	 */
	protected ExtremesNFilter(main.filters.ExtremesFilter.FilterMode mode,
			int size, Comparator<T> comparator) {
		super(mode, comparator);
		valuesBuffer = new Buffer<>(size);
		switch (mode) {
		case MIN:
			comparisonHeap = new PriorityQueue<>(size, comparator);
			break;
		case MAX:
			comparisonHeap = new PriorityQueue<>(size,
					Collections.reverseOrder(comparator));
			break;
		default:
			comparisonHeap = null;
			assert false : "This area should never be called. Please do not modify the FilterMode enumeration";
			break;
		}
	}

	@Override
	public void filter(T input) {
		T overWrite = valuesBuffer.addFirst(input);
		if (overWrite != null) {
			comparisonHeap.remove(overWrite);
		}
		comparisonHeap.add(input);
		extremeObject = comparisonHeap.peek();
	}

	@Override
	public void reset(T nextInput) {
		valuesBuffer.clear(null);
		comparisonHeap.clear();
		valuesBuffer.addFirst(nextInput);
		comparisonHeap.add(nextInput);
		extremeObject = nextInput;
	}
}
