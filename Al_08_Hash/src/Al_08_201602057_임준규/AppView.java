package Al_08_201602057_���ر�;

import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;
	
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	
	public void intro() {
		System.out.println("� �۾��� �����Ͻðڽ��ϱ�?\n "
				+ "1. Insert  2. Search  3. Delete   9. Exit\n");
	}
	public int scan() {
		int a = this._scanner.nextInt();
		return a;
	}
	public void selectThree() {
		System.out.println("� ����� �浹 ó�� ����� �����Ͻðڽ��ϱ�?\n"
				+ "1. Linear   2. Quadratic   3. Double Hashing");
	}
	public void errorinput() {
		System.out.println("�߸��� �Է��Դϴ�.");
	}
	public void end() {
		System.out.println("���α׷��� �����մϴ�.");
	}
	public void insert() {
		System.out.println("Insert�� �����մϴ�.\n");
	}
	public void search() {
		System.out.println("Search�� �����մϴ�.\n");
	}
	public void delete() {
		System.out.println("Delete�� �����մϴ�.\n");
	}
	public void countPrint(int count) {
		System.out.println("�浹 Ƚ���� "+count+"ȸ �Դϴ�.\n\n\n");
	}
	public void fullTable() {
		System.out.println("���̺��� ���� ���ֽ��ϴ�.");
	}
	public void searchSuccess(int a) {
		System.out.println(a+"���� �ֽ��ϴ�.");
	}
	public void searchFalse(int a) {
		System.out.println(a+"���� �����ϴ�.");
	}
	public void deleteSuccess(int a) {
		System.out.println(a+"���� �����߽��ϴ�.");
	}
	public void deleteFalse(int a) {
		System.out.println(a+"���� �����ϴ�.");
	}
}
