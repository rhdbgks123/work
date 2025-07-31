package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class SignFormControl implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("WEB-INF/html/signup_form.jsp").forward(req, res);
	}

}
