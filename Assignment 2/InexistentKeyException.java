/**
 * Implements error code for InexistentKeyException
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 1
 *
 */
public class InexistentKeyException extends RuntimeException {

	/**
	 * Throws exception with appropriate message
	 * 
	 * @param collection String representing the name of the collection
	 */
	public InexistentKeyException(String key) {

		super("Error: The " + key + " does not exist.");

	} // end InexistentKeyException

} // end InexistentKeyException
