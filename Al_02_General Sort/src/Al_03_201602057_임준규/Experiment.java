package Al_03_201602057_���ر�;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Experiment {
	
	private int [] _copy;//�ʱ�迭�� ����, �ʱ�ȭ�� ���
	
	private long  durationOfSort (Sort aSort,int [] A, int first, int last) { 
		Timer  timer = new Timer() ; 
		timer.start() ; //���۽ð�
		//System.out.println(timer.startn());
		{ 
			aSort.Sort(A,first,last) ;
			//aSort.count();
		} 
		timer.stop() ; //��
		//System.out.println(timer.stopn());
		return  timer.duration() ; //���ð�-���۽ð�=�ɸ��ð�. ��ȯ.
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
	private void printOutput(int [] A) {
		for(int a=0; a<A.length; a++)
       	 System.out.println(A[a]);//�迭 ���� ����Ʈ
		System.out.println("\n");
	}
	private void fileOutput(int [] A) throws IOException {
		FileWriter file = new FileWriter("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]�ǽ�3����\\output_test_100.txt");
		BufferedWriter buf = new BufferedWriter(file);
		for(int i = 0; i<A.length; i++) {
			buf.write(Integer.toString(A[i])); //���ۿ� ������ �Է�
			buf.newLine(); //���ۿ� ���� ����
		}
		buf.flush(); //������ ������ ���Ͽ� ����
		
		buf.close();
		file.close();
	}
	public Experiment() {
		
	}
	public void sortPrint(Sort aSort,int [] A, int first, int last) {
		this.copyArray(A);
		aSort.Sort(A,first,last);
		this.printOutput(A);
		this.clear(A);
		System.out.println("������ �Ϸ��Ͽ����ϴ�.");
	}
	public void sortOutput(Sort aSort,int [] A, int first, int last) throws IOException {
		this.copyArray(A);
		aSort.Sort(A,first,last);
		this.fileOutput(A);
		this.clear(A);
		System.out.println("output�� �Ϸ��Ͽ����ϴ�.");
	}
	public void experiment(Sort aSort,int [] A, int first, int last) {
		this.copyArray(A);
		long [] result = new long[5];
		long duration, add = 0, average = 0;
		for(int i=0; i<3; i++) {
			aSort.Sort(A,first,last);
			this.clear(A);//�迭 �ʱ�ȭ
			//aSort.count();
		}//�ʱ� 3ȸ ������ Sort ����
		System.out.println("�ʱ� 3ȸ �Ϸ�\n");
		for(int j=0; j<5; j++) {
			duration = this.durationOfSort(aSort, A, first, last);
			System.out.println(j+1+"��° ��� : "+duration+"����ũ�� ��");
			result[j] = duration;
			this.clear(A);//�迭 �ʱ�ȭ
		}//duration�� ����Ʈ�ϰ� �ʱ�ȭ �� 5ȸ �ݺ�����
		for(int k = 0; k < 5; k++) {
			add += result[k];
		}
		average = add/5;
		System.out.println("���� ������ ����� "+average+"����ũ�� ���Դϴ�.\n");
	}
}
