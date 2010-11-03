package net.hmrradio.podcastsite.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

    public AppRouter() {
        addRouting("/p/{key}", "/?p={key}");
        addRouting("/image/show/{key}", "/image/show?key={key}");
        addRouting("/member/{memberName}", "/member/?member={memberName}");
        addRouting("/corner/{cornerTitle}", "/corner/?corner={cornerTitle}");
        addRouting("/tag/{tag}", "/corner/?tag={tag}");
    }

}
