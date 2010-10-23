package net.hmrradio.podcastsite.controller;

import java.util.List;
import java.util.logging.Logger;

import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.model.Link;
import net.hmrradio.podcastsite.service.BlogEntryService;
import net.hmrradio.podcastsite.service.LinkService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.util.ApplicationMessage;

public class IndexController extends Controller {

    private Logger log = Logger.getLogger(IndexController.class.getName());

    private BlogEntryService blogEntryService = new BlogEntryService();
    private LinkService linkService = new LinkService();

    @Override
    public Navigation run() throws Exception {
        log.info("index start");

        // 記事
        try {

            List<BlogEntry> list = blogEntryService.list();
            requestScope(AttrName.ENTRY_LIST, list);
            log.info("エントリ数 = " + list.size());

        } catch (IllegalArgumentException e) {
            return notFound();
        } catch (EntityNotFoundRuntimeException e) {
            return notFound();
        }

        // リンク集
        List<Link> linkList = linkService.list();
        requestScope(AttrName.LINK_LIST, linkList);
        log.info("リンク数 = " + linkList.size());

        log.info("index end");
        return forward("index.jsp");
    }

    private Navigation notFound() {
        requestScope(
            AttrName.ERROR_MESSAGES,
            ApplicationMessage.get("message.noSuchBlogEntry"));
        return forward("error.jsp");
    }

}
