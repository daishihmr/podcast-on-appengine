if (typeof net == 'undefined') { var net = {}; }
if (typeof net.hmrradio == 'undefined') { net.hmrradio = {}; }
if (typeof net.hmrradio.podcastsite == 'undefined') { net.hmrradio.podcastsite = {}; }
if (typeof net.hmrradio.podcastsite.common == 'undefined') { net.hmrradio.podcastsite.common = {}; }
net.hmrradio.podcastsite.common.isAdmin = "unknown";
net.hmrradio.podcastsite.common.fArray = [];
net.hmrradio.podcastsite.common.eArray = [];

jQuery.fn.extend( {

    /**
     * フォームにsubmitイベントハンドラをセットする.
     *
     * @param url
     *            ポスト先URL
     * @param callback
     *            function(data:Object)
     * @return void
     */
    setAjaxSubmit : function(url, callback) {
        this.submit(function() {
            return post(url, $(this).attr("name"), callback);
        });
    }

});

$(function() {
    $.ajaxSetup( {
        error : function(xhr, status, e) {
            ajaxError(xhr, status, e);
        }
    });

    var alertDialog = $("<div id='alertDialog'></div>");
    alertDialog.append($("<p id='alertMessage'></p>"));
    $(document).append(alertDialog);

    alertDialog.dialog({
        title: "エラー",
        modal: true,
        autoOpen: false,
        buttons: {
            "OK": function() { $(this).dialog('close'); }
        }
    });
});

/**
 * フォームのデータをポストする.
 *
 * @param url
 *            ポスト先URL
 * @param formName
 *            フォームのname
 * @param callback
 *            function(data:Object)
 * @return false(固定)
 */
var post = function(url, formName, callback) {
    var data = {};
    if (formName) {
        var f = $("form[name='" + formName + "']");
        data = f.serializeArray();
    }
    $.post(url, data, getCallbackFunction(callback), "json");

    return false;
};

/**
 * JSONレスポンスを処理する関数を作る
 *
 * @param f
 *            成功時の関数
 * @return 関数
 */
var getCallbackFunction = function(f) {
    return function(data, status) {
        if (status != "success") {
            return ajaxError(null, status);
        } else if (data.success == false) {
            return error(data);
        }

        f(data.body);
    }
};

/**
 * Ajaxエラー時のイベントハンドラ
 *
 * @param xhr
 * @param status
 */
var ajaxError = function(xhr, status) {
    if (xhr.status == "500") {
        alert("Ajaxエラーが発生しました。F5を押してみてください。");
    } else {
        alert("Ajaxエラー\n" + //
                "status = " + status + "\n" + //
                "XHR.status = " + xhr.status + "\n" + //
                "XHR.statusText = " + xhr.statusText + "\n");
    }
};

/**
 * エラー時のイベントハンドラ
 *
 * @param data
 */
var error = function(data) {
    $("#alertMessage").text(data.messages.join("\n"));
    $("#alertDialog").dialog("open");
};

/**
 * ユーザがAdminとしてログイン済みかをチェックする
 *
 * @param f
 *            Adminログイン時に実行する処理
 * @param error
 *            Adminログインしていない時に実行する処理
 * @return void
 */
var checkLoginAdmin = function(f, e) {
    if (net.hmrradio.podcastsite.common.isAdmin == "unknown") {
        net.hmrradio.podcastsite.common.isAdmin = "checking";
        if (f) net.hmrradio.podcastsite.common.fArray.push(f);
        if (e) net.hmrradio.podcastsite.common.eArray.push(e);
        $.get("/loginCheck", {dummy: "dummy"}, function(result) {
            if (result.success) {
                net.hmrradio.podcastsite.common.isAdmin = "true";
                for(var i = 0; i < net.hmrradio.podcastsite.common.fArray.length; i++) {
                    net.hmrradio.podcastsite.common.fArray[i]();
                }
                net.hmrradio.podcastsite.common.fArray = [];
                net.hmrradio.podcastsite.common.eArray = [];
            } else {
                net.hmrradio.podcastsite.common.isAdmin = "false";
                for(var i = 0; i < net.hmrradio.podcastsite.common.eArray.length; i++) {
                    net.hmrradio.podcastsite.common.eArray[i]();
                }
                net.hmrradio.podcastsite.common.fArray = [];
                net.hmrradio.podcastsite.common.eArray = [];
            }
        }, "json");
    } else if (net.hmrradio.podcastsite.common.isAdmin == "checking") {
        if (f) net.hmrradio.podcastsite.common.fArray.push(f);
        if (e) net.hmrradio.podcastsite.common.eArray.push(e);
    } else if (net.hmrradio.podcastsite.common.isAdmin == "true") {
        if (f) f();
    } else {
        if (e) e();
    }
};

