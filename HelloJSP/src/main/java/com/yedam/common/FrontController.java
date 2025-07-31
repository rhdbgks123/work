package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.ModifyControl;
import com.yedam.control.ModifyFormControl;
//INIT - SERVICE - DESTROY
// *.do -> 실행할 컨트롤
// 요청url == 실행할 컨트롤
import com.yedam.control.RegisterControl;
import com.yedam.control.RemoveControl;
import com.yedam.control.SignFormControl;
import com.yedam.control.SignupControl;

public class FrontController extends HttpServlet
{

	Map<String, Control> map;

	public FrontController()
	{
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		map.put("/register.do", new RegisterControl()); // 등록화면
		map.put("/addBoard.do", new AddBoardControl()); // 등록기능
		map.put("/remove.do", new RemoveControl());
		map.put("/modifyForm.do", new ModifyFormControl()); // 수정화면
		map.put("/modify.do", new ModifyControl()); // 수정기능
		map.put("/signForm.do", new SignFormControl());
		map.put("/signup.do", new SignupControl());
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// url vs uri
		// http://localhost:8080/HelloJSP/boardList.do - URL
		// /HelloJSP/boardList.do - URI

		String uri = req.getRequestURI();
		String context = req.getContextPath(); // /HelloJSP - 프로젝트
		String page = uri.substring(context.length()); // context의 length부터 끝까지 자르기

		Control control = map.get(page);
		control.execute(req, res);
	}

}
