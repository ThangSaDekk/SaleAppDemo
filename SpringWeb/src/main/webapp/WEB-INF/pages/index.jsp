<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-md-3 col-12 btn-info mt-3">
        <c:url value="/login" var="action" />
        <form action="${action}">
            <div class="mb-3 mt-3">
                <label for="kw" class="form-label">Nhập từ khóa:</label>
                <input type="search" class="form-control" id="kw" placeholder="Nhập từ khóa..." name="kw">
            </div>
            <div class="mb-3">
                <label for="fromPrice" class="form-label">Giá từ:</label>
                <input type="number" class="form-control" id="fromPrice" placeholder="Nhập giá nhỏ nhất..." name="fromPrice">
            </div>
            <div class="mb-3">
                <label for="toPrice" class="form-label">Giá đến:</label>
                <input type="number" class="form-control" id="toPrice" placeholder="Nhập giá lớn nhất..." name="toPrice">
            </div>
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            <a href="<c:url value="/addProduct"/>" type="button" class="btn btn-primary">Thêm sản phẩm</a>
        </form>
    </div>
    <div class="col-md-9 col-12 mt-3 ">
        <table class="table table-striped"> 
            <tr>
                <th>Image</th>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th></th>
            </tr>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>
                        <img width="120" src="${p.image}" alt="${p.name}"/> 
                    </td>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${String.format("%,d",p.price)}VND</td>
                    <td>
                        <a href="#" class="btn btn-info" >&Lang;</a>
                        <button class="btn btn-danger">&times;</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>