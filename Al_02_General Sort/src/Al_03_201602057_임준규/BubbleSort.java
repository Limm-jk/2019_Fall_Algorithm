package Al_03_201602057_¿”¡ÿ±‘;

public class BubbleSort extends Sort {
	
	public BubbleSort() {
		
	}
	
	public void Sort(int[] arr, int a, int b) {
		for(int i = a ; i <= b ; i ++) {
			for(int j = b ; j > i; j --) {
				if(arr[j-1]>arr[j]) 
					this.swap(arr,j,j-1);
			}
		}
	}

}
