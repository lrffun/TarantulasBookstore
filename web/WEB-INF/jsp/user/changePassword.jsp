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
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 修改密码</div>
    <div class="panel-body">
        <form method="post" action="/changePassword?id=${id}">
            <div class="row">
                <div class="col-md-3">
                    <input id="id" type="text" name="id" class="form-control input-md" disabled="true" placeholder="${id}"/>
                </div>
                <div class="col-md-3">
                    <input id="password" type="text" name="password" class="form-control input-md" placeholder="请输入新密码"/>
                </div>
                <div class="col-md-1">
                    <button id="search" type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search"> </span> 修改
                    </button>
                </div>
                <div class="col-md-3"></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
