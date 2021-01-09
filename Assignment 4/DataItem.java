/**
 * Represents the data items that will be stored in the internal nodes of the
 * ordered dictionary
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 2
 *
 */
public class DataItem {
	// initial variables
	Key theKey;
	String content;

	/**
	 * method DataItem
	 * 
	 * @param k, data
	 */
	public DataItem(Key k, String data) { // constructor for DataItem
		theKey = k;
		content = data;
	}

	/**
	 * method getKey
	 * 
	 * @return theKey
	 */
	public Key getKey() { // return key
		return theKey;
	}

	/**
	 * method getContent
	 * 
	 * @return content
	 */
	public String getContent() { // returns content
		return content;
	}
}
