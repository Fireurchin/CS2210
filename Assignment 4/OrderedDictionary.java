/**
 * Implements Dictionary of type BinarySearchTree to store nodes of type
 * DataItem
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 2
 *
 */
public class OrderedDictionary implements OrderedDictionaryADT {
	// instance variables
	private BinNode<DataItem> root; // This points to the root of the binary search tree.
	private int size = 0; // This stores the number of nodes in the tree.

	/**
	 * method OrderedDictionary
	 * 
	 * @param root, size
	 */
	public OrderedDictionary() { // constructor for Ordered Dictionary
		root = null;
		size = 0;
	}

	/**
	 * method get
	 * 
	 * @return node storing key if exists, else null
	 */
	public DataItem get(Key k) {
		if (isEmpty())
			return null; // return null if key does not exist
		else if (root.getObj().getKey().compareTo(k) == 0)
			return root.getObj(); // return node if key found
		else if (root.getLeft() != null && root.getObj().getKey().compareTo(k) > 0)
			return getInternal(root.getLeft(), k); // call helper method if key is smaller
		else if (root.getRight() != null && root.getObj().getKey().compareTo(k) < 0)
			return getInternal(root.getRight(), k); // call helper method if key is larger
		else {
			return null; // else key is not in dictionary
		}
	}

	/**
	 * method getInternal
	 * 
	 * @return node storing key if exists, else null
	 */
	private DataItem getInternal(BinNode<DataItem> child, Key key) {
		if (child.getObj().getKey().compareTo(key) == 0)
			return child.getObj(); // return node if key found
		else if (child.getLeft() != null && child.getObj().getKey().compareTo(key) > 0)
			return getInternal(child.getLeft(), key); // search left child if key is smaller
		else if (child.getRight() != null && child.getObj().getKey().compareTo(key) < 0)
			return getInternal(child.getRight(), key); // search right child if key is larger
		else {
			return null; // else key is not in dictionary
		}
	}

	/**
	 * method put
	 * 
	 * @param key
	 * 
	 *            add node if not in dictionary, else throw DictionaryException
	 */
	public void put(DataItem key) throws DictionaryException {
		BinNode<DataItem> node = new BinNode<DataItem>(key); // create node of type DataItem
		if (isEmpty())
			root = node; // set node to root if tree is empty
		else if (get(key.getKey()) != null)
			throw new DictionaryException("key"); // throw exception if key is already in tree
		else
			internalAdd(root, key); // call helper method if key is not in tree
		size++; // increment size

	}

	/**
	 * method internalAdd
	 * 
	 * @param child, key
	 * 
	 *               add node if not in dictionary, else throw DictionaryException
	 */
	private void internalAdd(BinNode<DataItem> child, DataItem key) throws DictionaryException {
		BinNode<DataItem> node = new BinNode<DataItem>(key); // create node of type DataItem
		if (key.getKey().compareTo(child.getObj().getKey()) < 0) { // if key is smaller
			if (child.getLeft() != null)
				internalAdd(child.getLeft(), key); // call recursive method if left is not null
			else {
				child.setLeft(node); // else set node as left child
				node.setParent(child);
			}
		} else if (key.getKey().compareTo(child.getObj().getKey()) > 0) { // if key is larger
			if (child.getRight() != null)
				internalAdd(child.getRight(), key); // call recursive method if right is not null
			else {
				child.setRight(node); // else set node as right child
				node.setParent(child);
			}
		} else
			throw new DictionaryException("key"); // throw exception if key is already in dictionary
	}

