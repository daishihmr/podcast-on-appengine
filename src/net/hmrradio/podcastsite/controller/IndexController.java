package net.hmrradio.podcastsite.controller;

import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.define.Values;
import net.hmrradio.podcastsite.service.BlogEntryService;
import net.hmrradio.podcastsite.service.LinkService;
import net.hmrradio.podcastsite.util.SoyUtil;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.util.ApplicationMessage;

public class IndexController extends Controller {

    private BlogEntryService blogEntryService = new BlogEntryService();
    private LinkService linkService = new LinkService();

    @Override
    public Navigation run() throws Exception {

        // 記事
        BlogEntryQueryBean queryBean = null;
        try {

            if (requestScope("p") != null) {
                // 記事指定
                queryBean = new BlogEntryQueryBean();
                queryBean.setKeyEq(asKey("p"));
            }

            requestScope("blogEntries", SoyUtil.render(
                Values.SOY_NS,
                "showBlogEntries",
                blogEntryService.list(queryBean)));

        } catch (IllegalArgumentException e) {
            return notFound();
        } catch (EntityNotFoundRuntimeException e) {
            return notFound();
        }

        // リンク集
        requestScope("links", SoyUtil.render(
            Values.SOY_NS,
            "showLinks",
            linkService.list()));

        return forward("index.jsp");
    }

    private Navigation notFound() {
        requestScope(AttrName.ERROR_MESSAGES, ApplicationMessage
            .get("message.noSuchBlogEntry"));
        return forward("error.jsp");
    }

}
