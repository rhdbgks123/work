package 고유한;

import java.util.Scanner;

public class Report1 
	{
	public static void main(String[] args) 
	{
		int year = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도입력>");
		year = Integer.parseInt(sc.nextLine());
		
		if(year % 4 == 0 && year % 100 != 0)
		{
			System.out.println(year + "년은 윤년입니다.");	
		}
		else
		{
			if(year % 400 == 0)
			{
				System.out.println(year + "년은 윤년입니다.");
			}
			else
			{
				System.out.println(year + "년은 평년입니다.");
			}
		}
		sc.close();
	}
}

