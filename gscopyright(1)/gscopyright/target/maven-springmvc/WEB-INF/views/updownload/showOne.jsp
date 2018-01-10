<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.12.20
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
            request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
${fileDomain.description}<br>
${fileDomain.myfile.originalFilename}
</body>
</html>
