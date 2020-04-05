package al_06_201602057_임준규;

public class CompleteBinaryTree {
	private int level;
	
	public CompleteBinaryTree() {
		this.level=0;
	}
	
	public void TreeInsert(Tree T, int key) {
		BinaryNode z = new BinaryNode(key);
		BinaryNode y = new BinaryNode();
		BinaryNode x = T.root();
		this.level = 1;
		if(T.root() == null) {
			T.setroot(z);
			System.out.println(key+"값이 투입되었습니다");
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
		System.out.println(key+"값이 투입되었습니다");
		if(this.level>=T.depth())
			T.setdep(this.level);
	}
	
	public void medianInsert(Tree T, int[] arr, int start, int end) {
		
		if((end - start + 1) < 1)
			return;
		int median = (start + end)/2;
		BinaryNode n = this.IterativeSearch(T.root(), arr[median]);
		if(n==null) {
			TreeInsert(T, arr[median]);			
		}
		else {
			System.out.println("값이 중복되었습니다.");
		}
		
		medianInsert(T, arr, start, median-1);
		medianInsert(T, arr, median+1, end);
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
		while(root != null && key != root.element()) {
			if(key < root.element())
				root = root.left();
			else
				root = root.right();
		}
		if(root == null) {
			return null;
		}
		else {
			return root;
		}
	}
	
	public BinaryNode Successor(BinaryNode root) { //오른쪽 서브트리의 최솟값			
		if(root.right()!=null)
			return this.TreeMinimum(root.right());
		BinaryNode y = root.p();
		while(y!=null && root == y.right()) {
			root = y;
			y = y.p();
		}
		return y;
	}
	public BinaryNode Predecessor(BinaryNode root) { //왼쪽 서브트리의 최댓값
		BinaryNode predecessor = null;
		BinaryNode predecessorParent = null;
		BinaryNode current = root.left();//삭제할 노드의 왼쪽 자식을 current에 저장
			
		while(current != null) {
			predecessorParent = predecessor;
			predecessor = current;
			current = current.right();//오른쪽 자식 찾음
		}
		if(predecessor != root.left()) { //predecessor가 삭제할 노드의 왼쪽 자식이 아닌 경우
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
		System.out.println(z.element()+"값이 삭제되었습니다.");
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
