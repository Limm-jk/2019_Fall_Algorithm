import java.util.Scanner;
public class AppView {
	private Scanner _scanner;
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	public void input() {
		System.out.println("�ڷ� �Է��� �Ϸ�Ǿ����ϴ�\n");
	}
	public void intro() {
		System.out.println("� �۾��� �����Ͻðڽ��ϱ�?\n "
				+ "1.Bubble Sort  2. Selection Sort  3. Insertion Sort  4. OutPut   9. Exit\n");
	}
	public int scan() {
		int a = this._scanner.nextInt();
		return a;
	}
}
