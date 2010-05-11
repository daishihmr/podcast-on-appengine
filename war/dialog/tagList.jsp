<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>TagList</title>
</head>
<body>

<div id="tagList">
	<div style="margin:20px">
		<c:forEach var="i" items="${ map }" varStatus="s">
		<span style="font-size:${ i.value }pt">
		    <a href="javascript:void(0)">${ f:h(i.key) }</a>&nbsp;
		</span>
		</c:forEach>
	</div>
</div>

</body>
</html>
