/**
 * Implements helper class DataNode
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 2
 *
 */
public class DataNode {
	private DataNode next, prev;
	private DataItem elem;

	/**
	 * method DataNode
	 * 
	 * @param elem
	 * 
	 *             data object to be inserted into node of linked list
	 */
	public DataNode(DataItem elem) { // constructor for node
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
	public DataNode getNext() {
		return next; // return next
	}

	/**
	 * method getPrev
	 * 
	 * @return prev
	 * 
	 *         points to previous node
	 */
	public DataNode getPrev() {
		return prev; // return prev
	}

	/**
	 * method getElem
	 * 
	 * @return elem
	 * 
	 *         points to element stored in node
	 */
	public DataItem getElem() {
		return elem; // return element stored in node
	}

	/**
	 * method setNext
	 * 
	 * @param next
	 * 
	 *             sets next to point at specified node
	 */
	public void setNext(DataNode next) {
		this.next = next; // set next node
	}

	/**
	 * method setPrev
	 * 
	 * @param prev
	 * 
	 *             sets prev to point at specified node
	 */
	public void setPrev(DataNode prev) {
		this.prev = prev; // set previous node
	}

	/**
	 * method setElem
	 * 
	 * @param elem
	 * 
	 *             sets elem to point at specific data
	 */
	public void setElem(DataItem elem) {
		this.elem = elem; // store element in node
	}
}
