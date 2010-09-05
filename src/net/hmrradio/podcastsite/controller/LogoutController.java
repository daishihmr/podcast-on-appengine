package net.hmrradio.podcastsite.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LogoutController extends Controller {

    private UserService userService = UserServiceFactory.getUserService();

    @Override
    public Navigation run() throws Exception {
        return redirect(userService.createLogoutURL("/"));
    }
}
