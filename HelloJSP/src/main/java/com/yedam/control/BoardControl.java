package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		// WEB-INF/html/board_list.html
		BoardService srv = new BoardServiceImpl();
		
		req.setAttribute("board_info", srv.searchBoard(Integer.parseInt(bno)));
		req.setAttribute("page", Integer.parseInt(page));
		req.getRequestDispatcher("WEB-INF/html/board.jsp").forward(req, res);		
	}

	
}
