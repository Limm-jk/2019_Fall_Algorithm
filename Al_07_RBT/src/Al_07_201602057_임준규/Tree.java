package Al_07_201602057_¿”¡ÿ±‘;

public class Tree {
	private BinaryNode _root;
	private int _dep;
	
	public Tree() {
		this._root =null;
		this._dep =0 ;
	}
	public Tree(BinaryNode root) {
		this._root = root;
	}
	
	public BinaryNode root() {
		return this._root;
	}
	public void setroot(BinaryNode N) {
		this._root = N;
	}
	public int depth() {
		return this._dep;
	}
	public void setdep(int n) {
		this._dep = n;
	}
	
}
