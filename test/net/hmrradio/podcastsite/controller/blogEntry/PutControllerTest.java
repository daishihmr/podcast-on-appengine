package net.hmrradio.podcastsite.controller.blogEntry;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

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
        tester.param("content", "本文だよ[/member/だいし][/corner/オープニング]");
        tester.param("tags", "あ, い, う, え, 長門 有希");
        tester.start("/blogEntry/put");

        PutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/dashboard/index.jsp"));

        BlogEntry newEntry = Datastore.query(BlogEntry.class).asSingle();
        assertThat(newEntry, is(notNullValue()));
        assertThat(newEntry.getTitle(), is("タイトルだよ"));
        assertThat(
            newEntry.getContent().getValue(),
            is("本文だよ[/member/だいし][/corner/オープニング]"));
        assertThat(newEntry.getMembers().contains("だいし"), is(true));
        assertThat(newEntry.getCorners().contains("オープニング"), is(true));
        assertThat(newEntry.getTags().contains("あ"), is(true));
        assertThat(newEntry.getTags().contains("い"), is(true));
        assertThat(newEntry.getTags().contains("う"), is(true));
        assertThat(newEntry.getTags().contains("え"), is(true));
        assertThat(newEntry.getTags().contains("長門 有希"), is(true));
    }

    @Test
    public void noLogin() throws Exception {
        tester.param("title", "タイトルだよ");
        tester.param("content", "本文だよ[/member/だいし][/corner/オープニング]");

        tester.start("/blogEntry/put");

        PutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), not("/dashboard/index.jsp"));

        List<BlogEntry> all = Datastore.query(BlogEntry.class).asList();
        assertThat(all.size(), is(0));
    }

    @Test
    public void validate() throws Exception {
        ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment(
            "daishi.hmr@gmail.com",
            true));

        tester.param("title", "");
        tester.param("content", "本文だよ[/member/だいし][/corner/オープニング]");
        tester.start("/blogEntry/put");

        PutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/dashboard/index.jsp"));

        assertThat(tester.getErrors().size(), is(1));
        assertThat(tester.getErrors().get(0), is("タイトルは必須です。"));

        List<BlogEntry> all = Datastore.query(BlogEntry.class).asList();
        assertThat(all.size(), is(0));
    }

    @Test
    public void validate2() throws Exception {
        ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment(
            "daishi.hmr@gmail.com",
            true));

        tester.param("title", "タイトルだよ");
        tester.param("content", "");
        tester.start("/blogEntry/put");

        PutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/dashboard/index.jsp"));

        assertThat(tester.getErrors().size(), is(1));
        assertThat(tester.getErrors().get(0), is("本文は必須です。"));

        List<BlogEntry> all = Datastore.query(BlogEntry.class).asList();
        assertThat(all.size(), is(0));
    }
}
