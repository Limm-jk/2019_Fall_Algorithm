


import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public void scan(int a) {
		System.out.println("������ġ�� �����Ͽ� �ֽʽÿ�.");
		a = this._scanner.nextInt();

	}
}
