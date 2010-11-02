package net.hmrradio.podcastsite.controller.test;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class UploaderTestController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        return forward("uploaderTest.jsp");
    }

}
