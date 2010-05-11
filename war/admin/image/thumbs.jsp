<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<title>画像リスト</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
<p style="margin:20px;color:red">
${ f:h(ERROR_MESSAGES) }
</p>
<p style="margin:20px">
<form action="/admin/image/uploadThumbs" method="POST" enctype="multipart/form-data">
	<input type="file" name="formFile" />
	<input type="hidden" name="setTarget" value="${setTarget}" />
    <input type="hidden" name="setTargetImg" value="${setTargetImg}" />
	<input type="submit" id="upload" value="upload" />
</form>
</p>
<p style="margin:20px">
<c:forEach var="i" items="${list}" varStatus="s">
    <img src="/image/show/${i}" style="border:solid 2px black;fload:left;height:100px" />
</c:forEach>
</p>
<script type="text/javascript" src="/js/jquery-and-others.js"></script>
<script type="text/javascript">
$(function() {
    $("upload").button();
    
    $("img").mouseover(function() {
        $(this).css("border", "solid 2px orange");
    }).mouseout(function() {
        $(this).css("border", "solid 2px black");
    }).click(function() {
        var key = $(this).attr("src").substring("/image/show/".length);
        var setTarget = "${setTarget}";
        var setTargetImg = "${setTargetImg}";
        if (setTarget) {
            opener.document.getElementById(setTarget).value = key;
        }
        if (setTargetImg) {
            opener.document.getElementById(setTargetImg).src = "/image/show/" + key;
        }
        close();
    });
});
</script>
</body>
</html>
