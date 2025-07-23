package hgjava.고유한;

import java.util.Scanner;

public class Report5 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		int tem = 0;
		int input = 0;
		boolean check = true;
		
		while(check)
		{
			System.out.println("------------------------");
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("------------------------");
			
			System.out.print("▶번호 선택 : ");
			input = Integer.parseInt(sc.nextLine());
			switch(input)
			{
				case 1 :
					System.out.print("▶화씨 온도 입력 : ");
					tem = Integer.parseInt(sc.nextLine());
					System.out.println("섭씨온도 : " + (double)5/9*(tem - 32));
					break;
				case 2 :
					System.out.print("▶섭씨 온도 입력 : ");
					tem = Integer.parseInt(sc.nextLine());
					System.out.println("화씨온도 : " + ((double)9/5*tem + (double)32));
					break;
				default :
					check = false;
					System.out.println("program end");
			}
		}

		sc.close();
		
	}

}
