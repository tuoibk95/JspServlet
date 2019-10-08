<%@page import="model.UserModel"%>
<%@page import="model.UserDatabaseModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.ListUserController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center" style="border-collapse: collapse;" width="80%" align="center">List User</h1>
	<%--
		ArrayList<ListUser> list = (ArrayList) request.getAttribute("ListUser");
		out.println("<table border = 1>");
		
		for (ListUser l : list) {
			out.println("<tr>");
			out.print("<td>" + l.getID() + "</td>");
			out.print("<td>" + l.getName() + "</td>");
			out.print("<td>" + l.getBirthday() + "</td>");
			out.print("<td>" + l.getBirthplace() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	--%>
	
	<table border="1" style="border-collapse: collapse;" width="80%" align="center">
		<tr>
			<th>STT</th>
			<th>Name</th>
			<th>Birthday</th>
			<th>Birthpalce</th>
		</tr>

		<%
			ArrayList<UserModel> list = (ArrayList) request.getAttribute("ListUser");
			for (UserModel l : list) {
		%>

		<tr>
			<td><%= l.getID()%></td>
			<td><%= l.getName() %></td>
			<td><%= l.getBirthday() %></td>
			<td><%= l.getBirthplace() %></td>
		</tr>
		<% } %>
	</table>
	<br>
	<h1 align="center">List User</h1>
	
	<table border="1" style="border-collapse: collapse;" width="80%" align="center">
		<tr>
			<th>STT</th>
			<th>Name</th>
			<th>Birthday</th>
			<th>Birthpalce</th>
		</tr>

		<c:forEach items ="${ListUser}" var="list">
			<tr>
				<td>${list.ID }</td>
				<td>${list.getName() }</td>
				<td>${list.getBirthday() }</td>
				<td>${list.getBirthplace() }</td>
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>