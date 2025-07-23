package chap05;

public class Arr204 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		// 배열생성, 배열데이터 활용
		int[] scores = {83, 90, 87};
		int sum1 = 0;
		for(int i = 0; i < scores.length ; i ++)
		{
			sum1 += scores[i];
		}
		System.out.println("총합 : " + sum1);
		
		int sum2 = add(new int[] {80, 90, 100});
		System.out.println("총합 : " + sum2);
		System.out.println();
		
		//int형의 크기 5개짜리 배열 선언
		// 배열에 50 ~ 1-- 사이의 수 5개 입력
		// 배열의 합 계산

		int[] iArr = {(int)(Math.random()*50) + 50,(int)(Math.random()*50) + 50,(int)(Math.random()*50) + 50,(int)(Math.random()*50) + 50,(int)(Math.random()*50) + 50 };
		
		
		System.out.println(iArr[0] + " / " + iArr[1] + " / " + iArr[2] + " / " + iArr[3] + " / " + iArr[4]);
		
		System.out.println(add(iArr));
		
	}
	
	public static int add(int[] scores)
	{
		int sum = 0;
		for(int i = 0 ; i < scores.length ; i++)
		{
			sum+= scores[i];
		}
		return sum;
	}

}
