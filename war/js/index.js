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
	$.getJSON("/blogEntry", {}, function(data) {
		var html = Tofu.showBlogEntries(data.body);
		$("#posts").append($(html));
	});
}