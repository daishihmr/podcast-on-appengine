package net.hmrradio.podcastsite.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

    public AppRouter() {
        addRouting("/p/{key}", "/?p={key}");
        addRouting("/image/show/{key}", "/image/show?key={key}");
        addRouting("/member/{memberName}", "/?member={memberName}");
        addRouting("/corner/{cornerTitle}", "/?corner={cornerTitle}");
        addRouting("/tag/{tag}", "/?tag={tag}");
    }

}
