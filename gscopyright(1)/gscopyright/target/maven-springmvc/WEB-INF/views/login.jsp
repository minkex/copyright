<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.12.21
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/login.css">
    <meta charset="utf-8">
    <title>版权原型系统</title>
    <jsp:include page="/WEB-INF/views/HeadAndFoot/styles.jsp"></jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script>
        $(function () {
            $("#slider").responsiveSlides({
                auto: true,
                pager: true,
                nav: true,
                speed: 500,
                maxwidth: 960,
                namespace: "centered-btns"
            });
        });
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/views/HeadAndFoot/header.jsp"></jsp:include>
<div style="position:absolute;z-index:-1;width:100%;height:100%;">
    <img src='/images/login.jpg' width="100%" height="100%"/>
</div>

<div style="position: relative;width: 100%;height: 60%">
    <div class="auto_tab_content">
        <div >
            <form action="login.do" method="post">
                <table>
                    <tr>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            帐号：
                        </td>
                        <td>
                            <input type="text" name="username" style="width:200px; ">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            密码：
                        </td>
                        <td>
                            <input type="password" name="password" style="width:200px; ">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            验证码：
                        </td>
                        <td>
                            <input name="vcode"/>
                            <img src="/code" onclick="this.src='/code?'+Math.random();"
                                 class="s1" title="点击更换">
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="usertype" value="u" style="width:20px; ">个人
                            <input type="radio" name="usertype" value="m" style="width:20px; ">媒体
                        </td>
                    </tr>
                    <tr >
                        <td>
                        </td>
                        <td>
                            <input type="submit" class="button">

                        </td>
                    </tr>
                </table>
                <%
                    String result = request.getParameter("result");
                    if ("1".equals(result))
                    {
                %>
                <font color="#FF0000">账号密码错误!!<font>
                        <%
        }
        %>
            </form>
        </div>


    </div>
</div>
<jsp:include page="/WEB-INF/views/HeadAndFoot/foot.jsp"></jsp:include>
</body>
</html>
