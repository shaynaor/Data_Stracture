package AVL_Tree;

public class AVLNode {
	private int data , descendants;
	private AVLNode right , left , parent;
	
	public AVLNode (int data) {
		this.data = data;
		this.left = this.right = this.parent = null;
		this.descendants = 0;
	}
	//******GETTERS & SETTERS********///

	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public AVLNode getRight() {
		return this.right;
	}

	public void setRight(AVLNode right) {
		this.right = right;
	}

	public AVLNode getLeft() {
		return this.left;
	}

	public void setLeft(AVLNode left) {
		this.left = left;
	}

	public AVLNode getParent() {
		return this.parent;
	}

	public void setParent(AVLNode parent) {
		this.parent = parent;
	}
	//
	public int getDescendants() {
		return this.descendants;
	}

	public void setDescendants(int descendants) {
		this.descendants = descendants;
	}
	
}
