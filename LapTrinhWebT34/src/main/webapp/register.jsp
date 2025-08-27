<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
/* copy y chang css login để đồng bộ */
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.login-container {
	width: 400px;
	background-color: #fff;
	padding: 40px;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.input-group {
	margin-bottom: 20px;
	position: relative;
}

.input-group input {
	width: 100%;
	padding: 12px 12px 12px 40px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
}

.input-group .icon {
	position: absolute;
	left: 10px;
	top: 50%;
	transform: translateY(-50%);
	color: #aaa;
	font-size: 18px;
}

.login-button {
	width: 100%;
	padding: 12px;
	background-color: #28a745;
	color: #fff;
	border: none;
	border-radius: 4px;
	font-size: 18px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.login-button:hover {
	background-color: #218838;
}
</style>
</head>
<body>

	<div class="login-container">
		<h2>ĐĂNG KÝ</h2>
		<form action="register" method="post">
			<div class="input-group">
				<span class="icon"><i class="fas fa-id-card"></i></span>
				<input type="text" name="fullname" placeholder="Họ tên">
			</div>
			<div class="input-group">
				<span class="icon"><i class="fas fa-user"></i></span>
				<input type="text" name="username" placeholder="Tên đăng nhập">
			</div>
			<div class="input-group">
				<span class="icon"><i class="fas fa-lock"></i></span>
				<input type="password" name="password" placeholder="Mật khẩu">
			</div>
			<button type="submit" class="login-button">Tạo tài khoản</button>
		</form>
		
		<p style="margin-top:20px">
			Đã có tài khoản? 
			<a href="login.jsp">Đăng nhập</a>
		</p>
	</div>

</body>
</html>
	
</body>
</html>