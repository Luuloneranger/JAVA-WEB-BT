<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-4">

    <h2 class="mb-3">📂 Category List</h2>
    <a href="${pageContext.request.contextPath}/category/create" class="btn btn-primary mb-3">➕ Add New</a>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Icon</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${list}">
            <tr>
                <td>${c.cateid}</td>
                <td>${c.catename}</td>
                <td><i class="${c.icons}"></i> ${c.icons}</td>
                <td>
                    <c:if test="${not empty c.images}">
                        <img src="${c.images}" alt="image" width="60" height="60" style="object-fit:cover"/>
                    </c:if>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/category/edit?id=${c.cateid}" class="btn btn-sm btn-warning">✏ Edit</a>
                    <a href="${pageContext.request.contextPath}/category/delete?id=${c.cateid}" 
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Are you sure to delete this category?');">🗑 Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
