package net.hmrradio.podcastsite.controller.blogEntry;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class DeleteController extends BaseController {

    private BlogEntryService blogEntryService = new BlogEntryService();

    public DeleteController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation input() throws Exception {
        return forward("/dashboard/index.jsp");
    }

    @Override
    protected Navigation exec() throws Exception {

        blogEntryService.delete(asKey("key"));

        requestScope("message", asString("title") + "を削除しました。");

        return forward("/"); // TODO
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add("key", RequiredValidator.INSTANCE);

        return v.validate();
    }
}
