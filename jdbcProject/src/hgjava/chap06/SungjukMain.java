package hgjava.chap06;

import java.util.Scanner;

public class SungjukMain {

	public static void main(String[] args) {

		StudentDao stdao = new StudentDao();
		Student[] sts = null;

		int usersel = 0;
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		int stcnt = 0;
		
		while(run)
		{
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("1. 학생수 입력 | 2. 학생점수 등록 | 3. 학생점수 전체조회 | 4. 학생점수 분석 | 5. 종료");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.print("선택>");
			usersel = Integer.parseInt(sc.nextLine());
			switch(usersel)
			{
				case 1 :
					System.out.print("학생 수>");
					stcnt = Integer.parseInt(sc.nextLine());
					break;
				case 2 : 
					sts = stdao.stData(stcnt);
					break;
				case 3 :
					System.out.println("석차\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
					for(int i = 0 ; i < sts.length ; i ++)
					{
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n",i+1, sts[i].sname, sts[i].kor, sts[i].eng, sts[i].mat, sts[i].sum, sts[i].avg, sts[i].grade);
					}
					break;
				case 4 :
					
			}
			
			
		}
		
		
		
		
		
		
		
		
//		for(int i = 0 ; i < sts.length ; i ++)
//		{
//			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\n", sts[i].sname, sts[i].kor, sts[i].eng, sts[i].mat, sts[i].scoreSum(), sts[i].scoreAvg(), sts[i].scoreGrade());
//		}
	}

}
