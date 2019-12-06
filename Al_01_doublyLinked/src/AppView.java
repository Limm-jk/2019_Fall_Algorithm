import java.util.Scanner;
public class AppView {
	private Scanner _scanner;
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	public void input() {
		System.out.println("자료 입력이 완료되었습니다\n");
	}
	public void intro() {
		System.out.println("어떤 작업을 수행하시겠습니까?\n "
				+ "1.Bubble Sort  2. Selection Sort  3. Insertion Sort  4. OutPut   9. Exit\n");
	}
	public int scan() {
		int a = this._scanner.nextInt();
		return a;
	}
}
