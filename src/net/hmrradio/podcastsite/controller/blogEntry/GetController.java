package net.hmrradio.podcastsite.controller.blogEntry;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

import com.google.appengine.repackaged.org.apache.commons.logging.Log;
import com.google.appengine.repackaged.org.apache.commons.logging.LogFactory;

public class GetController extends BaseController {

    private BlogEntryService blogEntryService = new BlogEntryService();
    private Log log = LogFactory.getLog(GetController.class);

    @Override
    protected Navigation exec() throws Exception {
        log.info(asString("key"));
        return forwardJson(blogEntryService.get(asKey("key")));
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add("key", RequiredValidator.INSTANCE);

        return v.validate();
    }

    @Override
    protected Navigation input() {
        return forward("index.jsp");
    }
}
