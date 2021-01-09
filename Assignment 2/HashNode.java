/**
 * Implements code for linked list node for hash table
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 1
 *
 */
public class HashNode {
	// Initial variables
	HashNode prev; // initialize previous node
	HashNode next; // initialize next node
	Data elem; // initialize nested element

	/**
	 * method HashNode
	 * 
	 * @param elem
	 * 
	 *             data object to be inserted into node of linked list
	 */
	public HashNode(Data elem) { // constructor for node
		this.elem = elem; // declares elem
		next = null; // declares next as null
		prev = null; // declares prev as null
	}

	/**
	 * method getNext
	 * 
	 * @return next
	 * 
	 *         points to next node
	 */
	public HashNode getNext() {
		return next; // return next
	}

	/**
	 * method getPrev
	 * 
	 * @return prev
	 * 
	 *         points to previous node
	 */
	public HashNode getPrev() {
		return prev; // return prev
	}

	/**
	 * method getElem
	 * 
	 * @return elem
	 * 
	 *         points to element stored in node
	 */
	public Data getElem() {
		return elem; // return element stored in node
	}

	/**
	 * method setNext
	 * 
	 * @param next
	 * 
	 *             sets next to point at specified node
	 */
	public void setNext(HashNode next) {
		this.next = next; // set next node
	}

	/**
	 * method setPrev
	 * 
	 * @param prev
	 * 
	 *             sets prev to point at specified node
	 */
	public void setPrev(HashNode prev) {
		this.prev = prev; // set previous node
	}

	/**
	 * method setElem
	 * 
	 * @param elem
	 * 
	 *             sets elem to point at specific data
	 */
	public void setElem(Data elem) {
		this.elem = elem; // store element in node
	}
}
