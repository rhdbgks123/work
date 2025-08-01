package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper
{
	public int insertMember(MemberVO member);
	public MemberVO selectMember(@Param("id")String id, @Param("pw")String pw);
	public List<MemberVO> selectMemberList();
}
