/**
 * Represents the key attribute of the data items that will be stored in the
 * internal nodes of the binary search tree implementing the ordered dictionary
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 2
 *
 */
public class Key {
	// instance variables
	private String name, kind;

	/**
	 * method Key
	 * 
	 * @param word, type
	 */
	public Key(String word, String type) { // constructor for Key
		name = word.toLowerCase();
		kind = type;
	}

	/**
	 * method getName
	 * 
	 * @return name
	 */
	public String getName() { // return name
		return name;
	}

	/**
	 * method getKind
	 * 
	 * @return kind
	 */
	public String getKind() { // return kind
		return kind;
	}

	/**
	 * method compareTo
	 * 
	 * @return 0 if same, 1 if greater and -1 if lesser
	 */
	public int compareTo(Key k) {
		if (this.getName().equals(k.getName())) // if names are the same
			if (k.getKind() == "")
				return 0;
			else
				return (this.getKind().compareTo(k.getKind())); // return key with greater kind value
		else
			return (this.getName().compareTo(k.getName())); // return key with greater name value
	}
}
