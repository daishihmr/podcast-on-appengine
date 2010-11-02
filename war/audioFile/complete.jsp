<!DOCTYPE html>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>audioFile Upload</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/dark-hive/jquery-ui-1.8.custom.css" />    
<%@include file="/importScripts.jsp" %>
</head>
<body>
<script type="text/javascript">
$(function() {
	var url = "${url}";
	alert(url);
	opener.document.forms[0].audioFileURL.value = url;
});
</script>
</body>
</html>
