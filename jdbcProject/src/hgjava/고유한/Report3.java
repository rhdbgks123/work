package hgjava.고유한;

import java.util.Scanner;

public class Report3 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int gNum = (int)(Math.random() * 100) + 1;
		int sNum = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("숫자입력>");
			sNum = Integer.parseInt(sc.nextLine());
			if(gNum < sNum)
				System.out.println("down 하세요");
			else if (gNum > sNum)
				System.out.println("up하세요");
			else
			{
				System.out.println("축하합니다!");
				break;
			}
				
		}
		sc.close();
			
	}

}
