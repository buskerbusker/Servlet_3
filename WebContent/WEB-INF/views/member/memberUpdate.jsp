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
		<h2>Member Update Form</h2>
		<form action="./memberUpdate" method="post">

			<div class="form-group">
				<label for="Id">ID:</label> <input type="text" class="form-control"
					id="id" placeholder="아이디를 입력하세요" name="id" value="${member.id}"
					readonly="readonly">
			</div>

			<div class="form-group">
				<label for="Name">Name:</label> <input type="text"
					class="form-control" id="name" placeholder="이름을 입력하세요" name="name"
					value="${member.name}">
			</div>

			<div class="form-group">
				<label for="Age">Age:</label> <input type="text"
					class="form-control" id="age" placeholder="나이를 입력하세요" name="age"
					value="${member.age}">
			</div>

			<div class="form-group">
				<label for="Phone">Phone:</label> <input type="text"
					class="form-control" id="phone" placeholder="연락처를 입력하세요"
					name="phone" value="${member.phone}">
			</div>

			<div class="form-group">
				<label for="Email">Email:</label> <input type="text"
					class="form-control" id="email" placeholder="이메일을 입력하세요"
					name="email" value="${member.email}">
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>

</body>
</html>