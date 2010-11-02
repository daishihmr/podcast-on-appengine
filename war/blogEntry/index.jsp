<!DOCTYPE html>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>


<html>
<head>
<title>HMRのやっつけラジオ - blogEntry</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="ja" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GM"/>

<%@include file="/importScripts.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/style.css" />

<script type="text/javascript">
var waiting = false
$(function() {
    $("#buttonOk").button();
    $("#buttonUpload").button().click(function() {
    	open(
            //"http://hmr.sakura.ne.jp/qakgiehsnsgewa.html",
            "/test/uploaderTest",
    		"child",
    		"width=400,height=300,menubar=no,toolbar=no,scrollbars=no"
        );
    });
    $("input[name='recordingDate']").datepicker({
       dateFormat: "yy/mm/dd" 
    });
    $("textarea[name='content']").keyup(function() {
        if (!waiting) {
            var wiki = $(this).val();
            waiting = true;
            postData("/api/wiki", {wiki:wiki}, function(html) {
                $("#preview").html(html);
                waiting = false;
            });
        }
    });
});
</script>

</head>
<body>
<!-- begin wrap -->
<div id="wrap">
    <!-- begin header -->
    <div id="header">
        <h1>new entry</h1>
    </div>
    <!-- end header -->
    <!-- begin page -->
    <div id="page">
        <!-- begin content -->
        <div id="content">
			<ul class="error">
<c:forEach var="e" items="${f:errors()}">
                <li>${f:h(e)}</li>
</c:forEach>			
			</ul>
        <form action="put" method="POST">
            <table style="width:100%">
                <tr>
                    <th>タイトル</th>
                    <td><input type="text" ${f:text("title")} class="ui-corner-all" style="width:400px" /></td>
                </tr>
                <tr>
                    <th>音声ファイルURL</th>
                    <td><input type="text" id="audioFileURL" name="audioFileURL" class="ui-corner-all" style="width:400px" /><input type="button" value="upload" id="buttonUpload" /></td>
                </tr>
                <tr>
                    <th rowspan="2">本文</th>
                    <td>preview:<div id="preview" style="width:500px;height: 300px;overflow:scroll;padding:5px;background:black">
                    </div></td>
                </tr>
                <tr>
                    <td><textarea name="content" class="ui-corner-all" style="width:500px;height:300px"></textarea></td>
                </tr>
                <tr>
                    <th>収録日</th>
                    <td><input type="text" name="recordingDate" class="ui-corner-all" /></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:right">
                        <input type="submit" value="OK" id="buttonOk" />
                    </td>
                </tr>
            </table>
        </form>
        </div>
        <!-- end content -->
        <!-- begin sidebar -->
        <div id="sidebar"></div>
        <!-- end sidebar -->
    </div>
    <!-- end page -->
    <!-- begin footer -->
    <div id="footer">
    </div>
    <!-- end footer -->
</div>
<!-- end wrap -->
</body>
</html>
