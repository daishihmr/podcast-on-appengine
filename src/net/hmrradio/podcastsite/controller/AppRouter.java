package net.hmrradio.podcastsite.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

    public AppRouter() {
        addRouting("/image/show/{key}", "/image/show?key={key}");
    }

}
