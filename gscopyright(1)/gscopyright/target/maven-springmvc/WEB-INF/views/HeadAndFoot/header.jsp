<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.11.6
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.lang.String" %>

<html>
<head>
    <jsp:include page="styles.jsp"></jsp:include>
    <script>
        function registFirstly() {
            <%
                String ss=(String) session.getAttribute("session_username");
                if(ss!=null)
                {
            %>
                con=confirm("是否先注销");
                if(con==true)
                {
                    session.getAttribute("session_username").invalidate()
                    window.location.href="/mediaregister"
                }

            <%
                }else{
            %>
            window.location.href="/mediaregister"
            <%
            }
            %>

        }
    </script>
</head>
<body>
<!--------------Header--------------->

<header>
    <div class="zerogrid">
        <div class="row">
            <div class="col05">
                <div id="logo"><a href=""><img src="/images/logoDD.png"/></a></div>
            </div>
            <div style="margin-top: 5%">
                <span style="font-family: 微软雅黑;font-size: 40px;color: white">版权原型系统</span>
            </div>
            <div class="col06 offset05" style="margin-top: -5%">
                <div id='search-box'>
                    <form action='' id='search-form' method='get' target='_top'>
                        <input id='search-text' name='q' placeholder='type here' type='text'/>
                        <button id='search-button' type='submit'><span>Search</span></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</header>

<!--------------Navigation--------------->

<nav style="height:40px">

    <ul style="font-weight: bold;">
        <li><a href="/copyright/home">首页</a></li>
        <li><a href="/copyright/copyrightSearch?pageNum=1">版权检索</a></li>
        <li><a href="./copyrightCertification.jsp">版权认证</a></li>
        <li><a href="./copyrightPurchase.jsp">版权购买</a></li>
        <li><a href="./rightsProtection.jsp">维权</a></li>
        <li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li>
        <li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li>
        <li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li>
        <li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li><li>&nbsp;</li>



            <%
            String s=(String) session.getAttribute("session_username");
            System.out.println(s);
            if (s==null)
            {

            %>
                    <li><a href="/usercenter/login">登录</a></li>
                    <li><a href="/usercenter/register">注册</a></li>
            <%
            }
            else{
            %>
            <li><a href="/usercenter/myCenter?cart=1&order=1">欢迎你！<%=s%></a></li>
            <li><a href="/usercenter/logou">注销</a></li>
            <%
            }
            %>
        <li><a href="javascript:void(0);" onclick="registFirstly()">媒体入驻</a></li>

    </ul>

</nav>
<nav style="height: 75px">

    <ul>
        <li><a href="/copyright/home/politics">时政</a></li>
        <li><a href="/copyright/home/finance">财经</a></li>
        <li><a href="/copyright/home/local">地方</a></li>
        <li><a href="/copyright/home/technology">科技</a></li>
        <li><a href="/copyright/home/international">国际</a></li>
        <li><a href="/copyright/home/car">汽车</a></li>
        <li><a href="/copyright/home/taiwan">台湾</a></li>
        <li><a href="/copyright/home/education">教育</a></li>
        <li><a href="/copyright/home/sports">体育</a></li>
        <li><a href="/copyright/home/HKM">港澳</a></li>
        <li><a href="/copyright/home/health">健康</a></li>
        <li><a href="/copyright/home/house">房产</a></li>
        <li><a href="/copyright/home/energy">能源</a></li>
    </ul>

</nav>
</body>
</html>
