<!DOCTYPE html>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<title>HMRのやっつけラジオ - ダッシュボード</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Language" content="ja" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GM"/>


<%@include file="/importScripts.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/style.css" />

<script type="text/javascript"><!--
var waiting = false
$(function() {
    $("#buttonOk").button({
    	icons: {primary: "ui-icon-circlesmall-plus"}
    });
    $("#buttonCancel").button({
    	icons: {primary: "ui-icon-cancel"}
    });
    $("#buttonDelete").button({
        icons: {primary: "ui-icon-circlesmall-minus"}
    });

    $("#buttonUpload").button().click(function() {
    	open(
            "http://tomcat.dev7.jp/mp3uploader/",
    		"child",
    		"width=400,height=300,menubar=no,toolbar=no,scrollbars=no"
        );
    });
    $("input[name='recordingDate']").datepicker({
       dateFormat: "yy/mm/dd" 
    });

    var wikiToHtml = function() {
        if (!waiting) {
            var wiki = $("textarea[name='content']").val();
            waiting = true;
            postData("/api/wiki", {wiki:wiki}, function(html) {
                $("#preview").html(html);
                waiting = false;
            });
        }
    };

    var validateTitle = function() {
        if ($("input[name='title']").val()) {
            $("#alertTitle").text("");
        } else {
            $("#alertTitle").text("必須入力です");
        }
    };

    var validateContent = function() {
        var c = $("textarea[name='content']").val();
        if (c != null && c != "") {
            if (c.length <= 5000) {
                $("#alertContent").text("");
            } else {
                $("#alertContent").text("5000字以内でよろしく");
            }
        } else {
        	$("#alertContent").text("必須入力です");
        }
    };

    $("input[name='title']").keyup(validateTitle);
    $("textarea[name='content']").keyup(function() {
        validateContent();
        wikiToHtml();
    });

    validateTitle();
    wikiToHtml();
    validateContent();
});

function deleteEntry() {
	if (confirm("ホントに削除してもいいですか？")) {
		location.href = "/blogEntry/delete" +
		  "?key=" + $("input[name='key']").val() +
		  "&title=" + $("input[name='title']").val();
	}
}
//-->
</script>
<style type="text/css">
.alert {
    color: red;
    font-weight: bold;
}
</style>

</head>
<body>
<!-- begin wrap -->
<div id="wrap">
    <!-- begin header -->
    <div id="header">
        <h1>dash board</h1>
    </div>
    <!-- end header -->
    <!-- begin page -->
    <div id="page">
        <!-- begin content -->
        <div id="content">
			<ul class="error-ul">
<c:forEach var="e" items="${f:errors()}">
                <li>${f:h(e)}</li>
</c:forEach>			
			</ul>
        <form action="put" method="POST">
            <input type="hidden" ${f:hidden("key")} />
            <input type="hidden" ${f:hidden("createDate")} />
            <table style="width:100%">
                <tr>
                    <th>タイトル</th>
                    <td>
                        <div id="alertTitle" class="alert"></div>
                        <input type="text" ${f:text("title")} class="ui-corner-all" style="width:400px" maxlength="50"/>
                    </td>
                </tr>
                <tr>
                    <th>音声ファイルURL</th>
                    <td><input type="text" id="audioFileURL" ${f:text("audioFileURL")} class="ui-corner-all" style="width:400px" /><input type="button" value="upload" id="buttonUpload" /></td>
                </tr>
                <tr>
                    <th rowspan="2">本文</th>
                    <td>
                        <div id="alertContent" class="alert"></div>
                        <textarea name="content" class="ui-corner-all" style="width:500px;height:200px">${content}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>preview:<div id="preview" style="width:500px;padding:5px;background:black">
                    </div></td>
                </tr>
                <tr>
                    <th>タグ</th>
                    <td><input type="text" ${f:text("tags")} class="ui-corner-all" /></td>
                </tr>
                <tr>
                    <th>収録日</th>
                    <td><input type="text" ${f:text("recordingDate")} class="ui-corner-all" /></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:right">
                        <input type="button" value="削除" id="buttonDelete" onclick="deleteEntry()" />
                        ${f:nbsp("  ")}
                        <input type="button" value="キャンセル" id="buttonCancel" onclick="location.href='/'" />
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
