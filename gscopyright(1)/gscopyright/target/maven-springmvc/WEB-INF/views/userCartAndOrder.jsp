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

<%if(request.getAttribute("cartOrOrder").equals("cart")){%>
购物车
<form action="" method=get>
    <style>
        table, table tr th, table tr td {
            border: 1px solid #000000;
        }

        table {
            line-height: 25px;
            text-align: center;
            border-collapse: collapse;
        }
    </style>

        <%
            if(request.getAttribute("cartList")!=null){
                %>
    <table width=75% style="margin-left: 12.5%">
        <tr style="height: 35px;background: #0e4c2f;font-size: 16px;color: #ffffff;font-family: 微软雅黑">
            <th width="30%" style="padding-top: 6px">标题</th>
            <th width="10%" style="padding-top: 6px">来源</th>
            <th width="10%" style="padding-top: 6px">类型</th>
            <th width="10%" style="padding-top: 6px">编辑</th>
            <th width="20%" style="padding-top: 6px">时间</th>
        </tr><%
            List<Pageinfo> list = (ArrayList<Pageinfo>)request.getAttribute("cartList");
            for(Pageinfo p:list){
                String title = p.getTitle();
                String source = p.getSource();
                String ctype = p.getCtype();
                String editor = p.getEditor();
                String newsTime = p.getNewstime();
                int _id = p.get_id();
                String href="/copyright/details/"+_id;
        %>
        <tr>
            <td><a href=<%=href%>><%=title%></a></td>
            <td><%=source%></td>
            <td><%=ctype%></td>
            <td><%=editor%></td>
            <td><%=newsTime%></td>
        </tr>


    <% }
    %></table><%
        }else {
                %>
        <br>您的购物车为空！
        <%
        }
        %>
    <span style="margin-left: 65%">${cartPagination}</span>
</form>
<%}else {%>
已购买
<form action="" method=get>
    <style>
        table, table tr th, table tr td {
            border: 1px solid #000000;
        }

        table {
            line-height: 25px;
            text-align: center;
            border-collapse: collapse;
        }
    </style>

        <%
            if(request.getAttribute("orderList")!=null){
        %>
    <table width=75% style="margin-left: 12.5%">
        <tr style="height: 35px;background: #0e4c2f;font-size: 16px;color: #ffffff;font-family: 微软雅黑">
            <th width="30%" style="padding-top: 6px">标题</th>
            <th width="10%" style="padding-top: 6px">来源</th>
            <th width="10%" style="padding-top: 6px">类型</th>
            <th width="10%" style="padding-top: 6px">编辑</th>
            <th width="20%" style="padding-top: 6px">时间</th>
        </tr><%
            List<Pageinfo> list1 = (ArrayList<Pageinfo>)request.getAttribute("orderList");
            for(Pageinfo p:list1){
                String title = p.getTitle();
                String source = p.getSource();
                String ctype = p.getCtype();
                String editor = p.getEditor();
                String newsTime = p.getNewstime();
                int _id = p.get_id();
                String href="/copyright/details/"+_id;
        %>
        <tr>
            <td><a href=<%=href%>><%=title%></a></td>
            <td><%=source%></td>
            <td><%=ctype%></td>
            <td><%=editor%></td>
            <td><%=newsTime%></td>
        </tr>
    <% }
    %></table><%
        }else {
                %>
        <br>您的订单为空！
        <%
        }
        %>

    <span style="margin-left: 65%">${orderPagination}</span>
</form>
<%}%>
<a href="/usercenter/myCenter">返回</a>
<jsp:include page="HeadAndFoot/foot.jsp"></jsp:include>

</body>
</html>
