package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if(srv.removeCalendar(Integer.parseInt(eventNo)))
			req.getRequestDispatcher("searchCal.do");

	}

}
