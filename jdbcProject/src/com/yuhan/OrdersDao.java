package com.yuhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrdersDao
{

	String sSql = "";
	Connection conn = DBUtil.getConn();

	public boolean updateOrders(String ordno)
	{
		sSql = "";
		sSql += " UPDATE tb_orders ";
		sSql += "    SET status = 9 ";
		sSql += "  WHERE order_no = ? ";

		try
		{
			PreparedStatement stmt = conn.prepareStatement(sSql);
			stmt.setString(1, ordno);

			int r = stmt.executeUpdate();

			if (r > 0)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;

	}

	public boolean insertOrders(String order_no, String user_id)
	{

		try
		{
			sSql = "";
			sSql += " INSERT INTO tb_orders ( ";
			sSql += "     order_no ";
			sSql += "     , order_date ";
			sSql += "     , user_id ";
			sSql += " ) VALUES ( ";
			sSql += "     ? ";
			sSql += "   , trunc(sysdate) ";
			sSql += "   , ? ";
			sSql += " ) ";

			PreparedStatement stmt = conn.prepareStatement(sSql);
			stmt.setString(1, order_no); // ? 첫번째에 값을 지정
			stmt.setString(2, user_id); // ? 첫번째에 값을 지정

			int r = stmt.executeUpdate(); // 실행된 쿼리의 결과 count반환

			if (r < 1)
			{
				conn.rollback();
				return false;
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return true;

	}

	public boolean insertOrderdetail(ArrayList<Orders> list)
	{

		try
		{
			// for (int i = 0; i < list.size(); i++) {
			// System.out.println("Order No: " + list.get(i).getOrder_no());
			// System.out.println("Item Code: " + list.get(i).getItem_code());
			// System.out.println("Item Qty: " + list.get(i).getItem_qty());
			// }

			for (int i = 0 ; i < list.size() ; i++)
			{
				sSql = "";
				sSql += " INSERT INTO tb_orderdetail ( ";
				sSql += "     order_no ";
				sSql += "     , orderdetail_no ";
				sSql += "     , item_code ";
				sSql += "     , item_qty ";
				sSql += " ) VALUES ( ";
				sSql += "     ? ";
				sSql += "   , ? ";
				sSql += "   , ? ";
				sSql += "   , ? ";
				sSql += " ) ";

				PreparedStatement stmt = conn.prepareStatement(sSql);
				stmt.setString(1, list.get(i).getOrder_no()); // ? 첫번째에 값을 지정
				stmt.setString(2, getOrderdetailSeq());
				stmt.setString(3, list.get(i).getItem_code());
				stmt.setInt(4, list.get(i).getItem_qty());

				int r = stmt.executeUpdate(); // 실행된 쿼리의 결과 count반환

				if (r < 1)
				{
					conn.rollback();
					return false;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	public ArrayList<Orders> findOrder(String order_no, String order_date)
	{
		ArrayList<Orders> list = null;
		ResultSet rs = null;

		try
		{
			list = new ArrayList<Orders>();
			Statement stmt = conn.createStatement();

			sSql = "";
			sSql += " SELECT usr.user_name ";
			sSql += "      , itm.item_name ";
			sSql += "      , odd.item_qty ";
			sSql += "      , REGEXP_REPLACE(usr.phone, '(.{3})(.{4})(.{4})', '\\1-\\2-\\3') phone ";
			sSql += "      , usr.address ";
			sSql += "   FROM tb_orders ord ";
			sSql += "   JOIN tb_orderdetail odd ";
			sSql += "     ON ord.order_no = odd.order_no ";
			sSql += "   JOIN tb_user        usr ";
			sSql += "     ON ord.user_id = usr.user_id ";
			sSql += "   JOIN tb_item_master itm ";
			sSql += "     ON odd.item_code = itm.item_code ";
			sSql += "  WHERE 1=1";
			sSql += "    AND ord.status != 9 ";

			if (order_no != null && order_no != "")
				sSql += "   AND ord.order_no like '%" + order_no + "%' ";

			if (order_date != null && order_date != "")
				sSql += "   AND ord.order_date = to_date('" + order_date + "', 'YYMMDD')";

			rs = stmt.executeQuery(sSql);

			while (rs.next())
			{
				Orders order = new Orders();
				order.setUser_name(rs.getString("user_name"));
				order.setItem_name(rs.getString("item_name"));
				order.setItem_qty(rs.getInt("item_qty"));
				order.setPhone(rs.getString("phone"));
				order.setAddress(rs.getString("address"));
				list.add(order);
			}

		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return list;
	}

	public boolean checkOrders(String ordno)
	{

		try
		{
			Statement stmt = conn.createStatement();

			sSql = "";
			sSql += " SELECT count(1) ";
			sSql += "   FROM tb_orders ";
			sSql += "  WHERE order_no = '" + ordno + "' ";
			sSql += "    AND status != 9 ";

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

	public String getOrderSeq()
	{
		String seq = "";

		try
		{
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"select 'WO' || to_char(sysdate,'YYMMDD') || lpad(order_seq.nextval, 5, 0) seq from dual");

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

	public void createOrderdetailSeq()
	{

		try
		{
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("create sequence orderdetail_seq");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void dropOrderdetailSeq()
	{

		try
		{
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("drop sequence orderdetail_seq");

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public String getOrderdetailSeq()
	{
		String seq = "";

		try
		{
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select orderdetail_seq.nextval seq from dual");

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

}
