package chap02;

import java.io.IOException;

public class Exam106 {

	public static void main(String[] args) throws IOException {
		//문자열 -> 숫자

//		String str1 = "10";
//		String st2 = "3.14";
//		String str3 ="true";

		//p109 5번
		
		char c1 = 'a';
		System.out.println(c1);
		char c2 =(char)( c1 + 1);
		
	    System.out.println((char)c2);
	    
	    //p109 7번
//	    int x = 5;
//	    int y = 2;
	//    double result = (double)x/y;
	//    System.out.println(result);
		
	    //110 9번
	    long var1 = 2L;
	    float var2 = 1.8f;
	    double var3= 2.5;
	    String var4 = "3.9";
	    int result = 0;
	    
	    result = (int)(Double.parseDouble(var4)) +(int)(var1 + var2 +var3); 
	    
	    System.out.println(result);
	    
	    System.out.printf("정수 : %d, 실수 : %.1f, 실수 :%5.2f, 문자열 : %s, 결과 : %d \n", var1, var2, var3, var4, result);
		
	    //표준 입력장치로 키값 (유니코드) 입력받음
	    
		while(true) 
		{
			System.out.print("문자를 입력하세요.>>");
			int keyCode = 0;
			while(true)
			{
				keyCode = System.in.read();
				System.out.println(keyCode);
				if(keyCode == 10)
				{
					break;
				}
				if(keyCode == 113)
				{
					break;
				}
			}
	
			if(keyCode == 113)
			{
				System.out.println("끝");
				break;
			}
		}
	}// end main\
} // end class
	
