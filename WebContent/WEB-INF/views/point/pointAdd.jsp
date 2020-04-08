<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath}/">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Page 1-1</a></li>
						<li><a href="#">Page 1-2</a></li>
						<li><a href="#">Page 1-3</a></li>
					</ul></li>
				<li><a
					href="${pageContext.request.contextPath}/point/pointList">Point</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="jumbotron">
			<h1>Bootstrap Tutorial</h1>
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
	</div>

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
		</form>
	</div>

</body>

</html>