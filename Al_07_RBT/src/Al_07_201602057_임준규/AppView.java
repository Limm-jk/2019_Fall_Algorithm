package Al_07_201602057_���ر�;

import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	
	public void intro() {
		System.out.println("� �۾��� �����Ͻðڽ��ϱ�?\n "
				+ "1.Binary Search Tree Insert  2. Red Black Tree Insert  3. Search & Compare   9. Exit\n");
	}
	public int scan() {
		int a = this._scanner.nextInt();
		return a;
	}
}
