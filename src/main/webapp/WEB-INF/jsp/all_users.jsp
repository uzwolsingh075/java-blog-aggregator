<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="table table-stripped">
	<tr>
		<td>Name</td>
		<td>Address</td>
	</tr>
	<c:forEach items="${ users }" var="user">
		<tr>
			<td>${user.name}</td>
			<td>${user.address}</td>
		</tr>
	</c:forEach>
</table>