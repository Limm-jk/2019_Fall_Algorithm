package Al_05_201602057_¿”¡ÿ±‘;

public class linearSelectSort extends Select {
	public linearSelectSort() {
		
	}
	public int select(int [] A, int p, int r, int i) {
		int size = r-p+1;
		int mediansize = (size+4)/5;
		
		int medi[] = new int[mediansize];
		if(size<=5) {
			this.quickSort(A, p, r);
			return A[p+i-1];
		}
		for(int j = 0; j<mediansize; j++) {
			if(5*j+4<size) {
				this.quickSort(A, (5*j)+p, (5*j+4)+p);
				medi[j] = A[(5*j+2)+p];
			}
			else {
				this.quickSort(A, 5*j, r);
				medi[j] = A[5*j+(r-5*j+1)/2];
			}
		}
		
		int pivotM = this.select(medi, 0, mediansize-1, mediansize/2+1);
		
		for(int k = 0; k<=r; k++) {
			if(A[k] == pivotM) {
				this.swap(A, k, r);
				break;
			}
		}
		
		int q = this.partition(A, p, r);
		
		if(q-p+1 == i) {
	         return pivotM;
	    }
		else if(q-p+1 > i) {
	         return select(A,p,q-1,i);
	    }
		else {
	         return select(A,q+1, r, i-(q-p+1));
	    }

	}
	public void quickSort(int [] A, int p, int r) {
		if(p<r) {
			int q = partition(A, p, r);
			this.quickSort(A, p, q-1);
			this.quickSort(A, q+1, r);
		}
	}
}
