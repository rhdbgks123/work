package 고유한;

import java.util.Scanner;

public class Report6 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		//0 가위 1 바위 보 2
		int com = 0;
		int me = 0;
		Scanner sc = new Scanner(System.in);
		String result = "";
		int temp = 0;
		while(true)
		{
			com = (int)(Math.random()*3);
			System.out.print("가위(0) 바위(1) 보(2) : ");
			me = Integer.parseInt(sc.nextLine());
			
			if(me > 2)
				break;
			
			temp = (me - com + 3) % 3;
			
			System.out.printf("사람 %d 컴 %d ", me, com);
			if(temp == 0)
				result = "비겼음";
			else if (temp == 1)
				result = "사람 승리";
			else
				result = "컴 승리";
			System.out.print(result + "\n");
		}
		sc.close();
		System.out.println("game over");
	}

}
