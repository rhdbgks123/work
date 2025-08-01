package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class MeberListControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{

		// WEB-INF/html/board_list.html
		MemberService srv = new MemberServiceImpl();
		
		req.setAttribute("member_list", srv.searchMeberList());
		
		req.getRequestDispatcher("admin/meber_list.tiles").forward(req, res);		
	}

}
