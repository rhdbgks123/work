package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberService
{
	public boolean addMember(MemberVO member);
	public MemberVO userCheck(String id, String pw);
	public List<MemberVO> searchMeberList();
}
