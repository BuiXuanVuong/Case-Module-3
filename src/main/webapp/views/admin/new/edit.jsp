<%--
  Created by IntelliJ IDEA.
  User: Media
  Date: 25/10/2020
  Time: 9:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var="NewURL" value="/admin-new"/>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa sản phẩm</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">
                                ${message}
                        </div>
                    </c:if>
                    <form id="formSubmit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hãng</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="categoryId" name="categoryId">
                                    <c:if test="${empty model.categoryId}">
                                        <option value="">Chọn hãng xe</option>
                                        <c:forEach var="item" items="${categories}">
                                            <option value="${item.id}">${item.code}</option>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty model.categoryId}">
                                        <option value="">Chọn hãng xe</option>
                                        <c:forEach var="item" items="${categories}">
                                            <option value="${item.id}" <c:if test="${item.id == model.categoryId}">selected="selected"</c:if>>
                                                    ${item.code}
                                            </option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên sản phẩm</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="productName" name="productName" value="${model.productName}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Giá</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="price" name="price" value="${model.price}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả sản phẩm</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="description" name="description"
                                       value="${model.description}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <c:choose>

                                <c:when test="${model.id > 0}">
                                    <label class="col-sm-3 control-label no-padding-right">Type</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="type1" name="type"
                                               value="${model.type}"/>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <label class="col-sm-3 control-label no-padding-right">Kiểu</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="type2" name="type"
                                               value=""/>
                                    </div>
                                </c:otherwise>
                            </c:choose>


                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tốc độ tối đa</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="speed" name="speed"
                                       value="${model.speed}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mã lực</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="power" name="power"
                                       value="${model.power}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Gear</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="gear" name="gear"
                                       value="${model.gear}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Đường dẫn ảnh</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="linkImage" name="linkImage"
                                       value="${model.linkImage}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Cập nhật sản phẩm" id="btnAddOrUpdateNew"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Thêm mới sản phẩm" id="btnAddOrUpdateNew"/>
                                </c:if>
                            </div>
                        </div>
                        <input type="hidden" value="${model.id}" id="id" name="id"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
        // var title= $('#title').val();
        // var categoryCode = $('#categoryCode').val();
        // var shortDescription = $('#shortDescription').val();
        // var content = $('#content').val();
        // var thumbnail = $('#thumbnail').val();
        var data = {};
        var formData =  $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        if (id == "") {
            addNew(data);
        } else {
            updateNew(data)
        }
    });
    function addNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                console.log(result);
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
    function updateNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data), // bo chuyen javascript object -> json,
            dataType: 'json', //client gui du lieu cho server dang contentType, server gui du lieu cho client dang datatype
            success: function (result) {
                console.log(result);
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
</script>
</body>
</html>