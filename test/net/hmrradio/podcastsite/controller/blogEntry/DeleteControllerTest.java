package net.hmrradio.podcastsite.controller.blogEntry;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.hmrradio.podcastsite.model.BlogEntry;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;
import org.slim3.tester.TestEnvironment;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;
import com.google.apphosting.api.ApiProxy;

public class DeleteControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        BlogEntry entry = new BlogEntry();
        entry.setTitle("タイトル");
        entry.setContent(new Text("本文"));
        Datastore.put(entry);
        String key = KeyFactory.keyToString(entry.getKey());

        ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment(
            "daishi.hmr@gmail.com",
            true));

        tester.param("key", key);
        tester.start("/blogEntry/delete");
        DeleteController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/"));

        BlogEntry result =
            Datastore.getOrNull(BlogEntry.class, KeyFactory.stringToKey(key));
        assertThat(result, is(nullValue()));
    }
}
