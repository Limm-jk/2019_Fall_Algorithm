package Al_04_201602057_임준규;

import java.io.*;

public class AppController {
	private AppView _appview;
	private HeapSort _heap;
	private CountingSort _count;
	private int [] _array,_copy;
	
	public AppController() {
		this._appview = new AppView();
		this._heap = new HeapSort();
		this._count = new CountingSort();
	}
	public void run() throws IOException {
		this.fileInput();
		this.select();
	}
	private void fileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습3주차\\test_5000.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습3주차\\test_5000.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  
        this._array = new int[len];
        for(int i = 0; i < len; i++)
           this._array[i]=Integer.parseInt(Buf.readLine());
        
        Buf.close();
        length.close();
	}
	private void fileOutput(int [] A) throws IOException {
		FileWriter file = new FileWriter("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습3주차\\output_test.txt");
		BufferedWriter buf = new BufferedWriter(file);
		for(int i = 0; i<A.length; i++) {
			buf.write(Integer.toString(A[i])); //버퍼에 데이터 입력
			buf.newLine(); //버퍼에 개행 삽입
		}
		buf.flush(); //버퍼의 내용을 파일에 쓰기
		
		buf.close();
		file.close();
	}
	private void printOutput(int [] A) {
		for(int a=0; a<A.length; a++)
       	 System.out.println(A[a]);//배열 원소 프린트
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
	private void Sort(Sort sort, int [] A) {
		sort.Sort(A);
	}
	
	private void select() throws IOException {
		this.copyArray(_array);
		int i = 0;
		while(i!=9) {
			this._appview.intro();
			i = this._appview.scan();
			if(i==1) {
				System.out.println("Heap Sort를 수행합니다.");
				this.Sort(_heap, _array);
				this.printOutput(_array);
				this.clear(_array);
			}
			else if(i==2) {
				System.out.println("Counting Sort를 수행합니다.");
				this.Sort(_heap, _array);
				this.printOutput(_array);
				this.clear(_array);
			}
			else if(i==3) {
				System.out.println("output_text_5000.txt에 Heap Sort의 결과를 출력합니다.");
				this.Sort(_heap, _array);
				this.fileOutput(this._array);
				this.clear(_array);
			}
			else if(i==4) {
				System.out.println("output_text_5000.txt에 Counting Sort의 결과를 출력합니다.");
				this.Sort(_count, _array);
				this.fileOutput(this._array);
				this.clear(_array);
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
}
