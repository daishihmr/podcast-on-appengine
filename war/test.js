$("#agtobXIteS1yYWRpb3IPCxIJQmxvZ0VudHJ5GAEM")
.find("a")
.each(function {
	$(this).css({
		position: "relative",
		zIndex: 100
	});
	var text = $(this).text();
	$(this).text(text.split("/corner/").join("").split("/member/").join(""));
});

checkLoginAdmin(function() {
	$("#agtobXIteS1yYWRpb3IPCxIJQmxvZ0VudHJ5GAEM")
	.find(".edit-entry")
	.button({
		icons: {
			primary: "ui-icon-pencil"
		},
		text: false
	})
	.show();
});
