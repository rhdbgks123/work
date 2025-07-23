package chap02;

public class Variable {

	public static void main(String[] args) {

		int x = 10;
		int y = 50;
		int temp =  0;
		
		temp = x;
		x = y;
		y = temp;
		System.out.println("x = " + x + " y = " + y);
		
		//기본타입
		char font = 'A';
		int intchar = font + 1;
		char font2 = (char)intchar;
		System.out.println(font);
		System.out.println(intchar);
		System.out.println(font2);
		
		//문자열 저장 => String 객채타입 변수 생성
		String str = "홍길동";
		
		System.out.println(str);
		
		int su1 = 1;
		int su2 = 3;
		//int result = su1/su2;
		double result = (double)su1/su2;
		System.out.println(result);
		
		
		
	}

}
