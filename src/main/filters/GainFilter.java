package main.filters;

/**The Gain Filter simply returns the item it was passed in, scaled by the scaling value it was originally passed.
 * @author james
 *
 */
public class GainFilter extends FIRFilter {

	private Double gainVal;
	
	/**Constructor for a gain filter. Accepts a double by which to scale the inputs.
	 * @param gain The double that is multiplied by the inputs to scale them.
	 */
	public GainFilter(double gain) {
		super(0, new double[0]);
		this.gainVal = new Double(gain);
	}
	
	@Override
	public void filter(Double input) {
		this.result = input * gainVal;
	}
	
}
