
public class vertex implements Comparable<vertex> {
	private int key;
	private int d;
	private vertex pi;
	private int index;
	private int status = 0; // 그래프의 상태를 표시함. 무향 = 0 / 유향 = 1

	public vertex(int index) {
		this.index = index;
		this.key = 0;
		this.d = 0;
		this.pi = null;
	}

	public vertex() {
		this.key = 0;
		this.d = 0;
		this.pi = null;
		this.index = -1;
	}

	public int key() {
		return this.key;
	}

	public void setkey(int col) {
		this.key = col;
	}

	public int d() {
		return this.d;
	}

	public void setd(int nd) {
		this.d = nd;
	}

	public vertex pi() {
		return this.pi;
	}

	public void setpi(vertex npi) {
		this.pi = npi;
	}

	public int index() {
		return this.index;
	}

	public void directed() {
		this.status = 1;
	}

	public void undirected() {
		this.status = 0;
	}

	@Override
	public int compareTo(vertex target) {
		if (status == 1) {
			if (this.d() > target.d()) {
				return 1;
			} else if (this.d() < target.d()) {
				return -1;
			}
		} else {
			if (this.key() > target.key()) {
				return 1;
			} else if (this.key() < target.key()) {
				return -1;
			}
		}
		return 0;
	}
}
