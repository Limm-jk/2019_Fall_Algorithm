package Al_05_201602057_¿”¡ÿ±‘;

public class SelectSort extends Select {
	
	public SelectSort() {
		
	}
	public int select(int [] A, int p, int r, int i) {
		if(p==r) {
			return A[p];
		}
		int q = this.partition(A, p, r);
		int k = q-p+1;
		
		if(i<k) {
			return select(A,p,q-1,i);
		}
		else if(i == k) {
			return A[q];
		}
		else {
			return select(A,q+1,r,i-k);
		}
	}
	
}
