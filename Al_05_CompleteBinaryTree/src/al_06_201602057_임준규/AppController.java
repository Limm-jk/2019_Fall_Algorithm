package al_06_201602057_임준규;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppController {
	private AppView _appview;
	private int [] _array,_arrayed,_delete;
	private QuickSort _quick;
	private Tree _tree;
	private Tree _mtree;
	private CompleteBinaryTree _cbt;
	private int deletecount;
	
	public AppController() {
		this._appview = new AppView();
		this._quick = new QuickSort();
		this._cbt = new CompleteBinaryTree();
		this._tree = new Tree();
		this._mtree = new Tree();
		this.deletecount =0 ;
	}
	public void run() throws IOException {
		this.fileInput();
		this.deletefileInput();
		this.select();
	}
	private void fileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습6주차\\Insert.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습6주차\\Insert.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  
        this._arrayed = new int[len];

        for(int i = 0; i < len; i++)
           this._arrayed[i]=Integer.parseInt(Buf.readLine());
        this._array = new int[this._arrayed.length];
		for(int k = 0 ; k < this._arrayed.length; k++) {
			this._array[k] = this._arrayed[k];
		}
        this._quick.Sort(_arrayed, 0, this._arrayed.length-1);
        Buf.close();
        length.close();
	}
	private void deletefileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습6주차\\Delete.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습6주차\\Delete.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  
        this._delete = new int[len];

        for(int i = 0; i < len; i++)
           this._delete[i]=Integer.parseInt(Buf.readLine());
        Buf.close();
        length.close();
	}
	
	private void select() throws IOException {
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
					System.out.println("깊이 : "+this._tree.depth()); 
				
			}
			else if(i==2) {
				System.out.println("Median_Insert를 수행합니다.");
					this._cbt.medianInsert(this._mtree, _arrayed, 0, this._arrayed.length-1);
					System.out.println("깊이 : "+this._mtree.depth()); 
				
			}
			else if(i==3) {
				System.out.println("Recursive Search를 실행합니다.");
				int sc = this._appview.scan();
				boolean re;
				re = this._cbt.RecursiveSearch(this._tree.root(), sc);
				if(re)
					System.out.println("있습니다");
				else
					System.out.println("없습니다.");
			}
			else if(i==4) {
				System.out.println("Iterative Search를 실행합니다.");
				int sc = this._appview.scan();
				this._cbt.IterativeSearch(this._tree.root(), sc);
			}
			else if(i==5) {
				System.out.println("Successor를 실행합니다.");
				System.out.println("찾는 값 : "+this._cbt.Successor(this._mtree.root()).element());
			}
			else if(i==6) {
				System.out.println("Predecessor를 실행합니다.");
				System.out.println("찾는 값 : "+this._cbt.Predecessor(this._mtree.root()).element());
			}
			else if(i==7) {
				System.out.println("Insert Tree에서의 Delete를 실행합니다.");
				this.deleteCheck(_tree);
				System.out.println("Median Tree에서의 Delete를 실행합니다.");
				this.deleteCheck(_mtree);
				this._mtree.root();
				 
			}
			else if(i==9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
			
		}
	}
	private void deleteCheck(Tree T) {
		this.deletecount =0 ;
		for(int f = 0; f < this._delete.length; f++) {
			System.out.println(this._delete[f]);
			BinaryNode n = this._cbt.IterativeSearch(T.root(), this._delete[f]);
			if(n == null) {
				System.out.println("찾는 값이 없습니다.");
				continue;
			}
			this._cbt.Delete(T, n);
			this.deletecount++;
		}
		System.out.println("깊이 : "+T.depth()); 
		System.out.println("삭제한 개수 : "+this.deletecount);

	}
	
}
