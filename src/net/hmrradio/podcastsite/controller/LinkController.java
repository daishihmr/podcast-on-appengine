package net.hmrradio.podcastsite.controller;

import net.hmrradio.podcastsite.service.LinkService;

import org.slim3.controller.Navigation;

public class LinkController extends BaseController {

    private LinkService service = new LinkService();

    @Override
    protected Navigation exec() throws Exception {
        return forwardJson(service.list());
    }

}
