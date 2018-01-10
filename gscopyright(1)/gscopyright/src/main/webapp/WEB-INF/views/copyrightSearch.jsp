<%@ page import="com.seu.dao.PageinfoDAO" %><%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.11.7
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.seu.model.Pageinfo" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>版权检索</title>
</head>
<body>
<jsp:include page="HeadAndFoot/header.jsp"></jsp:include>

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
    <table width=75% style="margin-left: 12.5%">
        <tr style="height: 35px;background: #0e4c2f;font-size: 16px;color: #ffffff;font-family: 微软雅黑">
            <th width="30%" style="padding-top: 6px">标题</th>
            <th width="10%" style="padding-top: 6px">来源</th>
            <th width="10%" style="padding-top: 6px">类型</th>
            <th width="10%" style="padding-top: 6px">编辑</th>
            <th width="20%" style="padding-top: 6px">时间</th>
        </tr>
        <%
            List<Pageinfo> list = (ArrayList<Pageinfo>)request.getAttribute("pageinfos");
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
        %>
    </table>
    <span style="margin-left: 65%">${pagination}</span>
</form>


<jsp:include page="HeadAndFoot/foot.jsp"></jsp:include>

</body>
</html>
