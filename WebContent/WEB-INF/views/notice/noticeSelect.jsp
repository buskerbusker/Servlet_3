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
			<h1>공지 게시글 상세페이지</h1>
			<table class="table table-hover">
				<tr class="danger">
					<td>글번호</td>
					<td>아이디</td>
					<td>글제목</td>
					<td>글내용</td>
				</tr>
				<tr class="info">
					<td>${dto.no}</td>
					<td>${dto.id}</td>
					<td>${dto.subject}</td>
					<td>${dto.contents}</td>
				</tr>
			</table>
			<c:if test="${not empty member.id}">
				<c:if test="${member.id eq 'admin'}">
					<a href="./noticeDelete?no=${dto.no}" class="btn btn-danger" id=del>Delete</a>
					<a href="./noticeMod?no=${dto.no}" class="btn btn-primary">Update</a>
				</c:if>
			</c:if>
		</div>
	</div>

	<script type="text/javascript">
		$("#del").click(function() {
			var result = confirm("글을 삭제하시겠습니까?");
			if (result) {
				location.href = "./memberDelete";
				alert("삭제완료");
			}
		});
	</script>

</body>
</html>