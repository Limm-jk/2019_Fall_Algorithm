


import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public void scan(int a) {
		System.out.println("시작위치를 선택하여 주십시오.");
		a = this._scanner.nextInt();

	}
}
