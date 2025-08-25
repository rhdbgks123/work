package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		int page = Integer.parseInt(req.getParameter("page"));
		// DB 조회
		BoardService srv = new BoardServiceImpl(); 
		BoardVO board = srv.searchBoard(bno);
		System.out.println("test");
		
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("logId");
		
		if(sid != null && sid.equals(board.getWriter()))
		{
			// view 영역(jsp)
			req.setAttribute("board_info", board);
			req.setAttribute("page", page);
			req.getRequestDispatcher("user/update_form.tiles").forward(req, res);
		}
		else
		{
			//권한 없을경우
			req.setAttribute("board_info", board);
			req.setAttribute("msg","권한이 없습니다.");
			req.getRequestDispatcher("user/board.tiles").forward(req, res);
			
		}
			
		
	}

}
