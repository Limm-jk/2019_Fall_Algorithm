
public class UnionFind {
	public void make_set(Node x) { 
		x.setp(x);
	}
	
	public Node find_set(Node x) { 	
		if(x.p()==x) 
				return x; 
		else
			return find_set(x.p()); //노드 x가 속한 트리의 루트 노드를 반환
	}
	
	public boolean union(Node x, Node y) { //노드 x가 속한 집합과 노드 y가 속한 집합을 합침
		Node x1 = find_set(x);
		
		Node y1 = find_set(y);
		if(x1 == y1) //x==y인 경우 union할 거 없음(예외처리)
			return false;
		else { 
			if(x1.rank()>y1.rank())
				y1.setp(x1);//x1이 y트리의 루트가 됨
			else {
				x1.setp(y1);
				if(x1.rank() == y1.rank())
					y1.setrank(y1.rank()+1);
			}
			return true;
		}
	}
}
