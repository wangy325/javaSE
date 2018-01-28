<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 利用Java打印9x9</h1>
	<!-- 打印9x9 -->
	<%
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < (i + 1); j++) {
	%>
	<%=i + " x" + j + " = " + (i * j) + "&emsp;"%>
	<%
		}
	%>
	<%="<br/>"%>
	<%
		}
	%>
	<%="done"%>

	<h1>JSP 在 table 中打印9x9</h1>
	<table>
		<%
			for (int i = 1; i < 10; i++) {
		%>
		<tr>
			<%
				for (int j = 1; j < (i + 1); j++) {
			%>
			<th><%=i + " x" + j + " = " + (i * j) + "&emsp;"%></th>
			<%
				}
			%>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>