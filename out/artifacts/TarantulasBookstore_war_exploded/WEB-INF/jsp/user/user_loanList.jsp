<!--借阅记录页面-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="zh-CN">

<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="UTF-8">
    <title>借阅记录</title>
    <jsp:include page="../../../include.jsp"/>
</head>

<body>
<div class="panel panel-default">

            <div class="col-md-3"></div>
            <table class="table Cont_center" style="margin-top: 50px;">
                <tr><b>
                    <td>借阅人学号</td>
                    <td>借阅人姓名</td>
                    <td>图书编号</td>
                    <td>图书名称</td>
                    <td>借阅时间</td>
                    <td>归还时间</td>
                </b></tr>

                <c:forEach items="${loanRecordList}" var="item">
                    <tr data-id="${item.stu_id}">
                        <td>${item.stu_id}</td>
                        <td>${item.stu_name}</td>
                        <td>${item.book_id}</td>
                        <td>《${item.book_name}》</td>
                        <td><fmt:formatDate value="${item.borrow_date}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${item.sreturn_date}" pattern="yyyy-MM-dd"/></td>
                        <td><a href="/user/return.action?stu_id=${item.stu_id}&book_id=${item.book_id}">
                            <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 归还</button>
                        </a>
                            <a href="/user/renew.action?stu_id=${item.stu_id}&book_id=${item.book_id}">
                                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 续借
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
<%--    <div class="panel-footer">--%>
<%--        <ul class="pagination" style="margin-left: 33%">--%>
<%--            <c:if test="${pageL.currentPage-1 >= 1}">--%>
<%--                <li>--%>
<%--                    <a href="loanList.action?currentPage=${pageL.currentPage -1}">&laquo;上一页</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>

<%--            &lt;%&ndash; 遍历页码 &ndash;%&gt;--%>
<%--            <c:forEach begin="1" step="1" end="${pageL.totalPages}" varStatus="pageInfo">--%>
<%--                <li>--%>
<%--                    <a href="loanList.action?currentPage=${pageInfo.index}">${pageInfo.index}</a>--%>
<%--                </li>--%>
<%--            </c:forEach>--%>

<%--            <c:if test="${pageL.currentPage+1 <= pageL.totalPages}">--%>
<%--                <li>--%>
<%--                    <a href="loanList.action?currentPage=${pageL.currentPage +1}">下一页&raquo;</a>--%>
<%--                </li>--%>
<%--            </c:if>--%>
<%--        </ul>--%>
<%--    </div>--%>
</div>
</body>
<script>
    window.onload = function () {
        //获取到时间戳数组
        var formatDate = $(".formatDate");
        formatDate.each(function () {
            $(this).html(getLocalTime($(this).text()))
        })
    };


    $(function () {

        /*     function commit(parent, status) {
                 $.ajax({
                     url: 'cavavav',
                     type: 'post',
                     data: {'id': parent.dataset.id, status: status},
                     success: function (ev) {
                         console.log(ev)
                     }
                 })
             }*/

        /* $('.commit').click(function () {
             var _this = $(this)[0];
             var parent = _this.parentNode.parentNode;
             if (_this.classList.contains('btn-success')) {
                 _this.innerHTML = '<span class="glyphicon glyphicon-minus"></span>未归还';
                 _this.classList.remove('btn-success');
                 _this.classList.add('btn-danger');
                 commit(parent, false);

             } else {
                 _this.innerHTML = '<span class="glyphicon glyphicon-ok"></span>已归还';
                 _this.classList.add('btn-success');
                 _this.classList.remove('btn-danger');
                 commit(parent, true);
             }
         })*/
    });

</script>
</html>