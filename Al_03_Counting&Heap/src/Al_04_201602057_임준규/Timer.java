package Al_04_201602057_¿”¡ÿ±‘;

public class Timer {
	private long  _startTime ; 
	private long  _stopTime ; 
	
	public  Timer () {	
	}	

	public void  start () { 
		this._startTime = System.nanoTime() ; 
	} 
	public void  stop () { 
		this._stopTime = System.nanoTime() ; 
	} 
	public long  duration () { 
		return  (this._stopTime - this._startTime) ;
	}
	public long startn() {
		return this._startTime;
	}
	public long stopn() {
		return this._stopTime;
	}
}
