<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/dark-hive/jquery-ui-1.8.custom.css" />    
<script type="text/javascript" src="/js/jquery-and-others.js"></script>
<script type="text/javascript">
$(function() {
	$("#return-top").button({
		icons: { primary: "ui-icon-arrowreturnthick-1-w" }
	}).click(function() {
		location.href = "/";
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
	    <!-- begin header -->
	    <div id="header">
	        <h1>HMRのやっつけラジオ</h1>
	        <h2>佐世保出身の30代男性集団が送る、笑いと情熱のポッドキャスト</h2>
	    </div>
	    <!-- end header -->
        <!-- begin content -->
        <div id="content">
            <div class="post">
                <h2 class="title">Error</h2>
                <div class="entry">
                    <p class="byline"><i>hmr-y-radio</i></p>
                    <p>
<c:forEach var="msg" items="${ERROR_MESSAGES}">
                        <span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em; margin-top: 3px"></span>
                        <strong>${f:h(msg)}</strong><br />
</c:forEach>
                    </p>
                    <p>
                        <button id="return-top">トップへ戻る</button>
                    </p>
                </div>
            </div>
        </div>
        <!-- end content -->
    </div>
    <!-- end page -->
    <!-- begin footer -->
    <div id="footer">
        <!-- All we ask of you is to keep this credits intact. We hope you don't mind :) -->
        <p class="legal"><a href="http://www.thewebhub.com/2008/11/lightspeed/">LightSpeed Free CSS Template</a> by <a href="http://thewebhub.com/">TheWebHub.com</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/ph/">Creative Commons Attribution-Share Alike 3.0 Philippines License</a>.<br />
            <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/ph/"><img alt="Creative Commons License" src="http://i.creativecommons.org/l/by-sa/3.0/ph/88x31.png" /></a></p>
    </div>
    <!-- end footer -->
</div>
<!-- end wrap -->
<div style="text-align: center; font-size: 0.75em;">Design downloaded from <a href="http://www.freewebtemplates.com/">free website templates</a>.</div>
</body>
</html>