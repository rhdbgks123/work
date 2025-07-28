package com.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

@WebServlet("/deleteBoard")
public class BoardDelete extends HttpServlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO 자동 생성된 메소드 스텁
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			res.setContentType("text/html;charset=utf-8");
			
			String board_no = req.getParameter("board_no"); // "3"
			
			int bno = Integer.parseInt(board_no);
			
			BoardService svc = new BoardServiceImpl();
			if(svc.removeBoard(bno))
			{
				res.sendRedirect("BoardListServlet");
			}
			else
			{
				System.out.println("에러발생");
			}
			
	}
	
}
