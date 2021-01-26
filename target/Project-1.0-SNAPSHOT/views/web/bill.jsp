<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Media
  Date: 07/11/2020
  Time: 11:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<br>
<p>Chi tiết các đơn hàng đã đặt</p>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Tài khoản</th>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Giá</th>
        <th scope="col">Thời gian đặt hàng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listproductbyuser}" var="item" >
        <tr>
            <td>${item.customerName}</td>
            <td>${item.productName}</td>
            <td>${item.productPrice}</td>
            <td>${item.timeBuy}</td>

        </tr>

    </c:forEach>
    </tbody>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</body>
</html>
