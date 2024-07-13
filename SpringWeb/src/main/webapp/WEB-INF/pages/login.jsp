<%-- 
    Document   : login
    Created on : Jul 13, 2024, 2:00:40 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../WEB-INF/css/test.css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Login</a>
                    </li>
                    <c:forEach items="${cates}" var="c">
                        <li class="nav-item">
                            <a class="nav-link" href="#">${c.name}</a>
                        </li>
                    </c:forEach>

                </ul>
            </div>
        </nav>
        <section class="container margin">
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
        </section>
        
        
        
        
       
    </body>
</html>
