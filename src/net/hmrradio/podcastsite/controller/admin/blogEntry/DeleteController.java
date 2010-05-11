package net.hmrradio.podcastsite.controller.admin.blogEntry;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.meta.BlogEntryMeta;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class DeleteController extends BaseController {

    private BlogEntryMeta b = BlogEntryMeta.get();

    private BlogEntryService service = new BlogEntryService();

    @Override
    protected Navigation exec() throws Exception {

        BlogEntry entry = service.get(asKey(b.key));

        service.delete(asKey(b.key));

        return forwardJson(entry);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(b.key, RequiredValidator.INSTANCE);

        return v.validate();
    }
}
