<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="container" style="max-width:400px;margin-top:50px;">
    <h2 class="mb-3">Đăng nhập</h2>

    <% String alert = (String) request.getAttribute("alert");
       if (alert != null) { %>
       <div class="alert alert-danger"><%= alert %></div>
    <% } %>

    <form action="LoginServlet" method="post">
        <div class="mb-3">
            <input type="text" name="username" class="form-control" placeholder="Tên đăng nhập"/>
        </div>
        <div class="mb-3">
            <input type="password" name="password" class="form-control" placeholder="Mật khẩu"/>
        </div>
        <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
    </form>

    <p class="mt-3 text-center">
        Chưa có tài khoản? <a href="register.jsp">Đăng ký ngay</a>
    </p>
</div>
