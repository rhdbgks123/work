package hgjava.chap04;

public class Ex182 {
	public static void main(String[] args) {
		//182 문제2
		// 1에서 100까지 정수 중 3의 배수 합, 3의 배수의 갯수
		int i = 1;
		int sum = 0;
		int count = 0;
		while (i <= 100)
		{
			if(i % 3 == 0)
			{
				sum += i;
				count ++;
			}
			i++;
		}
		System.out.printf("3의 배수의 합 : %d\n3의 배수의 개수 : %d",sum, count);
		System.out.println();
		sum = 0;
		count = 0;
		for (i = 1 ; i <= 100 ; i ++)
		{
			if(i % 3 == 0)
			{
				sum += i;
				count ++;
			}
		}
		System.out.printf("3의 배수의 합 : %d\n3의 배수의 개수 : %d\n",sum, count);
		
		//182 문제3
		//추가 : 몇번만에 탈출했는지
		int dice1 = 0;
		int dice2 = 0;
		int cnt = 0;
		
		while(dice1 + dice2 != 5)
		{
			cnt++;
			dice1 = (int)(Math.random() * 6) + 1;
			dice2 = (int)(Math.random() * 6) + 1;
			System.out.println(dice1 + " / " + dice2);
		}
		System.out.println("반복횟수 : " + cnt );
		
		for(int x = 1 ; x <= 10 ; x++)
		{
			for(int y = 1; y <= 10 ; y++)
			{
				if(4*x + 5*y == 60)
					System.out.printf("(%d,%d)",x,y);
			}
		}
		System.out.println();

		for(i = 0; i < 4 ; i ++)
		{
			for(int k = 3; k > i ; k --)
			{
				System.out.print(" ");
			}
			for(int j = 0 ; j <= i ; j ++) 
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		String stars = "";
		for(i = 0; i < 4 ; i ++)
		{
			stars += "*";
			System.out.printf("%4s\n",stars);
		}

		for(i = 1; i <= 4 ; i ++)
		{
			for(int k = 4; k > 0 ; k --)
			{
				if (i < k)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
