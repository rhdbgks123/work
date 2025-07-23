package chap06_1;

import java.util.Scanner;

public class BookDao {

	Book[] books;
	Scanner sc = new Scanner(System.in);
	
	public Book[] setBook(int booknum)
	{
		books = new Book[booknum];
		
		for(int i = 0; i < books.length ; i ++)
		{
			System.out.println(i + 1 + "번째 도서 정보 입력");
			System.out.print("도서 번호>");
			int booknumber = Integer.parseInt(sc.nextLine());
			System.out.print("도서 제목>");
			String bookname = sc.nextLine();
			System.out.print("도서 가격>");
			int bookprice = Integer.parseInt(sc.nextLine());
			books[i] = new Book(booknumber, bookname, bookprice);
		}
		sc.close();
		return books;
	}
}
