package net.hmrradio.podcastsite.controller.blogEntry;

import net.hmrradio.podcastsite.controller.BaseController;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    public IndexController() {
        necessaryLoggedIn = true;
    }

    @Override
    public Navigation exec() throws Exception {
        return forward("index.jsp");
    }

    @Override
    protected Navigation input() throws Exception {
        return redirect("/");
    }
}
