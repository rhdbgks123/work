package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// 수정화면 . bno = 3
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		// DB 조회
		BoardService srv = new BoardServiceImpl();
		BoardVO board = srv.searchBoard(bno);
		
		// view 영역(jsp)
		req.setAttribute("board_info", board);

		req.getRequestDispatcher("WEB-INF/html/update_form.jsp").forward(req, res);
		
	}

}
