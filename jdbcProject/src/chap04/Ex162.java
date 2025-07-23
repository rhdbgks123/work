package chap04;

public class Ex162 {

	public static void main(String[] args)
	{
		// 주사위게임
		// 주사위 2개를 던져서 합이 10을 넘으면 두 수를 더하고
		// 아니면 두수를 곱한 결과를 출력
		int dice1, dice2;
		int temp = 0;
		
		dice1 = (int)(Math.random() * 6) + 1;
		dice2 = (int)(Math.random() * 6) + 1;
		
		temp = dice1 + dice2;
		
		if(temp >= 10)
			System.out.println("덧셈결과 : " + temp  + " " + dice1 + " " + dice2);
		else
		{
			System.out.println("곱셈결과 : " + (dice1 * dice2) + " " + dice1 + " "  + dice2);
			
		}
		// 오전시간(9~12) 일정 출력
		// 현재시간 확인
		// 9시 : 출근합니다
		// 10시 : 회의합니다
		// 11시 : 업무를 봅니다
		// 12시 : 외근을 나갑니다
		
		//169p 문제 3 -> switch로
		int score = 85;
		System.out.print("등급은");
		switch(score / 10) {
			case 10 :
			case 9 :
				System.out.print("A");
				break;
			case 8 :
				System.out.print("B");
				break;
			case 7 :
				System.out.print("C");
				break;
			default :
				System.out.print("D");
		}
		System.out.println("감사합니다.");
		
	}
}
