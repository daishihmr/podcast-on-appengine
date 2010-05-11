package net.hmrradio.podcastsite.controller.admin.image;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.service.ImageFileService;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class DestroyController extends BaseController {

    private ImageFileService service = new ImageFileService();

    @Override
    protected Navigation exec() throws Exception {
        Key key = asKey("imageKey");
        if (key != null) {
            service.delete(key);
        }

        return forwardJsonSuccess();
    }

}
