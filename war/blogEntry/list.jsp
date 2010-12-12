<?xml version="1.0" encodint="UTF-8"?><%@page pageEncoding="UTF-8" isELIgnored="false" session="false"
%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@taglib prefix="f" uri="http://www.slim3.org/functions"
%><%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
    xmlns:image="http://www.sitemaps.org/schemas/sitemap-image/1.1"
    xmlns:video="http://www.sitemaps.org/schemas/sitemap-video/1.1"><c:forEach var="entry" items="${list}" varStatus="s">
    <url>
        <loc>http://www.hmr-radio.net/p/${entry.keyString}</loc>
        <lastmod><fmt:formatDate value="${entry.pubDate}" pattern="yyyy-MM-dd" /></lastmod>
        <changefreq>monthly</changefreq>
    </url></c:forEach>
</urlset>
