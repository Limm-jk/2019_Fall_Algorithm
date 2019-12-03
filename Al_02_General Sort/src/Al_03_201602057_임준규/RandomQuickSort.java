package Al_03_201602057_¿”¡ÿ±‘;

public class RandomQuickSort extends Sort {
	public RandomQuickSort() {
		
	}
	public void Sort(int [] A, int p, int r) {
		if(p<r) {
			int q = randpartition(A, p, r);
			this.Sort(A, p, q-1);
			this.Sort(A, q+1, r);
		}
	}
	
	private int randpartition(int [] A, int p, int r) {
		int rand = (int) (Math.random()*(r-p+1))+p;
		int x = A[rand];
		this.swap(A, r, rand);
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
