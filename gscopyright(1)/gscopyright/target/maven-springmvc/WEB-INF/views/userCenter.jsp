<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.11.7
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.seu.model.Pageinfo" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <jsp:include page="HeadAndFoot/styles.jsp"></jsp:include>
    <title>个人中心</title>
</head>
<body>
<jsp:include page="HeadAndFoot/header.jsp"></jsp:include>
<a href="/usercenter/userCart?cart=1">查看购物车</a>
<a href="/usercenter/userOrder?order=1">查看订单</a>
<jsp:include page="HeadAndFoot/foot.jsp"></jsp:include>

</body>
</html>
