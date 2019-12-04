package com.xxxy.student_shixun.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class DataResolveUtil {

	public static Object resolveInputData(HttpServletRequest req, Class<?> clazz) {
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line);
			}
			return JSONObject.parseObject(builder.toString(), clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void resolveOutputData(HttpServletResponse resp, Object object) {
		resp.setContentType("text/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = resp.getWriter();
			writer.println(JSONObject.toJSON(object));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
