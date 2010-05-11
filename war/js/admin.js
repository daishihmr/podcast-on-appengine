var NEW_ENTRY = {
    title: "やっつけxxx「」",
    content: 
        "参加メンバー：\n" +
        "[/member/名前]\n" +
        "\n" +
        "【[/corner/コーナー名]】内容[[BR]]\n" +
        "\n" +
        "メッセージ\n"
};

var NEW_MEMBER = "プロフィール\n";

function init() {
    buttons();

    events();
    
    dialogs();

    // ログインリンクをログアウトリンクに
    $("#login").text("ログアウト").attr("href", "/admin/logout");

    // AdminOnlyの要素を可視化
    $("#create-entry-area").show("blind", {}, 500)
    $(".admin-only").show();
}

function buttons() {
    // 編集ボタン
    $(".edit").button({
        icons: { primary: "ui-icon-pencil" },
        text: false
    }).attr("title", "編集");

    // 追加ボタン
    $(".add").button({
        icons: { primary: "ui-icon-plus" },
        text: false
    }).attr("title", "追加");
    
    // 新規投稿ボタン
    $("#create-entry").button({
        icons: { primary: "ui-icon-plus" },
        text: false
    }).attr("title", "新規投稿");
}

function dialogs() {

    // Link編集ダイアログをロード
    $("#linkDialog").load("/dialog/linkDialog.html #linkDialog", {}, function() {
        $("#linkDialog").dialog({
            title:"リンクを編集",
            autoOpen: false,
            width: 350,
            buttons: {
                "Ok": function() {
                    var self = $(this);
                    var method = $("#linkForm input[name='method']").val();
                    post("/admin/link/" + method, "linkForm", function(l) {
                        var url = $("#linkForm input[name='url']");
                        var title = $("#linkForm input[name='title']");
                        var text = $("#linkForm textarea[name='text']");

                        appendLink(title.val(), url.val(), text.val());
                        
                        url.val("");
                        title.val("");
                        text.val("");

                        buttons();

                        self.dialog("close");
                    });
                }, 
                "Cancel": function() {
                    $(this).dialog("close");
                },
                "Delete": function() {
                    var self = $(this);
                    var method = $("#linkForm input[name='method']").val();
                    post("/admin/link/delete", "linkForm", function(l) {
                        var url = $("#linkForm input[name='url']");
                        var title = $("#linkForm input[name='title']");
                        var text = $("#linkForm textarea[name='text']");

                        deleteLink(url.val());
                        
                        url.val("");
                        title.val("");
                        text.val("");

                        buttons();

                        self.dialog("close");
                    });
                }
            }
        });
    });

    // エントリ編集ダイアログをロード
    $("#entryDialog").load("/dialog/entryDialog.html #ent", {}, function() {

        // 収録日テキストボックスにDatePicker設定
        $("#ent-dialog").find("input[name='recordingDate']").datepicker({
            dateFormat: "yy/mm/dd",
            showButtonPanel: true
        });
        
        // アップロードボタン
        $("#ent-upload").button({
            icons: { primary: "ui-icon-arrowthick-1-n" }
        }).click(function() {
            open("http://hmr.sakura.ne.jp/qakgiehsnsgewa.html", "audioFile", "width=600, height=400, menubar=no, toolbar=no, scrollbars=yes");
            return false;
        });
        
        // ファイル選択ボタン
        $("#ent-select").button({
            icons: { primary: "ui-icon-folder-open" }
        }).click(function() {
            return false;
        });
        
        // 例ボタン
        $("#ent-example").button({
            icons: { primary: "ui-icon-document" },
            text: false,
            title: "初期化"
        }).click(function() {
            if(confirm("テキストを初期化します")) {
                $("#ent-title").val(NEW_ENTRY.title);
                $("#ent-content").val(NEW_ENTRY.content);
            }
            return false;
        });
        
        // メンバーボタン
        $("#ent-member").button({
            icons: { primary: "ui-icon-person" },
            text: false,
            title: "メンバー"
        }).click(function() {
            var v = "[/member/名前]\n";
            var o = $("#ent-content").get(0);
            o.focus();
            if ($.browser.msie) {
                var r = document.selection.createRange();
                r.text = v;
                r.select();
            } else {
                var s = o.value;
                var p = o.selectionStart;
                var np = p + v.length;
                o.value = s.substr(0, p) + v + s.substr(p);
                o.setSelectionRange(np, np);
            }
            return false;
        });

        // コーナーボタン
        $("#ent-corner").button({
            icons: { primary: "ui-icon-bookmark" },
            text: false,
            title: "コーナー"
        }).click(function() {
            var v = "【[/corner/コーナー名]】内容[[BR]]\n";
            var o = $("#ent-content").get(0);
            o.focus();
            if ($.browser.msie) {
                var r = document.selection.createRange();
                r.text = v;
                r.select();
            } else {
                var s = o.value;
                var p = o.selectionStart;
                var np = p + v.length;
                o.value = s.substr(0, p) + v + s.substr(p);
                o.setSelectionRange(np, np);
            }
            return false;
        });

        // エントリ編集ダイアログ
        $("#ent-dialog").dialog({
            title: "エントリを編集",
            autoOpen: false,
            modal: true,
            width: 750,
            buttons: {
                "Ok": function() {
                    $(this).dialog("close");
                    var loader = $("<div class='entry'><img src='/images/ajax-loader.gif' /></div>");
                    if ($("#ent-key").val().length == 0) {
                        $("#create-entry-area").append(loader);
                    } else {
                        $(".edit-entry[key='" + $("#ent-key").val() + "']").parents(".post").find(".entry").replaceWith(loader);
                    }
                    post("/admin/blogEntry/create", "entryForm", function(data) {
                        loader.remove();
                        if ($("#ent-key").val().length == 0){
                            appendNewEntry(data);
                        } else {
                            updateEntry(data.keyString, data);
                        }
                    });
                },
                "Cancel": function() {
                    $(this).dialog("close");
                },
                "Delete": function() {
                    if ($("#ent-key").val().length == 0) {
                        return;
                    }
                    var loader = $("<div class='entry'><img src='/images/ajax-loader.gif' /></div>");
                    $(".edit-entry[key='" + $("#ent-key").val() + "']").parents(".post").find(".entry").replaceWith(loader);
                    post("/admin/blogEntry/delete", "entryForm", function(data) {
                        removeEntry(data.keyString);
                    });
                    $(this).dialog("close");
                }
            }
        });
        
        $("#ent-wait").dialog({
            title: "しばらくお待ちください",
            autoOpen: false,
            width: 300,
            height: 120,
            modal: true,
            resizable: false,
            draggable: false,
            show: "bounce"
        });

    });
    
    // パーソナリティ編集ダイアログをロード
    $("#memberDialog").load("/dialog/memberDialog.html #mem", {}, function() {
        $("#mem-icon-button").button().click(function() {
            openImageUploader("mem-icon", "mem-icon-img");
        });
        
        $("#mem-dialog").dialog({
            title: "パーソナリティ情報を編集",
            width: 600,
            autoOpen: false,
            buttons: {
                "Ok": function() {
                    post("/admin/personality/create", "memberForm", function(data) {
                        if ($("#member-" + data.name).length) {
                            $("#member-" + data.name).replaceWith(createMember(data));
                        }
                    });
                    $(this).dialog("close");
                },
                "Cancel": function() {
                    $(this).dialog("close");
                }
            }
        });
        
    });

    // コーナー編集ダイアログをロード
    $("#cornerDialog").load("/dialog/cornerDialog.html #cnr", {}, function() {
        $("#cnr-dialog").dialog({
            title: "コーナー情報を編集",
            width: 600,
            autoOpen: false,
            buttons: {
                "Ok": function() {
                    post("/admin/corner/create", "cornerForm", function(data) {
                        if ($("#corner-" + data.title).length) {
                            $("#corner-" + data.title).replaceWith(createCorner(data));
                        }
                    });
                    $(this).dialog("close");
                },
                "Cancel": function() {
                    $(this).dialog("close");
                }
            }
        });
    });
}

