package com.wangy325.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangy325
 *
 * @date Jan 27, 2018-- 2:11:37 PM
 *
 * @description Servlet 程序获取复选框的数据
 * 
 */
public class ReadCheckBox extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String TITLE = "Servlet 获取复选框数据";
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>\n");
		out.println("<head><meta charset=\"UTF-8\">\n");
		out.println("<title>" + TITLE + "</title>");
		out.println("</head>\n");
		out.println("<body  bgcolor='lightgray'>\n<ul>\n");
		out.println("<h1 align =\" center\">"+TITLE+"</h1>");
		out.println("<ul>\n");
		out.println("<li>菜鸟教程标识:" + request.getParameter("runoob") + "</li>\n");
		out.println("<li><b>google标识:</b>" + request.getParameter("google") + "</li>\n");
		out.println("<li>淘宝标识:" + request.getParameter("taobao") + "</li>\n");
		out.println("</ul><body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
