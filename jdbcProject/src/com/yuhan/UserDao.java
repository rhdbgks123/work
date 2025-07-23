package com.yuhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDao
{

	String sSql = "";
	private Connection conn = DBUtil.getConn();;

	public boolean userInsert(User user)
	{
		sSql = "";
		sSql += " INSERT INTO tb_user ( ";
		sSql += "     user_id ";
		sSql += "     , user_name ";
		sSql += "     , phone ";
		sSql += "     , address ";
		sSql += " ) VALUES ( ";
		sSql += "     ? ";
		sSql += "   , ? ";
		sSql += "   , ? ";
		sSql += "   , ? ";
		sSql += " ) ";

		try
		{
			PreparedStatement stmt = conn.prepareStatement(sSql);
			stmt.setString(1, user.getUser_id()); // ? 첫번째에 값을 지정
			stmt.setString(2, user.getUser_name());
			stmt.setString(3, user.getPhone());
			stmt.setString(4, user.getAddress());

			int r = stmt.executeUpdate(); // 실행된 쿼리의 결과 count반환

			if (r > 0)
			{ // 한건 입력이 되었으면..
				return true;
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<User> findUser(String user_name)
	{
		ArrayList<User> list = null;

		try
		{
			list = new ArrayList<User>();
			Statement stmt = conn.createStatement();

			sSql = "";
			sSql += " SELECT user_id ";
			sSql += "      , user_name ";
			sSql += "      , REGEXP_REPLACE(phone, '(.{3})(.{4})(.{4})', '\\1-\\2-\\3') phone";
			sSql += "      , address ";
			sSql += "   FROM tb_user ";
			if (user_name != null || user_name != "")
				sSql += " WHERE user_name like '%" + user_name + "%' ";

			ResultSet rs = stmt.executeQuery(sSql);

			while (rs.next())
			{
				User user = new User();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				list.add(user);
			}
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return list;
	}

	public String getUserSeq()
	{
		String seq = "";

		try
		{
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select lpad(user_seq.nextval, 5, 0) seq from dual");

			while (rs.next())
			{
				seq = rs.getString("seq");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return seq;
	}

	public boolean checkUser(String userid)
	{

		try
		{
			Statement stmt = conn.createStatement();

			sSql = "";
			sSql += " SELECT count(1) ";
			sSql += "   FROM tb_user ";
			if (userid != null && userid != "")
				sSql += " WHERE user_id = '" + userid + "' ";

			ResultSet rs = stmt.executeQuery(sSql);
			rs.next();
			if (rs.getInt(1) > 0)
				return true;
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return false;
	}
}
