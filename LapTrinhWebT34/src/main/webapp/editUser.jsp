<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Sửa người dùng</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
		<h2>Sửa thông tin người dùng</h2>

		<form action="${pageContext.request.contextPath}/edit" method="post">
			<p>Hidden ID: ${user.id}</p>
			<input type="hidden" name="id" value="${user.id}" />

			<div class="mb-3">
				<label for="username" class="form-label">Username</label> <input
					type="text" id="username" name="username" class="form-control"
					value="${user.userName}" required>
			</div>

			<div class="mb-3">
				<label for="fullname" class="form-label">Họ và tên</label> <input
					type="text" id="fullname" name="fullname" class="form-control"
					value="${user.fullName}" required>
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Mật khẩu</label> <input
					type="password" id="password" name="password" class="form-control"
					value="${user.passWord}" required>
			</div>

			<button type="submit" class="btn btn-primary">Cập nhật</button>
			<a href="${pageContext.request.contextPath}/list"
				class="btn btn-secondary">Hủy</a>
		</form>
	</div>
</body>
</html>
