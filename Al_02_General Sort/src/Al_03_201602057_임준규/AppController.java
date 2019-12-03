package Al_03_201602057_���ر�;

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
		int len = 0;//���ϱ���(�ټ�)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]�ǽ�3����\\test_5000.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]�ǽ�3����\\test_5000.txt"));
        //Buf->File length->��������
        while(length.readLine() != null)
            len++;  
        this._array = new int[len];
        for(int i = 0; i < len; i++)
           this._array[i]=Integer.parseInt(Buf.readLine());
        
        Buf.close();
        length.close();
	}
	private void sortedfileInput() throws IOException {
		int len = 0;//���ϱ���(�ټ�)
		
		BufferedReader Buf = new BufferedReader(new FileReader
				("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]�ǽ�3����\\sorted_5000.txt"));
        BufferedReader length = new BufferedReader(new FileReader
        		("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]�ǽ�3����\\sorted_5000.txt"));
        //Buf->File length->��������
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
				System.out.println("Bubble Sort�� �����մϴ�.\n");
				this._ex.sortPrint(_bubble, this._array, 0, this._array.length-1);
				buf = this._bubble;
			}
			else if(i==2) {
				System.out.println("Merge Sort�� �����մϴ�.\n");
				this._ex.sortPrint(_merge, this._array, 0, this._array.length-1);
				buf = this._merge;
			}
			else if(i==3) {
				System.out.println("Quick Sort�� �����մϴ�.\n");
				this._ex.sortPrint(_quick, this._array, 0, this._array.length-1);
				buf = this._quick;
			}
			else if(i==4) {
				System.out.println("Random Quick Sort�� �����մϴ�.\n");
				this._ex.sortPrint(_random, this._array, 0, this._array.length-1);
				buf = this._random;
			}
			else if(i==5) {
				System.out.println("������ �����ߴ� Sort�� ��� ���� �ܺ����Ͽ� ����մϴ�.\n");
				if(buf==null)
					System.out.println("������ �����ߴ� Sort�� �����ϴ�.");
				else
					this._ex.sortOutput(buf, _array, 0, this._array.length-1);
			}
			else if (i==6) {
				System.out.println("��ü ���� �м��� �����մϴ�.\n");
				System.out.println("Bubble Sort�� �м��մϴ�.");
				this._ex.experiment(_bubble, _array, 0, this._array.length-1);
				System.out.println("Merge Sort�� �м��մϴ�.");
				this._ex.experiment(_merge, _array, 0, this._array.length-1);
				System.out.println("Quick Sort�� �м��մϴ�.");
				this._ex.experiment(_quick, _array, 0, this._array.length-1);
				System.out.println("Random Quick Sort�� �м��մϴ�.");
				this._ex.experiment(_random, _array, 0, this._array.length-1);
			}
			else if (i==7) {
				System.out.println("���� ���� �м��� �����մϴ�. \n ���� �ֱٿ� �����ߴ� Sort�� ������ Ȯ���մϴ�.");
				if(buf==null)
					System.out.println("������ �����ߴ� Sort�� �����ϴ�.");
				else
					this._ex.experiment(buf, _array, 0, this._array.length-1);
			}
			else if (i==8) {
				System.out.println("Sort�� �迭�� QuickSort�� ���� �迭�ϰ� �����ս��� �м��մϴ�.");
				this._ex.experiment(_quick, _sortedarray, 0, this._sortedarray.length-1);
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
