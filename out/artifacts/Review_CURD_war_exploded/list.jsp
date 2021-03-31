<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        window.onload = function () {
            var uids = document.getElementsByName("uid");
            document.getElementById("delSeleced").onclick = function () {
                if (confirm("您确定要删除吗？")){
                    var flog = false;
                    for (var i = 0;i < uids.length;i++){
                        if (uids[i].checked){
                            flog = true;
                            break;
                        }
                    }
                    if (flog){
                        var form = document.getElementById("form");
                        form.submit();
                    }
                }
            }
            var selectAll = document.getElementById("selectAll");
            selectAll.onclick = function () {
                if (selectAll.checked){
                    for (var i = 0; i < uids.length; i++){
                        uids[i].checked = true;
                    }
                }else {
                    for (var i = 0; i < uids.length; i++){
                        uids[i].checked = false;
                    }
                }
            }
        }

        function deleteUser(id) {
            if (confirm("您确定要删除吗？")){
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id="+id;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <c:if test="${sessionScope.admin != null}">
        <div style="float: left;">
            您好！欢迎登陆${sessionScope.admin.username}!!!
        </div>
    </c:if>
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float:left;">
        <form class="form-inline" action="${pageContext.request.contextPath}/listUserServlet" method="post">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="王五">
            </div>
            <div class="form-group">
                <label for="hometown">籍贯</label>
                <input type="text" class="form-control" id="hometown" name="hometown" placeholder="浙江">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="12138@gmail.com">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" id="delSeleced" href="javascript:void(0);">删除选中</a>
    </div>
    <form action="${pageContext.request.contextPath}/deleteSelecedServlet" method="post" id="form">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="selectAll"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${requestScope.pbu.tList}" var="user" varStatus="number">
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.hometown}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/echoUserServlet?id=${user.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id});">删除</a></td>
            </tr>
            </c:forEach>
        </table>
    </form>
    <nav aria-label="...">
        <ul class="pagination">
            <c:if test="${requestScope.pbu.currentPageNumber == 1}">
                <li class="disabled">
            </c:if>
            <c:if test="${requestScope.pbu.currentPageNumber > 1}">
                <li>
            </c:if>
            <a href="${pageContext.request.contextPath}/listUserServlet?currentPageNumber=${requestScope.pbu.currentPageNumber - 1}&rows=5">&laquo;</a>
            </li>
            <c:forEach begin="1" end="${requestScope.pbu.totalPageNumber}" var="i" step="1">
            <c:if test="${requestScope.pbu.currentPageNumber == i}">
            <li class="active">
                <a href="${pageContext.request.contextPath}/listUserServlet?currentPageNumber=${i}&rows=5">${i} <span class="sr-only">(current)</span></a>
            </li>
            </c:if>
            <c:if test="${requestScope.pbu.currentPageNumber != i}">
            <li>
                <a href="${pageContext.request.contextPath}/listUserServlet?currentPageNumber=${i}&rows=5">${i} <span class="sr-only">(current)</span></a>
            </li>
            </c:if>
            </c:forEach>
            <c:if test="${requestScope.pbu.currentPageNumber == requestScope.pbu.totalPageNumber}">
            <li class="disabled">
            </c:if>
            <c:if test="${requestScope.pbu.currentPageNumber < requestScope.pbu.totalPageNumber}">
            <li>
            </c:if>
                <a href="${pageContext.request.contextPath}/listUserServlet?currentPageNumber=${requestScope.pbu.currentPageNumber >= requestScope.pbu.totalPageNumber ? requestScope.pbu.currentPageNumber:requestScope.pbu.currentPageNumber + 1}&rows=5" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 24px;">共有${requestScope.pbu.totalCount}条数据，共${requestScope.pbu.totalPageNumber}页</span>
        </ul>
    </nav>
</div>
</body>
</html>
