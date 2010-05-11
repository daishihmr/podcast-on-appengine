package net.hmrradio.podcastsite.controller;

import java.util.List;

import net.hmrradio.podcastsite.model.Corner;
import net.hmrradio.podcastsite.service.CornerService;

import org.slim3.controller.Navigation;

public class CornerListController extends BaseController {

    private CornerService service = new CornerService();

    @Override
    protected Navigation exec() throws Exception {
        List<Corner> list = service.list();
        requestScope("list", list);
        return forward("/dialog/cornerList.jsp");
    }

}
