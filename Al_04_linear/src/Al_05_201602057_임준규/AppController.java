package Al_05_201602057_���ر�;

import java.io.*;

public class AppController {
	private AppView _appview;
	private SelectSort _selec;
	private linearSelectSort _lisel;
	private int [] _array,_copy;
	
	public AppController() {
		this._appview = new AppView();
		this._selec = new SelectSort();
		this._lisel = new linearSelectSort();
	}
	public void run() throws IOException {
		this.fileInput();
		this.Choose();
	}
	private void fileInput() throws IOException {
		int len = 0;//���ϱ���(�ټ�)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]�ǽ�5����\\test_100.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]�ǽ�5����\\test_100.txt"));
        //Buf->File length->��������
        while(length.readLine() != null)
            len++;  
        this._array = new int[len];
        for(int i = 0; i < len; i++)
           this._array[i]=Integer.parseInt(Buf.readLine());
        
        Buf.close();
        length.close();
	}
	private void printOutput(int [] A) {
		for(int a=0; a<A.length; a++)
       	 System.out.println(A[a]);//�迭 ���� ����Ʈ
		System.out.println("\n");
	}
	private void copyArray(int [] A) {
		this._copy = new int[A.length];
		for(int k = 0 ; k < A.length; k++) {
			this._copy[k] = A[k];
		}
	}
	private void clear(int [] A) {
		for(int k = 0 ; k < A.length; k++) {
			A[k] = this._copy[k];
		}
	}
	private int Select(Select selec, int [] A , int first, int last, int select) {
		int result;
		result = selec.select(A, first, last, select);
		return result;
	}
	
	private void Choose() throws IOException {
		this.copyArray(_array);
		int i = 0;
		int scanN = 0;
		while(i!=9) {
			this._appview.intro();
			i = this._appview.scan();
			if(i==1) {
				System.out.println("Average Select�� �����մϴ�.\n");
				System.out.print("Rank : ");
				scanN = this._appview.scan();
				System.out.print("Result : ");
				System.out.println(this.Select(_selec, _array, 0,this._array.length-1, scanN)+"\n");
				this.clear(_array);
			}
			else if(i==2) {
				System.out.println("MEdian Of Median Select�� �����մϴ�.");
				System.out.print("Rank : ");
				scanN = this._appview.scan();
				System.out.print("Result : ");
				System.out.println(this.Select(_lisel, _array, 0,this._array.length-1, scanN)+"\n");
				this.clear(_array);
			}
			else if(i==3) {
				System.out.println("���� ����� ����մϴ�.");
				this._lisel.quickSort(_array, 0, this._array.length-1);
				this.printOutput(_array);
				this.clear(_array);
			}
			else if(i==9) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
			
		}
	}
	
}
