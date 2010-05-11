<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GM">
<title>CornerList</title>
</head>
<body>

<div id="cornerList">
<table width="100%">
<COLGROUP width="30%"/>
<c:forEach var="i" items="${ list }" varStatus="s">
    <tr style="background-color:${ s.index % 2 == 0 ? '#222' : '#111' }">
        <th><a href="javascript:void(0)">${ f:h(i.title) }</a></th>
        <td style="padding:10px">${ i.descriptionHtml }</td>
    </tr>
</c:forEach>
</table>
</div>

</body>
</html>
