
public class UnionFind {
	public void make_set(Node x) { 
		x.setp(x);
	}
	
	public Node find_set(Node x) { 	
		if(x.p()==x) 
				return x; 
		else
			return find_set(x.p()); //��� x�� ���� Ʈ���� ��Ʈ ��带 ��ȯ
	}
	
	public boolean union(Node x, Node y) { //��� x�� ���� ���հ� ��� y�� ���� ������ ��ħ
		Node x1 = find_set(x);
		
		Node y1 = find_set(y);
		if(x1 == y1) //x==y�� ��� union�� �� ����(����ó��)
			return false;
		else { 
			if(x1.rank()>y1.rank())
				y1.setp(x1);//x1�� yƮ���� ��Ʈ�� ��
			else {
				x1.setp(y1);
				if(x1.rank() == y1.rank())
					y1.setrank(y1.rank()+1);
			}
			return true;
		}
	}
}
