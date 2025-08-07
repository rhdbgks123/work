package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService
{
	SqlSession session = DBUtil.getInstance().openSession();
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);


	@Override
	public List<ReplyVO> searchReplyList(int boardNo, int page)
	{
		return mapper.selectReplyList(boardNo, page);
	}


	@Override
	public boolean removeReply(int replyNo)
	{
		int r = mapper.deleteReply(replyNo);
		if( r > 0)
		{
			session.commit();
			return true;
		}
		return false;
	}


	@Override
	public boolean registerReply(ReplyVO reply)
	{
		int r = mapper.insertReply(reply);
		if( r > 0)
		{
			session.commit();
			return true;
		}
		return false;
	}


	@Override
	public int replyCount(int boardNo)
	{
		return mapper.selectCount(boardNo);
	}

}