function events() {
    // Link集追加ボタンへのイベント設定
    $("#add-link").live("click", function() {
        $("#linkForm input[name='url']").val("").removeAttr("readonly");
        $("#linkForm input[name='title']").val("");
        $("#linkForm textarea[name='text']").val("");

        $("#linkForm input[name='method']").val("create");

        $("#linkDialog").dialog("open");
    });

    // Link集編集ボタンへのイベント設定
    $(".edit-link").live("click", function() {
        var a = $(this).prev("a");
        var title = a.text();
        var url = a.attr("href");
        var text = a.attr("title");

        $("#linkForm input[name='url']").val(url).attr("readonly", "readonly");
        $("#linkForm input[name='title']").val(title);
        $("#linkForm textarea[name='text']").val(text);

        $("#linkForm input[name='method']").val("update");

        $("#linkDialog").dialog("open");
    });

    // 新規投稿ボタン
    $("#create-entry").click(function() {
        $("#ent-title").val(NEW_ENTRY.title);
        $("#ent-content").val(NEW_ENTRY.content);
        $("#ent-audioFileURL").val("");
        $("#ent-recordingDate").val("");
        $("#ent-tags").val("");
        $("#ent-key").val("");

        $("#ent-dialog").dialog("open");
    });
    
    // 記事編集ボタン
    $(".edit-entry").live("click", function(){
        $("#ent-wait-message").text("データダウンロード中");
        $("#ent-wait").dialog("open");
        $.post("/admin/blogEntry/edit", { key: $(this).attr("key") }, function(data) {
            if (data.success) {
                var entry = data.body;
                $("#ent-key").val(entry.keyString);
                $("#ent-title").val(entry.title);
                $("#ent-audioFileURL").val(entry.audioFileURL);
                $("#ent-recordingDate").val(toDate(entry.recordingDate));
                $("#ent-content").val(entry.content.value);
                $("#ent-tags").val(entry.tags.join(", "));
                
                $("#ent-wait").dialog("close");
                $("#ent-dialog").dialog("open");
            } else {
                error("記事データをダウンロードできませんでした。");
                $("#ent-wait").dialog("close");
            }
        });
    });
    
}

