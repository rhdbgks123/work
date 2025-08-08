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
import com.yedam.vo.CalendarVO;

public class RegisterCalendarControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		CalendarService srv = new CalendarServiceImpl();
		
		CalendarVO calendar = new CalendarVO();
		
		calendar.setTitle(req.getParameter("title"));
		calendar.setStart(req.getParameter("start"));
		calendar.setEnd(req.getParameter("end"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		try 
		{
			srv.registerCalendar(calendar);
			map.put("retCode", "OK");
			map.put("retVal", calendar);
		}
		catch (Exception e)
		{
			map.put("retCode", "NG");
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		res.getWriter().print(json);
	}

}
