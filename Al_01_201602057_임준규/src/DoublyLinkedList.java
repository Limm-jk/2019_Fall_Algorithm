
public class DoublyLinkedList {
	
	private Node _head;
	private Node _tail;
	private int _size;
	
	public DoublyLinkedList() {
		this._head = new Node(0);
		this._tail = new Node(0);
		this._size = 0;
	}
	
	public void add(int data) {
		Node newNode = new Node(data);
		if(this.isEmpty()) {
			this._head.setNext(newNode);
			newNode.setPrev(this._head);
			this._tail.setPrev(newNode);
			newNode.setNext(this._tail);
		}
		else {
			newNode.setNext(this._tail);
			this._tail.prev().setNext(newNode);
			this._tail.setPrev(newNode);
		}
		this._size++;
	}
	public void remove(int n) {
		Node PreNode = this.SelectNode(n-1);
		Node NextNode = this.SelectNode(n+1);
		
		PreNode.setNext(NextNode);
		NextNode.setPrev(PreNode);
		this._size--;
	}
	public void insert(int current, int move) {
		Node insertNode = this.SelectNode(current);
		Node PreNode;
		if(current==move)
			return;
		if(move>current)
			PreNode = this.SelectNode(move);
		else
			PreNode = this.SelectNode(move-1);
		Node NextNode = PreNode.next();
		this.remove(current);
		this._size++;
		PreNode.setNext(insertNode);
		insertNode.setPrev(PreNode);
		insertNode.setNext(NextNode);
		NextNode.setPrev(insertNode);
	}
	public void swap(int a, int b) {
		if(a==b)
			return;
		else {
			this.insert(a, b);
			if(a>b)
				this.insert(b+1, a);
			else
				this.insert(b-1, a);
		}
	}
	public Node SelectNode(int n) {
		Node nNode = this._head;
		for(int i = 0; i<n; i++) {
			nNode = nNode.next();
		}
		return nNode;
	}
	public boolean LargeCompare(int a, int b) {
		if(this.SelectNode(a).element()>this.SelectNode(b).element())
			return true;
		else
			return false;
	}
	public Node head() {
		return this._head;
	}
	public Node tail() {
		return this._tail;
	}
	public int size() {
		return this._size;
	}
	public boolean isEmpty() {
		if(this._size==0)
			return true;
		else
			return false;
	}
}