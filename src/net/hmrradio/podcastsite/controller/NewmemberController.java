package net.hmrradio.podcastsite.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class NewmemberController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("newmember.jsp");
    }
}
