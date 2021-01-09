import java.util.EmptyStackException;

public class LinkedHashList {
	// instance variables
	private int size;
	private HashNode head;

	/**
	 * method HashLinkedList
	 * 
	 * constructor for LinkedHashList
	 * 
	 * @param h node to be returned as hash function
	 */
	public LinkedHashList(HashNode h) { // Create linked hash list of size 1
		head = h;
		size = 1;
	}

	/**
	 * constructor for LinkedHashList
	 */
	public LinkedHashList() { // create empty hash list if no entries are specified
		head = null;
		size = 0;
	}

	/**
	 * method getHead
	 * 
	 * @return head
	 */
	public HashNode getHead() { // return first node in list
		return head;
	}

	/**
	 * method append
	 * 
	 * @param elem
	 * 
	 *             data element to be added to list
	 */
	public void append(Data elem) {
		HashNode temp = new HashNode(elem);
		if (!isEmpty()) { // if head is not null
			temp.setNext(head); // new entry points forward to head
			head.setPrev(temp); // head points backward to new entry
		}
		head = temp; // set head to new entry
		size++; // increase size
	}

	/**
	 * method remove
	 * 
	 * @param key
	 * 
	 *            key to signify which node to remove
	 * @throws EmptyStackException
	 */
	public void remove(String key) throws EmptyStackException {
		if (isEmpty()) // if no entries, throw exception
			throw new EmptyStackException();
		else {
			HashNode curr = head;
			if (size == 1) { // if selected node is only node in list
				head = null; // remove head
			} else if (curr.getElem().getKey().equals(key)) { // if node is head
				head = curr.getNext(); // set next node as new head
				head.setPrev(null); // neutralize old head
			} else { // else if node is internal or rear
				while (!curr.getElem().getKey().equals(key) && curr != null) { // while node not found and not null
					curr = curr.getNext(); // search list
					if (curr.getElem().getKey().equals(key)) { // if node found
						if (curr.getNext() != null) { // if node is internal
							curr.getPrev().setNext(curr.getNext()); // point prev to next
							curr.getNext().setPrev(curr.getPrev()); // point next to prev
						} else // if node at rear, neutralize rear
							curr.getPrev().setNext(null);
					}
				}
			}
			size--; // descale size
		}
	}

	/**
	 * method isEmpty
	 * 
	 * @return true if empty else false
	 */
	public boolean isEmpty() { // if no nodes in list
		return (size == 0);
	}

	/**
	 * method size
	 * 
	 * @return size
	 * 
	 *         returns size of list
	 */
	public int size() { // return size
		return size;
	}
}
