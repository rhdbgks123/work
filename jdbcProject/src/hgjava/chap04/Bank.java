package hgjava.chap04;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁

		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		int select = 0;
		int money = 0;
		while(run)
		{
			money = 0;
			System.out.println("------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("------------------------------------");
			System.out.print("선택> ");
			select = Integer.parseInt(sc.nextLine());
			
			if(select > 4 || select < 1)
			{
				System.out.println();
				System.out.println("1~4 의 숫자만 입력 가능합니다.");
				continue;
			}
			
			switch(select)
			{
				case 1 :
					System.out.print("예금액>");
					money = Integer.parseInt(sc.nextLine());
					balance += money;
					break;
				case 2 :
					System.out.print("출금액>");
					money = Integer.parseInt(sc.nextLine());
					if (balance - money < 0)
					{
						System.out.println("잔고보다 많은 액수를 입력했습니다.");
						System.out.println("출금가능액 : " + balance);
					}
					else
					{
						balance -= money;
					}
					break;	
				case 3 :
					System.out.print("잔고>");
					System.out.println(balance);
					break;
				default :
					run = false;
			}
			System.out.println();
		}
		sc.close();
		System.out.println("프로그램 종료");
	}

}
