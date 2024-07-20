<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-primary mt-3"> Quản trị sản phẩm</h1>
<c:url value="/addProduct" var="action"/>
<form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data"> 
    
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    
    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Nhập tên sản phẩm</label>
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Nhập tên sản phẩm" name="name"/>
    </div>
    <div class="mb-3 mt-3">
        <label for="price" class="form-label">Nhập giá sản phẩm</label>
        <form:input path="price" type="number" class="form-control" id="price" placeholder="Nhập giá sản phẩm" name="price"/>
    </div>
    <div class="mb-3 mt-3">
        <label for="cate" class="form-label">Chọn danh mục sản phẩm</label>
        <form:select path="categoryId" id="cate" class="form-select">
            <c:forEach items="${cates}" var="c"><option value="${c.id}">${c.name}</option></c:forEach>
        </form:select>
    </div>
    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Chọn ảnh sản phẩm</label>
        <form:input path="file" accept=".png,.jpg" type="file"  class="form-control" id="file" placeholder="Nhập ảnh sản phẩm" name="file"/>
    </div>


    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>