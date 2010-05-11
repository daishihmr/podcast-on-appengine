package net.hmrradio.podcastsite.controller;

import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.util.ApplicationMessage;

public class IndexController extends Controller {

    private BlogEntryService blogEntryService = new BlogEntryService();

    @Override
    public Navigation run() throws Exception {
        if (requestScope("p") != null) {
            try {
                blogEntryService.get(asKey("p"));

                BlogEntryQueryBean queryBean = new BlogEntryQueryBean();
                queryBean.setKeyEq(asKey("p"));
                sessionScope(AttrName.BLOG_ENTRY_QUERY, queryBean);

            } catch (IllegalArgumentException e) {
                return notFound();
            } catch (EntityNotFoundRuntimeException e) {
                return notFound();
            }
        }
        return forward("index.html");
    }

    private Navigation notFound() {
        requestScope(AttrName.ERROR_MESSAGES, ApplicationMessage
            .get("message.noSuchBlogEntry"));
        return forward("error.jsp");
    }

}
