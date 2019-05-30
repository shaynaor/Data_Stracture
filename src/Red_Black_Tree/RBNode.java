package Red_Black_Tree;

public class RBNode {
	int data;
	RBNode left , right, parent;
	boolean isBlack , isLeftChild;
	
	public RBNode(int data) {
		this.data = data;
		isBlack = isLeftChild = false;
	}
}
