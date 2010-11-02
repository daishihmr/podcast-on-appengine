package net.hmrradio.podcastsite.controller.blogEntry;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.hmrradio.podcastsite.model.BlogEntry;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;
import org.slim3.tester.TestEnvironment;

import com.google.apphosting.api.ApiProxy;

public class PutControllerTest extends ControllerTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void run() throws Exception {
        ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment(
            "daishi.hmr@gmail.com",
            true));

        tester.param("title", "タイトルだよ");
        tester.param("content", "本文だよ");
        tester.start("/blogEntry/put");

        PutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/blogEntry/index.jsp"));

        BlogEntry newEntry = Datastore.query(BlogEntry.class).asSingle();
        assertThat(newEntry, is(notNullValue()));
        assertThat(newEntry.getTitle(), is("タイトルだよ"));
        assertThat(newEntry.getContent().getValue(), is("本文だよ"));
    }
}
