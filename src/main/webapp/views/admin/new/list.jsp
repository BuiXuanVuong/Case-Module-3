<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var="NewURL" value="/admin-new"/>
<!DOCTYPE html>
<head>
    <title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
    <form action="<c:url value='/admin-new'/>" id="formSubmit" method="get">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                </ul>
                <!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
                            <div class="alert alert-${alert}">
                                    ${messageResponse}
                            </div>
                        </c:if>
                        <div class="widget-box table-filter">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip"
                                           title='Thêm bài viết' href='<c:url value="/admin-new?type=edit"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
                                        </a>
                                        <button id="btnDelete" type="button"
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip" title='Xóa bài viết'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" id="checkAll"></th>
                                            <th>Tên sản phẩm</th>
                                            <th>Hãng sản xuất</th>
                                            <th>Giá</th>
                                            <th>Kiểu</th>
                                            <th>Tốc độ tối đa</th>
                                            <th>Mã lực</th>
                                            <th>Gear</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                                <td>${item.productName}</td>
                                                <td>
                                                    <c:forEach items="${categories}" var="category">
                                                        <c:if test="${category.id == item.categoryId}">
                                                            ${category.code}
                                                        </c:if>
                                                    </c:forEach>
                                                </td>
                                                <td>${item.price}</td>
                                                <td>${item.type}</td>
                                                <td>${item.speed}</td>
                                                <td>${item.power}</td>
                                                <td>${item.gear}</td>
                                                <td>
                                                    <c:url var="editURL" value="/admin-new">
                                                        <c:param name="type" value="edit"/>;
                                                        <c:param name="id" value="${item.id}"/>;
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật bài viết" href='${editURL}'><i
                                                            class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="type" name="type"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- /.main-content -->
<script type="text/javascript">
    $("#btnDelete").click(function(){
        var data = {};
        var id = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        // data['id'] = id;
        data['id'] = parseInt(id);
        deleteNew(data);

    });

    function deleteNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "${NewURL}?type=delete";
            },
            error: function (error) {
                console.log(error);
            }
        });
    }



</script>