	/**
	 * method remove
	 * 
	 * @param key
	 * 
	 *            remove node if in dictionary, else throw DictionaryException
	 */
	public void remove(Key key) throws DictionaryException {
		DataItem temp;
		if (get(key) == null)
			throw new DictionaryException("key"); // throw exception if key is not in dictionary
		else {
			if (size() == 1)
				root = null; // clear root if root is leaf
			else if (key.compareTo(root.getObj().getKey()) == 0) { // else if root was found
				if (root.getLeft() == null) { // if left child is empty
					root = root.getRight(); // set node as left child
					root.setParent(null);
				} else if (root.getRight() == null) { // if right child is empty
					root = root.getLeft(); // set root as right child
					root.setParent(null);
				} else { // else if node is internal
					temp = internalSmallest(root); // replace node with inOrder successor
					remove(temp.getKey());
					root.setObj(temp);
				}
			} else if (key.compareTo(root.getObj().getKey()) < 0)
				internalRemove(root.getLeft(), key); // call helper method if key is smaller
			else
				internalRemove(root.getRight(), key); // call helper method if key is larger
			size--; // decrement size
		}
	}

	/**
	 * method internalRemove
	 * 
	 * @param key, child
	 * 
	 *             remove internal node if in tree
	 */
	private void internalRemove(BinNode<DataItem> child, Key key) {
		if (key.compareTo(child.getObj().getKey()) == 0) { // if node is found
			if (child.isLeaf()) {
				if (child.getObj().getKey().compareTo(child.getParent().getObj().getKey()) < 0)
					child.getParent().setLeft(null); // remove left child of parent if child is lesser
				else
					child.getParent().setRight(null); // remove right child of parent if child is greater
			} else
				replace(child); // else call helper method if node has both right and left child nodes
		} else if (key.compareTo(child.getObj().getKey()) < 0) {
			internalRemove(child.getLeft(), key); // call recursive method if child is lesser
		} else {
			internalRemove(child.getRight(), key); // else call recursive method if child is greater
		}
	}

	/**
	 * method replace
	 * 
	 * @param node
	 * 
	 *             replace node if in tree
	 */
	private void replace(BinNode<DataItem> node) {
		DataItem smallest;
		if (node.getRight() == null) { // if right child is null
			if (node.getObj().getKey().compareTo(node.getParent().getObj().getKey()) < 0) // if smaller
				node.getParent().setLeft(node.getLeft()); // replace node with left child
			else // if larger
				node.getParent().setRight(node.getLeft());
			node.getLeft().setParent(node.getParent()); // replace node with left child
		} else if (node.getLeft() == null) { // if left child is null
			if (node.getObj().getKey().compareTo(node.getParent().getObj().getKey()) < 0) // if smaller
				node.getParent().setLeft(node.getRight()); // replace node with right child
			else // if larger
				node.getParent().setRight(node.getRight()); // replace node with right child
			node.getRight().setParent(node.getParent());
		} else { // else if both child nodes exist
			smallest = internalSmallest(node.getRight()); // replace node with inOrder successor
			remove(smallest.getKey());
			node.setObj(smallest);
		}
	}

	/**
	 * method successor
	 * 
	 * @return successor
	 */
	public DataItem successor(Key k) {
		DataList list = new DataList();
		BinNode<DataItem> p, parent;
		if (isEmpty())
			return null; // if no successor is possible return null
		else if (root.isLeaf()) { // if root is leaf
			if (root.getObj().getKey().compareTo(k) < 0)
				return root.getObj(); // return root if it is successor
			else
				return null; // else return null
		} else {
			p = retrieve(root, k);
			if (p != null) { // if k is in dictionary
				if (p.getRight() != null)
					return internalSmallest(p.getRight()); // Call helper method
				else {
					parent = p.getParent();
					while (p != root && parent.getRight() == p) { // while p is not root
						p = parent;
						parent = p.getParent();
					}
					if (p == root) // If p is root return null
						return null;
					else // else return parent
						return parent.getObj();
				}
			} else { // else perform inOrder traversal and manual comparison
				search(root, list);
				return nullSucc(list, k);
			}
		}
	}

	/**
	 * method retrieve
	 * 
	 * @return node if in dictionary else null
	 */
	private BinNode<DataItem> retrieve(BinNode<DataItem> node, Key k) {
		if (node.getObj().getKey().compareTo(k) == 0)
			return node; // return node if found
		else if (node.getLeft() != null && node.getObj().getKey().compareTo(k) > 0)
			return retrieve(node.getLeft(), k); // call recursive method if lesser
		else if (node.getRight() != null && node.getObj().getKey().compareTo(k) < 0)
			return retrieve(node.getRight(), k); // call recursive method if greater
		else {
			return null; // return null if not in dictionary
		}
	}

