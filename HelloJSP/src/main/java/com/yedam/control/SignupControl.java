package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignupControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.setCharacterEncoding("utf-8");
		String uid = req.getParameter("id");
		String upw = req.getParameter("psw");
		String uname = req.getParameter("name");

		MemberService srv = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setUserId(uid);
		member.setUserPw(upw);
		member.setUserName(uname);
		if(srv.addMember(member))
			res.sendRedirect("boardList.do");
		else
			System.out.println("에러발생");
	}

}
