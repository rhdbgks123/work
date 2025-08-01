package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// 기존 String만 넘어오는 형식
//		req.setCharacterEncoding("utf-8");
//		// addBoard.do?title=??&writer=??&content=??
//		String title = req.getParameter("title");
//		String writer = req.getParameter("writer");
//		String content = req.getParameter("content");
//
//		BoardService srv = new BoardServiceImpl();
//		BoardVO board = new BoardVO();
//		board.setTitle(title);
//		board.setWriter(writer);
//		board.setContent(content);
//		if(srv.registerBoard(board))
//			res.sendRedirect("boardList.do");
//		else
//			System.out.println("에러발생");
		
		
		
		//key=value 형식, 2진값 파일도 넘어옴
		//cos.jar 활용해서 Multipart 요청 처리
		//DB에 게시글 INSERT
		
		//서버상의 upload 폴더에 저장.
		String upload = req.getServletContext().getRealPath("upload"); // 요청정보.프로젝트명.경로중"upload"폴더찾기
		System.out.println(upload);
		
		//요청정보, upload경로, 최대파일크기(5MB), 인코딩방식, (cos.jar에 있는 library) 동일한 이름파일의 경우 rename정책
		MultipartRequest mr = new MultipartRequest(req, upload, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());

		String title = mr.getParameter("title");
		String writer = mr.getParameter("writer");
		String content = mr.getParameter("content");
		String file = mr.getFilesystemName("images");
		BoardService srv = new BoardServiceImpl();
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setImage(file);
		if(srv.registerBoard(board))
			res.sendRedirect("boardList.do");
		else
			System.out.println("에러발생");
		
	}

}
