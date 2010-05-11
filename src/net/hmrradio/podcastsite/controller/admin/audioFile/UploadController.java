package net.hmrradio.podcastsite.controller.admin.audioFile;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.meta.AudioFileMeta;
import net.hmrradio.podcastsite.model.AudioFile;
import net.hmrradio.podcastsite.service.AudioFileService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.LongTypeValidator;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.BeanUtil;

public class UploadController extends BaseController {

    private AudioFileMeta meta = AudioFileMeta.get();
    private AudioFileService aService = new AudioFileService();

    public UploadController() {
        necessaryLoggedIn = true;
    }

    @Override
    public Navigation exec() throws Exception {

        AudioFile a = new AudioFile();
        BeanUtil.copy(request, a);

        aService.create(a);

        return forward("upload.jsp");
    }

    @Override
    protected Navigation validationError() {
        requestScope(AttrName.ERROR_MESSAGES, errors.values());
        return forward("/admin/error.jsp");
    }

    @Override
    protected Navigation exceptionError(String error) {
        requestScope(AttrName.ERROR_MESSAGES, ApplicationMessage.get(error));
        return forward("/admin/error.jsp");
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
