package Al_08_201602057_임준규;

import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	
	public void intro() {
		System.out.println("어떤 작업을 수행하시겠습니까?\n "
				+ "1. Insert  2. Search  3. Delete   9. Exit\n");
	}
	public int scan() {
		int a = this._scanner.nextInt();
		return a;
	}
	public void selectThree() {
		System.out.println("어떤 방법의 충돌 처리 방법을 수행하시겠습니까?\n"
				+ "1. Linear   2. Quadratic   3. Double Hashing");
	}
	public void errorinput() {
		System.out.println("잘못된 입력입니다.");
	}
	public void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	public void insert() {
		System.out.println("Insert를 수행합니다.\n");
	}
	public void search() {
		System.out.println("Search를 수행합니다.\n");
	}
	public void delete() {
		System.out.println("Delete를 수행합니다.\n");
	}
	public void countPrint(int count) {
		System.out.println("충돌 횟수는 "+count+"회 입니다.\n\n\n");
	}
	public void fullTable() {
		System.out.println("테이블이 가득 차있습니다.");
	}
	public void searchSuccess(int a) {
		System.out.println(a+"값이 있습니다.");
	}
	public void searchFalse(int a) {
		System.out.println(a+"값이 없습니다.");
	}
	public void deleteSuccess(int a) {
		System.out.println(a+"값을 삭제했습니다.");
	}
	public void deleteFalse(int a) {
		System.out.println(a+"값이 없습니다.");
	}
}
