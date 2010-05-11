package net.hmrradio.podcastsite.controller.admin.corner;

import net.hmrradio.podcastsite.common.CornerCopyOptions;
import net.hmrradio.podcastsite.controller.BasePostController;
import net.hmrradio.podcastsite.meta.CornerMeta;
import net.hmrradio.podcastsite.model.Corner;
import net.hmrradio.podcastsite.service.CornerService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.MaxlengthValidator;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class CreateController extends BasePostController {

    private CornerMeta meta = CornerMeta.get();
    private CornerService service = new CornerService();

    public CreateController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {

        Corner result = new Corner();
        BeanUtil.copy(request, result, new CornerCopyOptions());

        service.put(result);

        return forwardJson(result);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(meta.title, RequiredValidator.INSTANCE);
        v.add("description", new MaxlengthValidator(1000));

        return v.validate();
    }

}
