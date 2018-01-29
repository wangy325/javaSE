package com.wangy325.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangy325
 *
 * @date Jan 28, 2018-- 12:00:01 PM
 *
 * @description Servlet 获取 HTTP 表头属性
 * 
 */
public class GetHeader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		 PrintWriter out = resp.getWriter();
		/**
		 * Enumeration<String> getHeaderNames();
		 * 获取request请求的所有请求头的的一个枚举，如果请求没有请求头，返回一个空枚举
		 */
		Enumeration<String> heads = req.getHeaderNames();
		while (heads.hasMoreElements()) {
			String head = heads.nextElement();
			/**
			 *  String getHeader(String name);
			 *  获取指定请求头的值的字符串表示形式
			 *  如果指定请求头不存在，返回 null
			 *  如果有多个同名的请求头，返回第一个请求头的值，
			 *  请求头大小写敏感
			 */
			System.out.println(head+" : "+req.getHeader(head));
		}
		// localhost:8080
		out.println(req.getHeader("host"));
		
		/**
		 * Enumeration <String> getAttributeNames()
		 * 究竟HTTP 请求体的【属性】指代的是什么？
		 */
		req.setAttribute("hello", "你好");
		Object attribute = req.getAttribute("hello");
		out.print(attribute);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
