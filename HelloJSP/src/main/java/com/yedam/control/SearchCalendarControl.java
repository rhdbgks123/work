package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.CalendarService;
import com.yedam.service.CalendarServiceImpl;
import com.yedam.vo.CalendarVO;

public class SearchCalendarControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/json;charset=utf-8");
		CalendarService srv = new CalendarServiceImpl();
		List<CalendarVO> list = srv.searchCalendar();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		

		res.getWriter().print(json);
		//req.setAttribute("json", json);
		//req.getRequestDispatcher("user/calendar.tiles").forward(req, res);
	}

}
