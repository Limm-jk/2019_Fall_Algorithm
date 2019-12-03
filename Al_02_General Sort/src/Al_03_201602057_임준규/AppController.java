package Al_03_201602057_임준규;

import java.io.*;

public class AppController {
	private MergeSort _merge;
	private BubbleSort _bubble;
	private QuickSort _quick;
	private RandomQuickSort _random;
	
	private AppView _appview;
	private Experiment _ex;
	private int [] _array,_sortedarray;
	public AppController() {
		this._appview = new AppView();
		this._merge = new MergeSort();
		this._bubble = new BubbleSort();
		this._quick = new QuickSort();
		this._random = new RandomQuickSort();
		this._ex = new Experiment();
		this._appview = new AppView();
	}
	public void run() throws IOException {
		this.fileInput();
		this.sortedfileInput();
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
	private void sortedfileInput() throws IOException {
		int len = 0;//파일길이(줄수)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습3주차\\sorted_5000.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습3주차\\sorted_5000.txt"));
        //Buf->File length->길이측정
        while(length.readLine() != null)
            len++;  
        this._sortedarray = new int[len];
        for(int i = 0; i < len; i++)
           this._sortedarray[i]=Integer.parseInt(Buf.readLine());
        
        Buf.close();
        length.close();
	}
 	private void select() throws IOException {
		int i = 0;
		Sort buf = null;
		while(i!=9) {
			this._appview.intro();
			i = this._appview.scan();
			if(i==1) {
				System.out.println("Bubble Sort를 수행합니다.\n");
				this._ex.sortPrint(_bubble, this._array, 0, this._array.length-1);
				buf = this._bubble;
			}
			else if(i==2) {
				System.out.println("Merge Sort를 수행합니다.\n");
				this._ex.sortPrint(_merge, this._array, 0, this._array.length-1);
				buf = this._merge;
			}
			else if(i==3) {
				System.out.println("Quick Sort를 수행합니다.\n");
				this._ex.sortPrint(_quick, this._array, 0, this._array.length-1);
				buf = this._quick;
			}
			else if(i==4) {
				System.out.println("Random Quick Sort를 수행합니다.\n");
				this._ex.sortPrint(_random, this._array, 0, this._array.length-1);
				buf = this._random;
			}
			else if(i==5) {
				System.out.println("이전에 실행했던 Sort의 결과 값을 외부파일에 출력합니다.\n");
				if(buf==null)
					System.out.println("이전에 실행했던 Sort가 없습니다.");
				else
					this._ex.sortOutput(buf, _array, 0, this._array.length-1);
			}
			else if (i==6) {
				System.out.println("전체 성능 분석을 수행합니다.\n");
				System.out.println("Bubble Sort를 분석합니다.");
				this._ex.experiment(_bubble, _array, 0, this._array.length-1);
				System.out.println("Merge Sort를 분석합니다.");
				this._ex.experiment(_merge, _array, 0, this._array.length-1);
				System.out.println("Quick Sort를 분석합니다.");
				this._ex.experiment(_quick, _array, 0, this._array.length-1);
				System.out.println("Random Quick Sort를 분석합니다.");
				this._ex.experiment(_random, _array, 0, this._array.length-1);
			}
			else if (i==7) {
				System.out.println("개별 성능 분석을 수행합니다. \n 가장 최근에 실행했던 Sort의 성능을 확인합니다.");
				if(buf==null)
					System.out.println("이전에 실행했던 Sort가 없습니다.");
				else
					this._ex.experiment(buf, _array, 0, this._array.length-1);
			}
			else if (i==8) {
				System.out.println("Sort된 배열을 QuickSort를 통해 배열하고 퍼포먼스를 분석합니다.");
				this._ex.experiment(_quick, _sortedarray, 0, this._sortedarray.length-1);
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
