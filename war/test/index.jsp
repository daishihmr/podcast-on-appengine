<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="net.hmrradio.podcastsite.define.Values"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="soy" uri="/WEB-INF/soy-render.tld" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="/js/jquery-and-others.js"></script>
<script type="text/javascript" src="/js/soyutils.js"></script>
<script type="text/javascript" src="/js/template.js"></script>
<script type="text/javascript">
function go() {
    var s = net.hmrradio.podcastsite.templates.test({target: "aaa"});
    eval(s);
}
</script>
<title>test Index</title>
</head>
<body>

<div id="aaa">gogogo</div>
<a href="javascript:go()">go</a>

</body>
</html>
