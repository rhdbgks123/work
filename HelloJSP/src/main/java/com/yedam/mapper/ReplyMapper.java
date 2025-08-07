package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper
{
	public int insertReply(ReplyVO reply);
	public List<ReplyVO> selectReplyList(@Param("boardNo") int boardNo,@Param("page") int page);
	public int deleteReply(int replyNo);
	public int selectCount(int boardNo);
}
