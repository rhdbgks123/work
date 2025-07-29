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

public class RemoveControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		BoardService srv = new BoardServiceImpl();
		
		String strbno = req.getParameter("bno");
		int bno = Integer.parseInt(strbno);
		
		if(srv.removeBoard(bno))
			res.sendRedirect("boardList.do");
		else
			System.out.println("에러발생");
		
		//jsp(뷰 역할) 페이지에 데이터 전달
		
		
	}

}
