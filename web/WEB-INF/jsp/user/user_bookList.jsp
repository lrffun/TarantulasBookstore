<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--图书列表页面-->
<!DOCTYPE html>
<head>
    <title>图书列表</title>
    <meta name="referrer" content="no-referrer">
    <jsp:include page="../../../include.jsp"/>
    <style>
        .backgroundShow{
            position: absolute;
            left: 0;
            top: 0;
            z-index: -1;
            //overflow: hidden;
            overflow: scroll;
            width: 80%;
            height:80%;
        }
        .backgroundImg{
            position: absolute;
            left: 0;
            top: 0;
            z-index: -2;
        }

        .lay_background_img{
            transition: opacity 20s ease;
            opacity: 0;
        }
    </style>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 图书列表</div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-1">
                <a href="/admin/ch/addBook">
                    <button class="btn btn-info" value="提交" type="submit"> + 添加图书</button>
                </a>
            </div>

            <form action="/admin/ch/selectBookByName.action" method="post">
                <div class="col-md-3">
                    <input type="text" name="name" class="form-control input-md" placeholder="请输入您想搜索的图书名">
                </div>
                <div class="col-md-1">
                    <button class="btn btn-info" type="submit"><span class="glyphicon glyphicon-search"> </span> 搜索
                    </button>
                </div>
            </form>
            <div class="col-md-3"></div>
            <table class="table Cont_center" style="margin-top: 50px;">
                <tr><b>
                    <td>图书编号</td>
                    <td>图书名</td>
                    <td>封面</td>
                    <td>类别</td>
                    <td>作者</td>
                    <td>出版社</td>
                    <td>出版日期</td>
                    <td>简介</td>
                    <td>所在校区</td>
                </b></tr>
                <%-- 遍历 图书列表 --%>
                <c:forEach var="bookInfo" items="${libraryPageCount}">
                    <tr>
                        <td>${bookInfo.id}</td>
                        <td>《${bookInfo.name}》</td>
                        <td><img src="${bookInfo.img} " style="width: 70px;height: 100px;"></td>
                        <td>${bookInfo.tag}</td>
                        <td>${bookInfo.author}</td>
                        <td>${bookInfo.press}</td>
                        <td>${bookInfo.date}</td>
                        <td>${bookInfo.introduction}</td>
                        <td>${bookInfo.place}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
    <%--    <div class="panel-footer">--%>
    <%--        <ul class="pagination" style="margin-left: 33%">--%>
    <%--            <li><a href="/admin/ch/loan_bookList.action?currentPage=${libraryPageCount.currentPage -1}&pageRows=6">&laquo;上一页</a>--%>
    <%--            </li>--%>
    <%--            <c:forEach begin="1" end="${libraryPageCount.totalPages}" varStatus="indexValue" step="1">--%>
    <%--                <li>--%>
    <%--                    <a href="/admin/ch/loan_bookList.action?currentPage=${indexValue.index}&pageRows=6">${indexValue.index}</a>--%>
    <%--                </li>--%>
    <%--            </c:forEach>--%>
    <%--            <li><a href="/admin/ch/loan_bookList.action?currentPage=${libraryPageCount.currentPage +1}&pageRows=6">下一页&raquo;</a>--%>
    <%--            </li>--%>

    <%--        </ul>--%>

    <%--    </div>--%>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#search").click(function () {
            // 获取 bookname 的值
            $(location).attr('href', '${pageContext.servletContext.contextPath}/admin/ch/loan_bookList.action?bookname=' + $("#bookname").val());
        })
    });

    window.onload = function () {
        //获取到时间戳数组
        var formatDate = $(".formatDate");
        formatDate.each(function () {
            $(this).html(getLocalTime($(this).text()))
        })
    };


</script>

</html>