	/**
	 * method search
	 * 
	 * @param node, list
	 * 
	 *              performs an inOrder traversal and populates list
	 */
	private void search(BinNode<DataItem> node, DataList list) {
		if (node.getLeft() != null)
			search(node.getLeft(), list); // call recursive method on left child
		list.add(node.getObj()); // add node to list
		if (node.getRight() != null)
			search(node.getRight(), list); // call recursive method on right child
	}

	/**
	 * method nullSucc
	 * 
	 * @return successor
	 */
	private DataItem nullSucc(DataList list, Key k) {
		DataItem compare = root.getObj();
		DataNode curr = list.getHead();
		while (curr.getNext() != null) { // traverse list
			if (compare.getKey().compareTo(curr.getElem().getKey()) > 0 && compare.getKey().compareTo(k) > 0)
				compare = curr.getElem(); // find smallest value greater than k
			curr = curr.getNext();
		}
		return compare; // return successor
	}

	/**
	 * method predecessor
	 * 
	 * @return predecessor
	 */
	public DataItem predecessor(Key k) {
		DataList list = new DataList();
		BinNode<DataItem> p, parent;
		if (isEmpty())
			return null; // if no successor is possible return null
		else if (size == 1) { // if root is leaf
			if (root.getObj().getKey().compareTo(k) < 0)
				return root.getObj(); // return root if it is successor
			else
				return null; // else return null
		} else {
			p = retrieve(root, k);
			if (p != null) { // if k is in dictionary
				if (p.getLeft() != null)
					return internalLargest(p.getLeft()); // call helper method
				else {
					parent = p.getParent();
					while (p != root && parent.getLeft() == p) { // while p is not root
						p = parent;
						parent = p.getParent();
					}
					if (p == root) // If p is root return null
						return null;
					else // else return parent
						return parent.getObj();
				}
			} else {
				search(root, list);
				return nullPred(list, k);
			}
		}
	}

	/**
	 * method nullPred
	 * 
	 * @return predecessor
	 */
	private DataItem nullPred(DataList list, Key k) {
		DataItem compare = root.getObj();
		DataNode curr = list.getHead();
		while (curr.getNext() != null) { // traverse list
			if (compare.getKey().compareTo(curr.getElem().getKey()) < 0 && compare.getKey().compareTo(k) < 0)
				compare = curr.getElem(); // find largest value lesser than k
			curr = curr.getNext();
		}
		return compare; // return predecessor
	}

	/**
	 * method smallest
	 * 
	 * @return smallest
	 */
	public DataItem smallest() {
		if (isEmpty())
			return null; // return null if empty
		else if (size == 1)
			return root.getObj(); // return root if leaf
		else
			return internalSmallest(root); // else call helper method
	}

	/**
	 * method internalSmallest
	 * 
	 * @return smallest
	 */
	private DataItem internalSmallest(BinNode<DataItem> node) {
		if (node.getLeft() == null)
			return node.getObj(); // return node if smallest is found
		else {
			return internalSmallest(node.getLeft()); // else call recursive method
		}
	}

	/**
	 * method largest
	 * 
	 * @return largest
	 */
	public DataItem largest() {
		if (isEmpty())
			return null; // return null if empty
		else if (size == 1)
			return root.getObj(); // return root if leaf
		else
			return internalLargest(root); // else call helper method
	}

	/**
	 * method internalLargest
	 * 
	 * @return largest
	 */
	private DataItem internalLargest(BinNode<DataItem> node) {
		if (node.getRight() == null)
			return node.getObj(); // return node if largest if found
		else {
			return internalLargest(node.getRight()); // else call recursive method
		}
	}

	/**
	 * method isEmpty()
	 * 
	 * Return true if empty
	 * 
	 * else return false
	 * 
	 * @return size == 0
	 */
	private boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * method size()
	 * 
	 * Returns the number of nodes
	 * 
	 * @return size
	 */
	private int size() {
		return size;
	}

}
