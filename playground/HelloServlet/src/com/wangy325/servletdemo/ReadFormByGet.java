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
 * @date Jan 27, 2018-- 10:21:28 AM
 *
 * @description 利用Get方法向Servlet传递参数，并读取出来
 * 
 */
public class ReadFormByGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadFormByGet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=utf-8");
		//
		PrintWriter writer = response.getWriter();
		String TITLE = "使用 Get() 方法获取表单内容";
		String DOCTYPE = "<!DOCTYPE html> \n";
		writer.println(DOCTYPE);
		writer.println("<html>\n");
		writer.println("<head><title>" + TITLE + "</title></head>\n");
		writer.println("<body bgcolor=\"#f0f0f0\">\n");
		writer.println("<h1 align=\"center\">" + TITLE + "</h1>\n");
		writer.println("<ul>\n");
		writer.println("  <li><b>站点名</b>：");
		writer.println(request.getParameter("name") + "</li>\n");
		writer.println("  <li><b>网址</b>：");
		writer.println(request.getParameter("url") + "</li>\n");
		writer.println("</ul>\n");
		writer.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
