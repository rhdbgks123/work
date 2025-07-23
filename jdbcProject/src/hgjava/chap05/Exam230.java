package hgjava.chap05;

import java.util.Calendar;

public class Exam230 {

	public static void main(String[] args) {
		// 요일
		
		Calendar today = Calendar.getInstance();
//		System.out.println(today.toString());
		
		Week day = null;
		int dayNo = today.get(Calendar.DAY_OF_WEEK);
		
		switch(dayNo)
		{
			case 1: day = Week.SUNDAY; break;
			case 2: day = Week.MONDAY; break;
			case 3: day = Week.TUESDAY; break;
			case 4: day = Week.WEDNESDAY; break;
			case 5: day = Week.THURSDAY; break;
			case 6: day = Week.FRIDAY; break;
			case 7: day = Week.SATURDAY; break;
				
		}
		System.out.println(day);
	}

}
