package main.filters;

public class FIRFilter extends ScalarLinearFilter {

	public FIRFilter(int m, double[] b) {
		super(new double[m], b);
	}

}
