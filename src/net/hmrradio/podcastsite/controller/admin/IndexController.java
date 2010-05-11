package net.hmrradio.podcastsite.controller.admin;

import net.hmrradio.podcastsite.controller.BaseController;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    public IndexController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {
        return redirect("/");
    }

}
