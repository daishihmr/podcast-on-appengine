package net.hmrradio.podcastsite.controller.admin.corner;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.service.CornerService;

import org.slim3.controller.Navigation;

public class ListController extends BaseController {

    private CornerService service = new CornerService();

    public ListController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {
        return forwardJson(service.list());
    }

}
