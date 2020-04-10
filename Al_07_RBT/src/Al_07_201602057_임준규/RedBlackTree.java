package Al_07_201602057_임준규;

public class RedBlackTree {
	private String black = "black";
	private String red = "red";
	private int _count;
	private BinaryNode NIL;

	public RedBlackTree() {
		this._count = 0;
		this.NIL = new BinaryNode(black);
	}
	public int count() {
		return this._count;
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
	public void Insert(Tree T, int key) {
		BinaryNode z = new BinaryNode(key,NIL,NIL,red);
		BinaryNode y = new BinaryNode();
		BinaryNode x = T.root();

		if(T.root() == null) {
			z.setcolor(black);
			T.setroot(z);
			System.out.println(key+"값이 투입되었습니다");
			return;
		}
		while(x!=NIL) {
			y = x;
			if(z.element() < x.element()) {
				x = x.left();
			}
			else {
				x = x.right();
			}
		}
		z.setp(y);

		if(z.element() < y.element()) {
			y.setleft(z);
		}
		else {
			y.setright(z);
		}
		System.out.println(key+"값이 투입되었습니다");

		if(y.p() == null)
			return;

		if(y.color() == red) {
			boolean right = true;
			if(y.p().left() == y) 
				right = false;
			if(y.p().right() == y) {
				if(y.p().left().color() == red) {//case1
					Recoloring(T, y, y.p(), right);
				}
				else {
					if(y.right() == z) {//부모노드를 자식노드의 left에 투입해
						y.p().setright(z);//형태를 통일해줌.
						z.setleft(y);//이후 리스트럭팅을 통해 무조건 최하위노드를 최상위로.
						y.setright(NIL);
						Restructing(T, y,z,y.p(), right);
					}
					else {
						Restructing(T, z,y,y.p(), right);
					}
				}
			}
			else {
				if(y.p().right().color() == red) {//case1
					Recoloring(T, y, y.p(), right);
				}
				else {
					if(y.right() == z) {//부모노드를 자식노드의 left에 투입해
						y.p().setleft(z);//형태를 통일해줌.
						z.setleft(y);//이후 리스트럭팅을 통해 무조건 최하위노드를 최상위로.
						y.setright(NIL);
						Restructing(T, y,z,y.p(), right);
					}
					else {
						Restructing(T, z,y,y.p(), right);
					}
				}
			}
		}
	}
	private void Restructing(Tree T, BinaryNode bot, BinaryNode mid, BinaryNode top, boolean newright) {
		BinaryNode right = NIL;
		BinaryNode left = NIL;

		if(bot.right() != NIL)
			right = bot.right();
		if(bot.left() != NIL)
			right = bot.left();

		if(top.p() == null) {
			if(newright) {//restructing실행 주소값지정. 아래도 똑같음
				top.setright(left);
				left.setp(top);
				top.setp(bot);
				mid.setleft(right);
				right.setp(mid);
				mid.setp(bot);
				bot.setleft(top);
				bot.setright(mid);
				bot.setp(null);

				bot.setcolor(black);
				top.setcolor(red);
				mid.setcolor(red);
				T.setroot(bot);
			}
			else {
				if(mid.right() != NIL) {
					top.setleft(mid.right());
					mid.right().setp(top);
				}
				else {
					top.setleft(NIL);
				}
				mid.setright(top);
				top.setp(mid);
				mid.setp(null);
				mid.setcolor(black);
				top.setcolor(red);
				T.setroot(mid);
			}
		}
		else {
			BinaryNode toppp = top.p(); 
			if(newright){
				top.setright(left);
				left.setp(top);
				top.setp(bot);
				mid.setleft(right);
				right.setp(mid);
				mid.setp(bot);
				bot.setleft(top);
				bot.setright(mid);
				bot.setp(null);

				bot.setcolor(black);
				top.setcolor(red);
				mid.setcolor(red);
				//루트로 설정하는것이 아닌 조부모노드의 부모노드에게 수정된 노드를 붙여줌
				if(top.p().right() == top) {
					top.p().setright(bot);
					bot.setp(top.p());
				}
				else {
					top.p().setleft(mid);
					mid.setp(top.p());
				}
			}
			else{
				if(mid.right() != NIL){
					top.setleft(mid.right());
					mid.right().setp(top);
				}
				else{
					top.setleft(NIL);
				}
				mid.setright(top);
				top.setp(mid);

				mid.setcolor(black);
				top.setcolor(red);
				if(toppp.right() == top) 
					toppp.setright(mid);
				else 
					toppp.setleft(mid);
				mid.setp(toppp);
			}
		}
	}
	public void Recoloring(Tree T, BinaryNode newNode, BinaryNode parentNode, boolean right){
		//새로 삽입된 노드가 부모 노드의 오른쪽에 붙어있는지 여부를 구분하여 색깔을 설정한다.
		if(right){
			newNode.setcolor(black);
			parentNode.setcolor(red);
			parentNode.left().setcolor(black);

		}else{
			newNode.setcolor(black);
			parentNode.setcolor(red);
			parentNode.right().setcolor(black);
		}
		//부모노드가 리스트의 헤드일 경우 black으로 바꿔준다.
		if(parentNode == T.root()){
			parentNode.setcolor(black);
		}else{
			if(parentNode.p().color() == red){
				//reColoring을 반복해준다.
				if(this.findNode(parentNode.p()).color() == red){
					if(parentNode.p().right() == parentNode){
						Recoloring(T, parentNode.p(), parentNode.p().p(), true);
					}
					else Recoloring(T , parentNode.p(), parentNode.p().p(), false);
				}else{
					//p.p가 red인데 형제 노드가 black인 경우
					//reStructing을 설정해준다.
					if(parentNode.p().right() == parentNode){
						//p.p의 부모노드를 설정해준다.
						//지금은 p.p를 새로운 노드로 인식하고 움직인다.
						if(parentNode.p().p().right() == parentNode.p()){
							parentNode.p().p().setright(parentNode);
							parentNode.setp(parentNode.p().p());
							parentNode.setleft(parentNode.p());
							parentNode.p().setp(parentNode);
							parentNode.p().setright(parentNode.left());
							parentNode.left().setp(parentNode.p());
							Restructing(T, parentNode.p(), parentNode, parentNode.p().p(), true);
						}else {
							parentNode.p().p().setleft(parentNode);
							parentNode.setleft(parentNode.p());
							parentNode.p().setright(parentNode.left());
							Restructing(T, parentNode.p(), parentNode,  parentNode.p().p(), false);
						}
					}else{
						if(parentNode.p().p().right() ==parentNode.p())
							Restructing(T, parentNode, parentNode.p(), parentNode.p().p(), true );
						else
							Restructing(T, parentNode, parentNode.p(),parentNode.p().p(), false );
					}

				}

			}

		}
	}
	public BinaryNode findNode(BinaryNode x){
		if(x.p().left() == x) 
			return x.p().right();
		else 
			return x.p().left();
	}
}
