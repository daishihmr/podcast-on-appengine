package net.hmrradio.podcastsite.controller.admin.audioFile;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.meta.AudioFileMeta;
import net.hmrradio.podcastsite.service.AudioFileService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class DeleteController extends BaseController {

    private AudioFileMeta meta = AudioFileMeta.get();
    private AudioFileService aService = new AudioFileService();

    public DeleteController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {

        aService.delete(param(meta.url));

        return forwardJsonSuccess();
    }

    protected boolean validate() {
        Validators v = new Validators(request);
        v.add(meta.url, RequiredValidator.INSTANCE);

        return v.validate();
    }
}
