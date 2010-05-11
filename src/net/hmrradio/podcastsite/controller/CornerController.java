package net.hmrradio.podcastsite.controller;

import net.hmrradio.podcastsite.define.MsgKey;
import net.hmrradio.podcastsite.meta.CornerMeta;
import net.hmrradio.podcastsite.model.Corner;
import net.hmrradio.podcastsite.service.CornerService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class CornerController extends BaseController {

    private CornerService service = new CornerService();

    private CornerMeta c = CornerMeta.get();

    @Override
    protected Navigation exec() throws Exception {

        Corner corner = service.findByTitle(asString(c.title));

        if (corner == null) {
            return forwardJsonError(MsgKey.NO_DATA);
        }

        return forwardJson(corner);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(c.title, RequiredValidator.INSTANCE);

        return v.validate();
    }
}
