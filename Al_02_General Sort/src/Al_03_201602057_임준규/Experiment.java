package Al_03_201602057_임준규;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Experiment {
	
	private int [] _copy;//초기배열값 저장, 초기화에 사용
	
	private long  durationOfSort (Sort aSort,int [] A, int first, int last) { 
		Timer  timer = new Timer() ; 
		timer.start() ; //시작시간
		//System.out.println(timer.startn());
		{ 
			aSort.Sort(A,first,last) ;
			//aSort.count();
		} 
		timer.stop() ; //끝
		//System.out.println(timer.stopn());
		return  timer.duration() ; //끝시간-시작시간=걸린시간. 반환.
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
       	 System.out.println(A[a]);//배열 원소 프린트
		System.out.println("\n");
	}
	private void fileOutput(int [] A) throws IOException {
		FileWriter file = new FileWriter("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습3주차\\output_test_100.txt");
		BufferedWriter buf = new BufferedWriter(file);
		for(int i = 0; i<A.length; i++) {
			buf.write(Integer.toString(A[i])); //버퍼에 데이터 입력
			buf.newLine(); //버퍼에 개행 삽입
		}
		buf.flush(); //버퍼의 내용을 파일에 쓰기
		
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
		System.out.println("정렬을 완료하였습니다.");
	}
	public void sortOutput(Sort aSort,int [] A, int first, int last) throws IOException {
		this.copyArray(A);
		aSort.Sort(A,first,last);
		this.fileOutput(A);
		this.clear(A);
		System.out.println("output을 완료하였습니다.");
	}
	public void experiment(Sort aSort,int [] A, int first, int last) {
		this.copyArray(A);
		long [] result = new long[5];
		long duration, add = 0, average = 0;
		for(int i=0; i<3; i++) {
			aSort.Sort(A,first,last);
			this.clear(A);//배열 초기화
			//aSort.count();
		}//초기 3회 버리는 Sort 실행
		System.out.println("초기 3회 완료\n");
		for(int j=0; j<5; j++) {
			duration = this.durationOfSort(aSort, A, first, last);
			System.out.println(j+1+"번째 결과 : "+duration+"마이크로 초");
			result[j] = duration;
			this.clear(A);//배열 초기화
		}//duration을 프린트하고 초기화 후 5회 반복실행
		for(int k = 0; k < 5; k++) {
			add += result[k];
		}
		average = add/5;
		System.out.println("정렬 실험의 평균은 "+average+"마이크로 초입니다.\n");
	}
}
