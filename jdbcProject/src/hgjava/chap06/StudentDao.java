package chap06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StudentDao {
	//학생 데이터 생성

	//필드
	
	Student[] sts;
	Scanner sc = new Scanner(System.in);
	
	//생성자 : 기본생성자 => 컴파일러가 자동 생성
	//메소드
	public Student[] stData(int stcnt) {


		sts = new Student[stcnt];
		for(int i = 0 ; i < stcnt ; i ++)
		{
			System.out.println(i + 1 + "번째 학생 정보입력>");
			System.out.print("학생이름>");
			String sname = sc.nextLine();
			System.out.print("국어점수>");
			int kor = Integer.parseInt(sc.nextLine());
			System.out.print("수학점수>");
			int mat = Integer.parseInt(sc.nextLine());
			System.out.print("영어점수>");
			int eng = Integer.parseInt(sc.nextLine());
			sts[i] = new Student(sname, kor, eng, mat, scoreSum( kor, eng, mat), scoreAvg( kor, eng, mat), scoreGrade( kor, eng, mat)); 
			
		}
		return sts;
	}
	

	public int scoreSum(int kor, int eng, int mat)
	{
		return kor + eng + mat;
	}
	
	public double scoreAvg(int kor, int eng, int mat)
	{
		return scoreSum( kor, eng, mat) / 3.00;
	}
	
	public char scoreGrade(int kor, int eng, int mat)
	{
		char grade;
		switch((int)scoreAvg( kor, eng, mat) / 10)
		{
			case 10 :
			case 9 : grade = 'A'; break;
			case 8 : grade = 'B'; break;
			case 7 : grade = 'C'; break;
			case 6 : grade = 'D'; break;
			default : grade = 'F';
			
		}
		
		return grade;
	}
	
}
