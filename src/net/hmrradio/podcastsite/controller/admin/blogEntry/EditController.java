package net.hmrradio.podcastsite.controller.admin.blogEntry;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.meta.BlogEntryMeta;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class EditController extends BaseController {

    private BlogEntryService service = new BlogEntryService();

    private BlogEntryMeta b = BlogEntryMeta.get();

    @Override
    protected Navigation exec() throws Exception {
        return forwardJson(service.get(asKey(b.key)));
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(b.key, RequiredValidator.INSTANCE);

        return v.validate();
    }

}
