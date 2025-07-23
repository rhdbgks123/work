package hgjava.고유한;

public class Report4 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁

		for(int i = 2; i <= 9 ; i ++)
		{
			System.out.print(i + "단\t");
		}
		System.out.println();
		for(int i = 1 ; i <= 9 ; i ++)
		{
			for(int j = 2 ; j <= 9 ; j ++)
			{
				System.out.printf("%dX%d=%2d\t", j, i, j*i);
			}
			System.out.println();
		}
	}

}
