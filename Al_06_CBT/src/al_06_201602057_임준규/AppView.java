package al_06_201602057_���ر�;

import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	
	public void intro() {
		System.out.println("� �۾��� �����Ͻðڽ��ϱ�?\n "
				+ "1.Insert  2. Median Insert  3. Recursive Search  4. Iterative Search  5. Successor  6. Predecessor  7. Delete   9. Exit\n");
	}
	public int scan() {
		int a = this._scanner.nextInt();
		return a;
	}
}
