package net.hmrradio.podcastsite.controller.blogEntry;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class PutControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/blogEntry/put");
        PutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));

        assertThat("hello", is("world"));
    }

    @Test
    public void go() {
    }
}
