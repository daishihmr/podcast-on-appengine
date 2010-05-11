package net.hmrradio.podcastsite.controller.admin.personality;

import net.hmrradio.podcastsite.common.PersonalityCopyOptions;
import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.meta.PersonalityMeta;
import net.hmrradio.podcastsite.model.Personality;
import net.hmrradio.podcastsite.service.PersonalityService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.MaxlengthValidator;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class CreateController extends BaseController {

    private PersonalityService service = new PersonalityService();

    private PersonalityMeta p = PersonalityMeta.get();

    @Override
    protected Navigation exec() throws Exception {

        Personality personality = new Personality();
        BeanUtil.copy(request, personality, new PersonalityCopyOptions());

        service.put(personality);

        return forwardJson(personality);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(p.name, RequiredValidator.INSTANCE);
        v.add("profile", new MaxlengthValidator(500));

        return v.validate();
    }

}
