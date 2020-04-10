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
		<h2>MemberMypage</h2>
		<form action="./memberPage" method="post">

			<div class="form-group">
				<label for="Id">ID:</label> <input type="text" class="form-control"
					id="id" placeholder="아이디를 입력하세요" name="id" value="${member.id}">
			</div>

			<div class="form-group">
				<label for="Password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="비밀번호를 입력하세요"
					name="password" value="${member.password}">
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

		</form>
		<button class="btn btn-primary" id="update">Update</button>
		<button class="btn btn-danger" id="withdrawal">Withdrawal</button>

	</div>

	<script type="text/javascript">
		$("#withdrawal").click(function() {
			var result = confirm("회원탈퇴 하시겠습니까?");
			if (result) {
				location.href = "./memberDelete";
				alert("탈퇴완료");
			}
		});
		$("#update").click(function() {
			location.href = "./memberUpdate";
		});
	</script>
</body>

</html>