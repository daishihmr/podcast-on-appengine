var decodeJson = function(json) {
	var result = eval("(" + json + ")");
	return result;
}

var Tofu = {};
for (var m in podcastsite) {
	if (typeof podcastsite[m] == "function") {
		Tofu[m] = new Function("arg", "podcastsite." + m + "(decodeJson(arg))");
	} else {
		Tofu[m] = podcastsite[m];
	}
}
