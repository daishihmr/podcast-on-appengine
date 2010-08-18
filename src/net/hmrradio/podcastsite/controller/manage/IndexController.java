package net.hmrradio.podcastsite.controller.manage;

import net.hmrradio.podcastsite.controller.BaseController;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    public IndexController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {
        return forward("index.jsp");
    }

}
