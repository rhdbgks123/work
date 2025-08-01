package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String id = req.getParameter("id");
		String psw = req.getParameter("psw");
		
		MemberService srv = new MemberServiceImpl();
		MemberVO member = srv.userCheck(id, psw);

		if(member == null) 
		{
			
		}
		else
		{
			HttpSession session =  req.getSession();
			session.setAttribute("logId", id);
			session.setAttribute("auth", member.getResponsibility());
			res.sendRedirect("boardList.do");
		}
		
		
	}

}
