package Al_04_201602057_임준규;

public class CountingSort extends Sort{
	private static final int MAX_HEAP = 5000;
	private int [] _count,_sorted;
	
	@Override
	public void Sort(int[] A) {
		this._count = new int [MAX_HEAP+1];
		this._sorted = new int [MAX_HEAP+1];
		for(int i = 0; i<MAX_HEAP; i++) {
			this._count[i] = 0;
		}
		for(int j = 0; j<A.length; j++) {
			this._count[A[j]]++;
		}
		for(int i = 1; i<this._count.length; i++) {
			this._count[i] += this._count[i-1];
		}
		for(int j = A.length-1; j>=0; j--) {
			this._sorted[this._count[A[j]]] = A[j];
			this._count[A[j]]--;
		}
		for(int p=0; p<MAX_HEAP; p++){
			   A[p] = _sorted[p+1];// 배열 sorted[]를 배열 A[]로 재복사
		}
	}

	

}
