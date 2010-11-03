package net.hmrradio.podcastsite.controller.blogEntry;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;
import org.slim3.tester.TestEnvironment;

import com.google.apphosting.api.ApiProxy;

public class IndexControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        TestEnvironment env = new TestEnvironment("daishi.hmr@gmail.com", true);
        ApiProxy.setEnvironmentForCurrentThread(env);

        tester.start("/blogEntry/");
        IndexController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/dashboard/index.jsp"));
    }
}
