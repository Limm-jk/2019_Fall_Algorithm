
public class Node {
	
	private int _element;
	private Node _prev;
	private Node _next;
	
	public Node() {
		this._element = 0;
		this._next = null;
		this._prev =null;
	}
	public Node(int givenE) {
		this._element = givenE;
		this._next = null;
		this._prev = null;
	}
	public Node(int givenE, Node givenN, Node givenP) {
		this._element = givenE;
		this._prev = givenP;
		this._next = givenN;
	}
	
	public int element() {
		return this._element;
	}
	public void setElement(int newE) {
		this._element = newE;
	}
	
	public Node prev() {
		return this._prev;
	}
	public void setPrev(Node newP) {
		this._prev = newP;
	}
	
	public Node next() {
		return this._next;
	}
	public void setNext(Node newN) {
		this._next = newN;
	}
}