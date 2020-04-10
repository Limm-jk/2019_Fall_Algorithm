package Al_07_201602057_임준규;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class AppController {
	private AppView _appview;
	private CompleteBinaryTree _cbt;
	private RedBlackTree _rbt;
	private Tree _tree,_redtree;
	private int [] _array,_search;
	
	public AppController() {
		this._appview = new AppView();
		this._cbt = new CompleteBinaryTree();
		this._rbt = new RedBlackTree();
		this._tree = new Tree();
		this._redtree = new Tree();
	}
	
	public void run() throws IOException {
		this.fileInput();
		this.searchfileInput();
		this.select();
		
	}
	private void fileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습7주차\\Insert.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습7주차\\Insert.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  
        this._array = new int[len];

        for(int i = 0; i < len; i++)
           this._array[i]=Integer.parseInt(Buf.readLine());
       
        Buf.close();
        length.close();
	}
	private void searchfileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습7주차\\Search.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습7주차\\Search.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  
        this._search = new int[len];

        for(int i = 0; i < len; i++)
           this._search[i]=Integer.parseInt(Buf.readLine());
       
        Buf.close();
        length.close();
	}
	private void select() {
		int i = 0;
		while(i!=9) {
			
			this._appview.intro();
			i = this._appview.scan();
			if(i==1) {
				System.out.println("Insert를 수행합니다.");
					for(int j=0; j<this._array.length; j++) {
						BinaryNode n = this._cbt.IterativeSearch(this._tree.root(), this._array[j]);
						if(n != null) {
							System.out.println("값이 중복되었습니다.");
							continue;
						}
						this._cbt.TreeInsert(_tree, this._array[j]);
					}
				
			}
			else if(i==2) {
				System.out.println("RedBlack_Insert를 수행합니다.");
				for(int j=0; j<this._array.length; j++) {
					BinaryNode n = this._cbt.IterativeSearch(this._redtree.root(), this._array[j]);
					if(n != null) {
						System.out.println("값이 중복되었습니다.");
						continue;
					}
					this._rbt.Insert(_redtree, this._array[j]);
				}
			}
			else if(i==3) {
				System.out.println("Recursive Search를 실행합니다.");
				for(int j=0; j<this._search.length; j++) {
					System.out.println("\n\n찾는 값 : "+this._search[j]);
					BinaryNode bst = this._cbt.IterativeSearch(this._tree.root(), this._search[j]);
					@SuppressWarnings("unused")
					BinaryNode rbt = this._rbt.IterativeSearch(this._redtree.root(), this._search[j]);
					if(bst == null) {
						System.out.println("없습니다..");
					}
					else {
						System.out.println("\n-----Binary Search Tree-----\n카운트(이동횟수) : "+this._cbt.count());
						System.out.println("\n-----Red Black Tree-----\n카운트(이동횟수) : "+this._rbt.count());
					}
					
				}
			}
		}
	}
}
