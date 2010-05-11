package net.hmrradio.podcastsite.controller;

import net.hmrradio.podcastsite.rss.PodcastChannel;
import net.hmrradio.podcastsite.rss.PodcastUtil;
import net.hmrradio.podcastsite.service.RssService;

import org.slim3.controller.Navigation;

public class RssController extends BaseController {

    private RssService rssService = new RssService();

    @Override
    protected Navigation exec() throws Exception {
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expires", "Thu, 01 Dec 1994 16:00:00 GM");
        response.setContentType("application/xml; charset=utf-8");

        PodcastChannel rss = rssService.getRss();
        PodcastUtil.out(rss, response.getWriter());
        return null;
    }
}
