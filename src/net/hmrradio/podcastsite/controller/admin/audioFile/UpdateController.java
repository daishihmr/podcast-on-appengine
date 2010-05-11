package net.hmrradio.podcastsite.controller.admin.audioFile;

import net.hmrradio.podcastsite.controller.BasePostController;
import net.hmrradio.podcastsite.meta.AudioFileMeta;
import net.hmrradio.podcastsite.model.AudioFile;
import net.hmrradio.podcastsite.service.AudioFileService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.LongTypeValidator;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class UpdateController extends BasePostController {

    private AudioFileMeta meta = AudioFileMeta.get();
    private AudioFileService aService = new AudioFileService();

    public UpdateController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {

        AudioFile a = new AudioFile();
        BeanUtil.copy(request, a);

        aService.update(a);

        return forwardJson(aService.findByUrl(a.getUrl()));
    }

    protected boolean validate() {
        Validators v = new Validators(request);
        v.add(meta.url, RequiredValidator.INSTANCE);
        v.add(meta.duration, RequiredValidator.INSTANCE);
        v.add(
            meta.length,
            RequiredValidator.INSTANCE,
            LongTypeValidator.INSTANCE);
        v.add(meta.type, RequiredValidator.INSTANCE);

        return v.validate();
    }
}
