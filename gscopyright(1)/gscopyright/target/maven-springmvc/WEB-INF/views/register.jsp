<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.12.21
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/login.css">
    <jsp:include page="HeadAndFoot/styles.jsp"></jsp:include>
    <title>用户注册</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/HeadAndFoot/header.jsp"></jsp:include>

<%--<jsp:include page="HeadAndFoot/header.jsp"></jsp:include>--%>
<script type="text/javascript">
    function checkEmail()
    {
        var emailValue=document.getElementsByName("email")[0].value;
        if (!isEmail(emailValue))
        {
            alert("您输入的邮箱有误,请重新核对后再输入!"+emailValue);
            document. getElementsByName("email").focus();
            return false;
        }
        return true;
    }

    function isEmail(str){
        var reg = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
        return reg.test(str);
    }
</script>
<div class="auto_tab_content_r">
    <form style="margin: 0px" action="/usercenter/register.do" method="post">
        <table>
            <tr>
                <td>
                </td>
            </tr>
            <tr>
                <td>
                    姓名：
                </td>
                <td>
                    <input  type="text" name="username" style="width:200px; ">
                </td>
            </tr>
            <tr>
                <td>
                    密码：
                </td>
                <td>
                    <input  type="password" name="password" style="width:200px; ">
                </td>
            </tr>
            <tr>
                <td>
                    邮箱：
                </td>
                <td>
                    <input  type="text" name="email" value="xxx@xxx.xxx" style="width:200px; " onchange="checkEmail()">
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="radio" name="sex" value="1" checked >男
                </td>
                <td>
                    <input type="radio" name="sex" value="2" checked >女
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

<jsp:include page="HeadAndFoot/foot.jsp"></jsp:include>
</body>
</html>
