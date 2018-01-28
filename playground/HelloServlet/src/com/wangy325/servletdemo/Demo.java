package com.wangy325.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author wangy325
 *
 * @date Jan 24, 2018-- 9:24:27 PM
 *
 * @description 利用Eclipse 创建 Servlet， Eclipse 会自动配置web.xml文件 
 * 
 * 处理最简单的Get 和 Post 请求
 * 		-- GET 请求来自于一个 URL 的正常请求，或者来自于一个未指定 METHOD 的 HTML 表单，它由 doGet() 方法处理
 *		-- POST 请求来自于一个特别指定了 METHOD 为 POST 的 HTML 表单（单选框，复选框，下拉框），它由 doPost() 方法处理
 */

public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("处理Get()请求...");
		// 获取输出流
		PrintWriter out = response.getWriter();
		// 设置响应文件类型
		response.setContentType("text/html; charset=utf-8");
		out.println("<strong>Hello, this sentence presented by <span style=\"color:red\">Servlet</span></strong>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("处理Post()请求...");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h5>Hello Servlet...</h5>");
	}

}