function editMember(data, name) {
    if(data) {
        $("#mem-name").val(data.name);
        $("#mem-name-span").text(data.name);
        $("#mem-twitterId").val(data.twitterId);
        $("#mem-icon-img").attr("src", "/image/show/" + data.icon);
        $("#mem-icon").val(data.icon);
        $("#mem-profile").val(data.profile.value);
        $("#mem-key").val(data.keyString);
    } else {
        $("#mem-name").val(name);
        $("#mem-name-span").text(name);
        $("#mem-twitterId").val("");
        $("#mem-icon-img").attr("src", "/images/nodata.png");
        $("#mem-icon").val("");
        $("#mem-profile").val("NO DATA");
        $("#mem-key").val("");
    }
    $("#mem-dialog").dialog("open");
}

function editCorner(data, title) {
    if(data) {
        $("#cnr-title").val(data.title);
        $("#cnr-title-span").text(data.title);
        $("#cnr-description").val(data.description.value);
        $("#cnr-key").val(data.keyString);
    } else {
        $("#cnr-title").val(title);
        $("#cnr-title-span").text(title);
        $("#cnr-description").val("NO DATA");
        $("#cnr-key").val("");
    }
    $("#cnr-dialog").dialog("open");
}

function appendNewEntry(data) {
    var post = createPost(data);
    $("#create-entry-area").after(post);
}

function updateEntry(key, data) {
    var target = $(".edit-entry[key='" + key + "']").parents(".post");
    var post = createPost(data);
    target.replaceWith(post);
}

function removeEntry(key) {
    var target = $(".edit-entry[key='" + key + "']").parents(".post");
    target.hide("blind", function() {
        $(this).remove();
    });
}

function openImageUploader(setTarget, setTargetImg) {
    open("/admin/image/thumbs?setTarget=" + setTarget + "&setTargetImg=" + setTargetImg, "_blank", "width=600, height=400, menubar=no, toolbar=no, scrollbars=yes");
}

init();
