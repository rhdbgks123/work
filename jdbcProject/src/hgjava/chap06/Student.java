package chap06;

public class Student {

	// 필드
	// 객체의 속성(데이터)
	String sname = "";
	String sId = "";
	int kor = 0;
	int eng = 0;
	int mat = 0;
	double avg = 0.0;
	int sum = 0;
	char grade = 'F';
	
	// 생성자
	// 객체 생성 시 속성값을 초기화
	public Student(String sname, String sId, int kor, int eng, int mat, int sum, double avg, char grade)
	{
		this.sname = sname;
		this.sId = sId;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
		this.avg = avg;
		this.grade = grade;
	}

	public Student(String sname, int kor, int eng, int mat, int sum, double avg, char grade)
	{
		this.sname = sname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
		this.avg = avg;
		this.grade = grade;
	}
	
	
	public Student(String sname, String sId, int kor, int eng, int mat)
	{
		this.sname = sname;
		this.sId = sId;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public Student(String sname, int kor, int eng, int mat)
	{
		this.sname = sname;
		this.sId = "0";
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	// 메소드
	// 객체의 기능
	
	
}
