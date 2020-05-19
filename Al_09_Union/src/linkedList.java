
public class linkedList {
	private Node _head;
	
	public linkedList() {
		this._head = null;
	}
	
	public void add(Node node) {
		
		if(this._head == null) {
			this._head = node;
		}
		else {
			Node current = this._head;
			while(current.next() != null) {
				current = current.next();
			}
			current.setnext(node);
		}
	}
	public Node search(String data) {
		Node current = this._head;
		while(!current.element().equals(data)) {
			current = current.next();
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	public Node head() {
		return this._head;
	}
	@SuppressWarnings("null")
	public int size() {
		int res = 0;
		Node cur = this._head;
		while(cur != null) {
			cur = cur.next();
			res++;
		}
		return res;
	}
}
