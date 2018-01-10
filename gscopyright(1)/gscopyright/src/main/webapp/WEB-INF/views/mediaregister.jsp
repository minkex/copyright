<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2017/12/26
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link rel="stylesheet" href="/css/login.css">
        <jsp:include page="HeadAndFoot/styles.jsp"></jsp:include>
        <title>用户注册</title>
    </head>
</head>
<body>
<jsp:include page="/WEB-INF/views/HeadAndFoot/header.jsp"></jsp:include>
<div class="auto_tab_content_r">
    <form style="margin: 0px" action="/mediaregister.do" method="post">
        <table>
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td>
                    媒体全称：
                </td>
                <td>
                    <input type="text" name="medianame" style="width:200px;">
				</td>
			</tr>
			<tr>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					法人姓名：
				</td>
				<td>
					<input type="text" name="username" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td>
                    身份证号：
                </td>
                <td>
                    <input type="text" name="IDnumber" style="width:200px;">
				</td>
			</tr>
			<tr>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					营业执照注册号：
				</td>
				<td>
				    <input type="text"  name="registernumber" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td>
                    密码：
                </td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input  type="submit" class="button"  >
                </td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="/WEB-INF/views/HeadAndFoot/foot.jsp"></jsp:include>
</body>
</html>
