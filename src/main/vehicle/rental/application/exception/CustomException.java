package main.vehicle.rental.application.exception;

/**
 * The class for throwing custom exception
 * 
 * @author Sruthy MS
 *
 */
public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message to be shown
	 * 
	 * @param msg
	 */
	public CustomException(String msg) {
		super(msg);
	}

}
