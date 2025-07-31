package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		BoardService srv = new BoardServiceImpl();
		BoardVO board = new BoardVO();
		
		//jsp(뷰 역할) 페이지에 데이터 전달
		
		req.setCharacterEncoding("utf-8");
		String strbno = req.getParameter("bno");
		int bno = Integer.parseInt(strbno);
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int page = Integer.parseInt(req.getParameter("page"));

		board.setBoardNo(bno);
		board.setTitle(title);
		board.setContent(content);
		if(srv.modifyBoard(board))
			res.sendRedirect("boardList.do?page="+page);
		else
			System.out.println("에러발생");
		

	}

}
