package hgjava.chap04;

public class Repeat {

	public static void main(String[] args)
	{
		// 주사위 게임
		// 주사위 2개 던져서 합이 10이되면 탈출
		// 5회이상이 되면 게임오버 출력
				
		for(int i = 0 ; i <= 4 ; i ++)
		{
			int dice1 = (int)(Math.random()*6) + 1;
			int dice2 = (int)(Math.random()*6) + 1;
			System.out.println(dice1 + " / " + dice2);
			if(dice1 + dice2 == 10)
			{
				System.out.println((i+1) + "회째 성공!");
				break;
			} 
			if(i == 4)
			{
				System.out.println("게임오버");
				break;
			}
		}
		
	}
}