var createPlayer = function(audioFileURL) {
    if (!audioFileURL) return null;
    var filename = audioFileURL.split("/")[audioFileURL.split("/").length - 1];
    var player = $("<p>" +
            "<object type='application/x-shockwave-flash' data='/player_mp3_maxi.swf' width='20' height='20'>" +
                "<param name='movie' value='/player_mp3_maxi.swf' />" +
                "<param name='bgcolor' value='#000000' />" +
                "<param name='FlashVars' value='mp3=" + encodeURI(audioFileURL) + "&amp;width=20&amp;showstop=0&amp;showslider=0&amp;buttonwidth=20' />" +
            "</object> " +
            "<a href='" + audioFileURL + "'>" + filename + "</a>" +
        "</p>");
    return player;
}

var personality = function(p) {
    p.profile = p.profile.value;
    return p;
};

var corner = function(row) {
    row.description = row.description.value;
    return row;
};

var link = function(row) {
    row.text = row.text.value;
};

var toDate = function(t) {
    var d = new Date(t);
    var fmt = new DateFormat("yyyy/MM/dd");
    return fmt.format(d);
};

var format = function(o, pre) {
    if (!o) {
        return o;
    }

    if (!pre) {
        pre = "";
    }

    if (o instanceof Array) {
        var r = "[";
        for ( var i = 0; i < o.length; i++) {
            if (i != 0) {
                r += ",";
            }
            r += format(o[i], pre + "  ");
        }
        r += "]";
        return r;
    } else if (typeof (o) == "object") {
        var r = "{";
        var i = 0;
        $.each(o, function(k, v) {
            if (i != 0) {
                r += ", ";
            }
            r += "\n" + pre + "  " + k + ":" + format(v, pre + "  ");
            i++;
        });
        r += "\n" + pre + "}";
        return r;
    } else if (typeof (o) == "string") {
        return "'" + o + "'";
    } else {
        return o;
    }
};



/*
--------------------------------------------------------
dateformat.js - Simple date formatter
Version 1.1 (Update 2008/04/02)

Copyright (c) 2007-2008 onozaty (http://www.enjoyxstudy.com)

Released under an MIT-style license.

For details, see the web site:
 http://www.enjoyxstudy.com/javascript/dateformat/

--------------------------------------------------------
patterns
y : Year         ex. "yyyy" -> "2007", "yy" -> "07"
M : Month        ex. "MM" -> "05" "12", "M" -> "5" "12"
d : Day          ex. "dd" -> "09" "30", "d" -> "9" "30"
H : Hour (0-23)  ex. "HH" -> "00" "23", "H" -> "0" "23"
m : Minute       ex. "mm" -> "01" "59", "m" -> "1" "59"
s : Second       ex. "ss" -> "00" "59", "H" -> "0" "59"
S : Millisecond  ex. "SSS" -> "000" "012" "999",
                     "SS" -> "00" "12" "999", "S" -> "0" "12" "999"

Text can be quoted using single quotes (') to avoid interpretation.
"''" represents a single quote.


Useing..

 var fmt = new DateFormat("yyyy/MM/dd HH:mm:ss SSS");

 var str = fmt.format(new Date()); // "2007/05/10 12:21:19 002"
 var date = fmt.parse("2007/05/10 12:21:19 002"); // return Date object

--------------------------------------------------------
*/

