package main.filters;

import org.apache.commons.math3.util.CombinatoricsUtils;

public class BinomialFilter extends FIRFilter{

	public BinomialFilter(int m, int n) {
		super(m, constructBinomailCoefficientArray(n));
	}
	
	private static double[] constructBinomailCoefficientArray(int n){
		double[] array = new double[n];
		for(int i=0; i<n; i++){
			array[i] = CombinatoricsUtils.binomialCoefficientDouble(n, i);
		}
		return array;
	}
	
}
