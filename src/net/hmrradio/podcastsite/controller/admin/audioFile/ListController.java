package net.hmrradio.podcastsite.controller.admin.audioFile;

import java.util.Date;
import java.util.List;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.model.AudioFile;
import net.hmrradio.podcastsite.service.AudioFileService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.DateTypeValidator;
import org.slim3.controller.validator.Validators;

public class ListController extends BaseController {

    private static String pattern = "yyyy/MM/dd HH:mm:ss";

    private AudioFileService aService = new AudioFileService();

    public ListController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {

        Date min = asDate("min", pattern);
        Date max = asDate("max", pattern);

        List<AudioFile> result = aService.list(min, max);

        return forwardJson(result);
    }

    protected boolean validate() {
        Validators v = new Validators(request);

        v.add("min", new DateTypeValidator(pattern));
        v.add("max", new DateTypeValidator(pattern));

        return v.validate();
    }
}
