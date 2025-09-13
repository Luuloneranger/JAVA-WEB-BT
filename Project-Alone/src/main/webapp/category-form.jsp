<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Category Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-4">

    <h2 class="mb-3">${category != null ? "✏ Edit Category" : "➕ Add Category"}</h2>

    <form method="post" action="${pageContext.request.contextPath}/category" class="needs-validation">

        <input type="hidden" name="cate_id" value="${category.cateid}"/>

        <div class="mb-3">
            <label class="form-label">Category Name</label>
            <input type="text" class="form-control" name="cate_name" 
                   value="${category.catename}" required/>
        </div>

        <div class="mb-3">
            <label class="form-label">Icon</label>
            <input type="text" class="form-control" name="icons" 
                   value="${category.icons}" placeholder="vd: fa-solid fa-laptop"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Image URL</label>
            <input type="text" class="form-control" name="images" 
                   value="${category.images}" placeholder="http://.../image.png"/>
        </div>
        <button type="submit" class="btn btn-success">💾 Save</button>
        <a href="${pageContext.request.contextPath}/category" class="btn btn-secondary">⬅ Back</a>
    </form>

</body>
</html>
