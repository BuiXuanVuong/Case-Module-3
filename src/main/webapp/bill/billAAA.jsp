<%--
  Created by IntelliJ IDEA.
  User: Media
  Date: 06/11/2020
  Time: 9:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="APIurl" value="/web-product"/>
<html>

<body>
<%--<form id="formSubmit" action="${APIurl}" method="post">--%>
<%--    <div class="form-group">--%>
<%--        <label >Tên sản phẩmAAAA</label>--%>
<%--        <div >--%>
<%--            <input type="text"  id="productName" name="productName" value="${product.getProductName()}"/>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <br/>--%>
<%--    <br/>--%>
<%--    <div class="form-group">--%>
<%--        <label>Số lượng sản phẩm</label>--%>
<%--        <div>--%>
<%--            <input type="text" id="amount" value="2" name="amount"/>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--    <br/>--%>
<%--    <br/>--%>
<%--    <div class="form-group">--%>
<%--        <label>Giá</label>--%>
<%--        <div >--%>
<%--            <input type="text" id="price" name="price" value="${product.getPrice()}"/>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <br/>--%>
<%--    <br/>--%>
<%--    <br/>--%>
<%--    <br/>--%>
<%--    <div class="form-group">--%>
<%--        <div>--%>
<%--            &lt;%&ndash;                        <c:if test="${empty model.id}">&ndash;%&gt;--%>
<%--            <input type="button" value="Thêm mới sản phẩm" id="btnAddOrUpdateNew"/>--%>
<%--            &lt;%&ndash;                        </c:if>&ndash;%&gt;--%>
<%--        </div>--%>
<%--    </div>--%>
<%--&lt;%&ndash;    <input type="hidden" value="${product.getId()}" id="id" name="id"/>&ndash;%&gt;--%>
<%--    <input type="hidden" value="1" id="productId" name="productId"/>--%>
<%--    <input type="hidden" value="2" id="customerId" name="customerId">--%>
<%--</form>--%>


<%--<form action="/web-product" method="post">--%>
<%--    <input type="button" value="Submit">--%>
<%--</form>--%>











<%--<button type="button" class="btn btn-primary">--%>
<%--    <a href='<c:url value="/web-product"/>'>--%>
<%--        <i class="menu-icon fa fa-caret-right"></i>--%>
<%--        Đặt hàng--%>
<%--    </a>--%>
<%--</button>--%>

<form method="post" action="/web-product">
        <div class="form-group">
            <label >Tên sản phẩm</label>
            <div >
                <input type="text"  id="productName" name="productName" value="${product.getProductName()}"/>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <label>Số lượng sản phẩm</label>
            <div>
                <input type="text" id="amount" value="1" name="amount"/>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <label>Giá</label>
            <div >
                <input type="text" id="price" name="price" value="${product.getPrice()}"/>
            </div>
        </div>
        <br/>
        <input type="hidden" value="${product.getId()}" id="productId" name="productId"/>
        <input type="hidden" value="${USERMODEL.id}" id="customerId" name="customerId">
        <input type="hidden" value="${USERMODEL.userName}" id="customerName" name="customerName">

    <div class="form-group">
        <div>
            <button type="submit" value="Submit" style="width: 150px; height: 50px">Đăng ký đặt hàng</button>
        </div>
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
</form>




<%--<script>--%>
<%--    $('#btnAddOrUpdateNew').click(function (e) {--%>
<%--        console.log("Nut an duoc nhan")--%>
<%--        e.preventDefault();--%>
<%--        // var title= $('#title').val();--%>
<%--        // var categoryCode = $('#categoryCode').val();--%>
<%--        // var shortDescription = $('#shortDescription').val();--%>
<%--        // var content = $('#content').val();--%>
<%--        // var thumbnail = $('#thumbnail').val();--%>
<%--        var data = {};--%>
<%--        var formData =  $('#formSubmit').serializeArray();--%>
<%--        $.each(formData, function (i, v) {--%>
<%--            data[""+v.name+""] = v.value;--%>
<%--        });--%>
<%--        var id = $('#id').val();--%>
<%--        if (id == "") {--%>
<%--            addBill(data);--%>
<%--        }--%>
<%--    });--%>
<%--    function addBill(data) {--%>
<%--        $.ajax({--%>
<%--            url: '${APIurl}',--%>
<%--            type: 'POST',--%>
<%--            contentType: 'application/json',--%>
<%--            data: JSON.stringify(data),--%>
<%--            dataType: 'json',--%>
<%--            success: function (result) {--%>
<%--                console.log(result);--%>
<%--            },--%>
<%--            error: function (error) {--%>
<%--                console.log(error);--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
