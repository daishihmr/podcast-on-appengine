<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@page import="net.hmrradio.podcastsite.define.Values"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="soy" uri="/WEB-INF/soy-render.tld" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/dark-hive/jquery-ui-1.8.custom.css" />
<style type="text/css">
.dialog-form th {
    color: white;
    font-size: 60%;
}

.dialog-form input {
    font-size: 60%;
    font-family: monospace;
    border: 1px;
}

.dialog-form textarea {
    font-size: 60%;
    font-family: monospace;
    border: 1px;
}
</style>
</head>
<body>

<div id="aaa">gogogo</div>
<a href="javascript:go()">go</a>
</body>
<%@include file="/script.jsp" %>
<script type="text/javascript" src="/js/index.js"></script>
<script type="text/javascript">
var Tofu = net.hmrradio.podcastsite.templates;
function go() {
    postData("/blogEntry/list", {}, function(result) {
        $.each(result.list, function(k, v) {
            var post = $(Tofu.showBlogEntry(v));
            $("#aaa").append(post);
            eval(Tofu.afterShowBlogEntry(v));
        });
    });
}

function editPost(key) {
    postData("/blogEntry/get", { key: key }, function(b) {
        eval(Tofu.beforeEditBlogEntry(b));
        var f = Tofu.editBlogEntry(b);
        $("#aaa").append(f);
        eval(Tofu.afterEditBlogEntry(b));
        f.dialog("open");
    });
}

function postBlogEntry(formName) {
    postForm("/blogEntry/put", formName, function(b) {
        var element = $(Tofu.showBlogEntry(b));
        $("#showBlogEntry-" + b.keyString).replaceWith(element);
        eval(Tofu.afterShowBlogEntry(b));
    });
}
</script>
</html>
