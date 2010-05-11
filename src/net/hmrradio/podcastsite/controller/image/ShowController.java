package net.hmrradio.podcastsite.controller.image;

import net.hmrradio.podcastsite.meta.ImageFileMeta;
import net.hmrradio.podcastsite.model.ImageFile;
import net.hmrradio.podcastsite.service.ImageFileService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ShowController extends Controller {

    private ImageFileService service = new ImageFileService();
    private ImageFileMeta meta = ImageFileMeta.get();

    @Override
    public Navigation run() throws Exception {
        ImageFile data = service.getData(asKey(meta.key));
        if (data == null) {
            return null;
        }
        byte[] bytes = service.getBytes(data);
        show(data.getFileName(), bytes);
        return null;
    }
}
