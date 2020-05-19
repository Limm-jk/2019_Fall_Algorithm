
public class Node {
	private String _element;
	private int _rank;
	private Node p;
	private Node _next;
	
	public Node() {
		this._element = null;
		this._rank = 0;
		this.p = null;
		this._next = null;
	}
	public Node(String givenE) {
		this._element = givenE;
		this._rank = 0;
		this.p = null;
		this._next = null;
	}
	public Node(String givenE, int givenN) {
		this._element = givenE;
		this._rank = givenN;
		this.p = null;
		this._next = null;
	}
	
	public String element() {
		return this._element;
	}
	public void setElement(String newE) {
		this._element = newE;
	}
	public int rank() {
		return this._rank;
	}
	public void setrank(int newrank) {
		this._rank = newrank;
	}
	public Node p() {
		return this.p;
	}
	public void setp(Node newp) {
		this.p = newp;
	}
	public Node next() {
		return this._next;
	}
	public void setnext(Node newN) {
		this._next = newN;
	}
}
