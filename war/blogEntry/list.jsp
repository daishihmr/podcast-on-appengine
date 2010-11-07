<!DOCTYPE html>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<html>
<head>
<title>HMRのやっつけラジオ - 記事一覧</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="ja" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GM"/>
<%@include file="/importScripts.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
<!-- begin wrap -->
<div id="wrap">
    <!-- begin header -->
    <div id="header">
        <h1>記事一覧</h1>
    </div>
    <!-- end header -->
    <!-- begin page -->
    <div id="page">
        <!-- begin content -->
        <div id="content">
            <table border="1">
                <tr>
                    <th>No</th>
                    <th>Title</th>
                </tr>
                <c:forEach var="entry" items="${list}" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>
                        <a href="/p/${entry.keyString}">${f:h(entry.title)}</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <!-- end content -->
        <!-- begin sidebar -->
        <div id="sidebar"></div>
        <!-- end sidebar -->
    </div>
    <!-- end page -->
    <!-- begin footer -->
    <div id="footer">
    </div>
    <!-- end footer -->
</div>
<!-- end wrap -->
</body>
</html>
