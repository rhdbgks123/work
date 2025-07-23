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

	public boolean insertOrders(String order_no, String user_id, String to_user, String to_address, String to_phone)
	{

		try
		{

			sSql = "";
			sSql += " INSERT INTO tb_orders ( ";
			sSql += "     order_no ";
			sSql += "     , order_date ";
			sSql += "     , user_id ";
			sSql += "     , to_user ";
			sSql += "     , to_address ";
			sSql += "     , to_phone ";
			sSql += " ) VALUES ( ";
			sSql += "     ? ";
			sSql += "   , trunc(sysdate) ";
			sSql += "   , ? ";
			sSql += "   , ? ";
			sSql += "   , ? ";
			sSql += "   , ? ";
			sSql += " ) ";

			PreparedStatement stmt = conn.prepareStatement(sSql);
			stmt.setString(1, order_no); 
			stmt.setString(2, user_id);
			stmt.setString(3, to_user);
			stmt.setString(4, to_address);
			stmt.setString(5, to_phone);

			int r = stmt.executeUpdate(); // 실행된 쿼리의 결과 count반환

			if (r < 1)
			{
				return false;
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
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
					return false;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
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
	
	public String getUserEmail()
	{
		String Users = null;
		try
		{
			Statement stmt = conn.createStatement();
			
			sSql = "";
			sSql += " SELECT LISTAGG(usr.email, ',') WITHIN GROUP (ORDER BY usr.email) email  ";
			sSql += "   FROM tb_orders ord ";
			sSql += "   JOIN tb_user usr ";
			sSql += "     ON ord.user_id = usr.user_id ";
			sSql += "  WHERE status = 0 ";
			sSql += "    AND order_date < trunc (sysdate) - 3 ";
			
			ResultSet rs = stmt.executeQuery(sSql);

			while (rs.next())
			{
				Users = rs.getString("email");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return Users;
	}
	public String getLastOrders()
	{
		String strOrd = "";

		try
		{
			Statement stmt = conn.createStatement();
			
			sSql = "";
			sSql += " SELECT '<tr padding = 5px>'     start_html ";
			sSql += "      , '<td>' || ord.order_no ";
			sSql += "                    || '</td>' order_no ";
			sSql += "      , '<td>' || ord.order_date ";
			sSql += "                    || '</td>' order_date ";
			sSql += "      , '<td>' || usr.user_name ";
			sSql += "                    || '</td>' user_name ";
			sSql += "      , '<td>' || itm.item_name ";
			sSql += "                    || '</td>' item_name ";
			sSql += "      , '<td>' || odd.item_qty ";
			sSql += "                    || '</td>' item_qty ";
			sSql += "      , '</tr>'    end_html ";
			sSql += "   FROM tb_orders ord ";
			sSql += "   JOIN tb_orderdetail odd ";
			sSql += " ON ord.order_no = odd.order_no ";
			sSql += "   JOIN tb_user        usr ";
			sSql += " ON ord.user_id = usr.user_id ";
			sSql += "   JOIN tb_item_master itm ";
			sSql += " ON odd.item_code = itm.item_code ";
			sSql += "  WHERE status = 0 ";
			sSql += "    AND order_date < trunc (sysdate) - 3 ";
			sSql += "  ORDER BY ord.order_no ";
			sSql += "         , odd.orderdetail_no ";
			
			ResultSet rs = stmt.executeQuery(sSql);
	
			strOrd += "<html><body><h2>미완료주문</h2>";
			strOrd += "<table border = 1px solid #ccc color = black><tr><th>주문번호</th><th>주문일자</th><th>담당자</th><th>상품명</th><th>상품수량</th></tr>";
			while (rs.next())
			{
				strOrd += rs.getString("start_html") + rs.getString("order_no") + rs.getString("order_date") + 
						rs.getString("user_name") + rs.getString("item_name") + rs.getString("item_qty") + rs.getString("end_html");
			}
			strOrd += "</table></body></html>";
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return strOrd;
	}

}
