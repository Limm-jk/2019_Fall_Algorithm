package Al_04_201602057_���ر�;

import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	
	public void intro() {
		System.out.println("� �۾��� �����Ͻðڽ��ϱ�?\n "
				+ "1.Heap Sort  2. Counting Sort  3. Heap Sort OutPut  4. Counting Sort output   9. Exit\n");
	}
	public int scan() {
		int a = this._scanner.nextInt();
		return a;
	}
}
