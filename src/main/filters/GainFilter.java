package main.filters;

public class GainFilter extends FIRFilter {

	private Double gainVal;
	
	public GainFilter(double gain) {
		super(0, new double[0]);
		this.gainVal = new Double(gain);
	}
	
	@Override
	public void filter(Double input) {
		this.result = input * gainVal;
	}
	
}
