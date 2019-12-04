package com.xxxy.student_shixun.model;

public class ResultMsg {

	private String code;
	private String msg;
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void success() {
		code = "200";
	}

	public void fail() {
		code = "500";
	}
}
