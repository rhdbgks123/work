package com.yedam;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DBUtil;
import com.yedam.vo.Book;

public class Main {
	public static void main(String[] args)
	{
		DBUtil util = new DBUtil();
		SqlSessionFactory factory = util.getInstance(); //DBUtil에 선언한 getInstance
		SqlSession session = factory.openSession(); // sqlsession 객체반환
		
		Book book = session.selectOne("com.yedam.mapper.selectBook", 1000);
		
		System.out.println(book);
		
		
	}
}
