package main.filters;

import java.util.Comparator;
import java.util.TreeSet;

import main.Buffer;

public class ExtremesNFilter<T> extends ComparableFilter<T>{

	protected final Buffer<T> valuesBuffer;
	protected final TreeSet<T> comparisonHeap;
	
	protected T extremeObject;
	
	protected ExtremesNFilter(main.filters.ExtremesFilter.FilterMode mode, int size) {
		super(mode);
		valuesBuffer = new Buffer<>(size);
		comparisonHeap = new TreeSet<>();
	}
	
	protected ExtremesNFilter(main.filters.ExtremesFilter.FilterMode mode, int size, Comparator<T> comparator) {
		super(mode,comparator);
		valuesBuffer = new Buffer<>(size);
		comparisonHeap = new TreeSet<>(comparator);
	}

	@Override
	public void filter(T input) {
		T overWrite = valuesBuffer.addFirst(input);
		if(overWrite != null){
			comparisonHeap.remove(overWrite);
		}
		comparisonHeap.add(input);
		switch(this.mode){
			case MIN:
				extremeObject = comparisonHeap.first();
				break;
			case MAX:
				extremeObject = comparisonHeap.last();
				break;
		}
	}

	@Override
	public void reset(T nextInput) {
		valuesBuffer.clear(null);
		comparisonHeap.clear();
		valuesBuffer.addFirst(nextInput);
		comparisonHeap.add(nextInput);
	}
}
