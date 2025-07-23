package hgjava.고유한;

public class Report7 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String output = "";
		String temp[];
		int cnt = 0;
		
		for(int i = 1; i <= 50 ; i ++)
		{
			cnt = 0;
			temp = String.valueOf(i).split("");
			
			for(int j = 0 ; j < temp.length ; j ++)
			{
				if(temp[j].equals("3") || temp[j].equals("6") || temp[j].equals("9"))
				{
					cnt++;
				}
			}
			if (cnt == 2)
				output += "♥♥\t";
			else if (cnt == 1)
				output += "♥\t";
			else
				output += i + "\t";

			if(i % 10 == 0)
				output += "\n";
		}
		System.out.println(output);
	}

}
