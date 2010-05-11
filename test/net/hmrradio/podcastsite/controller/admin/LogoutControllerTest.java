package net.hmrradio.podcastsite.controller.admin;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class LogoutControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/logout");
        LogoutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
    }
}
