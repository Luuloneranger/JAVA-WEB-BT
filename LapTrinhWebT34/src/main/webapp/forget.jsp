<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa;
}

.forgot-container {
	max-width: 420px;
	margin: 80px auto;
	background: #fff;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h3 {
	text-align: center;
	margin-bottom: 25px;
	font-weight: bold;
	color: #0d6efd;
}

.form-label {
	font-weight: 500;
}
</style>
</head>
<body>
	<div class="forgot-container">
		<h3>Quên mật khẩu</h3>
		<form action="${pageContext.request.contextPath}/forgetpassword" method="post">
			<div class="mb-3">
				<label for="user" class="form-label">Tên đăng nhập</label> <input
					type="text" name="user" id="user" class="form-control" required
					placeholder="Nhập username">
			</div>
			<div class="mb-3">
				<label for="fullname" class="form-label">Họ và tên</label> <input
					type="text" name="fullname" id="fullname" class="form-control"
					required placeholder="Nhập Full name">
			</div>
			<button type="submit" class="btn btn-primary w-100">Gửi yêu
				cầu</button>
		</form>

		<!-- Nút quay lại đăng nhập -->
		<div class="text-center mt-3">
			<a href="${pageContext.request.contextPath}/login.jsp"
				class="btn btn-secondary w-100">Quay về đăng nhập</a>
		</div>

		<c:if test="${not empty message}">
			<div class="alert alert-info mt-3">${message}</div>s
        </c:if>
	</div>
</body>
</html>
