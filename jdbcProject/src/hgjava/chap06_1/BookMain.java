package chap06_1;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		BookDao bookdao = new BookDao();
		Book[] book = null;
		Scanner sc = new Scanner(System.in);
		
		int usernum = 0;
		boolean run = true;
		
		int booknum = 0;
		
		while(run) {
		
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("1. 도서수 입력 | 2. 도서정보 등록 | 3. 도서정보 전체조회 | 4. 도서정보 분석 | 5. 종료");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.print("선택>");
			usernum = Integer.parseInt(sc.nextLine());
			
			switch(usernum)
			{
				case 1: 
					System.out.print("도서 수>");
					booknum = Integer.parseInt(sc.nextLine());
					break;
				case 2: 
					if(booknum == 0)
					{
						System.out.println("도서 수량을 먼저 입력 후 정보를 등록 해 주세요");
						continue;
					}
					book = bookdao.setBook(booknum);
					break;
				case 3:
					if(booknum == 0)
					{
						System.out.println("도서 수량을 먼저 입력 후 정보를 등록 해 주세요");
						continue;
					}
					for(int i = 0; i < book.length ; i ++)
					{
						System.out.printf("%d번째 도서 / 도서번호 : %d 도서명 : %s 가격 : %d\n", i + 1 , book[i].getBookNum(), book[i].getBookName(), book[i].getPrice());
					}
					break;
				case 4:
					if(booknum == 0)
					{
						System.out.println("도서 수량을 먼저 입력 후 정보를 등록 해 주세요");
						continue;
					}
					int sum = 0;
					int max = 0;
					int min = 9999999;
					double avg = 0;
					for(int i = 0 ; i < book.length ; i ++)
					{
						if(max < book[i].getPrice())
							max = book[i].getPrice();
						if(min > book[i].getPrice())
							min = book[i].getPrice();
						sum += book[i].getPrice();
					}
	
					avg = (double)sum/book.length;
					
					System.out.println("최고가격 : " + max + "원");
					System.out.println("최저가격 : " + min + "원");
					System.out.println("평균가격은 " + avg + "원 입니다.");
					break;
				case 5 :
					run = false;
					sc.close();
					
			}
		}
		
	}

}
