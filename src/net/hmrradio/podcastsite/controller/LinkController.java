package net.hmrradio.podcastsite.controller;

import java.util.List;

import net.hmrradio.podcastsite.service.LinkService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.com.google.common.collect.Lists;

public class LinkController extends BaseController {

    private LinkService service = new LinkService();

    @Override
    protected Navigation exec() throws Exception {

        List<Controller> cList = Lists.newArrayList();

        return forwardJson(service.list());
    }

}
