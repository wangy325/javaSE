package com.wangy325.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangy325
 *
 * @date Jan 27, 2018-- 7:13:41 PM
 *
 * @description  
 * 还可以利用其他方法获取请求参数名和请求参数值
 *  Map<String, String[]> getParameterMap()
 *  @return 返回一个参数名-->参数值的键值对
 */

public class GetParas1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String TITLE = "利用 getParameterMap() 读取所有表单的数据";
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
		 *Map<String, String[]> getParameterMap()
         * @return 返回一个参数名-->参数值的键值对
		 */
		 Map<String, String[]> parameterMap = request.getParameterMap();
		 // 处理键值对
		Set<Entry<String,String[]>> entrySet = parameterMap.entrySet();
		for(Entry<String,String[]> es : entrySet) {
			String paraName = es.getKey();
			out.println("<tr><td>"+paraName+"</td>\n");
			String[] paraValues = es.getValue();
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
