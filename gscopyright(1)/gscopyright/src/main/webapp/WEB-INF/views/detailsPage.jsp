<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.12.21
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style type="text/css">
        .inline_div {
            display: inline-block
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/css/zerogrid.css">
    <link rel="stylesheet" href="/css/style.css">
    <title>详情页</title>
</head>
<%
    String s ="";
    s+= (String) session.getAttribute("addCart_state");
    if (s.equals("commodity1"))
        response.getWriter().print("<script type=\"text/javascript\">alert(\"购物车添加成功！\");</script>");
    else if (s.equals("commodity0"))
        response.getWriter().print("<script type=\"text/javascript\">alert(\"已经添加购物车！\");</script>");
    else if (s.equals("commodity-1"))
        response.getWriter().print("<script type=\"text/javascript\">alert(\"购物车添加失败！\");</script>");
    else if (s.equals("order1"))
        response.getWriter().print("<script type=\"text/javascript\">alert(\"购买成功！\");</script>");
    else if (s.equals("order0"))
        response.getWriter().print("<script type=\"text/javascript\">alert(\"已经拥有该版权！\");</script>");
    else if (s.equals("order-1"))
        response.getWriter().print("<script type=\"text/javascript\">alert(\"购买失败！\");</script>");
    session.removeAttribute("addCart_state");

%>


<body>
<jsp:include page="HeadAndFoot/header.jsp"></jsp:include>

<section id="content">
    <div class="zerogrid">
        <div class="row block">

            <div class="main-content col11">

                <article>
                    <div class="heading">
                        <h2><a href="#"><strong>${pageinfo.title}
                        </strong></a></h2>
                        <p class="info">${pageinfo.source}&nbsp;${pageinfo.newstime}
                        </p>
                    </div>
                    <div class="content">
                        <img src="/images/thumb1.jpg"/>
                        <p>${pageinfo.content}
                        </p>
                    </div>
                    <div class="footer">
                        <p class="more"><a class="button" href=${pageinfo.url}>查看原文</a></p>
                    </div>
                </article>
                <article style="background: #cceed0">
                    <div class="" >
                        <h2 style="color: black">版权信息</h2>
                        <style type="text/css">
                            .info{font-family: 微软雅黑;font-weight: bold;font-size: 20px;color: red}
                        </style>
                        <span class="info">版权码：${pageinfo.copyright_code}</span><br>
                        <span class="info">版权归属：${pageinfo.source}</span><br>
                        <span class="info">授权价格：100￥</span><br>
                    </div>
                    <div class="footer">
                        <a class="button" href=${pageinfo.url}>查看原文</a>
                        <a class="button" href="/usercenter/addItem?_id=${pageinfo._id}">加入购物车</a>
                        <a class="button" href="/usercenter/buyItem?_id=${pageinfo._id}">授权购买</a>
                    </div>
                </article>

            </div>
            <div class="sidebar col05">
                <section>
                    <div class="heading">相关推荐</div>
                    <div class="content">
                        <ul class="list">
                            <li><a href="./${recommendation.rec_hot[0]._id}">${recommendation.rec_hot[0].title}</a></li>
                            <li><a href="./${recommendation.rec_hot[1]._id}">${recommendation.rec_hot[1].title}</a></li>
                            <li><a href="./${recommendation.rec_hot[2]._id}">${recommendation.rec_hot[2].title}</a></li>
                            <li><a href="./${recommendation.rec_hot[3]._id}">${recommendation.rec_hot[3].title}</a></li>
                            <li><a href="./${recommendation.rec_hot[4]._id}">${recommendation.rec_hot[4].title}</a></li>
                        </ul>
                    </div>
                </section>
                <section>
                    <div class="heading">热门推荐</div>
                    <div class="content">
                        <ul class="list">
                            <%--<li><a href="http://www.zerotheme.com"><%=titles[0]%></a></li>--%>
                            <li><a href="./${recommendation.rec_hot[0]._id}">${recommendation.rec_hot[0].title}</a></li>
                            <li><a href="./${recommendation.rec_hot[1]._id}">${recommendation.rec_hot[1].title}</a></li>
                            <li><a href="./${recommendation.rec_hot[2]._id}">${recommendation.rec_hot[2].title}</a></li>
                            <li><a href="./${recommendation.rec_hot[3]._id}">${recommendation.rec_hot[3].title}</a></li>
                            <li><a href="./${recommendation.rec_hot[4]._id}">${recommendation.rec_hot[4].title}</a></li>
                        </ul>
                    </div>
                </section>
                <section>
                    <div class="heading">猜你喜欢</div>
                    <div class="content">
                        <ul class="list">
                            <%--<li><a href="http://www.zerotheme.com"><%=titles[0]%>--%>
                            <li><a href="./${recommendation.rec_user[0]._id}">${recommendation.rec_user[0].title}</a></li>
                            <li><a href="./${recommendation.rec_user[1]._id}">${recommendation.rec_user[1].title}</a></li>
                            <li><a href="./${recommendation.rec_user[2]._id}">${recommendation.rec_user[2].title}</a></li>
                            <li><a href="./${recommendation.rec_user[3]._id}">${recommendation.rec_user[3].title}</a></li>
                            <li><a href="./${recommendation.rec_user[4]._id}">${recommendation.rec_user[4].title}</a></li>
                        </ul>
                    </div>
                </section>
                <%--<section>--%>
                <%--<div class="heading">Popular Post</div>--%>
                <%--<div class="content">--%>
                <%--<section>--%>
                <%--<img src="./header_foot/images/thumb4.jpg"/>--%>
                <%--<h4><a href="#">Sample post with, links, paragraphs and comments</a></h4>--%>
                <%--<p>Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat--%>
                <%--imperdiet. Vestibulum sapien. Proin quam. Etiam ultrices.</p>--%>
                <%--</section>--%>
                <%--<section>--%>
                <%--<img src="./header_foot/images/thumb5.jpg"/>--%>
                <%--<h4><a href="#">This is Just Going To Be Another Test Post</a></h4>--%>
                <%--<p>Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat--%>
                <%--imperdiet. Vestibulum sapien. Proin quam. Etiam ultrices.</p>--%>
                <%--</section>--%>
                <%--<section>--%>
                <%--<img src="./header_foot/images/thumb6.jpg"/>--%>
                <%--<h4><a href="#">This Is Going To Be A Decent Length Title With Little Text</a></h4>--%>
                <%--<p>Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat--%>
                <%--imperdiet. Vestibulum sapien. Proin quam. Etiam ultrices.</p>--%>
                <%--</section>--%>
                <%--</div>--%>
                <%--</section>--%>
            </div>

        </div>
    </div>
</section>

<jsp:include page="HeadAndFoot/foot.jsp"></jsp:include>

</body>
</html>
