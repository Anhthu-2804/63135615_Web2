<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// lay dl tu ng dung
	String tenDN = request.getParameter("username");
	String mk = request.getParameter("pass");
	// xu ly
	if(tenDN.equals("ABC") && mk.equals("123"))
		response.sendRedirect("myCV.html");
	else
		response.sendRedirect("myCV.html");

	%>

</body>
</html>