package Al_03_201602057_임준규;

public class MergeSort extends Sort {
	
	public MergeSort() {
		
	}
	
	public void Sort(int [] A, int p, int r) {
		if(p<r) {
			int mid = (p + r) / 2;
			this.Sort(A, p, mid);
			this.Sort(A, mid+1, r);
			this.Merge(A, p, mid, r);
		}
	}
	
	private void Merge(int [] A, int p, int mid, int r) {
		int i = p;
		int j = mid+1;
		int k = p;
		int l;
		
		int _sorted [] = new int[A.length];
		while(i<=mid && j<=r){
		    if(A[i]<=A[j]) {
		      _sorted[k] = A[i];
		      i++;
		    }
		    else {
		      _sorted[k] = A[j];
		      j++;
		    }//i와 j의 원소를 비교하여 더 작은 값을 임시배열인 sorted에 투입
		    k++;
		}
		if(i>mid){
			for(l=j; l<=r; l++) {
				_sorted[k] = A[l];// 우측남아 있는 값들을 일괄 복사
				k++;
		   }
		}
		else {
			for(l=i; l<=mid; l++)
				_sorted[k++] = A[l]; // 좌측남아 있는 값들을 일괄 복사		  
		}
		for(l=p; l<=r; l++){
		   A[l] = _sorted[l];// 배열 sorted[]를 배열 A[]로 재복사
		}
	}
}