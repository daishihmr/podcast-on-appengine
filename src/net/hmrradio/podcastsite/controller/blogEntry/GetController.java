package net.hmrradio.podcastsite.controller.blogEntry;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class GetController extends BaseController {

    private BlogEntryService blogEntryService = new BlogEntryService();

    @Override
    protected Navigation exec() throws Exception {
        return forwardJson(blogEntryService.get(asKey("key")));
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add("key", RequiredValidator.INSTANCE);

        return v.validate();
    }
}
