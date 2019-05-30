package skip_List;
public class SLNode {

	private SLNode next, previous, up, down;
	private int data;

	public SLNode(int d) {
		data = d;
	}

	public int getData() {
		return data;
	}

	public SLNode getNext() {
		return next;
	}

	public void setNext(SLNode next) {
		this.next = next;
	}

	public SLNode getPrevious() {
		return previous;
	}

	public void setPrevious(SLNode previous) {
		this.previous = previous;
	}

	public SLNode getUp() {
		return up;
	}

	public void setUp(SLNode up) {
		this.up = up;
	}

	public SLNode getDown() {
		return down;
	}

	public void setDown(SLNode down) {
		this.down = down;
	}

}