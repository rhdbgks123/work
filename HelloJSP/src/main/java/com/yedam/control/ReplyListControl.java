package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// 댓글목록(json)
		res.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		ReplyService srv = new ReplyServiceImpl();
		
		List<ReplyVO> list = srv.searchReplyList(Integer.parseInt(bno), Integer.parseInt(page));
		
		// json형태로 parsing -- Gson 라이브러리 활용
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		// 출력스트림에 입력
		res.getWriter().print(json);
		
		

	}

}
