package main.filters;

import org.apache.commons.math3.util.CombinatoricsUtils;

/**
 * The Binomial Filter is a filter that scales all the inputs by binomial
 * coefficients.
 * 
 * @author james
 *
 */
public class BinomialFilter extends FIRFilter {

	/**
	 * The constructor for the Binomial Filter.
	 * 
	 * @param m
	 *            The number of outputs to store
	 * @param n
	 *            The number of inputs to store, which is also used to construct
	 *            an array of the first n binomial coefficients.
	 */
	public BinomialFilter(int m, int n) {
		super(m, constructBinomailCoefficientArray(n));
	}

	private static double[] constructBinomailCoefficientArray(int n) {
		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = CombinatoricsUtils.binomialCoefficientDouble(n, i);
		}
		return array;
	}

}
