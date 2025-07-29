package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardListServlet() {
        super(); 
        System.out.println("BoardListServlet 생성자");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글목록 출력
		response.setContentType("text/html;charset=utf-8"); // 웹브라우저의 컨텐츠 데이터 타입
		System.out.println("Hello Servlet!!!");
		PrintWriter out = response.getWriter(); // 출력 stream
		out.println("<h1>Hello Servlet 2</h1>");
		int page = 0;
		BoardService srv = new BoardServiceImpl();
		List<BoardVO> list = srv.boardList(page);
		
		String html = "";
		html += " <table border = '2'> ";
		html += "   <thead> ";
		html += "     <tr> ";
		html += "       <th>글번호</th> ";
		html += "       <th>글제목</th> ";
		html += "       <th>작성자</th> ";
		html += "       <th>조회수</th> ";
		html += "     </tr> ";
		html += "   </thead> ";
		html += "   <tbody> ";
		for(BoardVO board : list)
		{
			html += "     <tr> ";
			html += "       <td align='center'><a href = 'board?board_no=" + board.getBoardNo() + "'>" + board.getBoardNo() + "</a></td> ";
			html += "       <td>" + board.getTitle() + "</td> ";
			html += "       <td>" + board.getWriter() + "</td> ";
			html += "       <td>" + board.getViewCnt() + "</td> ";
			html += "     </tr> ";
		}
		html += "   </tbody> ";
		html += " </table> ";
		html += " <a href = '/HelloJSP/html/register_form.html'>신규</a>";
		out.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
