<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.12.20
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<%=basePath%>
<table>
    <tr>
        <td>详情</td><td>文件名</td>
    </tr>
    <c:forEach items="${multiFileDomain.description}" var="description" varStatus="loop">
        <tr>
            <td>${description}</td>
            <td>${multiFileDomain.myfile[loop.count-1].originalFilename}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
