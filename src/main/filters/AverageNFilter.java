package main.filters;

import main.Buffer;
import main.filters.interfaces.ResetableFilter;
import main.filters.interfaces.ScalarFilter;

public class AverageNFilter<T extends Double> implements ScalarFilter<T>,
		ResetableFilter<T> {

	private double currentAverage = 0;
	private Buffer<Double> storageBuffer;

	public AverageNFilter(int size) {
		storageBuffer = new Buffer<>(size);
	}

	@Override
	public void filter(T input) {
		int count = storageBuffer.size();
		Double poppedItem = storageBuffer.addFirst(input);
		if (0 == count) {
			currentAverage = input;
		} else {
			Double subValue = (null == poppedItem) ? 0 : poppedItem
					.doubleValue();
			int itemCount = (null == poppedItem) ? count + 1 : count;
			currentAverage = (currentAverage * (count) / (itemCount))
					- (subValue / (itemCount)) + (input / (itemCount));
		}
	}

	@Override
	public T getOutput() {
		return (T) new Double(currentAverage);
	}

	@Override
	public void reset(T nextInput) {
		currentAverage = nextInput;
		storageBuffer.clear(null);
		storageBuffer.addFirst(nextInput);
	}

}
