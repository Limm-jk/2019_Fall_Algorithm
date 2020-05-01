package Al_08_201602057_���ر�;

public class Hashtable {
	private static final int NIL = -1;
	private static final int DELETED = -2;
	private int SIZE = 0;
	private static final int SIZE2 = 59;
	private int count = 0;
	public Hashtable() {
	}
	//�� �ؽ����̺� ����
	public void makeHash(int[] H) {
		for(int i = 0; i < H.length; i++) {
			H[i] = NIL;
		}
		this.SIZE = H.length;
	}
	//��Ʈ�ѷ����� ������� Ȯ�� �� ó����
	public boolean isFull(int[] H) {
		for(int i = 0; i < H.length; i++) {
			if(H[i] < 0)
				return false;
		}
		return true;
	}
	//ī��Ʈ ��°� �ʱ�ȭ
	public int count() {
		int result = this.count;
		this.count = 0;
		return result;
	}
	
	//���� 3����
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
	
	//�˻�3����
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
	
	//����3����
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
	
	//������Լ�
	private int modSize(int x) {
		int key = x % SIZE;
		return key;
	}
	
}
