package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// 댓글번호 -> DB삭제 -> 처리결과 반환
		String rno = req.getParameter("rno");
		ReplyService srv = new ReplyServiceImpl();
		
		if(srv.removeReply(Integer.parseInt(rno)))
		{
			// json타입
			// {"retCode":"OK"}
			res.getWriter().print("{\"retCode\":\"OK\"}");
		}
		else
		{
			// {"retCode":"NG"}
			res.getWriter().print("{\"retCode\":\"NG\"}");
		}
	}

}
