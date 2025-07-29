package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> selectList(int page); // 게시판 목록 가져오기
	public BoardVO selectBoard(int boardNo); // 단건 조회
	public int updateCount(int boardNo); // 조회수 증가
	public int insertBoard(BoardVO board); // insert
	public int deleteBoard(int boardNo); // delete
}
