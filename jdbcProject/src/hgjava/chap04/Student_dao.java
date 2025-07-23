package hgjava.chap04;


public class Student_dao {

    private static Student[] students;
    private static int count; // 현재 저장된 학생 수

    public Student_dao() {
        students = new Student[count];
        count = 0;
    }
    
    public static void addStudent(Student student) {
        if (count < 100) {
            students[count++] = student;
        } else {
            System.out.println("100명이상 저장불가능합니다.");
        }
    }
    
    public Student getStudent(int i)
    {
    	return students[i];
    }

    public Student[] getStudent()
    {
    	return students;
    }
    
	
}
