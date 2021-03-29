<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            function re() {
                window.history.go(-1);
            }
        </script>
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="" method="post">
          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" value="${echouser.name}" name="name"  readonly="readonly" placeholder="请输入姓名" />
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${echouser.gender == '男'}">
              <input type="radio" name="sex" checked="checked" value="男"  />男
                <input type="radio" name="sex" value="女"  />女
              </c:if>
              <c:if test="${echouser.gender == '女'}">
                  <input type="radio" name="sex" value="男"  />男
                  <input type="radio" name="sex" checked="checked" value="女"  />女
              </c:if>
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" value="${echouser.age}" name="age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
             <select name="address" id="address" class="form-control" >
                 <c:if test="${echouser.hometown == '河南'}">
                     <option value="陕西" >陕西</option>
                     <option value="河南" selected="selected">河南</option>
                     <option value="北京" >北京</option>
                     <option value="上海">上海</option>
                 </c:if>
                 <c:if test="${echouser.hometown == '陕西'}">
                    <option value="陕西" selected="selected">陕西</option>
                     <option value="河南">河南</option>
                    <option value="北京" >北京</option>
                    <option value="上海">上海</option>
                 </c:if>
                 <c:if test="${echouser.hometown == '北京'}">
                     <option value="陕西" >陕西</option>
                     <option value="河南">河南</option>
                     <option value="北京" selected="selected">北京</option>
                     <option value="上海">上海</option>
                 </c:if>
                 <c:if test="${echouser.hometown == '上海'}">
                     <option value="陕西" >陕西</option>
                     <option value="河南">河南</option>
                     <option value="北京" >北京</option>
                     <option value="上海" selected="selected">上海</option>
                 </c:if>
            </select>
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" value="${echouser.qq}" name="qq" placeholder="请输入QQ号码"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${echouser.email}" name="email" placeholder="请输入邮箱地址"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" onclick="re()" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>