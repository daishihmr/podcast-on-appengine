package net.hmrradio.podcastsite.controller.blogEntry;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class GetControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/blogEntry/get");
        GetController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/blogEntry/index.jsp"));
    }
}
