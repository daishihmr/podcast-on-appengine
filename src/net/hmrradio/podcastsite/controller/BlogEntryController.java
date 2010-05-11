package net.hmrradio.podcastsite.controller;

import java.util.ArrayList;
import java.util.List;

import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.datastore.ModelQuery;
import org.slim3.util.BeanUtil;

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

        List<BlogEntry> list = service.list(q);
        List<BlogEntry> result = new ArrayList<BlogEntry>();
        for (BlogEntry blogEntry : list) {
            try {
                result.add(service.parseContent(blogEntry));
            } catch (Exception e) {
            }
        }

        return forwardJson(result);
    }
}
