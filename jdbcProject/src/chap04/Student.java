package chap04;

public class Student {
	
	// f
	//이름
	//학번
	//점수 3개
	
	String sname = "";
	String sId = "";
	int kor = 0;
	int eng = 0;
	int mat = 0;
	
	
	//c
	//par 
	public Student(String sname, String sId, int kor, int eng, int mat)
	{
		this.sname = sname;
		this.sId = sId;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	
	//m
	//총점, 평균, grade 
	
	public int scoreSum()
	{
		int sum = kor + eng + mat;
	
		return sum;
	}
	
	public int scoreAvg()
	{
		int avg = scoreSum() / 3;
		
		return avg;
	}
	
	public char scoreGrade()
	{
		char grade;
		switch(scoreAvg() / 10)
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
