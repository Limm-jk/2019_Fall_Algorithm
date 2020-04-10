package Al_07_201602057_¿”¡ÿ±‘;

public class BinaryNode {
	private String _color;
	private int _element;
	private BinaryNode _left;
	private BinaryNode _right;
	private BinaryNode p;
	
	public BinaryNode() {
		this._element = 0;
		this._right = null;
		this._left =null;
		this.p = null;
		this._color = null;
	}
	public BinaryNode(int givenE) {
		this._element = givenE;
		this._right = null;
		this._left = null;
		this._color = null;
	}
	public BinaryNode(String givenC) {
		this._element = 0;
		this._right = null;
		this._left =null;
		this.p = null;
		this._color = givenC;
	}
	public BinaryNode(int givenE, String givenC) {
		this._element = givenE;
		this._right = null;
		this._left = null;
		this._color = givenC;
	}
	public BinaryNode(int givenE, BinaryNode givenN, BinaryNode givenP, String givenC) {
		this._element = givenE;
		this._left = givenP;
		this._right = givenN;
		this._color = givenC;
	}
	
	public boolean hasleft() {
		return (this._left != null);
	}
	public boolean hasright() {
		return (this._right != null);
	}
	public boolean isNL() {
		return (this._left == null) && (this._right == null);
	}
	
	public int element() {
		return this._element;
	}
	public void setElement(int newE) {
		this._element = newE;
	}
	public BinaryNode left() {
		return this._left;
	}
	public void setleft(BinaryNode newleft) {
		this._left = newleft;
	}
	public BinaryNode right() {
		return this._right;
	}
	public void setright(BinaryNode newright) {
		this._right = newright;
	}
	public BinaryNode p() {
		return this.p;
	}
	public void setp(BinaryNode newp) {
		this.p = newp;
	}
	public String color(){
	    return this._color;
	}
	public void setcolor(String color){
	    this._color = color;
	}
}