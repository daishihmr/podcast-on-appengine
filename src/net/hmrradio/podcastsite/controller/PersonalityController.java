package net.hmrradio.podcastsite.controller;

import net.hmrradio.podcastsite.define.MsgKey;
import net.hmrradio.podcastsite.meta.PersonalityMeta;
import net.hmrradio.podcastsite.model.Personality;
import net.hmrradio.podcastsite.service.PersonalityService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class PersonalityController extends BaseController {

    private PersonalityMeta p = PersonalityMeta.get();

    private PersonalityService service = new PersonalityService();

    @Override
    protected Navigation exec() throws Exception {
        Personality personality = service.findByName(asString(p.name));

        if (personality == null) {
            return forwardJsonError(MsgKey.NO_DATA);
        }

        return forwardJson(personality);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(p.name, RequiredValidator.INSTANCE);

        return v.validate();
    }
}
