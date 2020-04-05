package al_06_201602057_¿”¡ÿ±‘;

public abstract class Sort {
	long count = 0;
	
	protected void swap(int [] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	protected void count() {
		System.out.println(this.count);
		this.count = 0;
	}
	
	protected Sort() {
	}
	
	public abstract void Sort(int [] array, int a, int b) ;
}
