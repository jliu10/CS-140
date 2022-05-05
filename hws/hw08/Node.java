public class Node implements NodeFunctions
{
	private final int key;
	private Node parent;
	private Node left;
	private Node right;

	public Node(int key)
	{
		this.key = key;
		parent = null;
		left = null;
		right = null;
	}

	public int getKey()
	{
		return key;
	}

	public Node getParent()
	{
		return parent;
	}

	public Node getLeft()
	{
		return left;
	}

	public Node getRight()
	{
		return right;
	}

	public void setLeft(Node n)
	{
		left = n;
	}

	public void setRight(Node n)
	{
		right = n;
	}

	public void setParent(Node n)
	{
		parent = n;
	}

/** Returns (x,y,z,w)
*	x, y, z, w are the Node's key, parent key, left child key,
*	and right child key (blank for null values)
*/
	public String toString()
	{
		String y, z, w;
		y = z = w = "";

		if(parent != null) y += parent.getKey();
		if(left != null) z += left.getKey();
		if(right != null) w += right.getKey();

		return "(" + key + "," + y + "," + z + "," + w + ")";
	}

//	Returns true for a Node having the same key
	public boolean equals(Object o)
	{
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		return key == ((Node)o).getKey();
	}
}
