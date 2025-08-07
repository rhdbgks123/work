package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.CalendarMapper;
import com.yedam.vo.CalendarVO;

public class CalendarServiceImpl implements CalendarService
{
	SqlSession session = DBUtil.getInstance().openSession();
	CalendarMapper mapper = session.getMapper(CalendarMapper.class);
	@Override
	public List<CalendarVO> searchCalendar()
	{
		return mapper.selectCalendar();
	}
	@Override
	public boolean removeCalendar(int eventNo)
	{
		int r = mapper.deleteCalendar(eventNo);
		if(r > 0)
		{
			session.commit();
			return true;
			
		}
		return false;
	}
	@Override
	public boolean registerCalendar(CalendarVO calendar)
	{
		int r = mapper.insertCalendar(calendar);
		if(r > 0)
		{
			session.commit();
			return true;
			
		}
		return false;
	}


}
