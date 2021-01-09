import java.util.EmptyStackException;

/**
 * Implements helper class DataList to aid in successor() and predecessor()
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 2
 *
 */
public class DataList {
	// instance variables
	private int size;
	private DataNode head;

	/**
	 * method DataLinkedList
	 * 
	 * constructor for DataList
	 * 
	 * @param h node to be returned as Data function
	 */
	public DataList(DataNode h) { // Create linked Data list of size 1
		head = h;
		size = 1;
	}

	/**
	 * constructor for DataList
	 */
	public DataList() { // create empty Data list if no entries are specified
		head = null;
		size = 0;
	}

	/**
	 * method getHead
	 * 
	 * @return head
	 */
	public DataNode getHead() { // return first node in list
		return head;
	}

	/**
	 * method add
	 * 
	 * @param elem
	 * 
	 *             data element to be added to list
	 */
	public void add(DataItem elem) {
		DataNode temp = new DataNode(elem);
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
	public void remove(Key key) throws EmptyStackException {
		if (isEmpty()) // if no entries, throw exception
			throw new EmptyStackException();
		else {
			DataNode curr = head;
			if (size == 1) { // if selected node is only node in list
				head = null; // remove head
			} else if (curr.getElem().getKey().compareTo(key) == 0) { // if node is head
				head = curr.getNext(); // set next node as new head
				head.setPrev(null); // neutralize old head
			} else { // else if node is internal or rear
				while (curr.getElem().getKey().compareTo(key) != 0 && curr != null) { // while node not found and not
																						// null
					curr = curr.getNext(); // search list
					if (curr.getElem().getKey().compareTo(key) == 0) { // if node found
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
