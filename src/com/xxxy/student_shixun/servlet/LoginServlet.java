package com.xxxy.student_shixun.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxxy.student_shixun.model.ResultMsg;
import com.xxxy.student_shixun.model.User;
import com.xxxy.student_shixun.service.UserService;
import com.xxxy.student_shixun.utils.DataResolveUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 9126670689142271703L;

	UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) DataResolveUtil.resolveInputData(req, User.class);
		ResultMsg msg = userService.login(user, req);
		DataResolveUtil.resolveOutputData(resp, msg);
	}

}
