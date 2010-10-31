<!DOCTYPE html>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>


<html>
<head>
<title>HMRのやっつけラジオ</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="ja" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GM"/>

<%@include file="/importScripts.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/style.css" />

<script type="text/javascript">
$(function() {
    $("#buttonOk").button();
    $("input[name='recordingDate']").datepicker({
       dateFormat: "yy/mm/dd" 
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
        <form action="put" method="POST">
            <table style="width:100%">
                <tr>
                    <th>タイトル</th>
                    <td><input type="text" name="title" class="ui-corner-all" style="width:400px" /></td>
                </tr>
                <tr>
                    <th>本文</th>
                    <td><textarea name="content" class="ui-corner-all" style="width:500px;height:400px"></textarea></td>
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
