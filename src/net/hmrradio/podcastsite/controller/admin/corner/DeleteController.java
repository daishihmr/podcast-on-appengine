package net.hmrradio.podcastsite.controller.admin.corner;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.meta.CornerMeta;
import net.hmrradio.podcastsite.service.CornerService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class DeleteController extends BaseController {

    private CornerMeta meta = CornerMeta.get();
    private CornerService service = new CornerService();

    public DeleteController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {

        service.delete(param(meta.title));

        return forwardJsonSuccess();
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(meta.title, RequiredValidator.INSTANCE);

        return v.validate();
    }

}
