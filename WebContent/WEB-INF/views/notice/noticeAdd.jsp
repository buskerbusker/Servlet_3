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
		<h2>공지 게시글 쓰기</h2>
		<form action="./noticeAdd" method="post">

			<div class="form-group">
				<label for="Id">아이디:</label> <input type="text" class="form-control"
					id="id" name="id" value="${member.id}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="Subject">글 제목:</label> <input type="text"
					class="form-control" id="subject" name="subject">
			</div>

			<div class="form-group">
				<label for="contents">글 내용:</label> <input type="text"
					class="form-control" id="contents" name="contents">
			</div>

			<button type="submit" class="btn btn-default">Submit</button>

		</form>
	</div>

</body>

</html>