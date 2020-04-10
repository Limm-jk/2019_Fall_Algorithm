package Al_07_201602057_���ر�;

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
			System.out.println(key+"���� ���ԵǾ����ϴ�");
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
		System.out.println(key+"���� ���ԵǾ����ϴ�");

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
					if(y.right() == z) {//�θ��带 �ڽĳ���� left�� ������
						y.p().setright(z);//���¸� ��������.
						z.setleft(y);//���� ����Ʈ������ ���� ������ ��������带 �ֻ�����.
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
					if(y.right() == z) {//�θ��带 �ڽĳ���� left�� ������
						y.p().setleft(z);//���¸� ��������.
						z.setleft(y);//���� ����Ʈ������ ���� ������ ��������带 �ֻ�����.
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
			if(newright) {//restructing���� �ּҰ�����. �Ʒ��� �Ȱ���
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
				//��Ʈ�� �����ϴ°��� �ƴ� ���θ����� �θ��忡�� ������ ��带 �ٿ���
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
		//���� ���Ե� ��尡 �θ� ����� �����ʿ� �پ��ִ��� ���θ� �����Ͽ� ������ �����Ѵ�.
		if(right){
			newNode.setcolor(black);
			parentNode.setcolor(red);
			parentNode.left().setcolor(black);

		}else{
			newNode.setcolor(black);
			parentNode.setcolor(red);
			parentNode.right().setcolor(black);
		}
		//�θ��尡 ����Ʈ�� ����� ��� black���� �ٲ��ش�.
		if(parentNode == T.root()){
			parentNode.setcolor(black);
		}else{
			if(parentNode.p().color() == red){
				//reColoring�� �ݺ����ش�.
				if(this.findNode(parentNode.p()).color() == red){
					if(parentNode.p().right() == parentNode){
						Recoloring(T, parentNode.p(), parentNode.p().p(), true);
					}
					else Recoloring(T , parentNode.p(), parentNode.p().p(), false);
				}else{
					//p.p�� red�ε� ���� ��尡 black�� ���
					//reStructing�� �������ش�.
					if(parentNode.p().right() == parentNode){
						//p.p�� �θ��带 �������ش�.
						//������ p.p�� ���ο� ���� �ν��ϰ� �����δ�.
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
