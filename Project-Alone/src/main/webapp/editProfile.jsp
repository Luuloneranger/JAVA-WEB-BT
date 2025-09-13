<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="Luuloneranger.entity.UserModel" %>
<%
    UserModel user = (UserModel) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Chỉnh sửa thông tin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-4">

    <h2 class="mb-3">✏ Chỉnh sửa thông tin</h2>

    <form action="editProfile" method="post" enctype="multipart/form-data">
        
        <!-- ID (ẩn, không cho sửa) -->
        <input type="hidden" name="id" value="<%=user.getId()%>"/>

        <!-- Username -->
        <div class="mb-3">
            <label class="form-label">Tên đăng nhập</label>
            <input type="text" class="form-control" name="username" 
                   value="<%=user.getUsername()%>" readonly/>
            <div class="form-text">Tên đăng nhập không thể thay đổi.</div>
        </div>

        <!-- Email -->
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email" 
                   value="<%=user.getEmail()%>" required/>
        </div>

        <!-- Phone -->
        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" name="phone" 
                   value="<%=user.getPhone()%>" />
        </div>

        <!-- Password -->
        <div class="mb-3">
            <label class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" name="password" 
                   value="<%=user.getPassword()%>" required/>
        </div>

        <!-- Avatar -->
        <div class="mb-3">
            <label class="form-label">Ảnh đại diện</label><br/>
            <img src="<%=user.getAvatar()%>" alt="avatar" width="80" class="rounded mb-2"/>
            <input type="file" class="form-control" name="avatar"/>
        </div>
        
        <div class="mb-3">
            <label class="form-label">👑 Role</label>
            <input type="text" class="form-control" name="roleID" value="<%=user.getRoleID()%>" readonly/>
        </div>

        <button type="submit" class="btn btn-success">💾 Lưu thay đổi</button>
        <a href="home.jsp" class="btn btn-secondary">⬅ Quay lại</a>
    </form>

</body>
</html>
