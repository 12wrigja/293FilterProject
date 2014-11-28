package main.filters.exceptions;

/**The BufferException is a class that represents any errors thrown by the {@link main.utils.Buffer Buffer} class.
 * @author james
 *
 */
public class BufferException extends Exception {

	private static final long serialVersionUID = 1L;

	/**Constructor for a new exception
	 * @param message
	 */
	public BufferException(String message) {
		super(message);
	}
}
