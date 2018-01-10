<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.12.5
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
上传下载页面
<form action="/home/onefile" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="myfile"><br>
    文件描述:<input type="text" name="description"><br>
    <input type="submit" value="单文件上传">
</form>

<form action="/home/multifile" method="post" enctype="multipart/form-data">
    选择文件1:<input type="file" name="myfile"><br>
    文件描述1:<input type="text" name="description"><br>
    选择文件2:<input type="file" name="myfile"><br>
    文件描述2:<input type="text" name="description"><br>
    选择文件3:<input type="file" name="myfile"><br>
    文件描述3:<input type="text" name="description"><br>
    <input type="submit" value="多文件上传">
</form>
</body>
</html>
