<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<div class="row">
			<h1>공지 게시판</h1>
			<table class="table table-hover">
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>아이디</td>
					<td>날짜</td>
				</tr>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.no}</td>
						<td><a href="./noticeSelect?no=${dto.no}">${dto.subject}</a></td>
						<td>${dto.id}</td>
						<td>${dto.create_date}</td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${not empty member.id}">
				<c:if test="${member.id eq 'admin'}">
					<a href="./noticeAdd" class="btn btn-primary" id="write">글쓰기</a>
				</c:if>
			</c:if>
		</div>
	</div>


</body>
</html>