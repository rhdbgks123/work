package hgjava.chap05;

public class ExamArr {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int[] iArr = new int[10];
		
		int sum = 0;
		int max = 0;
		int min = 100;
		int cnt = 0;
		
		for(int i = 0 ; i < iArr.length ; i ++)
		{
			iArr[i] = (int)(Math.random()*100) + 1; 
			sum += iArr[i];
			System.out.println("배열값 : " + iArr[i]);
			if(min > iArr[i])
				min = iArr[i];
			if(max < iArr[i])
				max = iArr[i]; 
		}
		
		System.out.printf("합 : %d / 최대 : %d / 최소 : %d\n", sum, max, min);
	
		
		//배열의 요소 중 4의 배수 출력
		// 4의 배수 갯수 출력
		
		for(int i = 0 ; i < iArr.length ; i ++)
		{
			if(iArr[i]%4 == 0)
			{
				System.out.println(i+"번째 4의배수 " + iArr[i] + "발견");
				cnt++;
			}
		}
		System.out.println("4의 배수 " + cnt + "개");
		
		//2차원 배열 선언
		int[][] twoArr = {{80, 90},{70, 60, 50}};
		
		//2차원배열 출력
		for (int i = 0 ; i <twoArr.length ; i++)
		{
			for(int j = 0 ; j < twoArr[i].length ; j++)
				System.out.printf("| %d ",twoArr[i][j]);
			System.out.println();
		}
		
		int[][] tArr = {{1,2,3},{1,2},{1},{1,2,3}};
		
		for (int i = 0 ; i <tArr.length ; i++)
		{
			for(int j = 0 ; j < tArr[i].length ; j++)
				System.out.printf("%d ",tArr[i][j]);
			System.out.println();
		}
		
		int[][] theater = new int[3][10];
		cnt=0;
		
		for(int i = 0 ; i < theater.length ; i ++)
		{
			for(int j = 0 ; j < theater[i].length ; j ++)
			{
				theater[i][j] = (int)(Math.random()*2);
				cnt += theater[i][j];
				System.out.print(theater[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(cnt);

		int[][] student = new int[3][5];
		double[] avg = new double[3];
		
		for(int i = 0 ; i < student.length ; i ++)
		{
			sum = 0;
			for(int j = 0 ; j < student[i].length ; j ++)
			{
				student[i][j] = (int)(Math.random() * 51) + 50;
				sum += student[i][j];
				System.out.print(student[i][j] + " ");
			}
			System.out.println();
			avg[i] = sum/5.00;
			
		}
		for(int i = 0 ; i < avg.length ; i ++)
			System.out.printf("%d번 학생 평균 = %.2f\n",i+1, avg[i]);
		
		
		String[][] cards = {{"C","D","H","S"},{"A","2","3","4","5","6","7","8","9","10","J","Q","K"}};
		
		String output = "";
		
		for(int i = 0 ; i < cards.length ; i ++)
		{
			output += cards[i][(int)(Math.random()*cards[i].length)];
		}
		System.out.println(output);
		
		int[][] rans = new int[3][5];
		int x, y;
		
		x=0; y=0;
		for(int i = 0 ; i < 5 ; i ++)
		{
			x = (int)(Math.random()*3);
			y = (int)(Math.random()*5);
			if(rans[x][y] == 1)
				i--;
			else
				rans[x][y] = 1;
		}
		for(int i = 0; i < rans.length ; i ++)
		{
			for(int j = 0 ; j < rans[i].length ; j ++)
			{
				System.out.print(rans[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(Week.SUNDAY);
		
	}
}
