package com.yedam.service;

import java.util.List;

import com.yedam.vo.CalendarVO;

public interface CalendarService
{
	public List<CalendarVO> searchCalendar();
	public boolean removeCalendar(int eventNo);
	public boolean registerCalendar(CalendarVO calendar);
}
