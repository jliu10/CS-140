public class liu_BinarySearchTree implements BinarySearchTreeFunctions
{
	private Node root;

	public liu_BinarySearchTree()
	{
		root = null;
	}

	public Node getRoot()
	{
		return root;
	}

	public void setRoot(Node root)
	{
		this.root = root;
	}

/*
	private void insertNode(Node z, Node currentNode) {
		if(z.getKey() < currentNode.getKey()) {
			if(currentNode.getLeft() != null) { // will go to the left, so need to check if it's not the end
				insertNode(z, currentNode.getLeft());
			}
			else { // found a spot
				currentNode.setLeft(z);
				z.setParent(currentNode);
			}
		}
		else if(z.getKey() > currentNode.getKey()) {
			if(currentNode.getRight() != null) {
				insertNode(z, currentNode.getRight());
			}
			else {
				currentNode.setRight(z);
				z.setParent(currentNode);
			}
		}
		// do not add z if key is duplicate
	}
*/

	public void insertNode(Node z)
	{
		/* recursive
		if(root == null) root = z;
		else insertNode(z, root);
		// */

		////////////////////

		/* non-recursive */
		// /*
		if(root == null) root = z;
		else {
			boolean reachedEnd = false;
			Node currentNode = root;
			while(!reachedEnd) { // while(true) and use breaks?
				if(z.getKey() < currentNode.getKey()) {
					// currentNode has no left child
					if(currentNode.getLeft() == null) {
						z.setParent(currentNode);
						currentNode.setLeft(z);
						reachedEnd = true;
					}
					else {
						currentNode = currentNode.getLeft();
					}
				}
				else if(z.getKey() > currentNode.getKey()) {
					// currentNode has no right child
					if(currentNode.getRight() == null) {
						z.setParent(currentNode);
						currentNode.setRight(z);
						reachedEnd = true;
					}
					else {
						currentNode = currentNode.getRight();
					}
				}
				else { // don't add duplicates
					reachedEnd = true;;
				}
			}
		}
		// */
	}

	public void preOrderWalk(Node x)
	{
		if( x != null )
		{
			System.out.println(x.toString());
			preOrderWalk(x.getLeft());
			preOrderWalk(x.getRight());
		}
	}

	public void preOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if( x != null )
		{
			list.add(x.toString());
			preOrderWalk(x.getLeft(), list);
			preOrderWalk(x.getRight(), list);
		}
	}

	public void preOrderWalk(Node x, String id, java.util.ArrayList<String> result)
	{
		if( x != null )
		{
			System.out.println(x.toString() + " " + id);
			result.add(x.getKey() + " " + id);
			preOrderWalk(x.getLeft(), "0"+id, result);
			preOrderWalk(x.getRight(), "1"+id, result);
		}
	}

	public void inOrderWalk(Node x)
	{
		if( x != null ) {
			inOrderWalk(x.getLeft());
			System.out.println(x); // for us, this will equate to System.out.println(x.toString())
			inOrderWalk(x.getRight());
		}
	}

	public void inOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if( x != null ) {
			inOrderWalk(x.getLeft(), list);
			list.add(x.toString()); // for us, this will equate to nodeList.add(x.toString())
			inOrderWalk(x.getRight(), list);
		}
	}

	public void postOrderWalk(Node x)
	{
		if( x != null ) {
			postOrderWalk(x.getLeft());
			postOrderWalk(x.getRight());
			System.out.println(x); // for us, this will equate to System.out.println(x.toString())
		}
	}

	public void postOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if( x != null ) {
			postOrderWalk(x.getLeft(), list);
			postOrderWalk(x.getRight(), list);
			list.add(x.toString());
		}
	}

//	x is the root
	public Node getMax(Node x)
	{
		if(x.getRight() == null) return x;

		return getMax(x.getRight());
	}

//	x is the root
	public Node getMin(Node x)
	{
		if(x.getLeft() == null) return x;

		return getMin(x.getLeft());
	}

//	The node having the smallest key value greater than the node's key
	public Node getSuccessor(Node x)
	{
		if(x.getRight() != null) return getMin(x.getRight());
		Node y = x.getParent();
		while(y != null && x.equals(y.getRight())) {
			x = y;
			y = y.getParent();
		}
		return y;
	}

//	The node having the largest key value smaller than the node's key
	public Node getPredecessor(Node x)
	{
		if(x.getLeft() != null) return getMax(x.getLeft());
		Node y = x.getParent();
		while(y != null && x.equals(y.getLeft())) {
			x = y;
			y = y.getParent();
		}
		return y;
	}

//	Start search at root x
	public Node getNode(Node x, int key)
	{

		if(x == null || x.getKey() == key) return x;
		if(x.getKey() > key) return getNode(x.getLeft(), key);
		return getNode(x.getRight(), key);

		// return null;
	}

	private int getHeight(Node x, int count) {
		if(x == null) return count;
		return Math.max( getHeight(x.getLeft(), count + 1), getHeight(x.getRight(), count + 1));
	}

//	Return the height of the tree rooted at x
	public int getHeight(Node x)
	{
		return getHeight(x, -1);
	}

	public void shiftNode(Node u, Node v)
	{

		// if(root.equals(u)) setRoot(v);
		if(u.getParent() == null) setRoot(v);
		else {
			if(u.equals(u.getParent().getLeft())) u.getParent().setLeft(v);
			else u.getParent().setRight(v);
		}
		if(v != null) v.setParent(u.getParent());

	}

//	uses shiftNode()
	public void deleteNode(Node z)
	{
		if( z.getLeft() == null ) { // if 0 or 1 children
			shiftNode(z, z.getRight()); // directly replace z with child
		}
		else {
			if( z.getRight() == null ) { // if 0 children
				shiftNode(z, z.getLeft()); // directly replace z with child
			}
			else { // 2 children
				Node y = getSuccessor(z); // get z's successor, y
				if( y.getParent() != z ) { // y is not z's child
					shiftNode(y, y.getRight()); // replace y with right child
					y.setRight(z.getRight()); // update z's former right child
					y.getRight().setParent(y); // update z's former right child
				}
				shiftNode(z, y); // replace z with y
				y.setLeft(z.getLeft()); // update z's former left child
				y.getLeft().setParent(y); // update z's former left child
			}
		}
	}
}
