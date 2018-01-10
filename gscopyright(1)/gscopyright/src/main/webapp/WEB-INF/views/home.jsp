<%--
  Created by IntelliJ IDEA.
  User: SUN
  Date: 2017.12.21
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>版权原型系统</title>
    <jsp:include page="HeadAndFoot/styles.jsp"></jsp:include>
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
<jsp:include page="HeadAndFoot/header.jsp"></jsp:include>

<!--------------Content--------------->
<section id="content">
    <div class="zerogrid">
        <div class="row block">

            <div class="featured col16">
                <div class="rslides_container">
                    <ul class="rslides" id="slider">
                        <li><img src="/images/1.jpg"/></li>
                        <li><img src="/images/2.jpg"/></li>
                        <li><img src="/images/3.jpg"/></li>
                        <li><img src="/images/4.jpg"/></li>
                    </ul>
                </div>
            </div>

            <div class="sidebar col05">
                <section>
                    <div class="heading">热门推荐</div>
                    <div class="content">
                        <ul class="list">
                            <li><a href="/copyright/details/${recommendation.rec_hot[0]._id}">${recommendation.rec_hot[0].title}</a></li>
                            <li><a href="/copyright/details/${recommendation.rec_hot[1]._id}">${recommendation.rec_hot[1].title}</a></li>
                            <li><a href="/copyright/details/${recommendation.rec_hot[2]._id}">${recommendation.rec_hot[2].title}</a></li>
                            <li><a href="/copyright/details/${recommendation.rec_hot[3]._id}">${recommendation.rec_hot[3].title}</a></li>
                            <li><a href="/copyright/details/${recommendation.rec_hot[4]._id}">${recommendation.rec_hot[4].title}</a></li>
                            <%--<li><a href="http://www.zerotheme.com"><%=title[0]%></a></li>--%>
                        </ul>
                    </div>
                </section>
                <section>
                    <div class="heading">猜你喜欢</div>
                    <div class="content">
                        <ul class="list">
                            <li><a href="/copyright/details/${recommendation.rec_user[0]._id}">${recommendation.rec_user[0].title}</a></li>
                            <li><a href="/copyright/details/${recommendation.rec_user[1]._id}">${recommendation.rec_user[1].title}</a></li>
                            <li><a href="/copyright/details/${recommendation.rec_user[2]._id}">${recommendation.rec_user[2].title}</a></li>
                            <li><a href="/copyright/details/${recommendation.rec_user[3]._id}">${recommendation.rec_user[3].title}</a></li>
                            <li><a href="/copyright/details/${recommendation.rec_user[4]._id}">${recommendation.rec_user[4].title}</a></li>
                            <%--<li><a href="http://www.zerotheme.com"><%=title[0]%></a></li>--%>
                        </ul>
                    </div>
                </section>
                <%--<section>--%>
                <%--<div class="heading">Links List</div>--%>
                <%--<div class="content">--%>
                <%--<ul class="list">--%>
                <%--<li><a href="#">Free html5 templates</a></li>--%>
                <%--<li><a href="#">Free css3 menus</a></li>--%>
                <%--<li><a href="#">Free responsive html5 themes</a></li>--%>
                <%--<li><a href="#">Free onepage html5 themes</a></li>--%>
                <%--<li><a href="#">Free animated html5 themes</a></li>--%>
                <%--</ul>--%>
                <%--</div>--%>
                <%--</section>--%>
                <%--<section>--%>
                <%--<div class="heading">Popular Post</div>--%>
                <%--<div class="content">--%>
                <%--<section>--%>
                <%--<img src="./header_foot/images/thumb4.jpg"/>--%>
                <%--<h4><a href="#">Sample post with, links, paragraphs and comments</a></h4>--%>
                <%--<p>Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat imperdiet. Vestibulum sapien. Proin quam. Etiam ultrices.</p>--%>
                <%--</section>--%>
                <%--<section>--%>
                <%--<img src="./header_foot/images/thumb5.jpg"/>--%>
                <%--<h4><a href="#">This is Just Going To Be Another Test Post</a></h4>--%>
                <%--<p>Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat imperdiet. Vestibulum sapien. Proin quam. Etiam ultrices.</p>--%>
                <%--</section>--%>
                <%--<section>--%>
                <%--<img src="./header_foot/images/thumb6.jpg"/>--%>
                <%--<h4><a href="#">This Is Going To Be A Decent Length Title With Little Text</a></h4>--%>
                <%--<p>Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat imperdiet. Vestibulum sapien. Proin quam. Etiam ultrices.</p>--%>
                <%--</section>--%>
                <%--</div>--%>
                <%--</section>--%>
            </div>

            <div class="main-content col11">
                <article>
                    <div class="heading">
                        <h2><a href="/copyright/details/${pageinfos[0]._id}"><strong>${pageinfos[0].title}</strong></a></h2>
                        <p class="info">${pageinfos[0].source}&nbsp;${pageinfos[0].newstime}</p>
                    </div>
                    <div class="content">
                        <img src="/images/thumb1.jpg">
                        <p>${pageinfos[0].abstract_}</p>
                    </div>
                    <div class="footer">
                        <p class="more"><a class="button" href="/copyright/details/${pageinfos[0]._id}">详细信息>></a></p>
                    </div>
                </article>
                <article>
                    <div class="heading">
                        <h2><a href="/copyright/details/${pageinfos[1]._id}"><strong>${pageinfos[1].title}</strong></a></h2>
                        <p class="info">${pageinfos[1].source}&nbsp;${pageinfos[1].newstime}</p>
                    </div>
                    <div class="content">
                        <img src="/images/thumb1.jpg">
                        <p>${pageinfos[1].abstract_}</p>
                    </div>
                    <div class="footer">
                        <p class="more"><a class="button" href="/copyright/details/${pageinfos[1]._id}">详细信息>></a></p>
                    </div>
                </article>
                <article>
                    <div class="heading">
                        <h2><a href="/copyright/details/${pageinfos[2]._id}"><strong>${pageinfos[2].title}</strong></a></h2>
                        <p class="info">${pageinfos[2].source}&nbsp;${pageinfos[2].newstime}</p>
                    </div>
                    <div class="content">
                        <img src="/images/thumb1.jpg">
                        <p>${pageinfos[2].abstract_}</p>
                    </div>
                    <div class="footer">
                        <p class="more"><a class="button" href="/copyright/details/${pageinfos[2]._id}">详细信息>></a></p>
                    </div>
                </article>
                <article>
                    <div class="heading">
                        <h2><a href="/copyright/details/${pageinfos[3]._id}"><strong>${pageinfos[3].title}</strong></a></h2>
                        <p class="info">${pageinfos[3].source}&nbsp;${pageinfos[3].newstime}</p>
                    </div>
                    <div class="content">
                        <img src="/images/thumb1.jpg">
                        <p>${pageinfos[3].abstract_}</p>
                    </div>
                    <div class="footer">
                        <p class="more"><a class="button" href="/copyright/details/${pageinfos[3]._id}">详细信息>></a></p>
                    </div>
                </article>
                <article>
                    <div class="heading">
                        <h2><a href="/copyright/details/${pageinfos[4]._id}"><strong>${pageinfos[4].title}</strong></a></h2>
                        <p class="info">${pageinfos[4].source}&nbsp;${pageinfos[4].newstime}</p>
                    </div>
                    <div class="content">
                        <img src="/images/thumb1.jpg">
                        <p>${pageinfos[4].abstract_}</p>
                    </div>
                    <div class="footer">
                        <p class="more"><a class="button" href="/copyright/details/${pageinfos[4]._id}">详细信息>></a></p>
                    </div>
                </article>

                <%--<article>--%>
                <%--<div class="heading">--%>
                <%--<h2><a href="./detailsPage.jsp?_id=2"><%=title[1]%></a></h2>--%>
                <%--<p class="info">+ Posted by Admin - 01/01/2016 - 0 Comments</p>--%>
                <%--</div>--%>
                <%--<div class="content">--%>
                <%--<img src="./header_foot/images/thumb2.jpg"/>--%>
                <%--<p><%=contents[1]%></p>--%>
                <%--</div>--%>
                <%--<div class="footer">--%>
                <%--<p class="more"><a class="button" href="#">详细信息>></a></p>--%>
                <%--</div>--%>
                <%--</article>--%>
            </div>

        </div>
    </div>
</section>
<jsp:include page="HeadAndFoot/foot.jsp"></jsp:include>
</body>
</html>
