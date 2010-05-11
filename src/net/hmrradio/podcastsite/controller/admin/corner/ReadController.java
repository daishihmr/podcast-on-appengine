package net.hmrradio.podcastsite.controller.admin.corner;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.define.MsgKey;
import net.hmrradio.podcastsite.meta.CornerMeta;
import net.hmrradio.podcastsite.model.Corner;
import net.hmrradio.podcastsite.service.CornerService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class ReadController extends BaseController {

    private CornerMeta meta = CornerMeta.get();
    private CornerService service = new CornerService();

    public ReadController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {
        Corner result = service.findByTitle(param(meta.title));
        if (result == null) {
            return forwardJsonError(MsgKey.NO_DATA);
        }

        return forwardJson(result);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(meta.title, RequiredValidator.INSTANCE);

        return v.validate();
    }

}
