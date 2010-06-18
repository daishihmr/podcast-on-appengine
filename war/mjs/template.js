// This file was automatically generated from template.soy.
// Please don't edit this file by hand.

if (typeof net == 'undefined') { var net = {}; }
if (typeof net.hmrradio == 'undefined') { net.hmrradio = {}; }
if (typeof net.hmrradio.daishi == 'undefined') { net.hmrradio.daishi = {}; }
if (typeof net.hmrradio.daishi.templates == 'undefined') { net.hmrradio.daishi.templates = {}; }


net.hmrradio.daishi.templates.showEpisode = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<h3>', soy.$$escapeHtml(opt_data.title), '</h3><p><div>', soy.$$escapeHtml(opt_data.keyString), ' - ', opt_data.contentString, '</div><div>create: ', soy.$$escapeHtml(opt_data.createAt), ', last modify: ', soy.$$escapeHtml(opt_data.lastModifyAt), '</div></p>');
  if (!opt_sb) return output.toString();
};


net.hmrradio.daishi.templates.showEpisodes = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var eList16 = opt_data.episodes;
  var eListLen16 = eList16.length;
  for (var eIndex16 = 0; eIndex16 < eListLen16; eIndex16++) {
    var eData16 = eList16[eIndex16];
    output.append('<div>');
    net.hmrradio.daishi.templates.showEpisode(eData16, output);
    output.append('</div>');
  }
  if (!opt_sb) return output.toString();
};


net.hmrradio.daishi.templates.dialogEpisode = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<form><input type="hidden" name="key" value="', soy.$$escapeHtml(opt_data.keyString), '" /><table border="1"><tr><th>title</th><td><input type="text" name="title" value="', soy.$$escapeHtml(opt_data.title), '" /></td></tr><tr><th>content</th><td><textarea name="content">', soy.$$escapeHtml(opt_data.content), '</textarea></td></tr></table></form>');
  if (!opt_sb) return output.toString();
};
