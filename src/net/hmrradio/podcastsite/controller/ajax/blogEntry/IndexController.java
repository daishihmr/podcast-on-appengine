package net.hmrradio.podcastsite.controller.ajax.blogEntry;

import java.util.List;

import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private BlogEntryService blogEntryService = new BlogEntryService();

    @Override
    public Navigation run() throws Exception {
        Thread.sleep(10000);

        List<BlogEntry> list = blogEntryService.list(null);
        requestScope(AttrName.ENTRY_LIST, list);
        return forward("index.jsp");
    }
}
