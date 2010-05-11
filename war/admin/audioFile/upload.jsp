<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<html>
<head>
<title>admin audioFile Upload</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GM">
<link rel="stylesheet" type="text/css" href="/css/style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/dark-hive/jquery-ui-1.8.custom.css" />
</head>
<body>
<!-- begin wrap -->
<div id="wrap">
    <!-- begin page -->
    <div id="page">
        <!-- begin content -->
        <div id="content">
            <div class="post">
                <h2 class="title">Upload Successed</h2>
                <div class="entry">
                    <p class="byline"><i>hmr-y-radio</i></p>
                    <p>
                        <span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em; margin-top: 3px"></span>
                        <strong>アップロードが完了しました。</strong><br />
                    </p>
                    <p><button id="ok" style="font-size:xx-small">OK</button></p>
                </div>
            </div>
        </div>
        <!-- end content -->
    </div>
    <!-- end page -->
</div>
<!-- end wrap -->
<script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript">
$(function() {
    var f = opener.document.getElementById("entryForm");
    f.audioFileURL.value = "${url}";
    $("#ok").button({
        icons: { primary: "ui-icon-radio-on" }
    }).click(function() {
        close();
    });
});
</script>
</body>
</html>
