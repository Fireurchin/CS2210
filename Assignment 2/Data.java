/**
 * Implements code for records that will be stored in the objects of class
 * Dictionary.java
 * 
 * Objects of this class stores a string and two integers
 * 
 * The string stored in an object of this class will be used as its key
 * attribute.
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 1
 *
 */
public class Data {
	// initial variables
	private String key = "";
	private int score, level = 0;

	/**
	 * method Data
	 * 
	 * constructor for Data
	 * 
	 * @param key
	 * @param score
	 * @param level
	 */
	public Data(String key, int score, int level) { // The constructor for the class. Sets user-defined values for key,
													// score and level
		this.key = key;
		this.score = score;
		this.level = level;
	}

	/**
	 * method getKey
	 * 
	 * @return key
	 * 
	 *         requested key
	 */
	public String getKey() { // Returns the string stored in this Data object.
		return key;
	}

	/**
	 * method getScore
	 * 
	 * @return score
	 * 
	 *         requested score
	 */
	public int getScore() { // Returns the first integer stored in this Data object.
		return score;
	}

	/**
	 * method getLevel
	 * 
	 * @return level
	 * 
	 *         requested level
	 */
	public int getLevel() {// Returns the second integer stored in this Data object.
		return level;
	}
}
