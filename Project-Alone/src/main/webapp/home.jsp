<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="Luuloneranger.entity.*"%>
<%@ page import="java.util.List"%>
<%
UserModel user = (UserModel) session.getAttribute("user");
if (user == null) {
	response.sendRedirect("login.jsp");
	return;
}

List<Catogery> categories = (List<Catogery>) request.getAttribute("categories");
%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<div class="container mt-4">
		<h2>
			Welcome,
			<%=user.getUsername()%>!
		</h2>
		<p>This is your Home page.</p>
	</div>

	<div class="container my-4">
		<h2 class="text-center mb-4">Danh mục sản phẩm</h2>
		<div class="row">
			<%
			if (categories != null && !categories.isEmpty()) {
				for (Catogery c : categories) {
			%>
			<div class="col-md-3 mb-4">
				<div class="card h-100 shadow-sm">
					<img src="<%=c.getImages()%>" class="card-img-top"
						alt="ảnh danh mục">
					<div class="card-body text-center">
						<h5 class="card-title"><%=c.getCatename()%></h5>
						<p>
							<i class="<%=c.getIcons()%> fs-3"></i>
						</p>
						<a href="category?action=view&id=<%=c.getCateid()%>"
							class="btn btn-primary btn-sm">Xem sản phẩm</a>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			%>
			<p class="text-center">Chưa có danh mục nào được thêm!</p>
			<%
			}
			%>
		</div>
	</div>

</body>
</html>
