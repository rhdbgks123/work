package chap03;

import java.util.Scanner;

public class Ex149 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁

		byte b = 5;
		b = (byte)-b;
		int result = 10/b;
		System.out.println(result);
				
		
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		System.out.println(z);
		
		boolean stop = true;
		while(!stop)
		{
			
		}
		
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = (pencils / students);
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = (pencils % students);
		System.out.println(pencilsLeft);

		
		int var1 = 5;
		int var2 = 2;
		double var3 = (double)var1/var2;
		int var4 = (int) (var3*var2);
		System.out.println(var4);
		
		int value = 356;
		System.out.println(value/100*100);
		
		float var11 = 10f;
		float var22 = var11 / 100;
		if (var22 == (float)0.1)
		{
			System.out.println("10%입니다.");
		}
		else
		{
			System.out.println("10%가 아닙니다.");
		}
		
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (((double)lengthTop + (double)lengthBottom) * (double)height / (double)2);
		System.out.println(area);
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("첫 번째 수 : ");
//		double first = Double.parseDouble(sc.next());
//		System.out.print("두 번재 수 : ");
//		double second = Double.parseDouble(sc.next());
//		System.out.println("---------------------");
//		String result1 = second == 0.0 ? "무한대" : String.valueOf(first / second);
//		System.out.println("결과 : " + result1);
//		
//		sc.close();
		int var111 = 20;
		int var222 = 3;
		int var333 = 14;
		double var444 = var111 * var111 * Double.parseDouble(var222 + "." + var333);
		
		System.out.println("원의 넓이 : " + var444);
		
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.print("아이디 : ");
//		String name = scanner.nextLine();
//		
//		System.out.print("패스워드 : ");
//		String strPassword = scanner.nextLine();
//		int password = Integer.parseInt(strPassword);
//		
//		if (name.equals("java"))
//		{
//			if(password == 12345)
//			{
//				System.out.println("로그인 성공");
//			}
//			else
//			{
//				System.out.println("로그인 실패 : 패스워드가 틀림");
//			}
//		}
//		else
//		{
//			System.out.println("로그인 실패 : 아이디 존재하지 않음");
//		}
//		
//		scanner.close();
		
		int xx = 10;
		int yy = 5;
		System.out.println((xx>7) && (yy<=5));
		System.out.println((x%3 ==2) || (y%2 != 1));
		
//		int value1 = 0;
//		
//		value1 += 10;
//		value1 -= 10;
//		value1 *= 10;
//		value1 /= 10;
		
		int score = 85;
		String result2 = (!(score>90)) ? "가" : "나";
		System.out.println(result2);
		
		Scanner SC = new Scanner(System.in);
		
		System.out.print("##년도 입력 : ");
		int year = Integer.parseInt(SC.nextLine());
		
		if(year % 4 == 0)
		{
			if(year % 100 == 0)
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
			else
			{
				System.out.println(year + "년은 윤년입니다.");
			}
		}
		else
		{
			System.out.println(year + "년은 평년입니다.");
		}
		SC.close();
		
		
		
	}

}
