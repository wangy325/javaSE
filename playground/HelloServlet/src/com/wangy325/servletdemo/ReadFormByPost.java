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
 * @date Jan 27, 2018-- 11:00:23 AM
 *
 * @description 通过Post 读取表单内容
 * 
 */
public class ReadFormByPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadFormByPost() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=utf-8");
		// 处理字符编码问题
		String NAME = new String(request.getParameter("name").getBytes("iso8859-1"), "utf-8");
		/**
		 * 用到了2个字符串相关方法,一个构造方法,一个普通方法
		 *		-- byte[] getBytes(String charsetName)
		 *			使用指定字符集将字符串编码为byte序列,结果存储到新的byte数组中
		 *		-- String(byte[] bytes, String charsetName)
		 *			通过指定的 charset 解码指定的byte数组,构造一个新的String  
		 *
		 *servlet 规定, 如果客户端请求未定义编码限定符，则包容器（如tomcat）
		 *用于创建request reader和分析POST数据的request的缺省编码方式必须是“ISO-8859-1”
		 *
		 */
		// 设置请求编码,同样用来处理字符编码
		// request.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		String TITLE = "使用 Post() 方法获取表单内容";
		String DOCTYPE = "<!DOCTYPE html> \n";
		writer.println(DOCTYPE);
		writer.println("<html>\n");
		writer.println("<head><title>" + TITLE + "</title></head>\n");
		writer.println("<body bgcolor=\"#f0f0f0\">\n");
		writer.println("<h1 align=\"center\">" + TITLE + "</h1>\n");
		writer.println("<ul>\n");
		writer.println("  <li><b>站点名</b>：");
		writer.println(NAME + "</li>\n");
		// writer.println(request.getParameter("name") + "</li>\n");
		writer.println("  <li><b>网址</b>：");
		writer.println(request.getParameter("url") + "</li>\n");
		writer.println("</ul>\n");
		writer.println("</body></html>");
	}

}
