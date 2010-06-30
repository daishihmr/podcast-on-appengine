// This file was automatically generated from template.soy.
// Please don't edit this file by hand.

if (typeof net == 'undefined') { var net = {}; }
if (typeof net.hmrradio == 'undefined') { net.hmrradio = {}; }
if (typeof net.hmrradio.podcastsite == 'undefined') { net.hmrradio.podcastsite = {}; }
if (typeof net.hmrradio.podcastsite.templates == 'undefined') { net.hmrradio.podcastsite.templates = {}; }


net.hmrradio.podcastsite.templates.showBlogEntry = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div id="showBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '" class="post"><h2 class="title"><strong>', soy.$$escapeHtml(opt_data.title), '</strong>&nbsp;&nbsp;<button class="edit" style="display:none" onclick="editPost(\'', soy.$$escapeHtml(opt_data.keyString), '\')"></button></h2><div class="entry"><p class="byline"><i>公開日：', soy.$$escapeHtml(opt_data.createDate), '</i>&nbsp;<i>更新日：', soy.$$escapeHtml(opt_data.pubDate), '</i></p><p><object type="application/x-shockwave-flash" data="/player_mp3_maxi.swf" width="20" height="20"><param name="movie" value="/player_mp3_maxi.swf"><param name="bgcolor" value="#000000"><param name="FlashVars" value="mp3=', soy.$$escapeHtml(opt_data.audioFileURL), '&amp;width=20&amp;showstop=0&amp;showslider=0&amp;buttonwidth=20"></object><a href="', soy.$$escapeHtml(opt_data.audioFileURL), '" style="position: relative; z-index: 100;">', soy.$$escapeHtml(opt_data.audioFileName), '</a></p><p>収録日：', soy.$$escapeHtml(opt_data.recordingDate), '</p>', opt_data.contentHtml, '</div><div class="meta"><p class="tags"><b>Tags:</b>&nbsp;');
  var tagList25 = opt_data.tags;
  var tagListLen25 = tagList25.length;
  for (var tagIndex25 = 0; tagIndex25 < tagListLen25; tagIndex25++) {
    var tagData25 = tagList25[tagIndex25];
    output.append((! (tagIndex25 == 0)) ? ',&nbsp;' : '', '<a href="/tags/', soy.$$escapeHtml(tagData25), '" style="position: relative; z-index: 100;">', soy.$$escapeHtml(tagData25), '</a>');
  }
  output.append('</p><p class="links"><a href="https://twitter.com/home?status=%23hmrradio%20" class="comments" style="position: relative; z-index: 100;">Twitterでつぶやく</a>&nbsp;&nbsp;&bull;&nbsp;&nbsp;<a class="permalink" href="http://www.hmr-radio.net/?p=', soy.$$escapeHtml(opt_data.keyString), '" style="position: relative; z-index: 100;">Permalink</a></p></div></div>');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.afterShowBlogEntry = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('$("#showBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '").find("a").each(function() {$(this).css({position: "relative", zIndex: 100}); var text = $(this).text(); $(this).text(text.split("/corner/").join("").split("/member/").join(""));}); $("#showBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '").find("a[href*=\'/member/\']").click(clickMember); $("#showBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '").find("a[href*=\'/corner/\']").click(clickCorner); $("#showBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '").find("a[href*=\'/tags/\']").click(clickTags); checkLoginAdmin(function() {$("#showBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '").find(".edit").button({icons: { primary: "ui-icon-pencil" }, text: false}).show();});');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.beforeEditBlogEntry = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('$("#editBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '").remove();');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.editBlogEntry = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div id="editBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '"><form name="editBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '" class="dialog-form"><input type="hidden" name="key" value="', soy.$$escapeHtml(opt_data.keyString), '" /><table><tr><th>タイトル</th><td><input type="text" name="title" value="', soy.$$escapeHtml(opt_data.title), '" size="30" /></td></tr><tr><th>収録日</th><td><input type="text" name="recordingDate" value="', soy.$$escapeHtml(opt_data.recordingDate), '" size="12" /></td></tr><tr><th>音声ファイルURL</th><td><input type="text" name="audioFileURL" value="', soy.$$escapeHtml(opt_data.audioFileURL), '" size="30" /></td></tr><tr><th>内容</th><td><textarea name="content" cols="50" rows="20">', soy.$$escapeHtml(opt_data.contentWiki), '</textarea></td></tr><tr><th>タグ</th><td><input type="text" name="tags" value="');
  var tagList70 = opt_data.tags;
  var tagListLen70 = tagList70.length;
  for (var tagIndex70 = 0; tagIndex70 < tagListLen70; tagIndex70++) {
    var tagData70 = tagList70[tagIndex70];
    output.append((! (tagIndex70 == 0)) ? ', ' : '', soy.$$escapeHtml(tagData70));
  }
  output.append('" size="50" /></td></tr></table></form></div>');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.afterEditBlogEntry = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('$("#editBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '").dialog({title: "記事編集", width: 700, buttons: {"Cancel": function() { $(this).dialog("close") }, "Ok": function() { postBlogEntry("editBlogEntry-', soy.$$escapeHtml(opt_data.keyString), '") }}});');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.showBlogEntries = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var blogEntryList84 = opt_data.list;
  var blogEntryListLen84 = blogEntryList84.length;
  for (var blogEntryIndex84 = 0; blogEntryIndex84 < blogEntryListLen84; blogEntryIndex84++) {
    var blogEntryData84 = blogEntryList84[blogEntryIndex84];
    net.hmrradio.podcastsite.templates.showBlogEntry(blogEntryData84, output);
  }
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.afterShowBlogEntries = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('$(".post").find("a").each(function() {$(this).css({position: "relative", zIndex: 100}); var text = $(this).text(); $(this).text(text.split("/corner/").join("").split("/member/").join(""));}); $(".post").find("a[href*=\'/member/\']").click(clickMember); $(".post").find("a[href*=\'/corner/\']").click(clickCorner); $(".post").find("a[href*=\'/tags/\']").click(clickTags); checkLoginAdmin(function() {$(".post").find(".edit").button({icons: { primary: "ui-icon-pencil" }, text: false}).show();});');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.showLink = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<li id="showLink-', soy.$$escapeHtml(opt_data.keyString), '" class="link-item"><a href="', soy.$$escapeHtml(opt_data.url), '" title="', soy.$$escapeHtml(opt_data.textString), '">', soy.$$escapeHtml(opt_data.title), '</a>&nbsp;&nbsp;<button class="edit" style="display:none" onclick="editLink(\'', soy.$$escapeHtml(opt_data.keyString), '\')"></button></li>');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.afterShowLink = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('checkLoginAdmin(function() {$("#showLink-', soy.$$escapeHtml(opt_data.keyString), '").find(".edit").button({icons: { primary: "ui-icon-pencil" }, text: false}).show();});');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.showLinks = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var linkList106 = opt_data.list;
  var linkListLen106 = linkList106.length;
  for (var linkIndex106 = 0; linkIndex106 < linkListLen106; linkIndex106++) {
    var linkData106 = linkList106[linkIndex106];
    net.hmrradio.podcastsite.templates.showLink(linkData106, output);
  }
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.afterShowLinks = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('checkLoginAdmin(function() {$(".link-item").find(".edit").button({icons: { primary: "ui-icon-pencil" }, text: false}).show();});');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.test = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('$("#', soy.$$escapeHtml(opt_data.target), '").text("hello world");');
  if (!opt_sb) return output.toString();
};
