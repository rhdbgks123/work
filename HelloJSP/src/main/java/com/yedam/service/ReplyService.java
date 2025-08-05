package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService
{
	public List<ReplyVO> searchReplyList(int boardNo);
}
