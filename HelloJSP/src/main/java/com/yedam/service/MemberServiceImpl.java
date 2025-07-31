package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService
{
	SqlSession session = DBUtil.getInstance().openSession();
	MemberMapper mapper = session.getMapper(MemberMapper.class);

	@Override
	public boolean addMember(MemberVO member)
	{
		int r = mapper.insertMember(member); // 카운터증가

		if (r > 0)
		{
			session.commit();
			return true; 
		}

		return false;
	}

	@Override
	public MemberVO userCheck(String id, String pw)
	{
		return mapper.selectMember(id, pw);
	}

}
