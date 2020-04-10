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
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h1>공지게시글 수정폼</h1>
		<form action="./noticeMod" method="post">

			<div class="form-group">
				<label for="No">No:</label> <input type="text" class="form-control"
					id="no" name="no" value="${dto.no}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="Id">아이디:</label> <input type="text" class="form-control"
					id="id" name="id" value="${member.id}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="Subject">글 제목:</label> <input type="text"
					class="form-control" id="subject" name="subject"
					value="${dto.subject}">
			</div>

			<div class="form-group">
				<label for="contents">글 내용:</label> <input type="text"
					class="form-control" id="contents" name="contents"
					value="${dto.contents}">
			</div>

			<button type="submit" class="btn btn-default">Update</button>

		</form>
	</div>

</body>
</html>