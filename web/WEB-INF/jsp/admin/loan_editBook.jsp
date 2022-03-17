<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--图书回填-->
<!DOCTYPE html>
<head>
    <title>修改图书内容</title>
    <jsp:include page="../../../include.jsp"/>
</head>
<body>
<div class="loan_addBook_Context" style="width: 800px; margin: 0 auto;">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="glyphicon glyphicon-edit"> </span> 修改图书内容</div>
        <div class="panel-body">
            <form action="/admin/ch/updateBook.action" method="post">
                <%-- 图书 id --%>
                <input type="hidden" name="id" value="${book.id}"/>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="">图书编号：</label>
                        <input type="text" name="id" class="form-control input-md" value="${book.id}">
                    </div>
                    <div class="col-md-9"></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="">书名：</label>
                        <input type="text" name="name" class="form-control input-md" value="${book.name}">
                    </div>
                    <div class="col-md-9"></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="">类别：</label>
                        <input type="text" name="tag" class="form-control input-md" value="${book.tag}">
                    </div>
                    <div class="col-md-9"></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label>作者：</label>
                        <!-- <button class="btn btn-info websitUpdate_btn" style="margin-top: 3px;">浏览上传</button>-->
                        <input type="text" name="author" class="form-control input-md" value="${book.author}">

                    </div>
                </div>

                <!--后台接收select_v的参数即可-->
                <div class="row">
                    <div class="form-group col-md-5">
                        <label>出版社：</label>
                        <!-- <button class="btn btn-info websitUpdate_btn" style="margin-top: 3px;">浏览上传</button>-->
                        <input type="text" name="press" class="form-control input-md" value="${book.press}">

                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5">
                        <label for="">简介：</label>
                        <textarea class="form-control" rows="3" name="introduction">${book.introduction}</textarea>
                    </div>
                </div>

                <div class="row">
                    </br>
                    <div class="col-md-8">
                        <label for="">出版日期：</label>
                        <input type="text" name="date" class="form-control input-md" value="${book.date}">
                    </div>
                    </br>
                </div>
                    <div class="row">
                        </br>
                        <div class="col-md-5">
                            <label for="">所在校区：</label>
                            <input type="text" name="place" class="form-control input-md" value="${book.place}">
                        </div>
                        </br>
                    </div>

                <div class="row">
                    </br>
                    <button class="btn btn-info" value="提交" type="submit" style="margin-left: 15px;">提交 <span
                            class="glyphicon glyphicon-ok"> </span></button>
                </div>
            </form>
        </div>
    </div>
    <!--bs 栅格系统结束-->
</div>
</body>
</html>