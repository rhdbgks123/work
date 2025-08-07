package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if(srv.registerCalendar(calendar))
		{
			req.getRequestDispatcher("seachCal.do");
		}
	}

}
