package Al_03_201602057_¿”¡ÿ±‘;

public class QuickSort extends Sort {
	
	public QuickSort() {
		
	}
	public void Sort(int [] A, int p, int r) {
		if(p<r) {
			int q = partition(A, p, r);
			this.Sort(A, p, q-1);
			this.Sort(A, q+1, r);
		}
	}
	private int partition(int [] A, int p, int r) {
		int x = A[r];
		int i = p-1;
		for(int j = p; j < r; j++) {
			if(A[j] <= x) {
				i++;
				this.swap(A, i, j);
				this.count++;
			}
		}
		this.swap(A, i+1, r);
		
		return i+1;
	}
	
}
