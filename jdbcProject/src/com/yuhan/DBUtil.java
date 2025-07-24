package com.yuhan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//DB 접속정보 활용 -> 세션(Connection)
	//ojdbc11.jar 외부 라이브러리 참조
	public static Connection getConn()
	{
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.15:1521:xe","scott","tiger");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		return conn;
	}
	
}
