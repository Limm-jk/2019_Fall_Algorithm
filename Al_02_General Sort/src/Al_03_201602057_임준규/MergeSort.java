package Al_03_201602057_���ر�;

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
		    }//i�� j�� ���Ҹ� ���Ͽ� �� ���� ���� �ӽù迭�� sorted�� ����
		    k++;
		}
		if(i>mid){
			for(l=j; l<=r; l++) {
				_sorted[k] = A[l];// �������� �ִ� ������ �ϰ� ����
				k++;
		   }
		}
		else {
			for(l=i; l<=mid; l++)
				_sorted[k++] = A[l]; // �������� �ִ� ������ �ϰ� ����		  
		}
		for(l=p; l<=r; l++){
		   A[l] = _sorted[l];// �迭 sorted[]�� �迭 A[]�� �纹��
		}
	}
}