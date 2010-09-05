if (typeof net == 'undefined') { var net = {}; }
if (typeof net.hmrradio == 'undefined') { net.hmrradio = {}; }
if (typeof net.hmrradio.podcastsite == 'undefined') { net.hmrradio.podcastsite = {}; }

/** 表示中の一番古い記事の公開日 */
net.hmrradio.podcastsite.createDateOldest = new Date(2100, 1, 1).getTime();
/** 表示中のクエリ */
net.hmrradio.podcastsite.currentQuery = {};

$(function() {

    $("#header li a").button();
    $("#header ul").buttonset();

    // リンクパス付加
    $("#menu-bbs").tinyTips('dark', "未実装");
    $("#menu-member");
    $("#menu-corner");
    $("#menu-tag");
    $("#menu-mail").attr("href", "mailto:hmrradio@gmail.com");
    $("#menu-about").tinyTips('dark', "未実装");
    
    $("#next-link").button();
});

function getHrefBottom(element) {
	return element.attr("href").split("/").pop();
}

/**
 * メンバー名クリック時
 */
function clickMember() {
	var member = getHrefBottom($(this));
	alert(member);
	return false;
}

/**
 * コーナー名クリック時
 */
function clickCorner() {
	var corner = getHrefBottom($(this));
	alert(corner);
	return false;
}

/**
 * タグクリック時
 */
function clickTags() {
	var tag = getHrefBottom($(this));
	alert(tag);
	return false;
}

/**
 * 「さらに過去」クリック時
 */
function clickNextLink() {
}
