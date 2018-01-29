package com.wangy325.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangy325
 *
 * @date Jan 28, 2018-- 5:03:08 PM
 *
 * @description 自动刷新 Servlet 响应头
 * 
 */
public class RefreshResponseHeaderAutomaticlly extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		// 3 秒钟刷新一次响应头
		resp.setIntHeader("refresh", 1);
		// 通过状态码[302] 重定向至百度首页
		/*resp.setStatus(302);
		resp.setHeader("Location", "http://www.baidu.com");*/
		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日-HH时mm分ss秒");
		String TIME = df.format(date);
		PrintWriter out = resp.getWriter();
		String TITLE = "自动刷新 HTTP 响应头";
		out.println("<!DOCTYPE html/>\n");
		out.println("<html><head><meta charset = 'utf-8'/>\n");
		out.println("<title>"+TITLE+"</title></head>\n");
		out.println("<body align='center' ><h1>"+TITLE+"</h1>\n");
		out.println("<p>"+TIME+"</p></body>\n");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
