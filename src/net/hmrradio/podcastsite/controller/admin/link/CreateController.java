package net.hmrradio.podcastsite.controller.admin.link;

import net.hmrradio.podcastsite.common.TextCopyOptions;
import net.hmrradio.podcastsite.controller.BasePostController;
import net.hmrradio.podcastsite.define.Values;
import net.hmrradio.podcastsite.meta.LinkMeta;
import net.hmrradio.podcastsite.model.Link;
import net.hmrradio.podcastsite.service.LinkService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.MaxlengthValidator;
import org.slim3.controller.validator.RegexpValidator;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class CreateController extends BasePostController {

    private LinkMeta l = LinkMeta.get();

    private LinkService service = new LinkService();

    public CreateController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {
        Link link = new Link();
        BeanUtil.copy(request, link, new TextCopyOptions("text"));

        service.create(link);

        return forwardJson(link);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(
            l.url,
            RequiredValidator.INSTANCE,
            new MaxlengthValidator(100),
            new RegexpValidator(Values.URL_PATTERN));
        v.add(l.title, RequiredValidator.INSTANCE, new MaxlengthValidator(100));
        v.add("title", new MaxlengthValidator(1000));

        return v.validate();
    }
}
