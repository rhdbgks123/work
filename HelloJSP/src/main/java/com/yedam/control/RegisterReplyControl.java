package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class RegisterReplyControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");
		
		ReplyVO replys = new ReplyVO();
		
		replys.setBoardNo(Integer.parseInt(bno));
		replys.setReply(reply);
		replys.setReplyer(replyer);
		//retCode, bno, reply, replyer, rno => Map<키, 값>
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		
		ReplyService srv = new ReplyServiceImpl();
		
		// DB처리 -> 반환
		if(srv.registerReply(replys))
		{
			map.put("retCode", "OK");
			map.put("retVal", replys);
			
			//res.getWriter().print("{\"retCode\":\"OK\"}");
		}
		else
		{
			map.put("retCode", "NG");
			//res.getWriter().print("{\"retCode\":\"NG\"}");
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		res.getWriter().print(json);
		
	}

}
