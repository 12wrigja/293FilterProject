package main.filters;

import main.filters.interfaces.ResetableFilter;
import main.filters.interfaces.ScalarFilter;

public class AverageFilter implements ScalarFilter, ResetableFilter<Double>{
	
	double currentAverage = 0;
	double count = 0;	
	
	@Override
	public void filter(Double input) {
		if(0 == count){
			currentAverage = input;
		}else{
			currentAverage = (currentAverage*(count) + input) / (count + 1);
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
