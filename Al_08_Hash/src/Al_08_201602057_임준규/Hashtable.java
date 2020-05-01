package Al_08_201602057_임준규;

public class Hashtable {
	private static final int NIL = -1;
	private static final int DELETED = -2;
	private int SIZE = 0;
	private static final int SIZE2 = 59;
	private int count = 0;
	public Hashtable() {
	}
	//빈 해시테이블 생성
	public void makeHash(int[] H) {
		for(int i = 0; i < H.length; i++) {
			H[i] = NIL;
		}
		this.SIZE = H.length;
	}
	//컨트롤러에서 꽉찬경우 확인 후 처리용
	public boolean isFull(int[] H) {
		for(int i = 0; i < H.length; i++) {
			if(H[i] < 0)
				return false;
		}
		return true;
	}
	//카운트 출력과 초기화
	public int count() {
		int result = this.count;
		this.count = 0;
		return result;
	}
	
	//삽입 3가지
	public void QuadraticInsert(int[] H, int x){
		int key = this.modSize(x);
		int i = 0;
		while(H[key] >= 0) {
			i++;
			key = this.modSize(this.modSize(x) + i*i);
		}
		this.count += i;
		H[key] = x;
	}
	public void LinearInsert(int[] H, int x) {
		int key = this.modSize(x);
		while(H[key] >= 0) {
			key = this.modSize(key+1);
			this.count++;
		}
		H[key] = x;
	}
	public void DoubleInsert(int[] H, int x) {
		int key = this.modSize(x);
		int i = 0;
		while(H[key] >= 0) {
			i ++;
			key = this.modSize(this.modSize(x)+i*(x % SIZE2));
		}
		this.count += i;
		H[key] = x;
	}
	
	//검색3가지
	public boolean LinearSearch(int[] H, int x) {
		int key = this.modSize(x);
		while(H[key] != NIL) {
			if(H[key] == x)
				return true;
			else {
				key = this.modSize(key+1);
				this.count++;
			}
		}
		return false;
	}
	public boolean QuadraticSearch(int[] H, int x){
		int key = this.modSize(x);
		int i = 0;
		while(H[key] != NIL) {
			if(H[key] == x) {
				this.count += i;
				return true;
			}
			else {
				i++;
				key = this.modSize(this.modSize(x) + i*i);
			}
		}
		count += i;
		return false;
	}
	public boolean DoubleSearch(int[] H, int x) {
		int key = this.modSize(x);
		int i = 0;
		while(H[key] != NIL) {
			if(H[key] == x) {
				this.count += i;
				return true;
			}
			else {
				i ++;
				key = this.modSize(this.modSize(x)+i*(x % SIZE2));
			}
		}
		count += i;
		return false;
	}
	
	//삭제3가지
	public boolean LinearDelete(int[] H, int x) {
		int key = this.modSize(x);
		while(H[key] != NIL) {
			if(H[key] == x) {
				H[key] = DELETED;
				return true;
			}
			else {
				this.count++;
				key = this.modSize(key+1);
			}
		}
		return false;
	}
	public boolean QuadraticDelete(int[] H, int x){
		int key = this.modSize(x);
		int i = 0;
		while(H[key] != NIL) {
			if(H[key] == x) {
				count += i;
				H[key] = DELETED;
				return true;
			}
			else
				i++;
				key = this.modSize(this.modSize(x) + i*i);
		}
		count += i;
		return false;
	}
	public boolean DoubleDelete(int[] H, int x) {
		int key = this.modSize(x);
		int i = 0;
		while(H[key] != NIL) {
			if(H[key] == x) {
				H[key] = DELETED;
				count += i;
				return true;
			}
			else {
				i ++;
				key = this.modSize(this.modSize(x)+i*(x % SIZE2));
			}
		}
		count += i;
		return false;
	}
	
	//비공개함수
	private int modSize(int x) {
		int key = x % SIZE;
		return key;
	}
	
}
