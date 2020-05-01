package Al_08_201602057_임준규;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class AppController {
	private static final int TABLESIZE = 97;
	private AppView _appview;
	private int [] _insert,_search,_delete;
	private Hashtable _hash;
	private int [] _table = new int[TABLESIZE];
	
	public AppController() {
		this._appview = new AppView();
		this._hash = new Hashtable();
	}
	
	public void run() throws IOException {
		this.fileInput();
		this.searchfileInput();
		this.deletefileInput();
		this.select();
		
	}
	private void fileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습8주차\\Data1.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습8주차\\Data1.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  
        this._insert = new int[len];

        for(int i = 0; i < len; i++)
           this._insert[i]=Integer.parseInt(Buf.readLine());
       
        Buf.close();
        length.close();
	}
	private void searchfileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습8주차\\Data2.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습8주차\\Data2.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  
        this._search = new int[len];

        for(int i = 0; i < len; i++)
           this._search[i]=Integer.parseInt(Buf.readLine());
       
        Buf.close();
        length.close();
	}private void deletefileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습8주차\\Data3.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습8주차\\Data3.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  
        this._delete = new int[len];

        for(int i = 0; i < len; i++)
           this._delete[i]=Integer.parseInt(Buf.readLine());
       
        Buf.close();
        length.close();
	}
	private void select() {
		int i = 0;
		while(i!=9) {
			this._hash.makeHash(_table);
			this._appview.selectThree();
			i = this._appview.scan();
			if(i==1) {
				this._appview.insert();
				if(this._hash.isFull(_table)) {
					this._appview.fullTable();
					continue;
				}

				for(int j = 0; j < this._insert.length; j++)
					this._hash.LinearInsert(_table, this._insert[j]);
				this._appview.countPrint(this._hash.count());
				
				this._appview.search();
				for(int j = 0; j < this._search.length; j++) {
					boolean res = this._hash.LinearSearch(_table, this._search[j]);
					if(res) {
						this._appview.searchSuccess(this._search[j]);
					}
					else {
						this._appview.searchFalse(this._search[j]);
					}
				}
				this._appview.countPrint(this._hash.count());
				
				this._appview.delete();
				for(int j = 0; j < this._delete.length; j++) {
					boolean res = this._hash.LinearDelete(_table, this._delete[j]);
					if(res) {
						this._appview.deleteSuccess(this._delete[j]);
					}
					else {
						this._appview.deleteFalse(this._delete[j]);
					}
				}
				this._appview.countPrint(this._hash.count());
			}
			else if(i==2) {
				this._appview.insert();
				if(this._hash.isFull(_table)) {
					this._appview.fullTable();
					continue;
				}

				for(int j = 0; j < this._insert.length; j++)
					this._hash.QuadraticInsert(_table, this._insert[j]);
				this._appview.countPrint(this._hash.count());
				
				this._appview.search();
				for(int j = 0; j < this._search.length; j++) {
					boolean res = this._hash.QuadraticSearch(_table, this._search[j]);
					if(res) {
						this._appview.searchSuccess(this._search[j]);
					}
					else {
						this._appview.searchFalse(this._search[j]);
					}
				}
				this._appview.countPrint(this._hash.count());
				
				this._appview.delete();
				for(int j = 0; j < this._delete.length; j++) {
					boolean res = this._hash.QuadraticDelete(_table, this._delete[j]);
					if(res) {
						this._appview.deleteSuccess(this._delete[j]);
					}
					else {
						this._appview.deleteFalse(this._delete[j]);
					}
				}
				this._appview.countPrint(this._hash.count());
			}
			else if(i==3) {
				this._appview.insert();
				if(this._hash.isFull(_table)) {
					this._appview.fullTable();
					continue;
				}

				for(int j = 0; j < this._insert.length; j++)
					this._hash.DoubleInsert(_table, this._insert[j]);
				this._appview.countPrint(this._hash.count());
				
				this._appview.search();
				for(int j = 0; j < this._search.length; j++) {
					boolean res = this._hash.DoubleSearch(_table, this._search[j]);
					if(res) {
						this._appview.searchSuccess(this._search[j]);
					}
					else {
						this._appview.searchFalse(this._search[j]);
					}
				}
				this._appview.countPrint(this._hash.count());
				
				this._appview.delete();
				for(int j = 0; j < this._delete.length; j++) {
					boolean res = this._hash.DoubleDelete(_table, this._delete[j]);
					if(res) {
						this._appview.deleteSuccess(this._delete[j]);
					}
					else {
						this._appview.deleteFalse(this._delete[j]);
					}
				}
				this._appview.countPrint(this._hash.count());
			}
			else if(i==9) {
				this._appview.end();
				break;
			}
			else {
				this._appview.errorinput();
			}
		}
	}
}
