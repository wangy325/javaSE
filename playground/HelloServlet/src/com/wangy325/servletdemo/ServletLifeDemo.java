package com.wangy325.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLifeDemo01
 * 
 * 用于演示 Servlet 的生命周期
 * 1. init() 和destroy() 方法只执行一次
 * 2. 可以通过设置<load-on-startup>标签让服务器启动时就创建Servlet 对象, 并且可以设置不同Servlet启动的
 *     优先级 
 */
public class ServletLifeDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLifeDemo() {
    	System.out.println("ServletLifeDemo01 的构造器被执行...");
    	System.out.println(this.toString());
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletLifeDemo01 的init()方法被调用...");
	}

	public void destroy() {
		System.out.println("ServletLifeDemo01 的destroy() 方法被调用...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletLifeDemo01 的doGet() 方法被执行...");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset = utf-8");
		out.println("<h1>Hello ServletLifeDemo !!!!</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 以下代码的意思是让Post() 方法和 Get() 方法执行相同的操作
		doGet(request, response);
	}

}
