<%--
  Created by IntelliJ IDEA.
  User: Media
  Date: 21/10/2020
  Time: 3:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Trang chủ</title>
</head>

<body>

<div class="row">

    <div class="col-lg-3">

        <h1 class="my-4" style="font-size: 30px">Car Future</h1>
        <div class="list-group">
            <c:forEach var="item" items="${categories}">
                <a style="color: black" href="/trang-chu?sort=${item.getId()}" class="list-group-item">${item.getCode()}</a>
            </c:forEach>
            <a style="color: black" href="/trang-chu" class="list-group-item">All</a>
        </div>
        <br>
        <br>
        <div class="searchform" style="font-size: 12px">
            <div class="search">
                <div class="topnav">
                    <div class="search-container">
                        <form action="/trang-chu?search=${search}" method="get">
                            <%--                <form action="/trang-chu?search='%${search}%'" method="get">--%>
                            <input style="border: none" type="text" placeholder="Search..." name="search" id="search">
                            <button style=" border: none" type="submit" >Tìm kiếm</button>
                        </form>
                    </div>
                </div>
            </div>
            <br>
            <form action="/trang-chu?from=${from}&to=${to}">
                <p>Chọn khoảng giá</p>
                Từ:
                <select style="border: none" name="from">
                    <option value="100000">100000</option>
                    <option value="300000">300000</option>
                    <option value="500000">500000</option>
                    <option value="700000">700000</option>
                    <option value="900000">900000</option>
                </select>
                đến:
                <select style="border: none" name="to">
                    <option value="100000">100000</option>
                    <option value="300000">300000</option>
                    <option value="500000">500000</option>
                    <option value="700000">700000</option>
                    <option value="900000">900000</option>
                </select>
                <button style="border: none" type="submit">Tìm kiếm</button>
            </form>
            <br>
            <form action="/trang-chu?price=${asc}" method="get">
                <input type="hidden" name="price" value="asc">
                <button style="border: none" type="submit">Sắp xếp tăng dần theo giá</button>
            </form>
            <br>
            <form action="/trang-chu?price=${desc}" method="get">
                <input type="hidden" name="price" value="desc">
                <button style="border: none" type="submit">Sắp xếp giảm dần theo giá</button>
            </form>
        </div>

    </div>
    <!-- /.col-lg-3 -->

    <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <img class="d-block img-fluid" src="https://caredge.com/images/cars/photos/900_lexus-es-350.jpg"
                         alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block img-fluid" src="https://caredge.com/images/cars/photos/900_lexus-is-350.jpg"
                         alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img style="width: 900px; height: 463px" class="d-block img-fluid"
                         src="https://s3-us-east-2.amazonaws.com/lexus-cms-media/wp-content/uploads/2019/10/2020_Lexus_IS_F_SPORT_BLACKLINE_01-1500x900.jpg"
                         alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="row" >

            <c:forEach items="${listProduct}" var="item">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="#"><img style="height: 150px" class="card-img-top" src="${item.getLinkImage()}" alt=""></a>
                        <div class="card-body" >
                            <h4 class="card-title" >
                                <a style="color: black;font-size: 18px"  href="#">${item.getProductName()}</a>
                            </h4>
                            <h5>${item.getPrice()} $</h5>
                            <p class="card-text">${item.getDescription()}</p>
                            <center>
                                <c:if test="${not empty USERMODEL}">
                                    <button type="button" style="border: none; border-radius: 5px">
                                        <a style="color: black" href='<c:url value="/bill?type=order&id=${item.getId()}&username=${USERMODEL.userName}&userid=${USERMODEL.id}"/>'>
                                                <%--                                    <i class="menu-icon fa fa-caret-right"></i>--%>
                                            Đặt hàng
                                        </a>
                                    </button>
                                </c:if>

                                <button type="button" style="border: none; border-radius: 5px">
                                    <a style="color: black" href='<c:url value="/detail?type=detail&id=${item.getId()}"/>'>
                                            <%--                                    <i class="menu-icon fa fa-caret-right"></i>--%>
                                        Chi tiết
                                    </a>
                                </button>
                            </center>

                                <%--                            <button type="button" class="btn btn-success">--%>
                                <%--                                <a href='<c:url value="/detail?type=detailr&id=${item.getId()}"/>/>Chi tiết</a>--%>
                                <%--                            </button>--%>
                        </div>
                        <div class="card-footer">
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
        <!-- /.row -->

    </div>
    <!-- /.col-lg-9 -->

</div>
<!-- /.row -->
</body>
</html>
