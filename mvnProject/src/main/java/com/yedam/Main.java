package com.yedam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DBUtil;
import com.yedam.mapper.Bookmapper;
import com.yedam.vo.Book;

public class Main {
	public static void main(String[] args)
	{
		BookControl ctrl = new BookControl();
		
		ctrl.exe();
	}
	void backup()
	{
		//RunEx는 Runnable을 구현하는 클래스
		RunEx ex = new RunEx();
		ex.run();
		
//		SqlSessionFactory factory = DBUtil.getInstance(); //DBUtil에 선언한 getInstance
		SqlSession session = DBUtil.getInstance().openSession();//factory.openSession(); // sqlsession 객체반환
		
		Book book = session.selectOne("com.yedam.mapper.Bookmapper.selectBook", 1000);
		
		System.out.println(book);
		
		List<Book> list = session.selectList("com.yedam.mapper.Bookmapper.selectBooks");
		
		for(int i = 0 ; i < list.size() ; i ++)
		{
			System.out.println(list.get(i).toString());
		}
		
		//인터페이스 - 구현클래스
		Bookmapper mapper = session.getMapper(Bookmapper.class);
		Book book2 = mapper.selectBook(1001);
		List<Book> list2 = mapper.selectBooks(1);
		// mapper를 인터페이스로 따로 구현해 두면 getMapper를 통해 동일한 ID를 각각 매핑해줌

		
		System.out.println(book2.toString());
		
		for(Book books : list2)
		{
			System.out.println(books.toString());
		}
		
		session.close();
		
		
//		System.out.println(list);
	}
}
