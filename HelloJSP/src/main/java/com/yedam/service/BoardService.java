package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

//프로세스
public interface BoardService {
	public List<BoardVO> boardList(); // 업무단위 표기
	public BoardVO searchBoard(int boardNo); // 조회(조회 + 조회수 증가)
	public boolean registerBoard(BoardVO board);
	public boolean removeBoard(int boardNo);
}
