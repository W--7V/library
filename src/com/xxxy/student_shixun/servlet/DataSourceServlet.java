package com.xxxy.student_shixun.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.alibaba.druid.pool.DruidDataSource;

@WebServlet(loadOnStartup = 1,urlPatterns = "/init")
public class DataSourceServlet extends HttpServlet {

	private static final long serialVersionUID = 8222864514978136376L;
	
	public static DruidDataSource druidDataSource;
	@Override
	public void init() throws ServletException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/library");
		dataSource.setInitialSize(5);
		dataSource.setMinIdle(5);
		dataSource.setMaxActive(20);
		druidDataSource = dataSource;
	}

}
