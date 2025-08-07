package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.CalendarVO;

public interface CalendarMapper
{
	public List<CalendarVO> selectCalendar();
	public int insertCalendar(CalendarVO calendar);
	public int deleteCalendar(int eventNo);
	//목록, 추가, 삭제 mapper.xml에 추가
}
