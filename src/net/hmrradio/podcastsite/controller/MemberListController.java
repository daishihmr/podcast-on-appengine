package net.hmrradio.podcastsite.controller;

import java.util.List;

import net.hmrradio.podcastsite.model.Personality;
import net.hmrradio.podcastsite.service.PersonalityService;

import org.slim3.controller.Navigation;

public class MemberListController extends BaseController {

    private PersonalityService service = new PersonalityService();

    @Override
    protected Navigation exec() throws Exception {
        List<Personality> list = service.list();
        requestScope("list", list);
        return forward("/dialog/memberList.jsp");
    }

}
