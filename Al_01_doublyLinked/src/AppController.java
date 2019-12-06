import java.io.*;

public class AppController {
	int count=0;
	DoublyLinkedList DLL = new DoublyLinkedList();
	private AppView _appview;
	
	public AppController() {
		this.count=0;
		this.DLL = new DoublyLinkedList();
		this._appview = new AppView();
	}
	public void run() throws IOException {
         fileInput();
         if(!DLL.isEmpty()) {
        	 this._appview.input();
        	 this.select();
         }
    }
	private void fileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습1주차\\test_100.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습1주차\\test_100.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  

        for(int i = 0; i < len; i++)
           DLL.add(Integer.parseInt(Buf.readLine()));
        
        Buf.close();
        length.close();
	}
	private void fileOutput() throws IOException {
		FileWriter file = new FileWriter("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습1주차\\output_test_100.txt");
		BufferedWriter buf = new BufferedWriter(file);
		for(int i = 1; i<DLL.size()+1; i++) {
			buf.write(Integer.toString(DLL.SelectNode(i).element())); //버퍼에 데이터 입력
			buf.newLine(); //버퍼에 개행 삽입
		}
		buf.flush(); //버퍼의 내용을 파일에 쓰기
		
		buf.close();
		file.close();
	}
	private void BubbleSort() {
		for(int i = 1 ; i < DLL.size()+1 ; i ++) {
			for(int j = DLL.size() ; j > i; j --) {
				if(this.LargeCompare(j-1, j)) {
					DLL.swap(j,j-1);
				}
				count++;
			}
		}
	}
	private void SelectionSort() {
		for(int i = 1 ; i < DLL.size()+1 ; i ++) {
			int min = i;
			for(int j = i+1 ; j < DLL.size()+1 ; j ++) {
				if(this.LargeCompare(min, j))
					min=j;
				count++;
				}
			DLL.swap(i,min);
			}
	}
	private void InsertionSort() {
		for(int j = 2 ; j < DLL.size()+1 ; j ++) {
			int i = j - 1;
			while(i > 0 && this.LargeCompare(i, j)) {
				i--;
				count++;
			}
			DLL.insert(j, i + 1);
			
		}
	}
	private boolean LargeCompare(int a, int b) {
		if(DLL.SelectNode(a).element()>DLL.SelectNode(b).element())
			return true;
		else
			return false;
		//a가 b보다 클떄만 true return
	}
	private void printOutput() {
		for(int a=1; a<DLL.size()+1; a++)
       	 System.out.println(DLL.SelectNode(a).element());
		System.out.println("\n");
	}
	private void select() throws IOException {
		int i = 0;
		while(i!=9) {
			this._appview.intro();
			i = this._appview.scan();
			if(i==1) {
				System.out.println("Bubble Sort를 수행합니다.");
				this.BubbleSort();
				this.printOutput();
			}
			else if(i==2) {
				System.out.println("Selection Sort를 수행합니다.");
				this.SelectionSort();
				this.printOutput();
			}
			else if(i==3) {
				System.out.println("insertion Sort를 수행합니다.");
				this.InsertionSort();
				this.printOutput();
			}
			else if(i==4) {
				System.out.println("output_text_100.txt에 결과를 출력합니다.");
				this.fileOutput();
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
	private void count() {//count실험용 함수
		System.out.println(count);
		count=0;
	}
}
