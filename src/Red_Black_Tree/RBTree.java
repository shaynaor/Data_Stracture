package Red_Black_Tree;

public class RBTree {
	RBNode root;
	int size;

	public RBTree() {
		this.root = null;
		this.size = 0;
	}

	public void Add(int data) {
		RBNode n = new RBNode(data);
		if (root == null) {
			root = n;
			size++;
			return;
		}
		Add(n, root);
	}

	public void Add(RBNode node, RBNode parent) {
		if (node.data > parent.data) {
			if (parent.right == null) {
				parent.right = node;
				node.parent = parent;
				size++;
				return;
			}
			Add(node, parent.right);
		} else {
			if (parent.left == null) {
				parent.left = node;
				node.parent = parent;
				node.isLeftChild = true;
				size++;
				return;
			}
			Add(node, parent.left);
		}
		CheckColor(node);
	}

	public void CheckColor(RBNode node) {
		if (node.parent == null)
			return;
		if (!(node.isBlack) && !(node.parent.isBlack))
			CorrectTree(node);
		CheckColor(node.parent);
	}

	public void CorrectTree(RBNode node) {
		if (node.parent.isLeftChild) {
			RBNode uncle = node.parent.parent.right;
			if (uncle == null || uncle.isBlack)
				Rotate(node);
			else {
				if (uncle != null)
					uncle.isBlack = true;
				node.parent.parent.isBlack = false;
				node.parent.isBlack = true;
				return;
			}
		} else {
			RBNode uncle = node.parent.parent.left;
			if (uncle == null || uncle.isBlack)
				Rotate(node);
			else {
				if (uncle != null)
					uncle.isBlack = true;
				node.parent.parent.isBlack = false;
				node.parent.isBlack = true;
				return;
			}
		}
	}
	
	public void Rotate(RBNode node) {
		if(node.isLeftChild) {
			if(node.parent.isLeftChild) {
			//	RightRotation(node.parent.parent);
				node.isBlack = false;
				node.parent.isBlack = true;
				if(node.parent.parent.right != null)
	//				node.parent.parent.right = false;
				return;
			}
		//	RightLeftRotation(node.parent.parent);
			node.isBlack = true;
			node.left.isBlack = false;
			node.right.isBlack = false;
			return;
		}else {
			if(!(node.isLeftChild)) {
	//			LeftRotation(node.parent.parent);
				node.isBlack = false;
				node.parent.isBlack = true;
				
			}
		}
	}
}
