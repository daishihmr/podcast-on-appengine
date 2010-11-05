<!DOCTYPE html>
<%@page import="net.hmrradio.podcastsite.define.AttrName"%>
<%@page import="net.hmrradio.podcastsite.define.Values"%>
<%@page import="net.hmrradio.podcastsite.util.LoginCheckUtil"%>

<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html
   xmlns:og="http://ogp.me/ns#"
   xmlns:mixi="http://mixi-platform.com/ns#">

<head>

<title>HMRのやっつけラジオ<c:if test="${p!=null}"> - ${ENTRY_LIST[0].title}</c:if></title>

<%
  String ua = request.getHeader("user-agent");
  if (ua.contains("iPhone") || ua.contains("iPod")) {
%>
<!-- begin for iPhone -->
<meta name="viewport" content="width=device-width" />
<!-- end for iPhone -->
<%
  }
%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="ja" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GM"/>
<meta name="keywords" content="${tags}" />
<meta name="discription" content="佐世保出身の30代男性集団が送る、笑いと情熱のポッドキャスト。車、電脳、オタク、映画、風俗、音楽、ゲームなどをネタに、幅広い話題を提供。やっつけ仕事でなるべく週１回ぐらいで更新していくネットラジオです。" />
<link rel="alternate" type="application/rss+xml" title="RSS 2.0" href="/rss" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />

<!-- begin for Mixi Check -->
<meta property="mixi:content-rating" content="1" />
<link rel="mixi-check-image" type="image/jpeg" href="http://www.hmr-radio.net/yattsu-ke.jpg" />
<!-- end for Mixi Check -->

<%@include file="/importScripts.jsp" %>
<script type="text/javascript">
// <![CDATA[
$(function() {
    $("#content > a").css({ "z-index" : "100"});

	$(".editEntryButton").button({
		icons: { primary: "ui-icon-pencil" }
	});

    setTimeout(function() {
        $("#message").slideUp();
    }, 3000);
});
// ]]>
</script>

</head>

<body>

<!-- begin wrap -->
<div id="wrap">
    <!-- begin header -->
    <div id="header">
        <h1><a href="/"><img src="/images/header_logo-trans.png" /></a></h1>
        <h1 style="display:none">HMRのやっつけラジオ</h1>
        <h2>佐世保出身の30代男性集団が送る、笑いと情熱のポッドキャスト</h2>
        <ul>
            <li></li>
        </ul>
    </div>
    <!-- end header -->
    <!-- begin page -->
    <div id="page">
        <!-- begin content -->
        <div id="content">

            <div id="posts">
                <!-- begin 記事 -->
<c:forEach items="${ ENTRY_LIST }" var="entry" varStatus="s">
                <%@include file="entry.jsp" %>
</c:forEach>
                <!-- end 記事 -->
            </div>

        </div>
        <!-- end content -->
        <!-- begin sidebar -->
        <div id="sidebar">
            <ul>
<% if (LoginCheckUtil.isAdmin()) { %>
                <li>
                    <h2>for HMR only</h2>
                    <div style="padding: 20px">
                        <ul>
                            <li><a id="login" href="/logout">ログアウト</a></li>
                            <li><a href="/blogEntry/">新規投稿</a></li>
                            <li><a onclick="openImageWindow()" href="javascript:void(0)">画像投稿</a></li>
                        </ul>
                    </div>
                </li>
<% } %>
                <li>
                    <h2>Podcast Feed</h2>
                    <div style="padding: 20px">
                        <div style="text-align:center">
                            <a href="/rss"><img src="/images/podcast-rss.gif" /></a>
                        </div>
                        このバナーを<strong><a href="http://www.apple.com/jp/itunes/download/">iTunes(無料)</a></strong>上へドラッグ＆ドロップすることで番組を登録することができます。<br />
                        登録するとiTunesが自動的にやっつけラジオの最新放送をチェックします。<br />
                    </div>
                </li>
                <li>
                    <h2>Mail</h2>
                    <div style="padding:20px">
                        <a href="mailto:hmrblog@gmail.com">メールをくれ！</a>
                    </div>
                </li>
                <li>
                    <h2>Link</h2>
                    <div style="padding: 20px">
                        <ul id="linkUl">
<c:forEach items="${LINK_LIST}" var="link">
                            <%@include file="link.jsp" %>
</c:forEach>
                        </ul>
                    </div>
                </li>
                <li>
                    <h2>Twitter</h2>
                    <div style="padding: 20px">
                        <script src="http://widgets.twimg.com/j/2/widget.js"></script>
                        <script>
                        new TWTR.Widget({
                            version:2,
                            type:'list',
                            rpp:30,
                            interval:6000,
                            title:'HMR Tweet',
                            subject:'HMRのつぶやき',
                            width:'auto',
                            height:300,
                            theme:{
                                shell:{
                                    background:'#40408c',
                                    color:'#ffffff'
                                },
                                tweets:{
                                    background:'#000000',
                                    color:'#ece3ff',
                                    links:'#9587fa'
                                }
                            },
                            features:{
                                scrollbar:true,
                                loop:false,
                                live:true,
                                hashtags:true,
                                timestamp:true,
                                avatars:true,
                                behavior:'all'
                            }
                        }).render().setList('daishi_hmr', 'hmr').start();
                        </script>
                    </div>
                </li>
<% if (!LoginCheckUtil.isAdmin()) { %>
                <li>
                    <h2>for HMR only</h2>
                    <div style="padding: 20px">
                        <ul>
                            <li><a id="login" href="/login">ログイン</a></li>
                        </ul>
                    </div>
                </li>
<% } %>
            </ul>
        </div>
        <!-- end sidebar -->
    </div>
    <!-- end page -->
    <!-- begin footer -->
    <div id="footer">
        <p class="legal">
            <a href="http://www.thewebhub.com/2008/11/lightspeed/">LightSpeed Free CSS Template</a> by <a href="http://thewebhub.com/">TheWebHub.com</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/ph/">Creative Commons Attribution-Share Alike 3.0 Philippines License</a>.
        </p>
    </div>
    <!-- end footer -->
</div>
<!-- end wrap -->
<div style="text-align: center; font-size: 0.75em;">Design downloaded from <a href="http://www.freewebtemplates.com/">free website templates</a>.</div>

<!-- begin message -->
<c:if test="${message != null}">
    <div id="message" style="position:fixed;top:0;width:100%;text-align:center;background:white;color:black">
    ${message}
    </div>
</c:if>
<!-- end message -->

<%--
<script>
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script>
try {
var pageTracker = _gat._getTracker("UA-968682-13");
pageTracker._trackPageview();
} catch(err) {}
</script>
--%>

</body>
</html>
