package net.hmrradio.podcastsite.controller.admin.audioFile;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class UpdateControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/audioFile/update");
        UpdateController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/json.jsp"));
    }
}
