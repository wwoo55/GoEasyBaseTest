<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2021/3/26
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/test/insertClient">
        <div>
            <label for="name">姓名：</label>
            <input type="text" id="name" name="name" placeholder="姓名"><br>
        </div>
        <div>
            <label>性别：</label>
            <input type="radio" name="sex" value="male">男
            <input type="radio" name="sex" value="female">女<br>
        </div>
        <div>
            <label>出生日期：</label>
            <input type="date" name="birthdate"><br>
        </div>
        <div>
            <label for="tel">手机号：</label>
            <input type="tel" name="tel" id="tel"><br>
        </div>
        <div>
            <label for="job">职业：</label>
            <input type="text" name="job" id="job"><br>
        </div>
        <div>
            <label for="note">备注：</label>
            <input type="text" name="note" id="note"><br>
        </div>
        <div>
            <input type="submit" value="提交">
            <input type="reset" value="重置">
        </div>
    </form>
</div>
</body>
</html>
