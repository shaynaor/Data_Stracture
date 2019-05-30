package AVL_Tree;
public class AVLTree {
	private AVLNode root;
	private int size;

	public AVLTree() {
		root = null;
		this.size = 0;
	}

	public void add(int data) {
		AVLNode node = new AVLNode(data);
		if (root == null) {
			root = node;
			size++;
			return;
		}
		add(node, root);
	}

	private void add(AVLNode node, AVLNode parent) {
		if (node.getData() > parent.getData()) {
			if (parent.getRight() == null) {
				parent.setRight(node);
				node.setParent(parent);
				size++;
				return;
			} else {
				add(node, parent.getRight());
			}
		} else {
			if (parent.getLeft() == null) {
				parent.setLeft(node);
				node.setParent(parent);
				size++;
				return;
			} else {
				add(node, parent.getLeft());
			}
		}
		checkBalance(node);
	}

	private void checkBalance(AVLNode node) {
		if (Math.abs(height(node.getLeft()) - height(node.getRight())) > 1)
			rebalance(node);
		if (node.getParent() == null)
			return;
		checkBalance(node.getParent());
	}

	public int height(AVLNode node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}

	private AVLNode leftRotation(AVLNode node) {
		AVLNode temp = node.getRight();
		AVLNode parent = node.getParent();
		node.setRight(temp.getLeft());
		if (temp.getLeft() != null)
			temp.getLeft().setParent(node);
		temp.setLeft(node);
		if (node != null)
			node.setParent(temp);
		temp.setParent(parent);
		return temp;
	}

	private AVLNode rightRotation(AVLNode node) {
		AVLNode parent = node.getParent();
		AVLNode temp = node.getLeft();
		node.setLeft(temp.getRight());
		if (temp.getRight() != null)
			temp.getRight().setParent(node);
		temp.setRight(node);
		if (node != null)
			node.setParent(temp);
		temp.setParent(parent);
		return temp;
	}

	private AVLNode rightLeftRotation(AVLNode node) {
		node.setRight(rightRotation(node.getRight()));
		return leftRotation(node);
	}

	private AVLNode leftRightRotation(AVLNode node) {
		node.setLeft(leftRotation(node.getLeft()));
		return rightRotation(node);
	}

	private void rebalance(AVLNode node) {
		if ((height(node.getLeft()) - height(node.getRight())) > 1) {
			// left sub-tree problem.
			if (height(node.getLeft().getLeft()) > height(node.getLeft().getRight()))
				node = rightRotation(node);
			else
				node = leftRightRotation(node);
		} else {
			// right sub-tree problem.
			if (height(node.getRight().getLeft()) > height(node.getRight().getRight()))
				node = rightLeftRotation(node);
			else
				node = leftRotation(node);
		}
		if (node.getParent() == null)
			root = node;
	}

	public void printTree() {
		if (root != null) {
			printTree(root.getRight(), true, "");
			System.out.println(root.getData());
			printTree(root.getLeft(), false, "");

		}
	}

	private void printTree(AVLNode node, boolean isRight, String indent) {
		if (node != null) {
			printTree(node.getRight(), true, indent + (isRight ? "        " : " |      "));
			System.out.print(indent);
			if (isRight)
				System.out.print(" /");
			else
				System.out.print(" \\");
			System.out.print("----- ");
			System.out.println(node.getData());
			printTree(node.getLeft(), false, indent + (isRight ? " |      " : "        "));

		}
	}

	public void inorder() {
		inorder(root);
	}

	public void inorder(AVLNode root) {
		if (root != null) {
			inorder(root.getLeft());
			System.out.print(root.getData() + "  ");
			inorder(root.getRight());
		}
	}

	public int size() {
		return this.size;
	}

	//Q4
	public int smaller(int x) {
		AVLNode node = this.root;
		if (node == null)
			return 0;
		int numDes = 0;
		while (node != null) {
			if (node.getData() == x) {// when x == root
				if (node.getLeft() != null)
					return numDes = node.getLeft().getDescendants() + 1;
				else
					return numDes;
			} else if (node.getData() > x) {// go to the left sub-tree
				while (node.getData() > x && node.getLeft() != null)
					node = node.getLeft();
				if ((node.getLeft() == null) && (node.getRight() == null))// if node is a leaf
					return numDes = 1;
				if (node.getData() == x) {// if node =x.
					if (node.getLeft() != null)
						return numDes = node.getLeft().getDescendants() + 1;
					else
						return numDes;
				}
				if (node.getRight() == null)// if node have just left child.
					return node.getDescendants() + 1;
				if (node.getLeft() == null)
					return numDes = 1;
				if ((node.getLeft() != null) && (node.getRight() != null)) {// if node hve 2 child
					numDes = node.getLeft().getDescendants() + 2;
					if (node.getRight().getData() < x) {
						if (node.getRight().getLeft() != null)
							numDes = numDes + node.getRight().getLeft().getDescendants() + 2;
						else
							numDes = numDes + 1;
					} else if (node.getRight().getLeft() != null) {
						if (node.getRight().getLeft().getData() < x)
							numDes = numDes + node.getRight().getLeft().getDescendants() + 1;
					}
				}
				return numDes;

			} else// right sub- tree case
			if (node.getLeft() != null)// bigger then all left sub tree
				numDes = node.getLeft().getDescendants() + 2;
			while (node.getData() < x && node.getRight() != null) {// get left until the nodes not bigger yet
				node = node.getRight();
				if (node.getLeft() != null) {
					if (node.getLeft().getData() < x)
						numDes = numDes + node.getLeft().getDescendants() + 2;
				} else
					numDes++;
				if ((node.getLeft() == null) && (node.getRight() == null))
					return numDes;

			}
			if (node.getData() == x) {// if node = x.
				if (node.getLeft() != null)// all left side smaller then x.
					numDes = numDes + node.getLeft().getDescendants() + 1;
				else
					return numDes;
			}
			while (node.getData() > x && node.getLeft() != null)// while the node bigger the x go left
				node = node.getLeft();
			if (node.getData() == x) {// if node = x.
				if (node.getLeft() != null)// all left side smaller then x.
					numDes = numDes + node.getLeft().getDescendants() + 1;
				else
					return numDes;
			}
			if (node.getData() < x) {
				if (node.getRight() != null) {
					if (node.getRight().getData() < x)
						return numDes = numDes + node.getDescendants() + 1;
				}
			} else if (node.getLeft() != null)
				return numDes = numDes + node.getLeft().getDescendants() + 2;
			return numDes;
		}
		return numDes;
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		int[] arr = { 2, 0, 3, 15 };
		for (int i = 0; i < arr.length; i++) {
			tree.add(arr[i]);
		}
		tree.printTree();
		System.out.println(tree.smaller(0));
	}

}
