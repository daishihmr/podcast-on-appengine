package net.hmrradio.podcastsite.controller.api;

import java.util.logging.Logger;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.util.WikiUtil;

import org.slim3.controller.Navigation;

public class WikiController extends BaseController {

    private Logger log = Logger.getLogger(WikiController.class.getName());

    @Override
    protected Navigation input() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Navigation exec() throws Exception {
        log.info("/api/wiki");

        String html = WikiUtil.toHtml(asString("wiki"));
        return forwardJson(html);
    }

}
