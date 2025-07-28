package com.yedam;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class Main {

	public static void main(String[] args) {

		BoardService svc = new BoardServiceImpl();

		
//		SqlSession session = DBUtil.getInstance().openSession();
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		List<BoardVO> list = mapper.selectList();
//		
//		for(BoardVO board : list)
//			System.out.println(board.toString());
			
//		
//		BoardVO board = mapper.selectBoard(1);
//		mapper.updateCount(searchNo);
//		System.out.println(board.toString());
		
		int searchNo = 1;
		BoardVO board = svc.searchBoard(searchNo);
		System.out.println(board.toString());
	}

}
