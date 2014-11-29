package main.filters;

import main.filters.interfaces.ResetableFilter;
import main.filters.interfaces.ScalarFilter;
import main.utils.Buffer;

public class AverageNFilter implements ScalarFilter,
		ResetableFilter<Double> {

	private double currentAverage = 0;
	private Buffer<Double> storageBuffer;

	public AverageNFilter(int size) {
		storageBuffer = new Buffer<>(size);
	}

	@Override
	public void filter(Double input) {
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
	public Double getOutput() {
		return new Double(currentAverage);
	}

	@Override
	public void reset(Double nextInput) {
		currentAverage = nextInput;
		storageBuffer.clear(null);
		storageBuffer.addFirst(nextInput);
	}

}
