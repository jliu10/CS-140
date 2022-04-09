public class BinarySearchTree implements BinarySearchTreeFunctions
{
	private Node root;

	public BinarySearchTree()
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

	public void insertNode(Node z)
	{
		/* recursive
		if(root == null) root = z;
		else insertNode(z, root);
		*/

		////////////////////

		/* non-recursive */
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
	}

	public void inOrderWalk(Node x, java.util.ArrayList<String> list)
	{
	}

	public void postOrderWalk(Node x)
	{
	}

	public void postOrderWalk(Node x, java.util.ArrayList<String> list)
	{
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
		return null;
	}

//	The node having the largest key value smaller than the node's key
	public Node getPredecessor(Node x)
	{
		return null;
	}

	public Node getNode(Node x, int key)
	{
		return null;
	}

	public int getHeight(Node x)
	{
		return 0;
	}

	public void shiftNode(Node u, Node v)
	{

	}

//	uses shiftNode()
	public void deleteNode(Node z)
	{
	}
}
