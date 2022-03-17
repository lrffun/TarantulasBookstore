<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--图书列表页面-->
<!DOCTYPE html>
<head>
    <title>图书列表</title>
    <jsp:include page="../../../include.jsp"/>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 管理员借阅书籍办理</div>
    <div class="panel-body">
        <form method="post" action="/admin/TarantulasBookstore/OrderBorrow.action?id=${id}">
            <div class="row">
                <div class="col-md-3">
                    <input id="xuehao" type="text" name="id" class="form-control input-md" disabled="true" placeholder="${id}"/>
                </div>
                <div class="col-md-3">
                    <input id="barcode" type="text" name="barcode" class="form-control input-md" placeholder="请输入借阅图书编号"/>
                </div>
                <div class="col-md-3">
                    <input id="Date" type="text" name="mDate" class="form-control input-md" placeholder="请输入预约借阅时间（如2020-12-15）"/>
                </div>
                <div class="col-md-1">
                    <button id="search" class="btn btn-info"><span class="glyphicon glyphicon-search"> </span> 办理借阅
                    </button>
                </div>
                <div class="col-md-3"></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
