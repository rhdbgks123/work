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
import com.yedam.vo.BoardVO;

//서블릿의 실행순서
// 페이지 : 75
//(vscode) live server : html 그대로 구현
// client -> 웹서버(정적인page / html) -> 서블릿 컨테이너(tomcat) -> init(최초요청일때만) -> service(항상)
// servlet 클래스 생성 시 반드시 extends HttpServlet 써야함
//@WebServlet도 붙여줘야함
@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	
	// init은 최초 호출때만 실행
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	// service는 항상 호출되기때문에 기능은 모두 service에 입력
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		if(req.getMethod().equals("GET"))
		{
			res.setContentType("text/html;charset=utf-8");
			
			// http://localhost:8080/HelloJSP/board?board_no=3&writer=user01
			// 물음표 뒤에는 파라미터값 설정 가능
			String board_no = req.getParameter("board_no"); // "3"
			
			int bno = Integer.parseInt(board_no);
			
			BoardService svc = new BoardServiceImpl();
			BoardVO board = svc.searchBoard(bno);
			
			// 글번호 : 3 제목 : ???
			// 내용 : ~~~~
			// 작성자 : 홍길동
			// 작성일시 : 2025.07.25 13:22:18
			
			String html = "";
			html += " <table border = '2'> ";
			html += "   <tr> ";
			html += "     <th>글번호</th> ";
			html += "     <td>" + board.getBoardNo() + "</td> ";
			html += "     <th>제목</th> ";
			html += "     <td>" + board.getTitle() + "</td> ";
			html += "   </tr> ";
			html += "   <tr> ";
			html += "     <th>내용</th> ";
			html += "     <td colspan='3'>" + board.getContent() + "</td> ";
			html += "   </tr> ";
			html += "   <tr> ";
			html += "     <th>작성자</th> ";
			html += "     <td colspan='3'>" + board.getWriter() + "</td> ";
			html += "   </tr> ";
			html += "   <tr> ";
			html += "     <th>작성일지</th> ";
			html += "     <td colspan='3'>" + board.getCreateDate() + "</td> ";
			html += "   </tr> ";
			html += " </table> ";
			html += " <a href = './BoardListServlet'>글목록</a>";
			
			res.getWriter().print(html);
		}
		else if(req.getMethod().equals("POST"))
		{
			req.setCharacterEncoding("UTF-8");
			
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			BoardService srv = new BoardServiceImpl();
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			if(srv.registerBoard(board))
			{
				res.sendRedirect("BoardListServlet");
			}
			else
			{
				System.out.println("에러발생");
			}
			
			
			
		}
	}
}
