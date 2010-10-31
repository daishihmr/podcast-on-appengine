package net.hmrradio.podcastsite.controller;

import net.hmrradio.podcastsite.rss.PodcastChannel;
import net.hmrradio.podcastsite.rss.PodcastUtil;
import net.hmrradio.podcastsite.service.RssService;

import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.org.apache.commons.logging.Log;
import com.google.appengine.repackaged.org.apache.commons.logging.LogFactory;

public class RssController extends BaseController {

    private Log log = LogFactory.getLog(RssController.class);

    private RssService rssService = new RssService();

    @Override
    protected Navigation exec() throws Exception {
        log.info("RSS Controller start");

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expires", "Thu, 01 Dec 1994 16:00:00 GM");
        response.setContentType("application/xml; charset=utf-8");

        PodcastChannel rss = rssService.getRss();
        PodcastUtil.out(rss, response.getWriter());

        log.info("RSS Controller end");
        return null;
    }

    @Override
    protected Navigation input() {
        return null;
    }

}
