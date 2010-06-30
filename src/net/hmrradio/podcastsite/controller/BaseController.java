package net.hmrradio.podcastsite.controller;

import static net.hmrradio.podcastsite.define.MsgKey.*;

import java.util.logging.Logger;

import javax.transaction.NotSupportedException;

import net.arnx.jsonic.JSON;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.exception.EntityAlreadyDeletedException;
import net.hmrradio.podcastsite.exception.EntityAlreadyExistsException;
import net.hmrradio.podcastsite.exception.NoLoggedInException;
import net.hmrradio.podcastsite.util.JsonResponseUtil;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.ApplicationMessage;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public abstract class BaseController extends Controller {

    protected boolean necessaryLoggedIn = false;

    private UserService userService = UserServiceFactory.getUserService();

    @Override
    protected Navigation run() throws Exception {

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expires", "Thu, 01 Dec 1994 16:00:00 GM");

        try {

            if (necessaryLoggedIn) {
                checkAuth();
                if (!isAdmin()) {
                    requestScope(AttrName.ERROR_MESSAGES, "Admin権限が必要です。");
                    return forward("/admin/error.jsp");
                }
            }
            beforeExec();
            if (!validate()) {
                return validationError();
            }
            return exec();

        } catch (EntityAlreadyDeletedException e) {

            return exceptionError(NO_DATA);

        } catch (EntityAlreadyExistsException e) {

            return exceptionError(ALREADY_EXISTS);

        } catch (NotSupportedException e) {

            if ("POST".equals(e.getMessage())) {
                return exceptionError(POST_ONLY_API);
            }
            return exceptionError(ERROR);

        } catch (NoLoggedInException e) {

            return redirect(userService.createLoginURL(request.getRequestURI()));

        } catch (Exception e) {

            return exceptionError(ERROR);

        } finally {

            afterExec();

        }
    }

    protected boolean isAdmin() {
        if (!userService.isUserLoggedIn()) {
            return false;
        }
        User user = userService.getCurrentUser();
        if (user == null) {
            return false;
        }
        if ("daishi.hmr@gmail.com".equals(user.getEmail())
            || "hmrblog@gmail.com".equals(user.getEmail())) {
            return true;
        }
        return false;
    }

    protected Navigation validationError() throws Exception {
        return forwardJsonError();
    }

    protected Navigation exceptionError(String error) throws Exception {
        return forwardJsonError(error);
    }

    private void checkAuth() {
        if (!userService.isUserLoggedIn()) {
            throw new NoLoggedInException();
        }
    }

    protected void beforeExec() throws Exception {
        // no op
    }

    protected abstract Navigation exec() throws Exception;

    protected void afterExec() {
        // no op
    }

    protected boolean validate() {
        return true;
    }

    protected Navigation forwardJsonSuccess() throws Exception {
        Object jsonBean = JsonResponseUtil.jsonSuccess(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Logger logger = Logger.getLogger("json.jsp");
        if (request.getAttribute("slim3.controller") instanceof Controller) {
            logger.info(getClass().getName() + " : " + JSON.encode(jsonBean));
        }

        response.getWriter().print(JSON.encode(jsonBean));
        response.flushBuffer();

        return null;
    }

    protected Navigation forwardJson(Object object) throws Exception {
        Object jsonBean = JsonResponseUtil.jsonResponse(request, object);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Logger logger = Logger.getLogger("json.jsp");
        if (request.getAttribute("slim3.controller") instanceof Controller) {
            logger.info(getClass().getName() + " : " + JSON.encode(jsonBean));
        }

        response.getWriter().print(JSON.encode(jsonBean));
        response.flushBuffer();

        return null;
    }

    protected Navigation forwardJsonError() throws Exception {
        Object jsonBean = JsonResponseUtil.jsonError(request, errors);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Logger logger = Logger.getLogger("json.jsp");
        if (request.getAttribute("slim3.controller") instanceof Controller) {
            logger.info(getClass().getName() + " : " + JSON.encode(jsonBean));
        }

        response.getWriter().print(JSON.encode(jsonBean));
        response.flushBuffer();

        return null;

    }

    protected Navigation forwardJsonError(String errorKey, Object... args)
            throws Exception {
        Object jsonBean =
            JsonResponseUtil.jsonError(request, ApplicationMessage.get(
                errorKey,
                args));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Logger logger = Logger.getLogger("json.jsp");
        if (request.getAttribute("slim3.controller") instanceof Controller) {
            logger.info(getClass().getName() + " : " + JSON.encode(jsonBean));
        }

        response.getWriter().print(JSON.encode(jsonBean));
        response.flushBuffer();

        return null;

    }

    public void setNecessaryLoggedIn(boolean necessaryLoggedIn) {
        this.necessaryLoggedIn = necessaryLoggedIn;
    }
}
