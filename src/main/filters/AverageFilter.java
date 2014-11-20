package main.filters;

import main.filters.interfaces.ResetableFilter;
import main.filters.interfaces.ScalarFilter;

public class AverageFilter<T extends Double> implements ScalarFilter<T>, ResetableFilter<T>{
	
	double currentAverage = 0;
	double count = 0;	
	
	@Override
	public void filter(T input) {
		if(0 == count){
			currentAverage = input;
		}else{
			currentAverage = (currentAverage*(count) + input) / (count + 1);
		}
		count++;
	}
	@Override
	public T getOutput() {
		return (T) new Double(currentAverage);
	}
	@Override
	public void reset(T nextInput) {
		count = 1;
		currentAverage = nextInput;
	}
	
}
