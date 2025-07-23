package hgjava.chap02;

import java.util.Scanner;

public class Scanner117 {

	public static void main(String[] args) {
		// 통문자 읽어오기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[필수정보 입력]");
		System.out.print("1. 이름>>");
		String name = sc.nextLine();
		System.out.print("2. 주민번호 앞 6자리>>");
		String idNum = sc.nextLine();
		System.out.print("3. 전화번호>>");
		String phone = sc.nextLine();
		System.out.println();
		
		System.out.println("[입력된 내용]");
		System.out.printf("1. 이름 : %s\n", name);
		System.out.printf("2. 주민번호 앞 6자리 : %s\n", idNum);
		System.out.printf("3. 전화번호 : %s", phone);
		
		sc.close();
		
		
	}

}
