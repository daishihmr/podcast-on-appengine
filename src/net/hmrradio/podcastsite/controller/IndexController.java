package net.hmrradio.podcastsite.controller;

import java.util.List;
import java.util.Map;

import net.arnx.jsonic.JSON;
import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.service.BlogEntryService;
import net.hmrradio.podcastsite.service.LinkService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.datastore.ModelQuery;
import org.slim3.util.ApplicationMessage;

import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class IndexController extends Controller {

    private BlogEntryService service = new BlogEntryService();

    private LinkService linkService = new LinkService();

    @Override
    public Navigation run() throws Exception {
        if (requestScope("p") != null) {
            try {
                service.get(asKey("p"));

                BlogEntryQueryBean queryBean = new BlogEntryQueryBean();
                queryBean.setKeyEq(asKey("p"));
                sessionScope(AttrName.BLOG_ENTRY_QUERY, queryBean);

            } catch (IllegalArgumentException e) {
                return notFound();
            } catch (EntityNotFoundRuntimeException e) {
                return notFound();
            }
        } else {
            // クエリ無し
            BlogEntryQueryBean queryBean = new BlogEntryQueryBean();
            service.createQuery(queryBean);
            ModelQuery<BlogEntry> query = service.createQuery(queryBean);
            List<BlogEntry> list = service.list(query);
            Map<String, Object> result = Maps.newHashMap();
            result.put("blogEntries", list);
            requestScope("result", JSON.encode(result));
        }

        // リンク集
        Map<String, Object> linksJson = Maps.newHashMap();
        linksJson.put("links", linkService.list());
        requestScope("linksJson", linksJson);

        return forward("index.html");
    }

    private Navigation notFound() {
        requestScope(AttrName.ERROR_MESSAGES, ApplicationMessage
            .get("message.noSuchBlogEntry"));
        return forward("error.jsp");
    }

}
