package main.filters;

/**
 * A FIR Filter is an extension to a Scalar Linear Filter that scales all the
 * outputs stored by 0, and scales all the inputs by whatever value is provided.
 * 
 * @author james
 *
 */
public class FIRFilter extends ScalarLinearFilter {

	/**
	 * The constructor for a FIR Filter.
	 * 
	 * @param m
	 *            The number of outputs to store
	 * @param b
	 *            The scaling array for the inputs. For more information on what
	 *            this does, see the {@link ScalarLinearFilter}
	 */
	public FIRFilter(int m, double[] b) {
		super(new double[m], b);
	}

}
