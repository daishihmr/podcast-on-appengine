<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="net.hmrradio.podcastsite.util.LoginCheckUtil"%>
<%@page import="net.hmrradio.podcastsite.define.Values"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="post">
    <h2 class="title">${entry.title}<%if (LoginCheckUtil.isAdmin()){%> <a href="/blogEntry/?key=${entry.keyString}" class="editEntryButton" style="font-size:small">Edit</a><%}%></h2>
    <div class="entry">
        <p class="byline">
            <i>収録日：<fmt:formatDate value="${entry.recordingDate}" pattern="yyyy/MM/dd" /></i>
            <i>公開日：<fmt:formatDate value="${entry.createDate}" pattern="yyyy/MM/dd" /></i>
            <i>更新日：<fmt:formatDate value="${entry.pubDate}" pattern="yyyy/MM/dd" /></i>
        </p>
<c:if test="${entry.audioFileURL != null && entry.audioFileURL != ''}">
        <p>
            <a href="${entry.audioFileURL}" style="position:relative;z-index:100">MP3 File</a>
        </p>
</c:if>
        ${entry.contentHtml}
<%--
<c:if test="${s.index == 0}">
        <div style="text-align:center">
            <!-- AdSense -->
            <script type="text/javascript">
            google_ad_client = "pub-3487863134090836";
            google_ad_slot = "7912561868";
            google_ad_width = 468;
            google_ad_height = 60;
            </script>
            <script type="text/javascript" src="http://pagead2.googlesyndication.com/pagead/show_ads.js"></script>
            <!-- AdSense -->
        </div>
</c:if>
--%>
    </div>
    <div class="meta">
        <p class="tags">
            <b>Tags:</b>
<c:forEach items="${entry.tags}" var="tag">
            <a href="/tag/${tag}">${tag}</a>&nbsp;
</c:forEach>
        </p>
        <p class="links">
            <a href="https://twitter.com/home?status=%23hmrradio%20" class="comments" style="position:relative;z-index:100">Twitterでつぶやく</a>
            &nbsp;・&nbsp;
            <a class="permalink" href="/p/${entry.keyString}">Permalink</a>
        </p>
    </div>
</div>
