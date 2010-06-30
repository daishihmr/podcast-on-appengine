package net.hmrradio.podcastsite.controller.blogEntry;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;

public class ListController extends BaseController {

    private BlogEntryService blogEntryService = new BlogEntryService();

    @Override
    protected Navigation exec() throws Exception {
        return forwardJson(blogEntryService.list());
    }

}
