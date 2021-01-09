/**
 * Implements error code for DictionaryException
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 2
 *
 */
public class DictionaryException extends RuntimeException {

	/**
	 * Throws exception with appropriate message
	 * 
	 * @param collection String representing the name of the collection
	 */
	public DictionaryException(String key) {

		super("Error: The " + key + " does not exist or was repeated.");

	} // end DictionaryException

} // end DictionaryException
