package net.hmrradio.podcastsite.controller.admin.audioFile;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.meta.AudioFileMeta;
import net.hmrradio.podcastsite.model.AudioFile;
import net.hmrradio.podcastsite.service.AudioFileService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class ReadController extends BaseController {

    private AudioFileMeta meta = AudioFileMeta.get();
    private AudioFileService aService = new AudioFileService();

    public ReadController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {

        AudioFile a = aService.findByUrl(param(meta.url));
        if (a == null) {
            return forwardJsonError("message.nodata");
        }

        return forwardJson(a);
    }

    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(meta.url, RequiredValidator.INSTANCE);

        return v.validate();
    }

}
