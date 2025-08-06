package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService
{
	public List<ReplyVO> searchReplyList(int boardNo, int page);
	public boolean removeReply(int replyNo);
	public boolean registerReply(ReplyVO reply);
}
