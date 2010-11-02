<!DOCTYPE html>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/dark-hive/jquery-ui-1.8.custom.css" />    
<%@include file="importScripts.jsp" %>
<script>
$(function() {
	$("#return-top").button({
		icons: { primary: "ui-icon-arrowreturnthick-1-w" }
	});
});
</script>
<title>HMRのやっつけラジオ</title>
</head>
<body>
<!-- begin wrap -->
<div id="wrap">
    <!-- begin page -->
    <div id="page">
        <!-- begin content -->
        <div id="content">
            <div class="post">
                <h2 class="title">Error</h2>
                <div class="entry">
                    <p class="byline"><i>error page</i></p>
                    <p>
<c:forEach var="msg" items="${f:errors()}">
                        <span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em; margin-top: 3px"></span>
                        <strong>${f:h(msg)}</strong><br />
</c:forEach>
                    </p>
                    <p>
                        <a href="/" id="return-top">トップへ戻る</a>
                    </p>
                </div>
            </div>
        </div>
        <!-- end content -->
    </div>
    <!-- end page -->
</div>
<!-- end wrap -->
</body>
</html>
