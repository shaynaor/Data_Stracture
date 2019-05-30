package binary_Search_Tree;

public class Tnode {
	private Tnode father, right, left;
	private int data;

	public Tnode(int data) {
		this.data = data;
	}
	//// *****GETTERS AND SETTERS*******/////

	public void setFather(Tnode father) {
		this.father = father;
	}

	public Tnode getFather() {
		return this.father;
	}

	public void setRight(Tnode right) {
		this.right = right;
	}

	public Tnode getRight() {
		return this.right;
	}

	public void setLeft(Tnode left) {
		this.left = left;
	}

	public Tnode getLeft() {
		return this.left;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}
}
