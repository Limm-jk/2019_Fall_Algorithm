package Al_03_201602057_���ر�;

import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	
	public void intro() {
		System.out.println("� �۾��� �����Ͻðڽ��ϱ�?\n "
				+ "1.Bubble Sort  2. Merge Sort  3. Quick Sort  4. Random Quick Sort  5. Output  6. ��ü ���� �м�  7. ���� ���� �м�   9. Exit\n");
	}
	public int scan() {
		int a = this._scanner.nextInt();
		return a;
	}
}
