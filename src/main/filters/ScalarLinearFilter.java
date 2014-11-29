package main.filters;

import main.filters.interfaces.ResetableFilter;
import main.filters.interfaces.ScalarFilter;
import main.utils.Buffer;

public class ScalarLinearFilter implements ScalarFilter, ResetableFilter<Double> {
	
	private final Buffer<Double> inputBuffer;
	private final Buffer<Double> outputBuffer;
	private final double[] a;
	private final double[] b;
	
	protected Double result = null;
	
	private final Double resetMultiplier;
	
	public ScalarLinearFilter(double[] a, double[] b){
		this.a = a;
		this.b = b;
		inputBuffer = new Buffer<>(b.length, new Double(0));
		outputBuffer = new Buffer<>(a.length, new Double(0));
		double top = 0;
		for(int i=0; i<b.length; i++){
			top += b[i];
		}
		double bottom = 0;
		for(int i=0; i<b.length; i++){
			top += a[i];
		}
		resetMultiplier = top/(1+bottom);
	}
	
	
	@Override
	public void filter(Double input) {
		inputBuffer.addFirst(input);
		double sum = 0;
		for(int i = 0; i<b.length; i++){
			sum += b[i] * inputBuffer.get(i);
		}
		for(int i=0; i<a.length; i++){
			sum -= a[i] * outputBuffer.get(i);
		}
		result = new Double(sum);
		outputBuffer.addFirst(result);
	}

	@Override
	public void reset(Double nextInput) {
		inputBuffer.clear(nextInput);
		outputBuffer.clear(nextInput*resetMultiplier);
		result = null;
	}

	@Override
	public final Double getOutput() {
		return result;
	}
	
}
