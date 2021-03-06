package net.hmrradio.podcastsite.controller;

import org.slim3.controller.Navigation;

public class LoginCheckController extends BaseController {

    @Override
    protected Navigation exec() throws Exception {
        return forwardJsonSuccess();
    }

    @Override
    protected boolean validate() {
        return isAdmin();
    }

    @Override
    protected Navigation input() {
        return forward("index.jsp");
    }

}
