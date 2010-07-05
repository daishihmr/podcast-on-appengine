/**
 * 記事編集ボタンクリック
 * 
 * @param key
 *            記事のキー
 * @return
 */
function editPost(key) {
	postData("/blogEntry/get", {
		key : key
	}, function(data) {
		var form = $(Tofu.editBlogEntry(data));
		$("#dialog").html(form);
		eval(Tofu.afterEditBlogEntry(data));
	});
}

/**
 * 編集完了ボタンクリック
 * 
 * @return
 */
function postBlogEntry() {
	postForm("/blogEntry/put", "editBlogEntry", function(data) {
		$("#editBlogEntry").dialog("close").remove();
		$("#showBlogEntry-" + data.keyString).replaceWith(
				Tofu.showBlogEntry(data));
		eval(Tofu.afterShowBlogEntry(data));
	});
}
