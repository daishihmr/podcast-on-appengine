// This file was automatically generated from template.soy.
// Please don't edit this file by hand.

if (typeof net == 'undefined') { var net = {}; }
if (typeof net.hmrradio == 'undefined') { net.hmrradio = {}; }
if (typeof net.hmrradio.podcastsite == 'undefined') { net.hmrradio.podcastsite = {}; }
if (typeof net.hmrradio.podcastsite.templates == 'undefined') { net.hmrradio.podcastsite.templates = {}; }


net.hmrradio.podcastsite.templates.showBlogEntry = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div id="', soy.$$escapeHtml(opt_data.keyString), '" class="post"><h2 class="title"><strong>', soy.$$escapeHtml(opt_data.title), '</strong>&nbsp;&nbsp;<button class="edit" style="display:none" onclick="editPost(\'', soy.$$escapeHtml(opt_data.keyString), '\')"></button></h2><div class="entry"><p class="byline"><i>公開日：', soy.$$escapeHtml(opt_data.createDate), '</i>&nbsp;<i>更新日：', soy.$$escapeHtml(opt_data.pubDate), '</i></p><p><object type="application/x-shockwave-flash" data="/player_mp3_maxi.swf" width="20" height="20"><param name="movie" value="/player_mp3_maxi.swf"><param name="bgcolor" value="#000000"><param name="FlashVars" value="mp3=', soy.$$escapeHtml(opt_data.audioFileURL), '&amp;width=20&amp;showstop=0&amp;showslider=0&amp;buttonwidth=20"></object><a href="', soy.$$escapeHtml(opt_data.audioFileURL), '" style="position: relative; z-index: 100;">', soy.$$escapeHtml(opt_data.audioFileName), '</a></p><p>収録日：', soy.$$escapeHtml(opt_data.recordingDate), '</p>', opt_data.contentHtml, '</div><div class="meta"><p class="tags"><b>Tags:</b>&nbsp;');
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
  output.append('$("#', soy.$$escapeHtml(opt_data.keyString), '").find("a").each(function() {$(this).css({position: "relative", zIndex: 100}); var text = $(this).text(); $(this).text(text.split("/corner/").join("").split("/member/").join(""));}); $("#', soy.$$escapeHtml(opt_data.keyString), '").find("a[href*=\'/member/\']").click(clickMember); $("#', soy.$$escapeHtml(opt_data.keyString), '").find("a[href*=\'/corner/\']").click(clickCorner); $("#', soy.$$escapeHtml(opt_data.keyString), '").find("a[href*=\'/tags/\']").click(clickTags); checkLoginAdmin(function() {$("#', soy.$$escapeHtml(opt_data.keyString), '").find(".edit").button({icons: { primary: "ui-icon-pencil" }, text: false}).show();});');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.showBlogEntries = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var blogEntryList51 = opt_data.list;
  var blogEntryListLen51 = blogEntryList51.length;
  for (var blogEntryIndex51 = 0; blogEntryIndex51 < blogEntryListLen51; blogEntryIndex51++) {
    var blogEntryData51 = blogEntryList51[blogEntryIndex51];
    net.hmrradio.podcastsite.templates.showBlogEntry(blogEntryData51, output);
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
  output.append('<li id="', soy.$$escapeHtml(opt_data.keyString), '" class="link-item"><a href="', soy.$$escapeHtml(opt_data.url), '" title="', soy.$$escapeHtml(opt_data.textString), '">', soy.$$escapeHtml(opt_data.title), '</a>&nbsp;&nbsp;<button class="edit" style="display:none" onclick="editLink(\'', soy.$$escapeHtml(opt_data.keyString), '\')"></button></li>');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.afterShowLink = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('checkLoginAdmin(function() {$("#', soy.$$escapeHtml(opt_data.keyString), '").find(".edit").button({icons: { primary: "ui-icon-pencil" }, text: false}).show();});');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.showLinks = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var linkList73 = opt_data.list;
  var linkListLen73 = linkList73.length;
  for (var linkIndex73 = 0; linkIndex73 < linkListLen73; linkIndex73++) {
    var linkData73 = linkList73[linkIndex73];
    net.hmrradio.podcastsite.templates.showLink(linkData73, output);
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
