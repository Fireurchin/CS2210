/**
 * Implements code for node for BST
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 2
 *
 */
public class BinNode<T> {
	private BinNode<T> left, right, parent; // initialize child and parent nodes
	private DataItem object; // initialize nested object

	/**
	 * method BinNode
	 * 
	 * @param obj
	 * 
	 *            data object to create leaf node of BST
	 */
	public BinNode() { // constructor for node
		object = null; // no object can be stored in leaves
	}

	/**
	 * method BinNode
	 * 
	 * @param obj
	 * 
	 *            data object to create and populate internal node of BST
	 */
	public BinNode(DataItem obj) {
		setObj(obj);
		parent = null; // Set the parent to null
		left = null; // Set left child to null
		right = null; // set right child to null
	}

	/**
	 * method getLeft
	 * 
	 * @return Left
	 * 
	 *         points to left child
	 */
	public BinNode<T> getLeft() {
		return left; // return left child
	}

	/**
	 * method getRight
	 * 
	 * @return right
	 * 
	 *         points to right child
	 */
	public BinNode<T> getRight() {
		return right; // return right child
	}

	/**
	 * method getParent
	 * 
	 * @return parent
	 * 
	 *         points to parent node
	 */
	public BinNode<T> getParent() {
		return parent; // return right parent
	}

	/**
	 * method getObj
	 * 
	 * @return obj
	 * 
	 *         points to DataItem object stored in node
	 */
	public DataItem getObj() {
		return object; // return object stored in node
	}

	/**
	 * method setLeft
	 * 
	 * @param Left
	 * 
	 *             sets Left to point at specified node
	 */
	public void setLeft(BinNode<T> left) {
		this.left = left; // set Left node
	}

	/**
	 * method setRight
	 * 
	 * @param right
	 * 
	 *              sets right to point at specified node
	 */
	public void setRight(BinNode<T> right) {
		this.right = right; // set right node
	}

	/**
	 * method setObj
	 * 
	 * @param obj
	 * 
	 *            sets DataItem object to point at specific data
	 */
	public void setObj(DataItem obj) {
		object = obj; // store object in node
	}

	/**
	 * method setParent
	 * 
	 * @param parent
	 * 
	 *               sets parent of node
	 */
	public void setParent(BinNode<T> parent) {
		this.parent = parent; // store object in node
	}

	/**
	 * method isLeaf
	 * 
	 * @return true if leaf
	 */
	public boolean isLeaf() {
		return ((left == null) && (right == null)); // return true if leaf
	}

	/**
	 * method numChildren
	 * 
	 * @return number of child nodes
	 */
	public int numChildren() {
		int k = 0;

		if (left != null)
			k = left.numChildren() + 1; // increment k by 1 for every left child that exists

		if (right != null)
			k = k + right.numChildren() + 1; // increment k by 1 for every right child that exists

		return k;
	}
}
