package com.xxxy.student_shixun.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.xxxy.student_shixun.model.ResultMsg;
import com.xxxy.student_shixun.model.User;
import com.xxxy.student_shixun.servlet.DataSourceServlet;

public class UserService {

	DruidDataSource druidDataSource = DataSourceServlet.druidDataSource;

	public ResultMsg login(User user, HttpServletRequest req) {
		ResultMsg msg = new ResultMsg();
		HttpSession session = req.getSession();
		try {
			DruidPooledConnection connection = druidDataSource.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from user u where u.loginname = ? and u.password = ?");
			prepareStatement.setString(1, user.getLoginName());
			prepareStatement.setString(2, user.getPassword());
			ResultSet executeQuery = prepareStatement.executeQuery();
			if (executeQuery.first()) {
				msg.success();
				session.setAttribute("uid", executeQuery.getInt(1));
			} else {
				msg.fail();
				msg.setMsg("用户名或密码错误");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public ResultMsg getUserInfo(HttpServletRequest req) {
		ResultMsg msg = new ResultMsg();

		HttpSession session = req.getSession();
		Integer uid = (Integer) session.getAttribute("uid");

		if (uid == null) {
			msg.fail();
			return msg;
		}

		DruidPooledConnection connection;
		try {
			connection = druidDataSource.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("select * from user u where u.id = ?");
			prepareStatement.setInt(1, uid);
			ResultSet executeQuery = prepareStatement.executeQuery();
			if (executeQuery.first()) {
				User user = new User();
				user.setId(executeQuery.getInt(1));
				user.setLoginName(executeQuery.getString(2));
				user.setRealName(executeQuery.getString(4));
				msg.setData(user);
				msg.success();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return msg;
	}
	
	public ResultMsg logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("uid");
		ResultMsg msg = new ResultMsg();
		msg.success();
		return msg;
	}
}
