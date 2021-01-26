<%--
  Created by IntelliJ IDEA.
  User: Media
  Date: 21/10/2020
  Time: 8:30 CH
  To change this template use File | Settings | File Templates.
--%>
<!-- Navigation -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .navbar {
        background-color: #f8f9fa;
        font-weight: bold;
        font-family: Arial;
    }
</style>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/trang-chu" style="color: #484040; font-size: 35px">BXV</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

                <li class="nav-item active">
                    <a class="nav-link" style="color: #484040;" href="/trang-chu">Trang chủ
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <c:if test="${not empty USERMODEL}">
                    <li class="nav-item">
                        <a class="nav-link" style="color: #484040;" href="<c:url value='/bill?orders=${USERMODEL.userName}'/>">Đơn hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: #484040;" href='#'>Welcome, ${USERMODEL.userName}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: #484040;" href="<c:url value='/thoat?action=logout'/>">Thoát</a>
                    </li>
                </c:if>
                <c:if test="${empty USERMODEL}">
                    <li class="nav-item">
                        <a class="nav-link" style="color: #484040;" href="<c:url value='/dang-nhap?action=login'/>">Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: #484040;" href="<c:url value='/dang-ki?action=register'/>">Đăng kí</a>
                    </li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>

