package net.hmrradio.podcastsite.util;

import java.util.List;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.common.collect.Lists;

public class LoginCheckUtil {

    private static final List<String> adminUsers;
    static {
        adminUsers =
            Lists.newArrayList("daishi.hmr@gmail.com", "hmrblog@gmail.com");
    }

    private LoginCheckUtil() {
    }

    public static boolean isAdmin() {
        UserService service = UserServiceFactory.getUserService();
        if (!service.isUserLoggedIn()) {
            return false;
        }
        User user = service.getCurrentUser();
        return adminUsers.contains(user.getEmail());
    }
}
