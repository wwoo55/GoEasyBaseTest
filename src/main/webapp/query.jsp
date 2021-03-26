<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2021/3/26
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>
        <h1>查询功能(可只填部分条件)</h1>
    </div>
    <div>
        <form method="get" action="/test/queryClient">
            <div>
                <label for="name">客户名称：</label>
                <input type="text" name="name" id="name">
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
                <input type="submit" value="查询">
                <input type="reset" value="重置">
            </div>
        </form>
    </div>
</div>
</body>
</html>
