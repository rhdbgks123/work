package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper
{
	public int insertReply(ReplyVO reply);
	public List<ReplyVO> selectReplyList(int boardNo);
}
