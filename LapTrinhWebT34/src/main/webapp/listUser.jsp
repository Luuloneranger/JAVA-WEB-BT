<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Danh sách người dùng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2>Danh sách người dùng</h2>
    <a href="${pageContext.request.contextPath}/add" class="btn btn-success mb-3">+ Thêm người dùng</a>

    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>#</th>
                <th>Username</th>
                <th>Fullname</th>
                <th>Password</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="user" varStatus="st">
                <tr>
                    <td>${st.index + 1}</td>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.fullname}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/edit?id=${user.id}" class="btn btn-primary btn-sm">Sửa</a>
                        <a href="${pageContext.request.contextPath}/delete?id=${user.id}" 
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Bạn có chắc muốn xóa user này không?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
