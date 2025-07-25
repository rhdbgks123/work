package com.yedam;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.Bookmapper;
import com.yedam.vo.Book;

public class BookControl
{
	Scanner sc = new Scanner(System.in);
	SqlSession session = DBUtil.getInstance().openSession();
	Bookmapper mapper = session.getMapper(Bookmapper.class);

	public void exe()
	{
		boolean run = true;

		while (run)
		{
			System.out.println("도서정보 관리");
			System.out.println("1. 도서목록");
			System.out.println("2. 도서등록");
			System.out.println("0. 이전메뉴");
			System.out.print("선택>>");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu)
			{
				case 1 :
					bookList();
					break;
				case 2 :
					addBook();
					break;
				case 0 :
					return;
				default :
					System.out.println("메뉴를 선택하세요.");
			}
		}
	}

	void bookList()
	{
		int page = 1;
		while(true)
		{
			List<Book> list = mapper.selectBooks(page);
			System.out.println("도서ID\t도서제목\t가격");
			System.out.println("-----------------------");
	
			for (Book book : list)
			{
				System.out.println(book.showBrief());
			}
			System.out.println("-----------------------");
	
			System.out.println("이전(p) 다음(n) 선택>>");
			String p = sc.nextLine();
			if(p.equals("n"))
				page++;
			else if(p.equals("p"))
			page--;
		}
//		searchBook();
	}

	void addBook()
	{
		System.out.print("도서ID>>");
		String id = sc.nextLine();
		System.out.print("도서제목>>");
		String title = sc.nextLine();
		System.out.print("도서저자>>");
		String author = sc.nextLine();
		System.out.print("도서가격>>");
		String price = sc.nextLine();

		Book book = new Book();
		book.setId(Integer.parseInt(id));
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(Integer.parseInt(price));

		// return이 1이면 성공 0이면 실패
		if (mapper.insertBook(book) == 1)
		{
			session.commit();
			System.out.println("입력성공");
		}

	}

	void searchBook()
	{

		Book books = null;

		while (true)
		{
			System.out.print("상세보기(ID)입력, 취소(Q) / 선택 >>");
			String input = sc.nextLine();

			try
			{
				// if(input.equals("q") || input.equals("Q"))
				// return;
				books = mapper.selectBook(Integer.parseInt(input));

				if (books == null)
				{
					System.out.println("검색결과 없음");
				}
				else
				{
					
					System.out.println(books.showDetail());
					System.out.print("삭제하시겠습니까? y/N >>");
					String flag = sc.nextLine();
					if(flag.equals("y"))
					{
						if(mapper.deleteBook(books.getId()) == 1)
						{
							session.commit();
							System.out.println("삭제성공");
							break;
						}
						else
						{
							System.out.println("삭제실패");
							return;
						}
					}
				}
			}
			catch (NumberFormatException e)
			{
				return;
			}
		}

	}
}
