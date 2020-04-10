package Al_07_201602057_���ر�;

public class CompleteBinaryTree {
	private int level;
	private int _count;
	
	public CompleteBinaryTree() {
		this.level=0;
		this._count = 0;
	}
	public int count() {
		return this._count;
	}
	public void TreeInsert(Tree T, int key) {
		BinaryNode z = new BinaryNode(key);
		BinaryNode y = new BinaryNode();
		BinaryNode x = T.root();
		this.level = 1;
		if(T.root() == null) {
			T.setroot(z);
			System.out.println(key+"���� ���ԵǾ����ϴ�");
			return;
		}
		while(x!=null) {
			y = x;
			if(z.element() < x.element()) {
				x = x.left();
			}
			else {
				x = x.right();
			}
			this.level++;
		}
		z.setp(y);
		if(z.element() < y.element()) {
			y.setleft(z);
		}
		else {
			y.setright(z);
		}
		System.out.println(key+"���� ���ԵǾ����ϴ�");
		if(this.level>=T.depth())
			T.setdep(this.level);
	}
	

	
	public boolean RecursiveSearch(BinaryNode root, int key) {
	
		if(root == null ) {
			return false;
		}
		else if(key == root.element()) {
			return true;
		}
		if(key < root.element())
			return this.RecursiveSearch(root.left(), key);
		else
			return this.RecursiveSearch(root.right(), key);
	}
	public BinaryNode IterativeSearch(BinaryNode root, int key) {	
		this._count = 0;
		while(root != null && key != root.element()) {
			if(key < root.element())
				root = root.left();
			else
				root = root.right();
			this._count++;
		}
		if(root == null) {
			return null;
		}
		else {
			return root;
		}
	}
	
	public BinaryNode Successor(BinaryNode root) { //������ ����Ʈ���� �ּڰ�			
		if(root.right()!=null)
			return this.TreeMinimum(root.right());
		BinaryNode y = root.p();
		while(y!=null && root == y.right()) {
			root = y;
			y = y.p();
		}
		return y;
	}
	public BinaryNode Predecessor(BinaryNode root) { //���� ����Ʈ���� �ִ�
		BinaryNode predecessor = null;
		BinaryNode predecessorParent = null;
		BinaryNode current = root.left();//������ ����� ���� �ڽ��� current�� ����
			
		while(current != null) {
			predecessorParent = predecessor;
			predecessor = current;
			current = current.right();//������ �ڽ� ã��
		}
		if(predecessor != root.left()) { //predecessor�� ������ ����� ���� �ڽ��� �ƴ� ���
			predecessorParent.setright(predecessor.right());
			predecessor.setleft(root.right());
		}
		return predecessor;
	}
	public void Delete(Tree T, BinaryNode z) {
		if(z.left()==null) {
			this.Transplant(T, z, z.right());
		}
		else if(z.right()==null) {
			this.Transplant(T, z, z.left());
		}
		else {
			BinaryNode y = this.TreeMinimum(z.right());
			if(y.p()!=z) {
				this.Transplant(T, y, y.right());
				y.setright(z.right());
				y.right().setp(y);
			}
			this.Transplant(T, z, y);
			y.setleft(z.left());
			y.left().setp(y);
		}
		System.out.println(z.element()+"���� �����Ǿ����ϴ�.");
		T.setdep(this.TravelNDepth(T.root()));
	}
	private void Transplant(Tree T, BinaryNode u, BinaryNode v) {
		
		if(u.p()==null) {
			T.setroot(v);
		}
		else if(u == u.p().left()) {
			u.p().setleft(v);
		}
		else {
			u.p().setright(v);
		}
		if(v!=null) {
			v.setp(u.p());
		}
	}
	private BinaryNode TreeMinimum(BinaryNode root) {
		BinaryNode y = root;
		while(y.left() != null) {
			y = y.left();
		}
		return y;
	}
	private int TravelNDepth(BinaryNode root) {
		if(root == null) return 0;
		
		int ldep = this.TravelNDepth(root.left());
		int rdep = this.TravelNDepth(root.right());
		
		if(ldep > rdep)
			return ldep + 1;
		else
			return rdep + 1;
	}
}
