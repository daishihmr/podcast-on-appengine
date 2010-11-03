package net.hmrradio.podcastsite.controller.blogEntry;

import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ListController extends Controller {

    private BlogEntryService blogEntryService = new BlogEntryService();

    @Override
    public Navigation run() throws Exception {

        requestScope("list", blogEntryService.list());

        return forward("list.jsp");
    }
}
