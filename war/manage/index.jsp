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
    <!-- begin page -->
    <div id="page">
        <!-- begin content -->
        <div id="content">
        </div>
        <!-- end content -->

</div>
<!-- end wrap -->
<!-- start ダイアログ -->
<div id="dialog"></div>
<!-- end ダイアログ -->

</body>
</html>