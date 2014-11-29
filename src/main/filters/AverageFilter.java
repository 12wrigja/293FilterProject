package main.filters;

import main.filters.interfaces.ResetableFilter;
import main.filters.interfaces.ScalarFilter;

/**
 * A AverageFilter is a filter that computes the average of the numbers that are
 * passed in as input. This filter computes the average of all the numbers that are passed in until the reset is called.
 * 
 * @author james
 *
 */
public class AverageFilter implements ScalarFilter, ResetableFilter<Double> {

	double currentAverage = 0;
	double count = 0;

	@Override
	public void filter(Double input) {
		if (0 == count) {
			currentAverage = input;
		} else {
			currentAverage = (currentAverage * (count) + input) / (count + 1);
		}
		count++;
	}

	@Override
	public Double getOutput() {
		return currentAverage;
	}

	@Override
	public void reset(Double nextInput) {
		count = 1;
		currentAverage = nextInput;
	}

}
