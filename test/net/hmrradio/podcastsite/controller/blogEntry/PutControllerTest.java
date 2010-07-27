package net.hmrradio.podcastsite.controller.blogEntry;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.hmrradio.podcastsite.model.BlogEntry;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;

import com.google.appengine.api.datastore.KeyFactory;

public class PutControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.param("title", "タイトルだよ");
        tester.param("content", "本文だよ");
        tester.start("/blogEntry/put");

        PutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));

        assertThat(
            tester.response.getOutputAsString().contains("\"success\":true"),
            is(true));
        assertThat(
            tester.response
                .getOutputAsString()
                .contains("\"title\":\"タイトルだよ\""),
            is(true));

        Pattern p = Pattern.compile("(\"keyString\":\"\\w+\")");
        Matcher m = p.matcher(tester.response.getOutputAsString());
        assertThat(m.find(), is(true));
        assertThat(m.groupCount(), is(1));
        String hit = m.group(0);
        String key =
            hit.substring("\"keyString\":\"".length(), hit.length() - 1);

        BlogEntry newEntry =
            Datastore
                .query(BlogEntry.class, KeyFactory.stringToKey(key))
                .asSingle();
        assertThat(newEntry, is(notNullValue()));
        assertThat(newEntry.getTitle(), is("タイトルだよ"));
        assertThat(newEntry.getContent().getValue(), is("本文だよ"));
    }
}
