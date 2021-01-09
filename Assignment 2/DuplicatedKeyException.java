/**
 * Implements error code for DuplicatedKeyException
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 1
 *
 */
public class DuplicatedKeyException extends RuntimeException {

	/**
	 * Throws exception with appropriate message
	 * 
	 * @param collection String representing the name of the collection
	 */
	public DuplicatedKeyException(String key) {

		super("Error: The " + key + " already exists.");

	} // end DuplicatedKeyException

} // end DuplicatedKeyException
