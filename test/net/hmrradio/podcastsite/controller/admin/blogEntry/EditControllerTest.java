package net.hmrradio.podcastsite.controller.admin.blogEntry;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class EditControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/blogEntry/edit");
        EditController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/admin/blogEntry/edit.jsp"));
    }
}