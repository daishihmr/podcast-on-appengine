package net.hmrradio.podcastsite.controller.admin.link;

import net.hmrradio.podcastsite.common.TextCopyOptions;
import net.hmrradio.podcastsite.controller.BasePostController;
import net.hmrradio.podcastsite.meta.LinkMeta;
import net.hmrradio.podcastsite.model.Link;
import net.hmrradio.podcastsite.service.LinkService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class DeleteController extends BasePostController {

    private LinkMeta l = LinkMeta.get();

    private LinkService service = new LinkService();

    @Override
    protected Navigation exec() throws Exception {

        Link link = new Link();
        BeanUtil.copy(request, link, new TextCopyOptions("text"));

        service.delete(link);

        return forwardJsonSuccess();
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(l.url, RequiredValidator.INSTANCE);

        return v.validate();
    }

}
