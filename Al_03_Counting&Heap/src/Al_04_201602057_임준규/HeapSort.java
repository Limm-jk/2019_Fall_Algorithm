package Al_04_201602057_임준규;

public class HeapSort extends Sort {
	
	private int _heapSize = 0;
	private long _bmh = 0, _mhp = 0;
	
	public HeapSort() {
		this._bmh = 0;
		this._mhp = 0;
		this._heapSize = 0;
	}
	
	@Override
	public void Sort(int[] A) {
		//시간측정
		this.start();
		this.buildMaxHeap(A);
		this.stop();
		this._bmh = this.duration();
		//측정끝
		for(int i = A.length-1; i>=0; i--) {
			this.swap(A, 0, i);
			this._heapSize--;
			if(this._mhp == 0) {
				this.start();
				this.maxHeapify(A, 0);
				this.stop();
				this._mhp = this.duration();
			}
			else
				this.maxHeapify(A, 0);
		}
		System.out.println("Build Max Heap의 시간 측정은 "+this._bmh+"마이크로 초 입니다.\n");
		System.out.println("Max Heapify의 시간 측정은 "+this._mhp+"마이크로 초 입니다.\n");
	}
	private void buildMaxHeap(int [] A) {
		this._heapSize = A.length;
		for(int i = A.length/2; i>=0;i--) {
			this.maxHeapify(A, i);
		}
	}
	private void maxHeapify(int [] A, int i) {
		int l = 2*i;
		int r = (2*i)+1;
		int largest = i;
		if(l < this._heapSize && A[l] > A[i]) {
			largest = l;
		}
		if(r < this._heapSize && A[r] > A[largest]) {
			largest = r;
		}
		if(largest != i) {
			this.swap(A, i, largest);
			maxHeapify(A, largest);
		}
	}
}
