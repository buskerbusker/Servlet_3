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
		<h2>MemberJoin</h2>
		<form action="./memberLogin" method="post">

			<div class="form-group">
				<label for="Id">ID:</label> <input type="text" class="form-control"
					id="id" placeholder="아이디를 입력하세요" name="id">
			</div>

			<div class="form-group">
				<label for="Password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="비밀번호를 입력하세요"
					name="password">
			</div>

			<input type="checkbox"> <label>&nbsp Remember ID &
				Password</label> <br>
			<button type="submit" class="btn btn-default">Login</button>
		</form>
	</div>

</body>

</html>