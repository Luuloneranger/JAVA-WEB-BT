<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="Luuloneranger.entity.UserModel"%>
<%
System.out.println("Có cái nịt");
UserModel user = (UserModel) session.getAttribute("user");
if (user == null) {
	response.sendRedirect("login.jsp");
	return;
}
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

</body>
</html>
