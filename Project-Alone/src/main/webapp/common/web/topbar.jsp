<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="Luuloneranger.entity.UserModel"%>
<%
UserModel user = (UserModel) session.getAttribute("user");
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <!-- Logo -->
    <a class="navbar-brand" href="home.jsp">MyApp</a>

    <!-- Nút bấm khi màn hình nhỏ -->
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown">
      <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Menu chính -->
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="category-list.jsp">Categories</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="about.jsp">About</a>
        </li>
      </ul>

      <!-- Menu tài khoản bên phải -->
      <ul class="navbar-nav">
        <% if (user != null) { %>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" role="button" data-bs-toggle="dropdown">
              <% if (user.getAvatar() != null) { %>
                <img src="<%=user.getAvatar()%>" alt="avatar" width="30" height="30" class="rounded-circle me-2" />
              <% } %>
              <span><%=user.getUsername()%></span>
            </a>
            <ul class="dropdown-menu dropdown-menu-end">
              <li><a class="dropdown-item" href="editProfile.jsp">Chỉnh sửa thông tin</a></li>
              <li><a class="dropdown-item" href="logout.jsp">Đăng xuất</a></li>
            </ul>
          </li>
        <% } else { %>
          <li class="nav-item">
            <a class="btn btn-outline-light btn-sm" href="login.jsp">Đăng nhập</a>
          </li>
        <% } %>
      </ul>
    </div>
  </div>
</nav>