var DateFormat = function(pattern) {
  this._init(pattern);
};

DateFormat.prototype = {
  _init: function(pattern) {

    this.pattern = pattern;
    this._patterns = [];

    for (var i = 0; i < pattern.length; i++) {
      var ch = pattern.charAt(i);
      if (this._patterns.length == 0) {
        this._patterns[0] = ch;
      } else {
        var index = this._patterns.length - 1;
        if (this._patterns[index].charAt(0) == "'") {
          if (this._patterns[index].length == 1
             || this._patterns[index].charAt(this._patterns[index].length - 1) != "'") {
            this._patterns[index] += ch;
          } else {
            this._patterns[index + 1] = ch;
          }
        } else if (this._patterns[index].charAt(0) == ch) {
          this._patterns[index] += ch;
        } else {
          this._patterns[index + 1] = ch;
        }
      }
    }
  },

  format: function(date) {

    var result = [];
    for (var i = 0; i < this._patterns.length; i++) {
      result[i] = this._formatWord(date, this._patterns[i]);
    }
    return result.join('');
  },
  _formatWord: function(date, pattern) {

    var formatter = this._formatter[pattern.charAt(0)];
    if (formatter) {
      return formatter.apply(this, [date, pattern]);
    } else {
      return pattern;
    }
  },
  _formatter: {
    "y": function(date, pattern) {
      // Year
      var year = String(date.getFullYear());
      if (pattern.length <= 2) {
        year = year.substring(2, 4);
      } else {
        year = this._zeroPadding(year, pattern.length);
      }
      return year;
    },
    "M": function(date, pattern) {
      // Month in year
      return this._zeroPadding(String(date.getMonth() + 1), pattern.length);
    },
    "d": function(date, pattern) {
      // Day in month
      return this._zeroPadding(String(date.getDate()), pattern.length);
    },
    "H": function(date, pattern) {
      // Hour in day (0-23)
      return this._zeroPadding(String(date.getHours()), pattern.length);
    },
    "m": function(date, pattern) {
      // Minute in hour
      return this._zeroPadding(String(date.getMinutes()), pattern.length);
    },
    "s": function(date, pattern) {
      // Second in minute
      return this._zeroPadding(String(date.getSeconds()), pattern.length);
    },
    "S": function(date, pattern) {
      // Millisecond
      return this._zeroPadding(String(date.getMilliseconds()), pattern.length);
    },
    "'": function(date, pattern) {
      // escape
      if (pattern == "''") {
        return "'";
      } else {
        return pattern.replace(/'/g, '');
      }
    }
  },

  _zeroPadding: function(str, length) {
    if (str.length >= length) {
      return str;
    }

    return new Array(length - str.length + 1).join("0") + str;
  },


  /// Parser ///
  parse: function(text) {

    if (typeof text != 'string' || text == '') return null;

    var result = {year: 1970, month: 1, day: 1, hour: 0, min: 0, sec: 0, msec: 0};

    for (var i = 0; i < this._patterns.length; i++) {
       if (text == '') return null; // parse error!!
       text = this._parseWord(text, this._patterns[i], result);
       if (text === null) return null; // parse error!!
    }
    if (text != '') return null; // parse error!!

    return new Date(
                result.year,
                result.month - 1,
                result.day,
                result.hour,
                result.min,
                result.sec,
                result.msec);
  },
  _parseWord: function(text, pattern, result) {

    var parser = this._parser[pattern.charAt(0)];
    if (parser) {
      return parser.apply(this, [text, pattern, result]);
    } else {
      if (text.indexOf(pattern) != 0) {
        return null;
      } else {
        return text.substring(pattern.length);
      }
    }
  },
  _parser: {
    "y": function(text, pattern, result) {
      // Year
      var year;
      if (pattern.length <= 2) {
        year = text.substring(0, 2);
        year = year < 70 ? '20' + year : '19' + year;
        text = text.substring(2);
      } else {
        var length = (pattern.length == 3) ? 4 : pattern.length;
        year = text.substring(0, length);
        text = text.substring(length);
      }
      if (!this._isNumber(year)) return null; // error
      result.year = parseInt(year, 10);
      return text;
    },
    "M": function(text, pattern, result) {
      // Month in year
      var month;
      if (pattern.length == 1 && text.length > 1
          && text.substring(0, 2).match(/1[0-2]/) != null) {
        month = text.substring(0, 2);
        text  = text.substring(2);
      } else {
        month = text.substring(0, pattern.length);
        text  = text.substring(pattern.length);
      }
      if (!this._isNumber(month)) return null; // error
      result.month = parseInt(month, 10);
      return text;
    },
    "d": function(text, pattern, result) {
      // Day in month
      var day;
      if (pattern.length == 1 && text.length > 1
          && text.substring(0, 2).match(/1[0-9]|2[0-9]|3[0-1]/) != null) {
        day  = text.substring(0, 2);
        text = text.substring(2);
      } else {
        day  = text.substring(0, pattern.length);
        text = text.substring(pattern.length);
      }
      if (!this._isNumber(day)) return null; // error
      result.day = parseInt(day, 10);
      return text;
    },
    "H": function(text, pattern, result) {
      // Hour in day (0-23)
      var hour;
      if (pattern.length == 1 && text.length > 1
          && text.substring(0, 2).match(/1[0-9]|2[0-3]/) != null) {
        hour = text.substring(0, 2);
        text = text.substring(2);
      } else {
        hour = text.substring(0, pattern.length);
        text = text.substring(pattern.length);
      }
      if (!this._isNumber(hour)) return null; // error
      result.hour = parseInt(hour, 10);
      return text;
    },
    "m": function(text, pattern, result) {
      // Minute in hour
      var min;
      if (pattern.length == 1 && text.length > 1
          && text.substring(0, 2).match(/[1-5][0-9]/) != null) {
        min  = text.substring(0, 2);
        text = text.substring(2);
      } else {
        min  = text.substring(0, pattern.length);
        text = text.substring(pattern.length);
      }
      if (!this._isNumber(min)) return null; // error
      result.min = parseInt(min, 10);
      return text;
    },
    "s": function(text, pattern, result) {
      // Second in minute
      var sec;
      if (pattern.length == 1 && text.length > 1
          && text.substring(0, 2).match(/[1-5][0-9]/) != null) {
        sec  = text.substring(0, 2);
        text = text.substring(2);
      } else {
        sec  = text.substring(0, pattern.length);
        text = text.substring(pattern.length);
      }
      if (!this._isNumber(sec)) return null; // error
      result.sec = parseInt(sec, 10);
      return text;
    },
    "S": function(text, pattern, result) {
      // Millimsecond
      var msec;
      if (pattern.length == 1 || pattern.length == 2) {
        if (text.length > 2 && text.substring(0, 3).match(/[1-9][0-9][0-9]/) != null) {
          msec = text.substring(0, 3);
          text = text.substring(3);
        } else if (text.length > 1 && text.substring(0, 2).match(/[1-9][0-9]/) != null) {
          msec = text.substring(0, 2);
          text = text.substring(2);
        } else {
          msec = text.substring(0, pattern.length);
          text = text.substring(pattern.length);
        }
      } else {
        msec = text.substring(0, pattern.length);
        text = text.substring(pattern.length);
      }
      if (!this._isNumber(msec)) return null; // error
      result.msec = parseInt(msec, 10);
      return text;
    },
    "'": function(text, pattern, result) {
      // escape
      if (pattern == "''") {
        pattern = "'";
      } else {
        pattern = pattern.replace(/'/g, '');
      }
      if (text.indexOf(pattern) != 0) {
        return null; // error
      } else {
        return text.substring(pattern.length);
      }
    }
  },

  _isNumber: function(str) {
    return /^[0-9]*$/.test(str);
  }
}
