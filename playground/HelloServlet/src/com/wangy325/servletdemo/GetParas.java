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
 * @date Jan 27, 2018-- 4:01:33 PM
 *
 * @description 通用的方法获取所有的参数至Servlet 中
 * 		使用的方法为 Enumeration<String> getParameterNames(String name)
 */
public class GetParas extends HttpServlet {
	private static final long serialVersionUID = -2974566769798484000L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String TITLE = "利用 getParameterNames() 读取所有表单的数据";
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html \n");
		out.println("<html><meta charset=\"utf-8\">\n");
		out.println("<title>" + TITLE + "</title>\n");
		out.println("<body ><h1 align='center' >" + TITLE + "</h1>\n");
		out.print("<table width='100%' border='1' align='center' ><tr bgcolor ='gray'>\n");
		out.println("<th>参数名</th>\n<th>参数值</th></tr>\n");
		/**
		 * 以下的主体写获取的表单数据, 内容放置在html的<tr>标签中
		 */
		// 获取所有参数名字的枚举
		/**
		 * Enumeration<String> getParameterNames()
		 * @return 返回一个HTTP请求中包含所有参数名的字符串枚举,
		 * 如果参数名为空, 那么返回一个空枚举
		 */
		Enumeration<String> paraNames = request.getParameterNames();
		while (paraNames.hasMoreElements()) {
			// 如果有参数名, 那么获取这个参数名
			String paraName = paraNames.nextElement();
			out.println("<tr><td>" + paraName + "</td>\n");
			// 获取参数值
			/**
			 * getParameterValues(String name)
			 * @return 返回给定参数名的所有参数值的字符串数组形式, 
			 * 如果参数名不存在, 返回null 
			 * 返回null 对象就说名参数名传入错误了
			 */
			String[] paraValues = request.getParameterValues(paraName);
			// 进行判断
			if (paraValues.length == 1) {
				// 获取唯一的一个参数值
				String paraValue = paraValues[0];
				if (paraValues.length == 0) {
					// 如果字符串长度为0, 那么认为该参数的值未进行设置
					out.println("<td>未设置</td>\n");
				} else {
					out.println("<td>" + paraValue + "</td>\n");
				}
			} else {
				// 获取多个参数值, 用列表接收
				out.println("<td><ul>\n");
				for (int i = 0; i < paraValues.length; i++) {
					out.println("<li>" + paraValues[i] + "</li>\n");
				}
				out.println("</ul></td>");
			}
			out.println("</tr>");
		}
		out.println("</table></body>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
