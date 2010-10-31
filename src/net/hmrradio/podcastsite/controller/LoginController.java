package net.hmrradio.podcastsite.controller;

import org.slim3.controller.Navigation;

public class LoginController extends BaseController {

    public LoginController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {
        return redirect("/");
    }

    @Override
    protected Navigation input() {
        return redirect("index.jsp");
    }

}
