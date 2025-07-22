package com.yedam;

import java.util.ArrayList;

public class ListExe {
	public static void main(String[] args) {
	
		//ArrayList 클래스 vs 배열
		
		// 배열
		int[] iArr = {10, 20, 30};
		
		for(int i = 0 ; i < iArr.length ; i ++)
		{
			System.out.println(i + " : " + iArr[i]);
		}
		
		System.out.println();
		
		// ArrayList로 변경
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		
		for (int i = 0 ; i < list.size() ; i ++)
		{
			System.out.println(i + " : " + list.get(i));
		}
		
		//학생정보
		
		ArrayList<Student> stdList = new ArrayList<Student>();
		
		
		Student s1 = new Student(); // 인스턴스
		
		s1.setStdNo(1000);
		s1.setStdName("고유한");
		s1.setPhone("010-0000-0000");
		s1.setBloodType("A");
		
		stdList.add(s1);
		
		Student s2 = new Student(2000,"홍길동","010-1111-2222","B");
		
		stdList.add(s2);

		stdList.add(new Student(3000,"강감찬","010-3333-4444","O"));
		
		for (int i = 0 ; i < stdList.size() ; i ++)
		{
			System.out.println(i + " : " + stdList.get(i).getStdNo() + " : " + stdList.get(i).getStdName() + " : " + stdList.get(i).getPhone() + " : " + stdList.get(i).getBloodType());
			
		}
		
		System.out.println("end of prog.");
		
		
		
	}
}
