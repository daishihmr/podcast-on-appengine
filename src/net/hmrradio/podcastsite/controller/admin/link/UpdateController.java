package net.hmrradio.podcastsite.controller.admin.link;

import net.hmrradio.podcastsite.common.TextCopyOptions;
import net.hmrradio.podcastsite.controller.BasePostController;
import net.hmrradio.podcastsite.meta.LinkMeta;
import net.hmrradio.podcastsite.model.Link;
import net.hmrradio.podcastsite.service.LinkService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.MaxlengthValidator;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class UpdateController extends BasePostController {

    private LinkMeta l = LinkMeta.get();

    private LinkService service = new LinkService();

    public UpdateController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {
        Link link = new Link();
        BeanUtil.copy(request, link, new TextCopyOptions("text"));

        link = service.update(link);

        return forwardJson(link);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(l.url, RequiredValidator.INSTANCE, new MaxlengthValidator(100));
        v.add(l.title, RequiredValidator.INSTANCE, new MaxlengthValidator(100));
        v.add("text", new MaxlengthValidator(1000));

        return v.validate();
    }

}
