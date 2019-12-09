package Al_05_201602057_ÀÓÁØ±Ô;

public abstract class Select {
	long count = 0;
	
	protected void swap(int [] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	protected int partition(int [] A, int p, int r) {
		int x = A[r];
		int i = p-1;
		for(int j = p; j < r; j++) {
			if(A[j] <= x) {
				i++;
				this.swap(A, i, j);
			}
		}
		this.swap(A, i+1, r);
		
		return i+1;
	}
	
	protected Select() {
	}
	
	public abstract int select(int [] array, int a, int b, int i);
}
