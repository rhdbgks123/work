package com.yedam.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		DBUtil util = new DBUtil();
		Connection conn = util.getConn();
		Statement stmt = null;
		String sSql = "";
		try {
			stmt = conn.createStatement(); // 쿼리해석 실행 -> 반환
			conn.setAutoCommit(false);
			
			sSql += "SELECT * FROM BOOK";
			
			ResultSet rs = stmt.executeQuery(sSql);
			while(rs.next())
			{
				System.out.println(rs.getInt("ID") + rs.getString("TITLE"));
			}
			
			sSql = "";
			
			sSql += "INSERT INTO book ( ";
			sSql += "    id ";
			sSql += "    , title ";
			sSql += "    , author ";
			sSql += ") VALUES ( ";
			sSql += "    4000 ";
			sSql += "  , '자바스크립트 기초' ";
			sSql += "  , '웹디' ";
			sSql += ") ";
			
			int r = stmt.executeUpdate(sSql);
			if (r > 0)
			{
				conn.commit();
			}
			else
			{
				conn.rollback();
			}
			
		} catch (SQLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}

}
