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
		<h2>Point input</h2>
		<form action="./pointAdd" method="post">

			<div class="form-group">
				<label for="Name">Name:</label> <input type="text"
					class="form-control" id="name" placeholder="이름을 입력하세요" name="name">
			</div>

			<div class="form-group">
				<label for="Num">Num:</label> <input type="text"
					class="form-control" id="num" placeholder="번호를 입력하세요" name="num">
			</div>

			<div class="form-group">
				<label for="Guk">Guk:</label> <input type="text"
					class="form-control" id="guk" placeholder="국어점수를 입력하세요" name="kor">
			</div>

			<div class="form-group">
				<label for="Yung">Yung:</label> <input type="text"
					class="form-control" id="yung" placeholder="영어점수를 입력하세요" name="eng">
			</div>

			<div class="form-group">
				<label for="Soo">Soo:</label> <input type="text"
					class="form-control" id="soo" placeholder="수학점수를 입력하세요" name="math">
			</div>
			<div class="form-group">
				<label for="Hap">Hap:</label> <input type="text"
					class="form-control" id="hap" placeholder="합계점수를 입력하세요"
					name="total">
			</div>
			<div class="form-group">
				<label for="Pyung">Pyung:</label> <input type="text"
					class="form-control" id="pyung" placeholder="평균점수를 입력하세요"
					name="avg">
			</div>

			<button type="submit" class="btn btn-default">Submit</button>
			<input type="submit" value="submit">
		</form>
	</div>

</body>

</html>