package com.xxxy.student_shixun.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxxy.student_shixun.model.ResultMsg;
import com.xxxy.student_shixun.service.UserService;
import com.xxxy.student_shixun.utils.DataResolveUtil;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 6638205056069552497L;
	
	UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResultMsg msg = userService.logout(req);
		DataResolveUtil.resolveOutputData(resp, msg);
	}

}
