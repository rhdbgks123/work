package com.yuhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDao
{
	String sSql = "";
	private Connection conn = DBUtil.getConn();;

	public boolean itemInsert(Item item)
	{
		sSql = "";
		sSql += " INSERT INTO tb_item_master ( ";
		sSql += "     item_code ";
		sSql += "     , item_name ";
		sSql += "     , price ";
		sSql += "     , spec ";
		sSql += " ) VALUES ( ";
		sSql += "     ? ";
		sSql += "   , ? ";
		sSql += "   , ? ";
		sSql += "   , ? ";
		sSql += " ) ";

		try
		{
			PreparedStatement stmt = conn.prepareStatement(sSql);
			stmt.setString(1, item.getItem_code()); // ? 첫번째에 값을 지정
			stmt.setString(2, item.getItem_name());
			stmt.setInt(3, item.getPrice());
			stmt.setString(4, item.getSpec());

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

	public ArrayList<Item> findItem(String item_code)
	{
		ArrayList<Item> list = null;

		try
		{
			list = new ArrayList<Item>();
			Statement stmt = conn.createStatement();

			sSql = "";
			sSql += " SELECT item_code ";
			sSql += "      , item_name ";
			sSql += "      , price ";
			sSql += "      , spec ";
			sSql += "   FROM tb_item_master ";
			if (item_code != null || item_code != "")
				sSql += " WHERE item_code like '%" + item_code + "%' ";

			ResultSet rs = stmt.executeQuery(sSql);

			while (rs.next())
			{
				Item item = new Item();
				item.setItem_code(rs.getString("item_code"));
				item.setItem_name(rs.getString("item_name"));
				item.setPrice(rs.getInt("price"));
				item.setSpec(rs.getString("spec"));
				list.add(item);
			}
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return list;
	}

	public boolean checkItem(String itemcd)
	{

		try
		{
			Statement stmt = conn.createStatement();

			sSql = "";
			sSql += " SELECT count(1) ";
			sSql += "   FROM tb_item_master ";
			if (itemcd != null && itemcd != "")
				sSql += " WHERE item_code = '" + itemcd + "' ";

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