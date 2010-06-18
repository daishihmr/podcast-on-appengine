// This file was automatically generated from template.soy.
// Please don't edit this file by hand.

if (typeof net == 'undefined') { var net = {}; }
if (typeof net.hmrradio == 'undefined') { net.hmrradio = {}; }
if (typeof net.hmrradio.podcastsite == 'undefined') { net.hmrradio.podcastsite = {}; }
if (typeof net.hmrradio.podcastsite.templates == 'undefined') { net.hmrradio.podcastsite.templates = {}; }


net.hmrradio.podcastsite.templates.showPost = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="post"><h2 class="title"><strong>', soy.$$escapeHtml(opt_data.title), '</strong><button class="edit-entry small-button admin-only" style="font-size:xx-small"></button></h2><div class="entry"><p class="byline"><i>公開日：', soy.$$escapeHtml(opt_data.createDate), '</i>&nbsp;&nbsp;&nbsp;&nbsp;<i>更新日：', soy.$$escapeHtml(opt_data.pubDate), '</i></p><p><object type="application/x-shockwave-flash" data="./player_mp3_maxi.swf" width="20" height="20"><param name="movie" value="/player_mp3_maxi.swf"><param name="bgcolor" value="#000000"><param name="FlashVars" value="mp3=', soy.$$escapeHtml(opt_data.audioFileURL), '&amp;width=20&amp;showstop=0&amp;showslider=0&amp;buttonwidth=20"></object><a href="', soy.$$escapeHtml(opt_data.audioFileURL), '" style="position: relative; z-index: 100;">', soy.$$escapeHtml(opt_data.audioFileName), '</a></p><p>収録日：', soy.$$escapeHtml(opt_data.recordingDate), '</p>', opt_data.contentHtml, '</div><div class="meta"><p class="tags"><b>Tags:</b>&nbsp;');
  var tagList21 = opt_data.tags;
  var tagListLen21 = tagList21.length;
  for (var tagIndex21 = 0; tagIndex21 < tagListLen21; tagIndex21++) {
    var tagData21 = tagList21[tagIndex21];
    output.append((! (tagIndex21 == 0)) ? ',&nbsp;' : '', '<a href="/tags/', soy.$$escapeHtml(tagData21), '" style="position: relative; z-index: 100;">', soy.$$escapeHtml(tagData21), '</a>');
  }
  output.append('</p><p class="links"><a href="https://twitter.com/home?status=%23hmrradio%20" class="comments" style="position: relative; z-index: 100;">Comment on Twitter</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="permalink" href="http://www.hmr-radio.net/?p=', soy.$$escapeHtml(opt_data.keyString), '" style="position: relative; z-index: 100;">Permalink</a></p></div></div>');
  if (!opt_sb) return output.toString();
};


net.hmrradio.podcastsite.templates.showPosts = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var eList35 = opt_data.episodes;
  var eListLen35 = eList35.length;
  for (var eIndex35 = 0; eIndex35 < eListLen35; eIndex35++) {
    var eData35 = eList35[eIndex35];
    output.append('<p>');
    net.hmrradio.podcastsite.templates.showPost(eData35, output);
    output.append('</p>');
  }
  if (!opt_sb) return output.toString();
};
