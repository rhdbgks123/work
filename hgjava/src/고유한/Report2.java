package 고유한;

import java.util.Scanner;

public class Report2 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		int money = 0;
		int coin[] = {500, 100, 50, 10};
		int coincnt = 0;
		int change = 0;
		
		System.out.print("교환할 금액 입력 : ");
		money = Integer.parseInt(sc.nextLine());
		sc.close();
		for (int i = 0 ; i < coin.length ; i ++)
		{
			
			coincnt = money / coin[i];
			money %= coin[i];
			change += coincnt * coin[i];
			
			System.out.print(coin[i] + "원 짜리 : " + coincnt + "개\n");

		}
		
		System.out.println("교환금액 : " + change + "원");
		System.out.println("남은금액 : " + money + "원");
		
	}

}
