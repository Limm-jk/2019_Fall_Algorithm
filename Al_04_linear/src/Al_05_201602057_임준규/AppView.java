package Al_05_201602057_임준규;

import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	
	public void intro() {
		System.out.println("어떤 작업을 수행하시겠습니까?\n "
				+ "1.Select  2. Median of Median Select  3. QuickSort  9. Exit\n");
	}
	public int scan() {
		int a = this._scanner.nextInt();
		return a;
	}
}
