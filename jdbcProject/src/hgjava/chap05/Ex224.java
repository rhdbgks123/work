package chap05;

import java.util.Scanner;

public class Ex224 {

	public static void main(String[] args) {
		//확인문제 6번
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int min = 100;
		int cnt = 0;
		int sum = 0;
		double avg = 0.0;
		
		while(run)
		{
			System.out.println("---------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("---------------------------------------------------------");
			System.out.print("선택>");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			if(selectNo >5 || selectNo <1)
			{
				System.out.println("1 ~ 5 사이 숫자만 입력해 주세요");
				continue;
			}
			
			switch(selectNo)
			{
				case 1:
					System.out.print("학생 수>");
					studentNum = Integer.parseInt(sc.nextLine());
					scores = new int[studentNum];
					max = 0; min = 100; sum = 0; avg = 0.0; cnt = 0;
					break;
				case 2:
					if(scores == null) 
					{
						System.out.println("학생수를 먼저 입력 해 주세요.");
						continue;
					}
					for(int i = 0 ; i < studentNum ; i ++)
					{
						System.out.printf("scores[%d]>",i);
						scores[i] = Integer.parseInt(sc.nextLine());
						if(max < scores[i])
							max = scores[i];
						if(min > scores[i])
							min = scores[i];
						sum += scores[i];
					}
					avg = (double)sum / studentNum;
					cnt++;
					break;
				case 3:
					if(scores == null) 
					{
						System.out.println("학생수를 먼저 입력 해 주세요.");
						continue;
					}
					if(cnt == 0)
					{
						System.out.println("점수를 먼저 입력 해 주세요.");
						break;
					}
					
					for(int i = 0 ; i < studentNum ; i ++)
					{
						System.out.printf("scores[%d]> %d\n",i, scores[i]);
					}
					break;					
				case 4:
					if(scores == null) 
					{
						System.out.println("학생수를 먼저 입력 해 주세요.");
						continue;
					}
					if(cnt == 0)
					{
						System.out.println("점수를 먼저 입력 해 주세요.");
						break;
					}
					System.out.println("최고점수 : " + max);
					System.out.println("최저점수 : " + min);
					System.out.println("전체점수 : " + sum);
					System.out.println("평균점수 : " + avg);
					break;
				case 5:
					run = false;
					sc.close();
			
			}
					
					
			
			
		}

	}

}
