<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title><sitemesh:write property="title" /></title>

<!-- Bootstrap CSS & JS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Bootstrap Icons -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

</style>
</head>
<body class="d-flex flex-column vh-100">

	<!-- Header -->
	<header>
		<jsp:include page="/common/web/header.jsp" />
		
	</header>
	
	 <!-- Topbar -->
    <nav>
        <jsp:include page="/common/web/topbar.jsp" />
    </nav>

	<main class="flex-fill p-4">
		<sitemesh:write property="body" />
	</main>

	<!-- Footer -->
	<footer class="mt-auto">
		<jsp:include page="/common/web/footer.jsp" />
	</footer>


</body>
</html>
