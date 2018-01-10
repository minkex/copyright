<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.12.20
  Time: 17:14
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
<table>
    <c:forEach items="${files}" var="filename">
        <tr>
            <td><a href="home/down?filename=${filename}">${filename}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
