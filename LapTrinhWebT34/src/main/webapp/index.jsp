<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.top-right {
	position: absolute;
	top: 15px;
	right: 20px;
}

.btn {
	background: #007bff;
	color: #fff;
	border: none;
	padding: 8px 15px;
	margin-left: 10px;
	border-radius: 5px;
	cursor: pointer;
	text-decoration: none;
	font-size: 14px;
}

.btn:hover {
	background: #0056b3;
}

.welcome {
	margin-top: 80px;
	text-align: center;
	font-size: 20px;
}

.actions {
	margin-top: 30px;
	text-align: center;
}
</style>
</head>
<body>

	<div class="top-right">
		<span>Xin chào, <b>${sessionScope.account.fullName}</b></span>
		<a href="${pageContext.request.contextPath}/logout" class="btn">
			<i class="fas fa-right-from-bracket"></i> Đăng xuất
		</a>
	</div>

	<div class="welcome">
		<h1 class="display-5 fw-bold">
			Xin chào,
			<c:out value="${sessionScope.account.fullName}" default="Khách" />
		</h1>
	</div>

	<div class="actions">
		<a href="${pageContext.request.contextPath}/list" class="btn">
			<i class="fas fa-users"></i> Xem danh sách người dùng
		</a>
	</div>

</body>
</html>
