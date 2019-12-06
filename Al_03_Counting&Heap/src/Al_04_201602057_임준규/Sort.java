package Al_04_201602057_¿”¡ÿ±‘;

public abstract class Sort {
	protected long  _startTime ; 
	protected long  _stopTime ;
	
	protected void swap(int [] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	//timer
	public void start () { 
		this._startTime = System.currentTimeMillis() ; 
	} 
	public void stop () { 
		this._stopTime = System.currentTimeMillis() ; 
	} 
	public long  duration () { 
		return  (this._stopTime - this._startTime) ;
	}
	
	protected Sort() {
	}
	
	public abstract void Sort(int [] A);
}
