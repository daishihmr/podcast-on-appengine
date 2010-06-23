package net.hmrradio.podcastsite.controller;

import java.util.Map;

import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.datastore.ModelQuery;
import org.slim3.util.BeanUtil;

import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class BlogEntryController extends BaseController {

    private BlogEntryService service = new BlogEntryService();

    @Override
    protected Navigation exec() throws Exception {

        BlogEntryQueryBean queryBean;
        if (sessionScope(AttrName.BLOG_ENTRY_QUERY) != null) {
            queryBean = sessionScope(AttrName.BLOG_ENTRY_QUERY);
            removeSessionScope(AttrName.BLOG_ENTRY_QUERY);
        } else {
            queryBean = new BlogEntryQueryBean();
            BeanUtil.copy(request, queryBean);
        }
        ModelQuery<BlogEntry> q = service.createQuery(queryBean);

        Map<String, Object> blogEntries = Maps.newHashMap();
        blogEntries.put("blogEntries", service.list(q));

        return forwardJson(blogEntries);
    }
}
