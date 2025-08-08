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
import com.yedam.service.CalendarService;
import com.yedam.service.CalendarServiceImpl;

public class RemoveCalendarControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		CalendarService srv = new CalendarServiceImpl();
		
		String eventNo = req.getParameter("event_no");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// DB처리 -> 반환
		if(srv.removeCalendar(Integer.parseInt(eventNo)))
		{
			map.put("retCode", "OK");
			
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
