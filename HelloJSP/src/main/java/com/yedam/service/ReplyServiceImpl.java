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
	public List<ReplyVO> searchReplyList(int boardNo)
	{
		return mapper.selectReplyList(boardNo);
	}

}
