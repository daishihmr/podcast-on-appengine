// This file was automatically generated from template.soy.
// Please don't edit this file by hand.

if (typeof podcastsite == 'undefined') { var podcastsite = {}; }


podcastsite.showBlogEntry = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div id="', soy.$$escapeHtml(opt_data.keyString), '" class="post"><h2 class="title"><strong>', soy.$$escapeHtml(opt_data.title), '</strong>&nbsp;&nbsp;<button class="edit-entry" style="display:none" onclick="editPost(\'', soy.$$escapeHtml(opt_data.keyString), '\')"></button></h2><div class="entry"><p class="byline"><i>公開日：', soy.$$escapeHtml(opt_data.createDate), '</i>&nbsp;<i>更新日：', soy.$$escapeHtml(opt_data.pubDate), '</i></p><p><object type="application/x-shockwave-flash" data="/player_mp3_maxi.swf" width="20" height="20"><param name="movie" value="/player_mp3_maxi.swf"><param name="bgcolor" value="#000000"><param name="FlashVars" value="mp3=', soy.$$escapeHtml(opt_data.audioFileURL), '&amp;width=20&amp;showstop=0&amp;showslider=0&amp;buttonwidth=20"></object><a href="', soy.$$escapeHtml(opt_data.audioFileURL), '" style="position: relative; z-index: 100;">', soy.$$escapeHtml(opt_data.audioFileName), '</a></p><p>収録日：', soy.$$escapeHtml(opt_data.recordingDate), '</p>', opt_data.contentHtml, '</div><div class="meta"><p class="tags"><b>Tags:</b>&nbsp;');
  var tagList25 = opt_data.tags;
  var tagListLen25 = tagList25.length;
  for (var tagIndex25 = 0; tagIndex25 < tagListLen25; tagIndex25++) {
    var tagData25 = tagList25[tagIndex25];
    output.append((! (tagIndex25 == 0)) ? ',&nbsp;' : '', '<a href="/tags/', soy.$$escapeHtml(tagData25), '" style="position: relative; z-index: 100;">', soy.$$escapeHtml(tagData25), '</a>');
  }
  output.append('</p><p class="links"><a href="https://twitter.com/home?status=%23hmrradio%20" class="comments" style="position: relative; z-index: 100;">Twitterでつぶやく</a>&nbsp;&nbsp;&bull;&nbsp;&nbsp;<a class="permalink" href="http://www.hmr-radio.net/?p=', soy.$$escapeHtml(opt_data.keyString), '" style="position: relative; z-index: 100;">Permalink</a></p></div></div><script type="text/javascript">\n$("#', soy.$$escapeHtml(opt_data.keyString), '").find("a").each(function() {$(this).css({position: "relative", zIndex: 100}); var text = $(this).text(); $(this).text(text.split("/corner/").join("").split("/member/").join(""));}); checkLoginAdmin(function() {$("#', soy.$$escapeHtml(opt_data.keyString), '").find(".edit-entry").button({icons: { primary: "ui-icon-pencil" }, text: false}).show();});</script>\n\n');
  if (!opt_sb) return output.toString();
};


podcastsite.showBlogEntries = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var blogEntryList43 = opt_data.blogEntries;
  var blogEntryListLen43 = blogEntryList43.length;
  for (var blogEntryIndex43 = 0; blogEntryIndex43 < blogEntryListLen43; blogEntryIndex43++) {
    var blogEntryData43 = blogEntryList43[blogEntryIndex43];
    podcastsite.showBlogEntry(blogEntryData43, output);
  }
  if (!opt_sb) return output.toString();
};


podcastsite.showLink = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<li><a href="', soy.$$escapeHtml(opt_data.url), '" title="', soy.$$escapeHtml(opt_data.textString), '">', soy.$$escapeHtml(opt_data.title), '</a></li>');
  if (!opt_sb) return output.toString();
};


podcastsite.showLinks = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var linkList55 = opt_data.links;
  var linkListLen55 = linkList55.length;
  for (var linkIndex55 = 0; linkIndex55 < linkListLen55; linkIndex55++) {
    var linkData55 = linkList55[linkIndex55];
    podcastsite.showLink(linkData55, output);
  }
  if (!opt_sb) return output.toString();
};
