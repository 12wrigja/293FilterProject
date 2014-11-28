package main.filters.exceptions;

/**
 * The ResetNotSupportedException should be thrown whenever something attempts
 * to reset a filter that is not resetable. An example of this behaviour is
 * visible in the {@link main.filters.FilterCascade FilterCascade} class.
 * 
 * @author james
 *
 */
public class ResetNotSupportedException extends Exception {
	private static final long serialVersionUID = 1L;

	/**Default Constructor
	 * @param message
	 */
	public ResetNotSupportedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
