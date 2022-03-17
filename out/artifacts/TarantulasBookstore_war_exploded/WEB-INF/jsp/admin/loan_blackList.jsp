<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!--用户列表-->
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>用户管理</title>
    <jsp:include page="../../../include.jsp"/>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 用户管理</div>
    <div class="panel-body">
        <div class="row">

            <!-- <div class="col-md-1">
        <select class="form-control">
            <option>是否放置首页</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>
    <div class="col-md-1">
        <select class="form-control">
            <option>是否推荐</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>
    <div class="col-md-1">
        <select class="form-control">
            <option>是否置顶</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>
    <div class="col-md-1">
        <select class="form-control">
            <option>选择分类</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>-->
            <form action="/admin/selectLikeName.action" method="post">
                <div class="col-md-3">
                    <input type="text" name="username" class="form-control input-md" placeholder="请输入您想搜索的学号">
                </div>
                <div class="col-md-1">
                    <button class="btn btn-info" type="submit"><span class="glyphicon glyphicon-search"> </span> 搜索
                    </button>
                </div>
            </form>
            <div class="col-md-3"></div>
            <table class="table Cont_center" style="margin-top: 50px;">
                <tr><b>
                    <%--<td>用户ID</td>--%>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>所在院系</td>
                    <td>所在班级</td>
                    <td>操作</td>
                </b></tr>
                <c:forEach items="${userList}" var="useList">
                    <tr>
                        <td>${useList.id}</td>
                        <td>${useList.name}</td>
                        <td>${useList.sex}</td>
                        <td>${useList.age}</td>
                        <td>${useList.college}</td>
                        <td>${useList.sclass}</td>
                        <td><a href="/admin/loan_editUser.action?id=${useList.id}">
                            <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                        </a>
                            <a href="/admin/loan_deleteUser?id=${useList.id}">
                                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除
                                </button>
                            </a>
                            <a href="/admin/outBlackList?id=${useList.id}">
                                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 移出黑名单
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>

                <!-- <tr>
            <td><label><input type="checkbox"> </label> 1</td>
            <td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>
            <td><img src="img/banner_1.jpg" width="120px" height="50px"/></td>
            <td>这是文章名称</td>
            <td>首页</td>
            <td>新闻资讯</td>
            <td>2017年5月3日</td>
            <td>
                <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
            </td>
        </tr>
        <tr>
            <td><label><input type="checkbox"> </label> 1</td>
            <td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>
            <td><img src="img/banner_1.jpg" width="120px" height="50px"/></td>
            <td>这是文章名称</td>
            <td>首页</td>
            <td>新闻资讯</td>
            <td>2017年5月3日</td>
            <td>
                <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
            </td>
        </tr>
        <tr>
            <td><label><input type="checkbox"> </label> 1</td>
            <td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>
            <td><img src="img/banner_1.jpg" width="120px" height="50px"/></td>
            <td>这是文章名称</td>
            <td>首页</td>
            <td>新闻资讯</td>
            <td>2017年5月3日</td>
            <td>
                <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
            </td>
        </tr>
        <tr>
            <td><label><input type="checkbox"> </label> 1</td>
            <td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>
            <td><img src="img/banner_1.jpg" width="120px" height="50px"/></td>
            <td>这是文章名称</td>
            <td>首页</td>
            <td>新闻资讯</td>
            <td>2017年5月3日</td>
            <td>
                <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
            </td>
        </tr>
    </table>
    <div class="col-md-8">
        <table class="table Cont_center">
            <tr>
                <td><label><input type="checkbox"> </label> 全选</td>
                <td>
                    <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
                </td>
                <td>
                    <button class="btn btn-info"><span class="glyphicon glyphicon-indent-left"> </span> 排序
                    </button>
                </td>
                <td><select class="form-control">
                    <option>是否放置首页</option>
                    <option>是</option>
                    <option>否</option>
                </select></td>
                <td><select class="form-control">
                    <option>是否推荐</option>
                    <option>是</option>
                    <option>否</option>
                </select></td>

                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>是否置顶</option>
                        <option>是</option>
                        <option>否</option>
                    </select></td>
                </div>
                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>选择分类</option>
                        <option>是</option>
                        <option>否</option>
                    </select></td>
                </div>
                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>修改分类</option>
                        <option>分类1</option>
                        <option>分类2</option>
                        <option>分类3</option>
                    </select></td>
                </div>
                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>批量复制</option>
                        <option>复制5条</option>
                        <option>复制10条</option>
                        <option>复制15条</option>
                    </select></td>
                </div>
            </tr>-->
            </table>
        </div>
    </div>
</div>
<div class="panel-footer">
    <ul class="pagination" style="margin-left: 33%">
        <li>
            <a href="#">&laquo;上一页</a>
        </li>
        <li>
            <a href="#">1</a>
        </li>
        <li>
            <a href="#">2</a>
        </li>
        <li>
            <a href="#">3</a>
        </li>
        <li>
            <a href="#">4</a>
        </li>
        <li>
            <a href="#">5</a>
        </li>
        <li>
            <a href="#">下一页&raquo;</a>
        </li>
    </ul>

</div>
</div>

<script type="text/javascript">
    window.onload = function () {
        //获取到时间戳数组
        var formatDate = $(".formatDate");
        formatDate.each(function () {
            $(this).html(getLocalTime($(this).text()))
        })
    };

    var addUserForm = $("#addUserForm");
    addUserForm.on("submit", function (ev) {
        ev.preventDefault();
        var data = addUserForm.serialize();
        $.ajax({
            type: "post",
            url: "/admin/loan_addUser.action",
            data: data,
            async: true,
//					success:function(e){}
        }).done(function (e) {
            console.log(e);
            alert("添加成功！");
        }).fail(function (e) {
            alert("添加失败！");
        });
    })
</script>
</body>

</html>