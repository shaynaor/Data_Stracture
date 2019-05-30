package binary_Search_Tree;

public class BST {
	Tnode head;

	public void insert(int value) {
		Tnode temp = new Tnode(value);
		if (head == null)
			head = temp;
		else {
			Tnode current = head;
			boolean exit = false;
			while (!exit) {
				if (value < current.getData()) {
					if (current.getLeft() == null) {
						current.setLeft(temp);
						temp.setFather(current);
						exit = true;
					} else
						current = current.getLeft();
				} else {
					if (current.getRight() == null) {
						current.setRight(temp);
						temp.setFather(current);
						exit = true;
					} else
						current = current.getRight();
				}

			}
		}

	}

	public boolean contains(int value) {
		Tnode current = head;
		while (current != null) {
			if (current.getData() == value)
				return true;
			else if (value < current.getData())
				current = current.getLeft();
			else
				current = current.getRight();
		}
		return false;
	}

	public boolean delete(int value) {
		if (contains(value) == false)// check if value in the tree
			return false;
		Tnode current = head;
		while (current.getData() != value) {// where is value?
			if (value < current.getData())
				current = current.getLeft();
			else
				current = current.getRight();
		}
		Tnode father = current.getFather();
		// case 1: value = leaf/////
		if (current.getLeft() == null && current.getRight() == null) {
			if (father == null)
				head = father;
			else if (value < father.getData())
				father.setLeft(null);
			else
				father.setRight(null);
		}
		// case 2: one childe.///
		else if (current.getLeft() == null) {
			if (father == null) {
				head = current.getRight();
				head.setFather(null);
			} else if (value < father.getData()) {
				father.setLeft(current.getRight());
				current.getRight().setFather(father);
			} else {
				father.setRight(current.getRight());
				current.getRight().setFather(father);
			}
		} else if (current.getRight() == null) {
			if (father == null) {
				head = current.getLeft();
				head.setFather(null);
			} else if (value < father.getData()) {
				father.setLeft(current.getLeft());
				current.getLeft().setFather(father);
			} else {
				father.setRight(current.getLeft());
				current.getLeft().setFather(father);
			}
		}
		// case 3 : two childe.
		else {
			Tnode replace = current.getLeft();
			while (replace.getRight() != null)
				replace = replace.getRight();
			delete(replace.getData());
			current.setData(replace.getData());
		}
		return true;
	}

	public void printTree() {
		if (head != null) {
			printTree(head.getRight(), true, "");
			System.out.println(head.getData());
			printTree(head.getLeft(), false, "");

		}
	}

	private void printTree(Tnode node, boolean isRight, String indent) {
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

	public void preorder(Tnode head) {
		if (head == null)
			return;
		System.out.println(head.getData());
		preorder(head.getLeft());
		preorder(head.getRight());
	}

	public void inorder(Tnode head) {
		if (head == null)
			return;
		inorder(head.getLeft());
		System.out.println(head.getData());
		inorder(head.getRight());
	}

	public void postorder(Tnode head) {
		if (head == null)
			return;
		postorder(head.getLeft());
		postorder(head.getRight());
		System.out.println(head.getData());
	}

	public int size(Tnode head) {
		if (head == null)
			return 0;
		else
			return size(head.getLeft()) + size(head.getRight()) + 1;
	}

	public int depth(Tnode node) {// far from root?
		if (node == null || node.getFather() == null)
			return 0;
		else
			return depth(node.getFather()) + 1;
	}

	public Tnode find(int data) {// int data det the node
		if (contains(data) == false)
			return null;
		else {
			Tnode current = head;
			while (current != null) {
				if (current.getData() == data)
					break;
				else if (data < current.getData())
					current = current.getLeft();
				else
					current = current.getRight();
			}
			return current;

		}
	}

	public int height(Tnode node) {
		if (node == null || node.getLeft() == null || node.getRight() == null)
			return 0;
		else
			return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}

	public String isLeaf(int data) {
		if (contains(data) == false)
			return "not a vertex!";
		else if (height(find(data)) != 0)
			return "not a leaf! ";
		else if (height(find(data)) == 0)
			return "a leaf! ";
		else
			return "";
	}

	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(8);
		tree.insert(3);
		tree.insert(15);
		tree.insert(1);
		tree.insert(12);
		tree.insert(20);
		tree.insert(0);
		tree.insert(2);
		tree.insert(4);
		tree.insert(7);
		tree.insert(10);
		tree.insert(14);
		tree.insert(18);
		tree.insert(21);
		tree.insert(6);
		tree.printTree();
		System.out.println();
		tree.postorder(tree.head);

	}
}
