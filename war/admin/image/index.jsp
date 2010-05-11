<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>画像アップロード</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="free css templates, xhtml, css, templates" />
<meta name="description"
	content="A two-column, dark-themed design suitable for personal websites and blogs use. Designed by Enjay for The Web Hub." />
<meta name="robots" content="all" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GM">
<link rel="stylesheet" type="text/css" href="/css/style.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="/css/dark-hive/jquery-ui-1.8.custom.css" />
<script type="text/javascript" src="/js/jquery-and-others.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<style type="text/css">
body{ font: 62.5% "Trebuchet MS", sans-serif; margin: 50px;}
</style>
<script type="text/javascript">
$(function(){
	$("#upload").button();
	$("#cancel").button().click(function() {
		close();
	});
	
	$("#ok").button({
		label: "OK",
		icons: { primary: "ui-icon-heart" }
	}).click(function() {
		close();
		if (opener) {
			opener.receiveImageKey("${f:h(imageKey)}");
		}
	});
	
	$("#ng").button({
		label: "NG",
		icons: { primary: "ui-icon-close" }
	}).click(function() {
		$.post("/admin/image/destroy", { imageKey:"${f:h(imageKey)}"}, function(result) {
			if (result.success) {
				delete $("#confirm").remove();
			}
		}, "json");
	});
});
</script>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td><input type="file" name="formFile" /></td>
	</tr>
	<tr>
		<td><input type="submit" id="upload" value="upload" /><input type="submit" id="cancel" value="cancel" /></td>
	</tr>
</table>
</form>
<c:if test="${imageKey != null}">
<div id="confirm">
	<p>
		<img src="/image/show/${f:h(imageKey)}" />
	</p>
	この画像でいいですか？<br />
	<button id="ok"></button><button id="ng"></button>
</div>
</c:if>
</body>
</html>
