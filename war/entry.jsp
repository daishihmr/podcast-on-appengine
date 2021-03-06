<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@page import="net.hmrradio.podcastsite.util.LoginCheckUtil"
%><%@page import="net.hmrradio.podcastsite.define.Values"
%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><div class="post">
    <h2 class="title">
        <%if (LoginCheckUtil.isAdmin()){%><a href="/blogEntry/?key=${entry.keyString}" title="編集"><%}%>
	    ${entry.title}
        <%if (LoginCheckUtil.isAdmin()){%></a><%}%>
    </h2>
    <div class="entry">
        <p class="byline">
<fmt:timeZone value="Asia/Tokyo">
            <i>収録日：<fmt:formatDate value="${entry.recordingDate}" pattern="yyyy/MM/dd" /></i>
            <i>公開日：<fmt:formatDate value="${entry.createDate}" pattern="yyyy/MM/dd HH:mm:ss" /></i>
            <i>更新日：<fmt:formatDate value="${entry.pubDate}" pattern="yyyy/MM/dd HH:mm:ss" /></i>
</fmt:timeZone>
        </p>
<c:if test="${entry.audioFileURL != null && entry.audioFileURL != ''}">
        <p>
            <a href="${entry.audioFileURL}" style="position:relative">MP3 File</a>
        </p>
</c:if>
        <!-- begin Content -->
        ${entry.contentHtml}
        <!-- end Content -->
        <!-- begin ads -->
<c:if test="${s.index == 0 && showAds}">
        <div style="text-align:center">
        <script type="text/javascript"><!--
        google_ad_client = "pub-3487863134090836";
        /* 468x60, 作成済み 10/05/24 */
        google_ad_slot = "7912561868";
        google_ad_width = 468;
        google_ad_height = 60;
        //-->
        </script>
        <script type="text/javascript" src="http://pagead2.googlesyndication.com/pagead/show_ads.js"></script>
        </div>
</c:if>
        <!-- end ads -->
    </div>
    <div class="meta">
        <p class="tags">
            <b>Tags:</b>&nbsp;<c:forEach items="${entry.tags}" var="tag"><a href="/tag/${tag}">${tag}</a>&nbsp;</c:forEach>
        </p>
        <p class="links">
            <a href="http://twitter.com/share" class="twitter-share-button" data-count="none" data-via="yattsuketan" data-lang="ja">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
            &nbsp;・&nbsp;
            <a href="http://mixi.jp/share.pl" class="mixi-check-button"
                data-key="bd2465c84747c17a088d91f01127a90aa8b3d056"
                style="padding-left:0">Check</a>
            <script type="text/javascript" src="http://static.mixi.jp/js/share.js"></script>
            &nbsp;・&nbsp;
            <a class="permalink" href="/p/${entry.keyString}">Permalink</a>
        </p>
    </div>
</div>
<script type="text/javascript">
<!--
createDateLt = "${entry.createDate.time}";
//-->
</script>
