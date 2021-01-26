<%--
  Created by IntelliJ IDEA.
  User: Media
  Date: 06/11/2020
  Time: 10:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<div class="container">
    <h2>Thông số</h2>
    <p>Chi tiết cấu hình</p>
    <table class="table">
        <thead>
        <tr>
            <th>Đặc điểm</th>
            <th>Thông số</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Type</td>
            <td>${product.getType()}</td>
        </tr>
        <tr>
            <td>Speed</td>
            <td>${product.getSpeed()}</td>
        </tr>
        <tr>
            <td>Power</td>
            <td>${product.getPower()}</td>
        </tr>
        <tr>
            <td>Gear</td>
            <td>${product.getGear()}</td>
        </tr>
        </tbody>
    </table>
</div>
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
