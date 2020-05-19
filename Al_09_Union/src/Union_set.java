import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Union_set {
	private UnionFind _uf = new UnionFind();
	private linkedList _link = new linkedList();
	public void fileInput(String filename) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader Buf = new BufferedReader(new FileReader(filename));
		//Buf->File length->길이측정
		String a = Buf.readLine();
		String [] aarr = a.split(" ");
		for(int i = 0; i<aarr.length; i++) {
			Node node = new Node(aarr[i]);
			this._uf.make_set(node);
			this._link.add(node);
		}
       
		while(true) {
			String b = Buf.readLine();
			if(b == null) {
				break;
			}
			String [] barr = b.split(" ");
        	if(barr.length == 2) {
        		Node a1 = this._link.search(barr[0]);
        		Node a2 = this._link.search(barr[1]);
        		if(a1==null||a2==null) {
        			System.out.println("잘못된 입력입니다.");
        			return;
        		}
        		boolean uni = this._uf.union(a1, a2);
        		if(!uni)
        			System.out.println("같은 트리입니다.");
        	}
        	else if(barr.length == 1) {
        		Node fs = this._link.search(barr[0]);
        		Node root = this._uf.find_set(fs);
        		fs.setp(root);
        	}
		}
		Buf.close();
	}
	public void printele(String filename) throws IOException {
		Node cur = this._link.head();
		BufferedWriter file = new BufferedWriter(new FileWriter(filename));
		
		for(int i = 0; i<this._link.size(); i++) {
			System.out.println(cur.element()+" "+cur.p().element()+" "+this._uf.find_set(cur).element());
			file.write(cur.element()+" "+cur.p().element()+" "+this._uf.find_set(cur).element());
			file.newLine();
			cur = cur.next();
		}
		file.close();
	}
}
