<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Query Page</title>
<style type="text/css">
	.center {
		margin-left:600px; 
	}
</style>
</head>
<body>
	<form method="post" action="query.handler">
		<table class="center">
			<tr>
				<td>員工編號</td>
				<td><input type="text" name="id"/></td>
				<td>${errors.id}</td>
			</tr>
			<tr>
				<td>密碼</td>
				<td><input type="password" name="pwd"/></td>
				<td>${errors.pwd}</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Query"/></td>
			</tr>
		</table>
	</form>
	<div class="center">${errors.auth}</div>
	<hr>
	<table class="center">
		<tr>
			<th>員工編號</th>
			<th>月份</th>
			<th>薪水</th>
		</tr>
		<c:forEach var="result" items="${results}">
			<tr>
				<td>${result.employee_id}</td>
				<td>${result.month}</td>
				<td>${result.income}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>