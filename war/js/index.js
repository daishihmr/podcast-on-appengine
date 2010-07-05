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

/**
 * メンバー名クリック時
 */
function clickMember() {
	alert(this.href.split("/").pop());
	return false;
}

/**
 * コーナー名クリック時
 */
function clickCorner() {
	alert(this.href);
	return false;
}

/**
 * タグクリック時
 */
function clickTags() {
	alert(this.href);
	return false;
}

/**
 * 「さらに過去」クリック時
 */
function clickNextLink() {
}
