package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String strPage = req.getParameter("page");
		strPage = strPage==null ? "1" : strPage;
		// WEB-INF/html/board_list.html
		BoardService srv = new BoardServiceImpl();
		List<BoardVO> list = srv.boardList(Integer.parseInt(strPage));
		
		//페이징
		int totalCnt = 512;
		PageDTO paging = new PageDTO(Integer.parseInt(strPage), totalCnt);
		
		req.setAttribute("board_list", list);
		req.setAttribute("paging", paging);
		
		req.getRequestDispatcher("WEB-INF/html/board_list.jsp").forward(req, res);
		
		//jsp(뷰 역할) 페이지에 데이터 전달
		
		
	}

}
