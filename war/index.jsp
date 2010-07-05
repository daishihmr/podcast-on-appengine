<!DOCTYPE html>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="net.hmrradio.podcastsite.define.Values"%>
<%@page import="net.hmrradio.podcastsite.util.LoginCheckUtil"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="soy" uri="/WEB-INF/soy-render.tld" %>

<html>
<head>
<title>HMRのやっつけラジオ</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="ja" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GM"/>
<meta name="keywords" content="ネットラジオ,佐世保,Podcast,九州ネットラジオ組合,関東ネットラジオリンク,電脳,オタク,映画,風俗,音楽,コンビニ,ゲーム" />
<meta name="discription" content="佐世保出身の30代男性集団が送る、笑いと情熱のポッドキャスト。車、電脳、オタク、映画、風俗、音楽、ゲームなどをネタに、幅広い話題を提供。やっつけ仕事でなるべく週１回ぐらいで更新していくネットラジオです。" />
<meta name="robots" content="index,nofollow,archive" />
<link rel="stylesheet" type="text/css" href="/css/style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/dark-hive/jquery-ui-1.8.custom.css" />
<link rel="canonical" href="http://www.hmr-radio.net/" />
<link rel="alternate" type="application/rss+xml" title="RSS 2.0" href="http://www.hmr-radio.net/rss" />

<%@include file="/script.jsp" %>
<script type="text/javascript" src="/js/index.js"></script>
<% if (LoginCheckUtil.isAdmin()) { %>
<script type="text/javascript" src="/js/admin.js"></script>
<% } %>

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
            <li><a id="menu-top" href="/">トップ</a></li>
            <li><a id="menu-bbs">掲示板</a></li>
            <li><a id="menu-member">メンバー</a></li>
            <li><a id="menu-corner">コーナー</a></li>
            <li><a id="menu-tag">タグ</a></li>
            <li><a id="menu-mail">メール</a></li>
            <li><a id="menu-about">HMRのやっつけラジオについて</a></li>
        </ul>
    </div>
    <!-- end header -->
    <!-- begin page -->
    <div id="page">
        <!-- begin content -->
        <div id="content">

            <div id="posts">
                <!-- begin 新規作成-->
                <div id="create-entry-area" class="post admin-only">
                    <h2 class="title">Create New Entry&nbsp;<button id="create-entry" class="admin-only" style="font-size:xx-small"></button></h2>
                </div>
                <!-- end 新規作成 -->

                <!-- begin 記事 -->
<c:forEach items="${ blogEntries }" var="blogEntry">
    <soy:soyrender namespace="<%= Values.SOY_NS %>" template="showBlogEntry" value="${ blogEntry }"/>
</c:forEach>
                <!-- end 記事 -->
            </div>

            <!-- begin 「さらに過去」ボタン -->
            <div style="text-align:left">
                <a id="next-link" onclick="clickNextLink()">さらに過去</a>
            </div>
            <!-- end 「さらに過去」ボタン -->
        </div>
        <!-- end content -->
        <!-- begin sidebar -->
        <div id="sidebar">
            <ul>
                <li>
                    <h2>Information</h2>
                    <div style="padding: 20px">
                       <div>現在、<span id="information">すべてのエピソードを表示しています</span></div>
                       <div id="information-detail"></div>
                       <div><a id="show-all-link" style="display:none" href="/">すべてのエピソードを表示する</a></div>
                    </div>
                </li>
                <li>
                    <h2>Podcast Feed</h2>
                    <div style="padding: 20px">
                        <div style="text-align:center">
                            <a href="http://www.hmr-radio.net/rss"><img src="/images/podcast-rss.gif" /></a>
                        </div>
                        このバナーを<strong><a href="http://www.apple.com/jp/itunes/download/">iTunes(無料)</a></strong>上へドラッグ＆ドロップすることで番組を登録することができます。<br />
                        登録するとiTunesが自動的にやっつけラジオの最新放送をチェックします。<br />
                    </div>
                </li>
                <li>
                    <h2>Mail</h2>
                    <div style="padding: 20px">
                        <iframe frameborder="0" allowtransparency="true" src="/parts/mailform.html" width="280px" height="330px"></iframe>
                    </div>
                </li>
                <li>
                    <h2>Link&nbsp;<button id="add-link" class="add admin-only" style="font-size:xx-small"></button></h2>
                    <div style="padding: 20px">
                        <ul id="linkUl">
                            <soy:soyrender namespace="<%=Values.SOY_NS %>" template="showLinks" value="${ links }"/>
                        </ul>
                    </div>
                </li>
                <li>
                    <h2>Twitter</h2>
                    <div style="padding: 20px">
<%--
                        <script type="text/javascript" src="http://widgets.twimg.com/j/2/widget.js"></script>
                        <script type="text/javascript">
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
--%>
                    </div>
                </li>
                <li>
                    <h2>for HMR only</h2>
                    <div style="padding: 20px">
                        <ul>
                            <li><a id="login" href="/admin/">ログイン</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
        <!-- end sidebar -->
    </div>
    <!-- end page -->
    <!-- begin footer -->
    <div id="footer">
        <!-- All we ask of you is to keep this credits intact. We hope you don't mind :) -->
        <p class="legal">
            <a href="http://www.thewebhub.com/2008/11/lightspeed/">LightSpeed Free CSS Template</a> by <a href="http://thewebhub.com/">TheWebHub.com</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/ph/">Creative Commons Attribution-Share Alike 3.0 Philippines License</a>.<br />
            <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/ph/"><img alt="Creative Commons License" src="http://i.creativecommons.org/l/by-sa/3.0/ph/88x31.png" /></a>
        </p>
    </div>
    <!-- end footer -->
</div>
<!-- end wrap -->
<div style="text-align: center; font-size: 0.75em;">Design downloaded from <a href="http://www.freewebtemplates.com/">free website templates</a>.</div>

<!-- start ダイアログ -->
<div id="dialog"></div>
<!-- end ダイアログ -->

<%--
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-968682-13");
pageTracker._trackPageview();
} catch(err) {}</script>
--%>

</body>
</html>
