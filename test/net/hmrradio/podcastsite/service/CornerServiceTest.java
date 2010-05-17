package net.hmrradio.podcastsite.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.hmrradio.podcastsite.exception.EntityAlreadyDeletedException;
import net.hmrradio.podcastsite.exception.EntityAlreadyExistsException;
import net.hmrradio.podcastsite.model.Corner;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Text;

public class CornerServiceTest extends AppEngineTestCase {

    private CornerService service = new CornerService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void testCreate() {
        Corner c = new Corner();
        c.setTitle("123");
        c.setDescription(new Text("test"));
        service.create(c);

        Corner c2 = service.findByTitle("123");
        assertThat("test", is(c2.getDescription().getValue()));
    }

    @Test
    public void testCreate2() {
        Corner c = new Corner();
        c.setTitle("123");
        c.setDescription(new Text("test"));
        service.create(c);

        Corner c2 = new Corner();
        c2.setTitle("123");
        try {
            service.create(c2);
            fail();
        } catch (Exception e) {
            assertThat(e, is(EntityAlreadyExistsException.class));
        }
    }

    @Test
    public void testUpdate2() {
        Corner c = new Corner();
        c.setTitle("123");

        try {
            service.update(c);
            fail();
        } catch (Exception e) {
            assertThat(e, is(EntityAlreadyDeletedException.class));
        }
    }

    @Test
    public void testPut() {
        Corner c = new Corner();
        c.setTitle("123");
        c.setDescription(new Text("test"));
        service.put(c);

        Corner c2 = service.findByTitle("123");
        assertThat("test", is(c2.getDescription().getValue()));
    }

    @Test
    public void testPut2() {
        Corner c = new Corner();
        c.setTitle("");

        try {
            service.put(c);
            fail();
        } catch (Exception e) {
            assertThat(e, is(IllegalArgumentException.class));
        }
    }
}
