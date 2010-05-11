package net.hmrradio.podcastsite.controller.admin.image;

import net.hmrradio.podcastsite.service.ImageFileService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ThumbsController extends Controller {

    private ImageFileService service = new ImageFileService();

    @Override
    public Navigation run() throws Exception {
        requestScope("list", service.list());
        return forward("thumbs.jsp");
    }

}
